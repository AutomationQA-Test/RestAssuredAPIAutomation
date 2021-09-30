package APITesting;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_UserList {
	
	
	@Test
	public void getSingleUser(){
		
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();		
		Response responseBody = httpRequest.request(Method.GET, "/unknown");
		String body = responseBody.getBody().asString();
		System.out.println("responseBody::" +body);
		String contentType = responseBody.header("Content-Type");
		System.out.println("contentType:: " +contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");		
		
	}

}
