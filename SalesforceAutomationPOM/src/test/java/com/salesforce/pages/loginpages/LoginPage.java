package com.salesforce.pages.loginpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.salesforce.base.BasePage;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='username']")WebElement userName;
	@FindBy(xpath = "//input[@id='password']")WebElement passWord;
	@FindBy(xpath = "//input[@id='Login']")WebElement loginButton;
	//@FindBy(xpath = "//div[@id='error']")WebElement errorEnterPassword;
	@FindBy(xpath = "//input[@id='rememberUn']")WebElement rememberCheck;
	@FindBy(xpath = "//a[@id='forgot_password_link']")WebElement forgetPasswordLink;
	@FindBy(xpath="//div[@id='error']")WebElement wrongDataError;
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	
	public void enterUserName(String username) {
		waitUntilVisibleElement(userName, "User Name Field");
		clearText(userName, "User Name Field");
		sendText(userName, username, "User Name Field");
	}
	
	public void enterPassword(String password) {
		sendText(passWord, password, "Password");
	}
	
	public void clickLoginButton() {
		clickButton(loginButton, "Login Button Click");
	}
	
	public void clearPassword() {
		clearText(passWord, "Clear Password");
	}
	
	public void clickRememberCheck() {
		clickButton(rememberCheck, "Remember Check Click");
	}
	
	public void clickForgetPasswordLink() {
		clickButton(forgetPasswordLink, "Forget Password Link Click");
	}
	
	public void login(String usrNam,String passWrd) {
		enterUserName(usrNam);
		enterPassword(passWrd);
		clickLoginButton();
	}
	
	public void loginClearPassword(String usrNam) {
		enterUserName(usrNam);
		clearPassword();
		clickLoginButton();
	}
	
	public void loginRememberCheck(String usrNam,String passWrd) {
		enterUserName(usrNam);
		enterPassword(passWrd);
		clickRememberCheck();
		clickLoginButton();
	}
	
	public void loginForgetPassword(String usrNamFP) {
		enterUserName(usrNamFP);
		clickForgetPasswordLink();
	}
	
	/*
	 * public String getErrorFromPasswordField() { return
	 * readText(errorEnterPassword, "Error Password"); }
	 */
	
	public String getErrorMessage() {
		return readText(wrongDataError, "Wrong Data Error");
	}
	
}
