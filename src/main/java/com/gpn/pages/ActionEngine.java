package com.gpn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.gpn.driver.DriverManager;
import com.gpn.enums.WaitStrategy;
import com.gpn.factories.ExplicitWaitFactory;
import com.gpn.reports.ExtentLogger;

public class ActionEngine {
	
	protected void click(By by, WaitStrategy waitStrategy, String elementName) throws Exception {
		ExplicitWaitFactory.performExplictWait(waitStrategy, by).click();
		ExtentLogger.pass(elementName + " is clicked");
	}
	
	protected void jsClick(By by, WaitStrategy waitStrategy, String elementName) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].click();", ExplicitWaitFactory.performExplictWait(waitStrategy, by));
		ExtentLogger.pass(elementName + " is clicked by js");
	}
	
	protected void sendKeys(By by, WaitStrategy waitStrategy, String value, String elementName) {
		ExplicitWaitFactory.performExplictWait(waitStrategy, by).sendKeys(value);
		ExtentLogger.pass(value + " is entered successfully in " + elementName);
	}
	
	protected void select(By by, WaitStrategy waitStrategy, String selectBy, String selectByCondition, String elementName) {
		WebElement element = ExplicitWaitFactory.performExplictWait(waitStrategy, by);
		Select select = new Select(element);
		if (selectByCondition.contains("index")) {
			select.selectByIndex(Integer.valueOf(selectBy));
		} else if (selectByCondition.contains("value")) {
			select.selectByValue(selectBy);
		} else if (selectByCondition.contains("text")) {
			select.selectByVisibleText(selectBy);
		}
		ExtentLogger.pass(selectBy + " is selected successfully in " + elementName);
	}
	
	protected String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

}
