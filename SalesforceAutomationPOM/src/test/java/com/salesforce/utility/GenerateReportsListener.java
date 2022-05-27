package com.salesforce.utility;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.salesforce.base.BaseTest;

public class GenerateReportsListener implements ITestListener {
	
	ExtentHtmlReporter htmlreport;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public GenerateReports report=GenerateReports.getInstance();
	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("GenerateReportsListener onStart()");
		report.startExtentReport();
	}
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("GenerateReportsListener onTestStart()");
		report.startSingleTestReport(result.getMethod().getMethodName());
		System.out.println("onTestStart completed");
	}
	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestSuccess completed");
		report.logTestpassed(result.getMethod().getMethodName() );	
	}
	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriver driver=BaseTest.getDriverInstance();
		String screenshotPath=CommonUtilities.takeScreenShot(driver);
		report.logTestFailed(result.getMethod().getMethodName());
		try {
			report.attachScreenShot(screenshotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		report.logTestSkipped(result.getMethod().getMethodName());
	}
	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.endReport();
	}
	
}