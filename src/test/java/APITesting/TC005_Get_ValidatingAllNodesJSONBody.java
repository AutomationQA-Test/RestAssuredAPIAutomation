package APITesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_Get_ValidatingAllNodesJSONBody {
	
	
	@Test
	public void validateResponseBody(){
		 RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET,"/api/users/2");
		
		JsonPath jspath = response.jsonPath();
		jspath.get("email");
		jspath.get("first_name");
		
		System.out.println("email : " +jspath.get("email"));
		
		System.out.println("first name : " +jspath.get("first_name"));
	}
	

}
