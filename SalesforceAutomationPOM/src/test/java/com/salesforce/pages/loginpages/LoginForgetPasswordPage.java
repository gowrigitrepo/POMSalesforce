package com.salesforce.pages.loginpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.base.BasePage;

public class LoginForgetPasswordPage extends BasePage{
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='un']")WebElement userNameFP;
	@FindBy(xpath="//input[@id='continue']")WebElement continueButton;

	public LoginForgetPasswordPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterUserName(String userNamFP) {
		sendText(userNameFP, userNamFP, "Forget Password UserName");
	}
	
	public void clickContinue() {
		clickButton(continueButton, "Forget Password Continue");
	}	
	
	public void loginForgetPasword(String usrNameFP) {
		enterUserName(usrNameFP);
		clickContinue();
	}
	
}
