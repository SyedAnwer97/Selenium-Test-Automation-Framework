package com.gpn.pages;

import org.openqa.selenium.By;

import com.gpn.enums.WaitStrategy;

public final class AlfaDOCKCustomerLoginPage extends ActionEngine {
	
	private final By dropdownLangaugeSelect = By.xpath("//select[@id='mySelect']");
	private final By textboxCustomerUserName  = By.id("username");
	private final By textboxCustomerPassword = By.xpath("//input[@id='password' and @type='password']");
	private final By buttonLogin = By.xpath("//button[@id = 'logmein']");
	
	public AlfaDOCKCustomerLoginPage selectLangauge(String langauge) {
		select(dropdownLangaugeSelect, WaitStrategy.PRESCENCE, langauge,"text", "langaugeSelect");
		return this;
	}
	
	public AlfaDOCKCustomerLoginPage enterCustomerUsername(String userName) {
		sendKeys(textboxCustomerUserName, WaitStrategy.PRESCENCE, userName, "customerUserName");
		return this;
	}
	
	public AlfaDOCKCustomerLoginPage enterCustomerPassword(String password) {
		sendKeys(textboxCustomerPassword,WaitStrategy.PRESCENCE, password, "customerPassword");
		return this;
	}
	
	public AlfaDOCKUserLoginPage clickLoginButton() throws Exception {
		click(buttonLogin, WaitStrategy.CLICKABLE, "loginButton");
		return new AlfaDOCKUserLoginPage();
	}
	
	public String pageTitle() {
		return getTitle();
	}
}
