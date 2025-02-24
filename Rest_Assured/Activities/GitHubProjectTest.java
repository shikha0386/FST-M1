package project;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GitHubProjectTest
{
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	//The String variable will hold the SSH key that will be added to your GitHub account
	String SSHkey = "ssh-test dummy key";
	
	//and the int variable will hold the id that is generated for the SSH key.
	int SSHkeyID;
	
	@BeforeClass
	public void setUp()
	{
		//Request specification - specify the common request parts only in RequestSpecBuilder
		requestSpec = new RequestSpecBuilder().setBaseUri("https://api.github.com/user/keys").
			addHeader("Authorization","token ghp_test dummy access key").
			addHeader("Content-Type","application/json").build();
		
		 // Response Specification
	    responseSpec = new ResponseSpecBuilder().
	            expectResponseTime(lessThan(4000L)).
	            expectBody("key", equalTo(SSHkey)).
	            expectBody("title", equalTo("TestAPIKey")).
	            build();
	}
	
	//One for sending a POST request to add a SSH key to your account
	@Test (priority=1)
	public void postRequest()
	{
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("title", "TestAPIKey");
		reqBody.put("key", SSHkey);
		
		//create an response object
		Response response = given()
				.spec(requestSpec)
				.body(reqBody)
				.when().post();
		
		SSHkeyID = response.then().extract().path("id");
		System.out.println("extract the id of the SSH key : " + SSHkeyID);
		

		response.then().statusCode(201).spec(responseSpec);
	}
	//One for sending a GET request to get all the SSH keys attached to your account
	@Test (priority=2)
	public void getRequest()
	{
		given().spec(requestSpec).pathParam("keyId", SSHkeyID)
		.when().get("/{keyId}")
		.then().statusCode(200).spec(responseSpec)
		.log().all();
	}
	
	//One for sending a DELETE request to delete the key attached to your account.
	@Test (priority=3)
	public void deleteRequest()
	{
		given().spec(requestSpec).pathParam("keyId", SSHkeyID)
		.when().delete("/{keyId}")
		.then().statusCode(204).time(lessThan(3000L));
		
		System.out.println("New Pet got deleted " + SSHkeyID);
	}

}
