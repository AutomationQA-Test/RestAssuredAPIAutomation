package APITesting;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_DelayedUser {
	
	@Test
	public void getSingleUser(){
		//specify base url 
		RestAssured.baseURI="https://reqres.in/api";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		Response response = httpRequest.request(Method.GET,"/users?delay=3");
		
		//Print the response in console
		
		String responseBody = response.getBody().asString();
		System.out.println("The response body is :" +responseBody);
		
		//Status code validation start
		int statusCode = response.getStatusCode();
		System.out.println("The status code is:" +statusCode);
		Assert.assertEquals(statusCode, 200, "The actual and expecte code is not matched");
			
	}

}
