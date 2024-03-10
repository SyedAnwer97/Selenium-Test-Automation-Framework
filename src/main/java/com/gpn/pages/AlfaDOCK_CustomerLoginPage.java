package com.gpn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.gpn.driver.DriverManager;

public final class AlfaDOCK_CustomerLoginPage {
	
	private AlfaDOCK_CustomerLoginPage() {}
	
	private final By Dropdown_LangaugeSelect = By.xpath("//select[@id='mySelect']");
	private final By Textbox_CustomerUserName  = By.id("username");
	private final By Textbox_CustomerPassword = By.xpath("//input[@id='password' and @type='password']");
	private final By Button_Login = By.xpath("//button[@id = 'logmein']");
	
	public AlfaDOCK_CustomerLoginPage selectLangauge(String Langauge) {
		Select select = new Select(DriverManager.getDriver().findElement(Dropdown_LangaugeSelect));
		select.selectByVisibleText(Langauge);
		return this;
	}
	
	public AlfaDOCK_CustomerLoginPage enterCustomerUsername(String userName) {
		DriverManager.getDriver().findElement(Textbox_CustomerUserName).sendKeys(userName);
		return this;
	}
	
	public AlfaDOCK_CustomerLoginPage enterCustomerPassword(String password) {
		DriverManager.getDriver().findElement(Textbox_CustomerPassword).sendKeys(password);
		return this;
	}
	
	public AlfaDOCK_UserLoginPage clickLoginButton() {
		DriverManager.getDriver().findElement(Button_Login).click();
		return new AlfaDOCK_UserLoginPage();
	}
}
