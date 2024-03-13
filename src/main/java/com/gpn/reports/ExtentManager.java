package com.gpn.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
	
	private ExtentManager() {}
	
	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

	static void setExtentTest(ExtentTest test) {
		extTest.set(test);
	}

	static ExtentTest getExtentTest() {
		return extTest.get();
	}

	public static void unload() {
		extTest.remove();
	}

}
