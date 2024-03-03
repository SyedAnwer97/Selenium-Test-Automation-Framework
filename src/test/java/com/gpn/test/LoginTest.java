package com.gpn.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.gpn.driver.DriverManager;

public final class LoginTest extends BaseTest {

	private  LoginTest() {}

	@Test
	public void test1() throws InterruptedException {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("anwer" + Keys.ENTER);
		Thread.sleep(2000);
	}
	
	@Test
	public void test2() throws InterruptedException {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("LAO" + Keys.ENTER);
		Thread.sleep(2000);
	}

}
