package APITesting;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_Header {
	
	@Test
	public void getHeaders(){
		
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification request=	RestAssured.given();
		
		Response response = request.request(Method.GET, "/api/users/2");
		String body = response.getBody().asString();
		
		System.out.println("Response body : " +body);
		String connection = response.header("Connection");
		System.out.println("connection : " +connection);
		
		Assert.assertEquals(connection, "keep-alive");
		Headers allHeaders = response.headers();
		
		for(Header header: allHeaders){
			
			
			System.out.println(header.getName() +" =  " +header.getValue());
		}
		
		
		
	}

}
