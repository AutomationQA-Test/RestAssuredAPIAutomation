package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_Get_Single_User extends TestBase {

	@BeforeClass
	public void getSingleUser() throws InterruptedException {

		logger.info("********** Starting the Get Single User **********");
		RestAssured.baseURI = "https://reqres.in";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/api/users/" + user);
		Thread.sleep(3000);
	}

	@Test
	public void checkResponseBody() {
		logger.info("*********** Checking response body ***********");
		String bodyResponse = response.getBody().asString();
		logger.info("Response Body:: " + bodyResponse);
		Assert.assertTrue(bodyResponse != null);
		Assert.assertEquals(bodyResponse.contains(user), true);

	}

	@Test
	public void checkStatusCode() {
		logger.info("*********** Checking status code ***********");
		int statusCode = response.getStatusCode();
		logger.info("Status code:: " + statusCode);
		Assert.assertEquals(statusCode, 200);

	}

	@Test
	public void checkStatusLine() {
		logger.info("*********** Checking status line ***********");
		String statusLine = response.getStatusLine();
		logger.info("Status line:: " + statusLine);

		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

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

	@Test
	public void checkContentCoding() {
		logger.info("*********** Checking the content coding ***********");
		String contentEncoding = response.header("Content-Encoding");
		logger.info("Content Encoding : " + contentEncoding);

		Assert.assertEquals(contentEncoding, "gzip");

	}

	@AfterClass
	public void tearDown() {

		logger.info("************** TC002 is completed  *******************");

	}

}
