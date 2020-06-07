package tests;

import java.net.http.HttpRequest;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Put {

	//URLused : http://dummy.restapiexample.com/
	
	public static HashMap serviceMap=new HashMap();
	int id=3;
	
	@BeforeClass
	public void putData()
	{
		String name=PostUtil.getName();
		int salary=PostUtil.getSalary();
		int age=PostUtil.getAge();
		serviceMap.put("name",name);
		serviceMap.put("salary",salary);
		serviceMap.put("age",age);
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="update/"+id;	
	}
	
	@Test
	public void putMethod()
	{
		given()
			.contentType("application/json")
			.body(serviceMap)
		.when()
			.put()
		.then()
			.statusCode(200);
		System.out.println(serviceMap);
		
	}
	@Test(priority=2)
	public void getPutValues()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employee/"+id;
		RequestSpecification request_specification= RestAssured.given();
		request_specification.header("Content-Type","application/json");
		Response response=request_specification.get(baseURI);
		ResponseBody response_body=response.getBody();
		System.out.println("this is the response body "+response_body);
		String responseBody=response_body.asString();
		System.out.println("this is the response body as string "+responseBody);
		
	}
	
	
}
