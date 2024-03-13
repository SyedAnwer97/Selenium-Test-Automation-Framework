package com.gpn.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.gpn.driver.Driver;

public class BaseTest {

	protected BaseTest() {}
	
	@BeforeMethod
	protected void setup() throws Exception {
		Driver.initDriver();
	}

	@AfterMethod
	protected void tearDown() {
		Driver.tearDown();
	}

}
