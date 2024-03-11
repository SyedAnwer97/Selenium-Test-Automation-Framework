package com.gpn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.gpn.driver.DriverManager;
import com.gpn.enums.WaitStrategy;
import com.gpn.factories.ExplicitWaitFactory;

public class ActionEngine {
	
	protected void click(By by, WaitStrategy waitStrategy) {
		ExplicitWaitFactory.performExplictWait(waitStrategy, by).click();
	}
	
	protected void jsClick(By by, WaitStrategy waitStrategy) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].click();", ExplicitWaitFactory.performExplictWait(waitStrategy, by));
	}
	
	protected void sendKeys(By by, WaitStrategy waitStrategy, String text) {
		ExplicitWaitFactory.performExplictWait(waitStrategy, by).sendKeys(text);
	}
	
	protected void select(By by, WaitStrategy waitStrategy, String selectBy, String condition) {
		WebElement element = ExplicitWaitFactory.performExplictWait(waitStrategy, by);
		Select select = new Select(element);
		if (condition.contains("index")) {
			select.selectByIndex(Integer.valueOf(selectBy));
		} else if (condition.contains("value")) {
			select.selectByValue(selectBy);
		} else if (condition.contains("text")) {
			select.selectByVisibleText(selectBy);
		}
	}
	
	protected String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

}
