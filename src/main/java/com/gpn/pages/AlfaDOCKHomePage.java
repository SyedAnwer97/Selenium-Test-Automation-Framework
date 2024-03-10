package com.gpn.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.google.common.util.concurrent.Uninterruptibles;
import com.gpn.driver.DriverManager;

public class AlfaDOCKHomePage {
	
	private final By iconLogout = By.xpath("//i[@class='fa fa-sign-out fa-2x']");
	
	public AlfaDOCKUserLoginPage clickAlfaDOCKLogoutButton() {
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].click();", DriverManager.getDriver().findElement(iconLogout));
		return new AlfaDOCKUserLoginPage();
	}

}
