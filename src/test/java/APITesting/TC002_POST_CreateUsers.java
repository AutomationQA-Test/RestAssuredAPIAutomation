package APITesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_CreateUsers {
	
	
	@Test
	public void createUser(){
		
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification http = RestAssured.given();
		
		//request body // request payload	
		JSONObject requestPara = new JSONObject(); 
		requestPara.put("name", "morpheus");
		requestPara.put("job", "leader");
		
		http.header("Content-Type","application/json");
		http.request(requestPara.toJSONString());// Attach data to request
		
		Response response = http.request(Method.POST, "/users");
		String responseBody = response.getBody().asString();
		int statusCode = response.getStatusCode();
			
		System.out.println("Response body :" +responseBody);
		System.out.println("Status code :" +statusCode);
		
		Assert.assertEquals(statusCode, 201, "The actual and expecte code is not matched");
		
		
		
		
	}
	

}
