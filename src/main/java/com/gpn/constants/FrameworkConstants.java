package com.gpn.constants;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.gpn.enums.ConfigProperties;

import utils.PropertyUtils;

public final class FrameworkConstants{

	private FrameworkConstants() {}
	
	private static final String RESOURCEPATH = System.getProperty("user.dir");
	private static final String PROPERTYFILEPATH= RESOURCEPATH+"/src/test/resources/resources/config/config.properties";
	private static final int EXPLICITWAIT = 10;
	private static final String EXTENTREPORTFOLDERPATH= RESOURCEPATH + "/extent-test-output/";
	private static String extentReportFilePath = "";
	
	
	private static String createReportPath() throws Exception  {
		if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
			return EXTENTREPORTFOLDERPATH+timeStamp+"/index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH+"/index.html";
		}
	}
	
	public static String getExtentReportFilePath() throws Exception  {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}
	
	public static String getPropertyfilepath() {
		return PROPERTYFILEPATH;
	}

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

}
