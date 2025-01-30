package liveProject;

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
import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.given;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
	
	//Set the headers
	Map<String,String> headers = new HashMap<>();
	//headers.put
	
	//Create the contrct(Pact)
	@Pact(consumer = "UserConsumer" , provider ="UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder) 
	{
	  //set hearder
		headers.put("Content-Type","application/json");
		//The request and response body
		DslPart reqResBody = new PactDslJsonBody()
				.numberType("id",123)
				.stringType("firstName","shikha")
				.stringType("lastName","shrivastava")
				.stringType("email","shikha.shri@gmail.com");
		
		//Create the pact
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
	
	//Consumer test with mock provider
	@Test
	@PactTestFor(providerName = "UserProvider" , port ="8282")
	public void postRequestTest()
	{
		Map<String,Object> reqBody = new HashMap<String,Object>();
		reqBody.put("id", 123);
		reqBody.put("firstName", "shikha");
		reqBody.put("lastName", "shrivastava");
		reqBody.put("email", "shikha.shri@gmail.com");
		//Send request get response , add assertions
		given().baseUri("http://localhost:8282/api/users")
		.headers(headers).body(reqBody).log().all()
		.when().post()
		.then().log().all().statusCode(201).body("email",equalTo("shikha.shri@gmail.com"));
		
	}
	
}
