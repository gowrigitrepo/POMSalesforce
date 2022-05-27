package com.salesforce.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.salesforce.utility.CommonUtilities;
import com.salesforce.utility.Constants;
import com.salesforce.utility.GenerateReports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static GenerateReports report;

	@BeforeTest
	public static void initialTestSetup() {
		report = GenerateReports.getInstance();
		//report.startExtentReport();
		//report.logTestInfo("Inside initialTestSetup()-Before Test");
	}

	@BeforeMethod
	public static void setUp(Method method) {
		//report.startSingleTestReport(method.getName());
		//report.logTestInfo("Inside setUp()");
		System.out.println("before method started");
		String url = CommonUtilities.getApplicationProperty("url");
		//getDriver();
		goToChromeDriver();
		gotoUrl(url);
	}

	@AfterMethod
	public static void tearDown() {
		System.out.println("after method started");
		//report.logTestInfo("Inside TearDown");
		closeAllDriver();
	}

	public static void getDriver() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		//report.logTestInfo("Driver instance created");
	}
	
	public static void goToChromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// report.logTestInfo("Chrome driver instance created");
	}

	public static void gotoUrl(String url) {
		System.out.println("URL :" + url);
		driver.get(url);
		//report.logTestInfo("url entered is "+url);
	}

	public static void closeDriver() {
		driver.close();
	}

	public static void closeAllDriver() {
		driver.quit();
	}

	public static WebDriver getDriverInstance() {
		return driver;
	}

}
