package com.gpn.pages;

import java.time.Duration;

import org.openqa.selenium.By;

import com.google.common.util.concurrent.Uninterruptibles;
import com.gpn.driver.DriverManager;

public class AlfaDOCKUserLoginPage{
	
	private final By textboxUsername = By.xpath("//input[@id='username']");
	private final By textboxUserPassword = By.xpath("//input[@id='password']");
	private final By buttonLogin = By.xpath("//button[@id='login']");
	private final By buttonLogout = By.xpath("//button[@id='logout']");
	
	public AlfaDOCKUserLoginPage enterUsername(String username) {
		DriverManager.getDriver().findElement(textboxUsername).sendKeys(username);
		return this;
	}
	
	public AlfaDOCKUserLoginPage enterUserPassword(String userPassword) {
		DriverManager.getDriver().findElement(textboxUserPassword).sendKeys(userPassword);
		return this;
	}
	
	public AlfaDOCKHomePage clickLogin() {
		DriverManager.getDriver().findElement(buttonLogin).click();
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
		return new AlfaDOCKHomePage();
	}
	
	public AlfaDOCKCustomerLoginPage clickUserLogout() {
		DriverManager.getDriver().findElement(buttonLogout).click();
		return new AlfaDOCKCustomerLoginPage();
	}
	
	
	
}
