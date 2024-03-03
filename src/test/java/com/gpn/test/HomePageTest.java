package com.gpn.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.gpn.driver.DriverManager;

public final class HomePageTest extends BaseTest {

	private HomePageTest() {}
	
	@Test
	public void test3() throws InterruptedException {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("testing" + Keys.ENTER);
		Assert.assertEquals(false, true);
		Thread.sleep(2000);

	}
	
	@Test
	public void test4() throws InterruptedException {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("testing" + Keys.ENTER);
		throw new SkipException("Skipping this exception");

	}
}
