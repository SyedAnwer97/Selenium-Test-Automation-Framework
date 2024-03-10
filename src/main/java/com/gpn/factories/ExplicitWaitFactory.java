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

	public static WebElement performExplictWait(WaitStrategy waitstrategy, By by) {
		WebElement element = null;
		switch (waitstrategy) {
		case CLICKABLE:new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait())).until(ExpectedConditions.elementToBeClickable(by));
			break;
		case PRESCENCE:new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait())).until(ExpectedConditions.presenceOfElementLocated(by));
			break;
		case VISIBLE:new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait())).until(ExpectedConditions.visibilityOfElementLocated(by));
			break;
		case INVISIBLE:new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait())).until(ExpectedConditions.invisibilityOfElementLocated(by));
			break;
		case NONE:
			DriverManager.getDriver().findElement(by);
			break;
		default:
			break;
		}
		return element;
	}
	
	public static WebElement performExplictWait(WaitStrategy waitstrategy, String string) {
		WebElement element = null;
		switch (waitstrategy) {
		case TITLECHANGE:
			new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
					.until(ExpectedConditions.titleContains(string));
			break;
		default:
			break;
		}
		return element;
	}

}
