package utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.gpn.constants.FrameworkConstants;

public final class DataProviderUtils {
	private DataProviderUtils() {}
	
	@DataProvider(parallel = true)
	public static Object[] getData(Method m) {
		String testname = m.getName();
		List<Map<String,String>> list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationdata());
		List<Map<String,String>> testDataList = new ArrayList<>();
		for(int i = 0;i<list.size();i++) {
			if(list.get(i).get("testname").equalsIgnoreCase(testname) && list.get(i).get("execute").equalsIgnoreCase("yes")){
				testDataList.add(list.get(i));
			}
			}
		return testDataList.toArray();
	}
}
