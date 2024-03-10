package com.gpn.test;

import java.time.Duration;
import java.util.Objects;

import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.gpn.driver.DriverManager;
import com.gpn.pages.AlfaDOCKCustomerLoginPage;

public final class DummyPageTest extends BaseTest {

	private DummyPageTest() {}

	@Test(enabled = true)
	public void test1() {
		new AlfaDOCKCustomerLoginPage().selectLangauge("English");
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
		String Title =DriverManager.getDriver().getTitle();
		Assert.assertTrue(Objects.nonNull(Title));
		Assert.assertTrue(Title.length()<=25);
		Assert.assertTrue(Title.length()>=5);
		Assertions.assertThat(Title).contains("Company").isEqualTo("Company Login");
	}

	@Test(enabled = true)
	public void test2()  {
		new AlfaDOCKCustomerLoginPage().selectLangauge("English");
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
	}

	@Test(enabled = true)
	public void test3() {
		new AlfaDOCKCustomerLoginPage().selectLangauge("English");
		Assert.assertEquals(false, true);
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
	}

	@Test(enabled = true )
	public void test4() throws InterruptedException {
		new AlfaDOCKCustomerLoginPage().selectLangauge("English");
		throw new SkipException("Skipping this exception");
	}

}
