package com.gpn.pages;

import java.time.Duration;

import org.openqa.selenium.By;

import com.google.common.util.concurrent.Uninterruptibles;

public final class AlfaDOCKUserLoginPage extends ActionEngine{
	
	private final By textboxUsername = By.xpath("//input[@id='username']");
	private final By textboxUserPassword = By.xpath("//input[@id='password']");
	private final By buttonLogin = By.xpath("//button[@id='login']");
	private final By buttonLogout = By.xpath("//button[@id='logout']");
	
	public AlfaDOCKUserLoginPage enterUsername(String username) {
		sendKeys(textboxUsername, username);
		return this;
	}
	
	public AlfaDOCKUserLoginPage enterUserPassword(String userPassword) {
		sendKeys(textboxUserPassword, userPassword);
		return this;
	}
	
	public AlfaDOCKHomePage clickLogin() {
		click(buttonLogin);
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
		return new AlfaDOCKHomePage();
	}
	
	public AlfaDOCKCustomerLoginPage clickUserLogout() {
		click(buttonLogout);
		return new AlfaDOCKCustomerLoginPage();
	}
	
	
	
}
