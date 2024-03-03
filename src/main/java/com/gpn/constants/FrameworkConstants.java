package com.gpn.constants;

public final class FrameworkConstants{

	private FrameworkConstants() {}
	
	private static final String PROPERTYFILEPATH= System.getProperty("user.dir")+"/src/test/resources/resources/config/config.properties";

	public static String getPropertyfilepath() {
		return PROPERTYFILEPATH;
	}

}
