package com.gpn.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gpn.enums.ConfigProperties;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.PropertyUtils;

public final class Driver {

	private Driver() {}

	public static void initDriver() throws Exception {
		if (Objects.isNull(DriverManager.getDriver())) {
			WebDriver driver = new ChromeDriver();
			DriverManager.setDriver(driver);
			WebDriverManager.chromedriver().setup();
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}
	}

	public static void tearDown() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	} 
}
