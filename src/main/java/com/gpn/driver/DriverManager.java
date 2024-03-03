package com.gpn.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

	private DriverManager() {}

	private static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();

	public static void setDriver(WebDriver driver) {
		tDriver.set(driver);
	}

	public static WebDriver getDriver() {
		return tDriver.get();
	}

	public static void unload() {
		tDriver.remove();
	}

}
