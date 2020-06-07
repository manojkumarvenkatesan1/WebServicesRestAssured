package tests;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Post {

	public static HashMap map=new HashMap();
	
	
	//https://jsonplaceholder.typicode.com/posts
	/*@BeforeClass
	public void postData() {
		map.put("name", PostUtil.getName());
		map.put("salary", PostUtil.getSalary());
		map.put("age", PostUtil.getAge());
		RestAssured.baseURI="http://dummy.restapiexample.com";
		RestAssured.basePath="/api/v1/create";
	}
	@Test
	public void testPost()
	{
		given()
		.contentType("application/json")
		.body(map)
		.when()
		.post()
		.then()
		.statusCode(200);
		System.out.println(map);
	}*/
	
	//https://jsonplaceholder.typicode.com/posts
	
	
	@BeforeClass
	public void postDataa()
	{
		map.put("userID", PostUtil.userId());
		map.put("id", PostUtil.id());
		map.put("title",PostUtil.title() );
		map.put("body", PostUtil.body());
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		RestAssured.basePath="/posts";
	}
	
	@Test
	public void testPostt()
	{
		RequestSpecification req_spec= new RequestSpecBuilder().addParams(map).build();
		ResponseBody res_body=req_spec.post(basePath);
		System.out.println("This is the response body :" +res_body);
		
	}
}
