package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gpn.constants.FrameworkConstants;

public final class ExcelUtils {

	private ExcelUtils() {}

	public static List<Map<String, String>> getTestDetails(String sheetname) {
		List<Map<String, String>> list = null;
		try (FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelpath())) {
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetname);
			int lastrownum = sheet.getLastRowNum();
			int lastcolnum = sheet.getRow(0).getLastCellNum();
			Map<String, String> map = null;
			list = new ArrayList<>();
			for (int i = 1; i <= lastrownum; i++) {
				map = new HashMap<>();
				String key;
				String value;
				for (int j = 0; j < lastcolnum; j++) {
					key = sheet.getRow(0).getCell(j).toString();
					if (sheet.getRow(i).getCell(j) != null) {
						value = sheet.getRow(i).getCell(j).toString();
					} else {
						value = "";
					}
					map.put(key, value);
				}
				list.add(map);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}

}
