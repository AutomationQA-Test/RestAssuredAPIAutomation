package com.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.utility.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC005_Delete_Created_User extends TestBase {

	@BeforeClass
	public void getSingleUser() throws InterruptedException {

		logger.info("********** Starting the Get Single User **********");
		RestAssured.baseURI = "https://reqres.in";
		httpRequest = RestAssured.given();
		response= httpRequest.request(Method.DELETE, "/api/users/2" );

		Thread.sleep(3000);
	}

	@Test
	public void checkStatusCode() {
		logger.info("*********** Checking status code ***********");
		int statusCode = response.getStatusCode();
		logger.info("Status code:: " + statusCode);
		Assert.assertEquals(statusCode, 204);

	}

	@Test
	public void checkStatusLine() {
		logger.info("*********** Checking status line ***********");
		String statusLine = response.getStatusLine();
		logger.info("Status line:: " + statusLine);

		Assert.assertEquals(statusLine, "HTTP/1.1 204 No Content");

	}

	@Test
	public void checkServerType() {
		logger.info("*********** Checking the Server Type ***********");
		String server = response.header("Server");
		logger.info("server type : " + server);

		Assert.assertEquals(server, "cloudflare");

	}

	@AfterClass
	public void tearDown() {

		logger.info("************** TC002 is completed  *******************");

	}

}
