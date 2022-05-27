package com.salesforce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.base.BaseTest;
import com.salesforce.pages.homepages.HomePage;
import com.salesforce.pages.loginpages.LoginCheckEmailPage;
import com.salesforce.pages.loginpages.LoginForgetPasswordPage;
import com.salesforce.pages.loginpages.LoginPage;
import com.salesforce.utility.CommonUtilities;

public class AutomationScript extends BaseTest {

	@Test
	public static void loginToSalesforce() {
		String expectedPage = "Welcome to your free trial.";
		LoginPage login = new LoginPage(driver);
		String userNam = CommonUtilities.getApplicationProperty("username");
		String passWrd = CommonUtilities.getApplicationProperty("password");
		login.login(userNam, passWrd);
		HomePage home = new HomePage(driver);
		String actualPage = home.getTitleFromHomePage();
		System.out.println(expectedPage);
		System.out.println("Actual Page - Login: " + actualPage);
		Assert.assertEquals(actualPage, expectedPage);
	}

	@Test
	public static void loginToSalesforceClearPassword() {
		String expectedMessage = "Please enter your password.";
		LoginPage login = new LoginPage(driver);
		String userNam = CommonUtilities.getApplicationProperty("username");
		login.loginClearPassword(userNam);
		String actualMessage = login.getErrorMessage();
		System.out.println(expectedMessage);
		System.out.println("Actual Message - Clear Password: " + actualMessage);
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@Test
	public static void loginToSalesforceRememberCheck() {
		String expectedUserName = "training@automation.com";
		LoginPage login = new LoginPage(driver);
		String userNam = CommonUtilities.getApplicationProperty("username");
		String passWrd = CommonUtilities.getApplicationProperty("password");
		login.loginRememberCheck(userNam, passWrd);
		HomePage home = new HomePage(driver);
		home.logout();
		String actualUserName = home.getUserNameAfterLogout();
		System.out.println(expectedUserName);
		System.out.println("Actual User Name - Remember Check : " + actualUserName);
		Assert.assertEquals(actualUserName, expectedUserName);
	}

	@Test
	public static void loginToSalesforceForgetPassword() {
		String expectedTitle = "Check Your Email | Salesforce";
		LoginPage login = new LoginPage(driver);
		String userNam = CommonUtilities.getApplicationProperty("username");
		login.loginForgetPassword(userNam);
		LoginForgetPasswordPage loginFP = new LoginForgetPasswordPage(driver);
		loginFP.loginForgetPasword(userNam);
		LoginCheckEmailPage loginCheckEmail = new LoginCheckEmailPage(driver);
		String actualTitle = loginCheckEmail.getCheckEmailTitle(driver);
		System.out.println(expectedTitle);
		System.out.println("Actual Title - Checkk Email : " + actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public static void loginToSalesforceWrongData() {
		String expectedError = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		LoginPage login = new LoginPage(driver);
		String wrongUserNam = CommonUtilities.getApplicationProperty("wrongusername");
		String wrongPassWrd = CommonUtilities.getApplicationProperty("wrongpassword");
		login.login(wrongUserNam, wrongPassWrd);
		String actualError = login.getErrorMessage();
		System.out.println(expectedError);
		System.out.println("Actual Page - Login: " + actualError);
		Assert.assertEquals(actualError, expectedError);
	}

}
