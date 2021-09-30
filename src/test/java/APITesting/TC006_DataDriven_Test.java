package APITesting;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_DataDriven_Test {
	XLUtils xl = new XLUtils();
	
	
	@Test(dataProvider="userDataProvider")
	public void DataDriven(String ename , String ejob){
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification request = RestAssured.given();
		JSONObject reqparameter = new JSONObject();
		reqparameter.put("name", ename);
		reqparameter.put("job", ejob);

		
		request.header("Content-Type", "application/json");
		
		request.body(reqparameter.toJSONString());
		
		
		Response respone = request.request(Method.POST, "/api/users");
		
		
		
		String responseBody = respone.getBody().asString();
		System.out.println("The response body is :" +responseBody);
		
		int statusCode = respone.getStatusCode();
		System.out.println("The status code is :" +statusCode);
		
		
		
		
		
	}
	
	@DataProvider(name="userDataProvider")
	public String[][] getData() throws IOException{
		
		
		String filePath = "C:\\Automation\\ResetAssuredAPIProject\\DataFile\\empData.xlsx";
		int numRow = xl.getRowCount(filePath, "Sheet1");
		int numColumn = xl.getCellCount(filePath, "Sheet1",1);
		
		String empData[][] = new String[numRow][numColumn];

	//	String empData[][] = {{"sachin","leader"},{"dev","QA"},{"pratik","Senior QA"} };
		return empData;
	}

}
