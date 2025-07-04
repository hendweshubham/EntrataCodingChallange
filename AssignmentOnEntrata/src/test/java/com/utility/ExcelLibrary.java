package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary {
	
	private static XSSFWorkbook wb;
	private static XSSFSheet sheet;
	
	public ExcelLibrary() {
		
		File file = new File(KeyReader.getKey("filePath"));
		
		try {
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String readData(String sheetName, int row, int col) {
		sheet = wb.getSheet(sheetName);
		String data = sheet.getRow(row).getCell(col).toString();
		return data;
	}
}
