package utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.gpn.constants.FrameworkConstants;
import com.gpn.enums.ConfigProperties;

public final class PropertyUtils  {

	private PropertyUtils () {}

	private static Properties properties = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	static {
		try {
			FileInputStream fis = new FileInputStream(FrameworkConstants.getPropertyfilepath());
			properties.load(fis);
			for(Map.Entry<Object, Object> entry : properties.entrySet()){
				CONFIGMAP.put(String.valueOf(entry.getKey()).toLowerCase(),String.valueOf(entry.getValue()).trim());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String get(ConfigProperties key) throws Exception {
		if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())))
			throw new Exception("Property name "+ key + " is not found. Please check config.properties");
		return CONFIGMAP.get(key.name().toLowerCase());
	}

}
