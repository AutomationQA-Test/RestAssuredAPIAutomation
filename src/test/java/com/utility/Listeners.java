package com.utility;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;




public class Listeners extends TestListenerAdapter {
	
		public ExtentHtmlReporter htmlReport;
		public ExtentReports extentReport;
		public ExtentTest test;
		
		public void onStart(ITestContext testContext){
			htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/myReport.html");
			htmlReport.config().setDocumentTitle("Automation Report");
			htmlReport.config().setReportName("Rest Api Testing");
			htmlReport.config().setTheme(Theme.DARK);
		
			extentReport = new ExtentReports();
			extentReport.attachReporter(htmlReport);
			extentReport.setSystemInfo("Host Name", "localhost");
			extentReport.setSystemInfo("Project Name", "Demo");
			extentReport.setSystemInfo("Enviorment", "QA");
			extentReport.setSystemInfo("User", "Sachin");
			
			
			
		}
	
		public void onTestSuccess(ITestResult result){
			
			test = extentReport.createTest(result.getName());
			test.log(Status.PASS, "Test Cases is Passed " +result.getName());
			
		}
		
		public void onTestFailure(ITestResult result){
				
				test = extentReport.createTest(result.getName());
				test.log(Status.FAIL, "Test Cases is Failed " +result.getName());
				test.log(Status.FAIL, "Test Cases is Failed " +result.getThrowable());
				
			}
		
		public void onTestSkipped(ITestResult result){
			
			test = extentReport.createTest(result.getName());
			test.log(Status.SKIP, "Test Cases is Skipped " +result.getName());
		
			
		}
		
		
		public void onFinish(ITestContext textContext){
			
			 extentReport.flush();
			
		
			
		}

}
