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

public class TC003_POST_Create_New_User extends TestBase {

	RestUtils rs = new RestUtils();
	String userName = rs.getName();
	String userJob = rs.getJob();

	@BeforeClass
	public void getSingleUser() throws InterruptedException {

		logger.info("********** Starting the Get Single User **********");
		RestAssured.baseURI = "https://reqres.in";
		httpRequest = RestAssured.given();
		JSONObject requestPara = new JSONObject();
		requestPara.put("name", userName);
		requestPara.put("job", userJob);
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestPara.toJSONString());

		response = httpRequest.request(Method.POST, "/api/users");
		Thread.sleep(3000);
	}

	@Test
	public void checkResponseBody() {
		logger.info("*********** Checking response body ***********");
		String bodyResponse = response.getBody().asString();
		logger.info("Response Body:: " + bodyResponse);
		Assert.assertTrue(bodyResponse != null);
		Assert.assertEquals(bodyResponse.contains(userName), true);
		Assert.assertEquals(bodyResponse.contains(userJob), true);

	}

	@Test
	public void checkStatusCode() {
		logger.info("*********** Checking status code ***********");
		int statusCode = response.getStatusCode();
		logger.info("Status code:: " + statusCode);
		Assert.assertEquals(statusCode, 201);

	}

	@Test
	public void checkStatusLine() {
		logger.info("*********** Checking status line ***********");
		String statusLine = response.getStatusLine();
		logger.info("Status line:: " + statusLine);

		Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");

	}

	@Test
	public void checkContentType() {
		logger.info("*********** Checking the content type ***********");
		String contentType = response.header("Content-Type");
		logger.info("contentType : " + contentType);

		Assert.assertEquals(contentType, "application/json; charset=utf-8");

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
