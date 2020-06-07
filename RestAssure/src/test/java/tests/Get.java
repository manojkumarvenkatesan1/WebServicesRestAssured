package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.HashMap;
public class Get {

/*	@Test
	public void testGet()
	{
		
		given()
		.when()
			.get("https://jsonplaceholder.typicode.com/posts?userId=1&id=1")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
		
			//.assertThat().body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
			.header("Content-Type","application/json");
	}*/
	
	/*@Test
	public void testSimple()
	{
		expect().body("address.street", hasItem(equalTo("Kulas Light"))).when().get("https://jsonplaceholder.typicode.com/users?address.street=Kulas Light");
	}*/
	
	@Test
	public void testGet1()
	{
	RestAssured.baseURI="http://localhost:8888";
	RequestSpecification httpRequest=RestAssured.given();
	httpRequest.header("Content-Type","application/json");
	Response response=httpRequest.get("https://jsonplaceholder.typicode.com/users?email=Sincere@april.biz");
	
	// Get Response Body 
	ResponseBody body = response.getBody();

	// Get Response Body as String 
	String bodyStringValue = body.asString();
	
	System.out.println("body string "+bodyStringValue);
	
			// Validate if Response Body Contains a specific String
			Assert.assertTrue(bodyStringValue.contains("Leanne Graham"));
			
			
			// Get JSON Representation from Response Body 
			JsonPath jsonPathEvaluator = response.jsonPath();
			
			System.out.println("the json response :"+jsonPathEvaluator);

			// Get specific element from JSON document
			ArrayList<String> mapp=new ArrayList<String>();
			mapp = jsonPathEvaluator.get("name");
			System.out.println("here it is the :"+mapp);

			// Validate if the specific JSON element is equal to expected value
			Assert.assertTrue(mapp.contains("Leanne Graham"));
			
	}
	

	
}
