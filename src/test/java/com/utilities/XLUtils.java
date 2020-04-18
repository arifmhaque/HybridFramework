package com.utilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;

	public static int getRowCount(String pathOfXlFile, String sheetName) {
		try {
			wb = new XSSFWorkbook(pathOfXlFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ws = wb.getSheet(sheetName);
		int rowCount = ws.getLastRowNum();
		return rowCount;
	}
	
	public static int getCellCount(String pathOfXlFile, String sheetName, int rownum) {
		try {
			wb = new XSSFWorkbook(pathOfXlFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ws = wb.getSheet(sheetName);
		int cellCount = ws.getRow(rownum).getLastCellNum();
		return cellCount;
	}
	
	public static String getCellData(String pathOfXlFile, String sheetName,int row, int col) {
		try {
			wb = new XSSFWorkbook(pathOfXlFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ws = wb.getSheet(sheetName);
		String cellData = ws.getRow(row).getCell(col).getStringCellValue();
		return cellData;
	}



}
