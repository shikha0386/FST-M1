package project;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest 
{
	//set the header
	Map<String, String> headers = new HashMap<>();
	
	//create the contract(Pact)
	@Pact(consumer = "userConsumer", provider = "userProvider")
	public RequestResponsePact createPact(PactDslWithProvider builder)
	{
		//set the header
		headers.put("Content-Type", "application/json");
		
		//the request and response body
		/* DslPart reqResBody = new PactDslJsonBody()
				.numberType("id")
				.stringType("firstName")
				.stringType("lastName")
				.stringType("email");
		*/
		
		 DslPart reqResBody = new PactDslJsonBody()
				.numberType("id", 123)
				.stringType("firstName", "testuser")
				.stringType("lastName", "testuser")
				.stringType("email", "testuser@example.com");
		
		
		//create the Pact
		return builder.given("POST Request")
			.uponReceiving("A request to create a user")
				.method("POST")
				.path("/api/users")
				.headers(headers)
				.body(reqResBody)
			.willRespondWith()
				.status(201)
				.body(reqResBody)
			.toPact();
	}
	
	//consumer test with mock provider
	@Test
	@PactTestFor(providerName = "userProvider", port = "8282")
	public void postRequesttest()
	{
		//create a request body
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", 123);
		reqBody.put("firstName", "testuser");
		reqBody.put("lastName", "testuser");
		reqBody.put("email", "testuser@example.com");
		
		//send request, get response, add assertions
		given().baseUri("http://localhost:8282/api/users")
		.headers(headers).body(reqBody)
		.log().all()
		.when().post()
		.then().statusCode(201).body("email", equalTo("testuser@example.com"))
		.log().all();
		
	}
	
}
