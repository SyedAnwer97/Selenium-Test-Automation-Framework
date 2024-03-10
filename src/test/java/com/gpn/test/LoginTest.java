package com.gpn.test;

import java.util.Objects;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gpn.driver.DriverManager;

public final class LoginTest extends BaseTest {

	private  LoginTest() {}

	@Test
	public void test1() throws InterruptedException {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("anwer" + Keys.ENTER);
		Thread.sleep(2000);
		String Title =DriverManager.getDriver().getTitle();
		Assert.assertTrue(Objects.nonNull(Title));
		Assert.assertTrue(Title.length()<=25);
		Assert.assertTrue(Title.length()>=5);
		Assertions.assertThat(Title).contains("anwer").isEqualTo("anwer - Google Search");
	}
	
	@Test(enabled = false)
	public void test2() throws InterruptedException {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("LAO" + Keys.ENTER);
		Thread.sleep(2000);
	}

}
