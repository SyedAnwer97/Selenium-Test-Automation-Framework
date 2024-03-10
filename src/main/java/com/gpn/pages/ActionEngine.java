package com.gpn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.gpn.driver.DriverManager;

public class ActionEngine {
	
	protected void click(By by) {
		DriverManager.getDriver().findElement(by).click();
	}
	
	protected void jsClick(By by) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].click();", DriverManager.getDriver().findElement(by));
	}
	
	protected void sendKeys(By by, String text) {
		DriverManager.getDriver().findElement(by).sendKeys(text);
	}
	
	protected String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

}
