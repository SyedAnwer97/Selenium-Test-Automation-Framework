package com.gpn.reports;

import java.awt.Desktop;
import java.io.File;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.gpn.constants.FrameworkConstants;
import com.gpn.enums.ConfigProperties;

import utils.PropertyUtils;

public final class ExtentReport {

	private ExtentReport() {}

	private static ExtentReports extent;

	public static void initReports() throws Exception {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("GPN Report");
			spark.config().setReportName("alfaDOCK GPN");
			spark.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';");

			extent.setSystemInfo("Executed on OS & Java: ", System.getProperty("os.name") + " Java : " + System.getProperty("java.version"));
			extent.setSystemInfo("Executed on Environment: ", PropertyUtils.get(ConfigProperties.URL));
			extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));
		}
	}

	public static void createTest(String testName) {
		ExtentTest test = extent.createTest(testName);
		ExtentManager.setExtentTest(test);
	}

	public static void flushReports() throws Exception {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
	}

}
