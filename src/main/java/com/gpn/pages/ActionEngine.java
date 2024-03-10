package com.gpn.pages;

import org.openqa.selenium.By;

import com.gpn.driver.DriverManager;

public class ActionEngine {
	
	protected void click(By by) {
		DriverManager.getDriver().findElement(by).click();
	}
	
	protected void sendKeys(By by, String text) {
		DriverManager.getDriver().findElement(by).sendKeys(text);
	}

}