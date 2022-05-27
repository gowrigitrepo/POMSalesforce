package com.salesforce.pages.homepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.base.BasePage;


public class HomePage extends BasePage{
	
	@FindBy(css = "#userNavLabel")WebElement userMenu;
	@FindBy(xpath = "//a[contains(text(),'Logout')]")WebElement logoutMenu;
	@FindBy(xpath = "//span[@id='idcard-identity']")WebElement userNameAfterLogout;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public String getTitleFromHomePage() {
		return driver.getTitle();
	}
	
	public void userMenu() {
		clickButton(userMenu, "User Menu Click");
	}
	
	public void logout() {
		waitUntilVisibleElement(userMenu, "User Menu Click");
		clickButton(userMenu, "User Menu Click");
		clickButton(logoutMenu, "Logout Click");
	}
	
	public String getUserNameAfterLogout() {
		return readText(userNameAfterLogout, "User Name After Logout"); 
	}
	
}
