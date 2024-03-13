package com.gpn.reports;

import java.time.Duration;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.util.concurrent.Uninterruptibles;
import com.gpn.enums.ConfigProperties;

import utils.PropertyUtils;
import utils.ScreenshotUtils;

public final class ExtentLogger {
	
	private ExtentLogger() {}
	
	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}
	
	public static void fail(Throwable t) {
		ExtentManager.getExtentTest().fail(t);
	}
	
	public static void pass(String message, Boolean isScreenShotNeeded) throws Exception {
		if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && Boolean.TRUE.equals(isScreenShotNeeded)) {
		ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
	}
	}
	
	public static void fail(String message, Boolean isScreenShotNeeded) throws Exception {
		if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && Boolean.TRUE.equals(isScreenShotNeeded)) {
		ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
	}
	}
	
	public static void skip(String message, Boolean isScreenShotNeeded) throws Exception {
		if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && Boolean.TRUE.equals(isScreenShotNeeded)) {
		ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
	}
	}
	
	public static void remove() {
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
	}
	
}
