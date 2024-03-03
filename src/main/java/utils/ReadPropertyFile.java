package utils;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

import com.gpn.constants.FrameworkConstants;

public final class ReadPropertyFile {

	private ReadPropertyFile() {}
	
	public static String get(String key) throws Exception {
		String value = "";
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(FrameworkConstants.getPropertyfilepath());
		properties.load(fis);
		value = properties.getProperty(key.toLowerCase());
		if(Objects.isNull(value))
			throw new Exception("Property name "+ key + " is not found. Please check config.properties");
		return value;
	}
}
