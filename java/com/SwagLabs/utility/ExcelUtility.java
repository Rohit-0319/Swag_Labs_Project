package com.SwagLabs.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Object[][] excelData(String excelPath) throws IOException {

		// String excelPath =System.getProperty("user.dir")+"/src/test/resources/SwagLabsCredentials.xlsx";

		// Opening excel
		try (FileInputStream fin = new FileInputStream(System.getProperty("user.dir") + "/" + excelPath)) {

			// get workbook
			XSSFWorkbook workbook = new XSSFWorkbook(fin);

			XSSFSheet sheet = workbook.getSheet("Sheet1");

			int totalRows = sheet.getPhysicalNumberOfRows(); // real row count
			int totalCols = sheet.getRow(1).getPhysicalNumberOfCells(); // header row

			Object[][] data = new Object[totalRows - 1][totalCols];

			for (int i = 1; i < totalRows; i++) { // start after header
				for (int j = 0; j < totalCols; j++) {
					data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
				}
			}

			workbook.close();
			return data;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}