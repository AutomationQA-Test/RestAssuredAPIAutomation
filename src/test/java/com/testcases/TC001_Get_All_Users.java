package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_Get_All_Users extends TestBase {

	@BeforeClass
	public void getAllEmployeed() throws InterruptedException {

		logger.info("*********** Started TC001 Get All Employees ***********");
		RestAssured.baseURI = "https://reqres.in/";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/api/users?page=2");

		Thread.sleep(3000);

	}

	@Test
	public void checkResponseBody() {
		logger.info("*********** Checking response body ***********");
		String bodyResponse = response.getBody().asString();
		logger.info("Response Body:: " + bodyResponse);
		Assert.assertTrue(bodyResponse != null);

	}

	@Test
	public void checkStatusCode() {
		logger.info("*********** Checking status code ***********");
		int statusCode = response.getStatusCode();
		logger.info("Status code:: " + statusCode);
		Assert.assertEquals(statusCode, 200);

	}

	@Test
	public void checkResponseTime() {
		logger.info("*********** Checking Response Time ***********");
		long responsetime = response.getTime();
		logger.info("Response Time :: " + responsetime);
		if (responsetime > 1)
			logger.warn("The response time is greater than 1 :" + responsetime);

		Assert.assertTrue(responsetime > 2);

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

	@Test
	public void checkCookies() {
		logger.info("*********** Checking the Cookies ***********");
		String cookies = response.getCookie("PHPSESSID");
		logger.info("cookies : " + cookies);

		// Assert.assertEquals(contentEncoding, "gzip");

	}

	@AfterClass
	public void tearDown() {

		logger.info("************** TC001 is completed  *******************");

	}

}
