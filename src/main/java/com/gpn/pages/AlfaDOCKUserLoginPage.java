package com.gpn.pages;

import org.openqa.selenium.By;

import com.gpn.enums.WaitStrategy;
import com.gpn.factories.ExplicitWaitFactory;

public final class AlfaDOCKUserLoginPage extends ActionEngine{
	
	private final By textboxUsername = By.xpath("//input[@id='username']");
	private final By textboxUserPassword = By.xpath("//input[@id='password']");
	private final By buttonLogin = By.xpath("//button[@id='login']");
	private final By buttonLogout = By.xpath("//button[@id='logout']");
	
	public AlfaDOCKUserLoginPage enterUsername(String username) {
		if(ExplicitWaitFactory.performExplictWait(WaitStrategy.TITLECHANGE, "UserLogin")) {
		sendKeys(textboxUsername, WaitStrategy.PRESCENCE, username, "username");
		}
		return this;
	}
	
	public AlfaDOCKUserLoginPage enterUserPassword(String userPassword) {
		sendKeys(textboxUserPassword, WaitStrategy.PRESCENCE, userPassword, "userPassword");
		return this;
	}
	
	public AlfaDOCKHomePage clickLogin() throws Exception {
		click(buttonLogin, WaitStrategy.CLICKABLE, "userLoginButton");
		return new AlfaDOCKHomePage();
	}
	
	public AlfaDOCKCustomerLoginPage clickUserLogout() throws Exception {
		click(buttonLogout, WaitStrategy.CLICKABLE, "userLogoutButton");
		return new AlfaDOCKCustomerLoginPage();
	}
	
	
	
}
