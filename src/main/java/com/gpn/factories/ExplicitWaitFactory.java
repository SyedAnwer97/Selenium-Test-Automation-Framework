package com.gpn.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gpn.constants.FrameworkConstants;
import com.gpn.driver.DriverManager;
import com.gpn.enums.WaitStrategy;

public final class ExplicitWaitFactory {

	private ExplicitWaitFactory() {
	}
	
	private static WebElement element = null;
	private static boolean condition ;

	public static WebElement performExplictWait(WaitStrategy waitstrategy, By by) {
		
		switch (waitstrategy) {
		case CLICKABLE: element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait())).until(ExpectedConditions.elementToBeClickable(by));
			break;
		case PRESCENCE:element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait())).until(ExpectedConditions.presenceOfElementLocated(by));
			break;
		case VISIBLE:element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait())).until(ExpectedConditions.visibilityOfElementLocated(by));
			break;
		case NONE:element = DriverManager.getDriver().findElement(by);
			break;
		default:
			break;
		}
		return element;
	}
	
	public static boolean performExplictWait(WaitStrategy waitstrategy, String string) {
		if (waitstrategy == WaitStrategy.TITLECHANGE) {
			condition = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
						.until(ExpectedConditions.titleContains(string));
		}
		return condition;
	}

}
