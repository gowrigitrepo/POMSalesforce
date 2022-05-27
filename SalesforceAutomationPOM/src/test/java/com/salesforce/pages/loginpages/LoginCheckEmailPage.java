package com.salesforce.pages.loginpages;

import org.openqa.selenium.WebDriver;

import com.salesforce.base.BasePage;

public class LoginCheckEmailPage extends BasePage{
	WebDriver driver;

	public LoginCheckEmailPage(WebDriver driver) {
		super(driver);
	}
	
	public String getCheckEmailTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
}
