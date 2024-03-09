package com.gpn.constants;

public final class FrameworkConstants{

	private FrameworkConstants() {}
	
	private static final String RESOURCEPATH = System.getProperty("user.dir");
	private static final String PROPERTYFILEPATH= RESOURCEPATH+"/src/test/resources/resources/config/config.properties";

	public static String getPropertyfilepath() {
		return PROPERTYFILEPATH;
	}

}
