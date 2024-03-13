package com.gpn.listeners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.gpn.reports.ExtentLogger;
import com.gpn.reports.ExtentReport;

public class ListenerClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		try {
			ExtentReport.initReports();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite suite) {
		try {
			ExtentReport.flushReports();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " is passed" );
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ExtentLogger.fail(result.getThrowable());
			ExtentLogger.fail(result.getMethod().getMethodName() + " is failled", true );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " is skiped" );
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		//need to implement later
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		//need to implement later
	}

	@Override
	public void onStart(ITestContext context) {
		//need to implement later
	}

	@Override
	public void onFinish(ITestContext context) {
		//need to implement later
	}

}
