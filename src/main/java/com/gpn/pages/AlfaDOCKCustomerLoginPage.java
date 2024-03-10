package com.gpn.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.google.common.util.concurrent.Uninterruptibles;
import com.gpn.driver.DriverManager;

public final class AlfaDOCKCustomerLoginPage {
	
	private final By dropdownLangaugeSelect = By.xpath("//select[@id='mySelect']");
	private final By textboxCustomerUserName  = By.id("username");
	private final By textboxCustomerPassword = By.xpath("//input[@id='password' and @type='password']");
	private final By buttonLogin = By.xpath("//button[@id = 'logmein']");
	
	public AlfaDOCKCustomerLoginPage selectLangauge(String langauge) {
		Select select = new Select(DriverManager.getDriver().findElement(dropdownLangaugeSelect));
		select.selectByVisibleText(langauge);
		return this;
	}
	
	public AlfaDOCKCustomerLoginPage enterCustomerUsername(String userName) {
		DriverManager.getDriver().findElement(textboxCustomerUserName).sendKeys(userName);
		return this;
	}
	
	public AlfaDOCKCustomerLoginPage enterCustomerPassword(String password) {
		DriverManager.getDriver().findElement(textboxCustomerPassword).sendKeys(password);
		return this;
	}
	
	public AlfaDOCKUserLoginPage clickLoginButton() {
		DriverManager.getDriver().findElement(buttonLogin).click();
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
		return new AlfaDOCKUserLoginPage();
	}
	
	public String pageTitle() {
		return DriverManager.getDriver().getTitle();
	}
}
