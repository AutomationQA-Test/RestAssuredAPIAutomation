package APITesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_Get_ValidatingJSONBody {
	
	
	@Test
	public void validateResponseBody(){
		 RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET,"/api/users/2");
		String res = response.getBody().asString();
		
		System.out.println("Response body :" +res);
		
		Assert.assertEquals(res.contains("janet.weaver@reqres.in"), true);
		
		Assert.assertEquals(res.contains("Janet"), true);
		
	}
	

}
