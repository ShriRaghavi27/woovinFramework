package com.woovin.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcelFile(String sheetName,int rowNum,int cellNum) throws IOException
	{
		FileInputStream file=new FileInputStream("./src/test/resources/WOOVIN_TestCaseData.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	public int getRowCount(String sheetName) throws IOException
	{
		FileInputStream file=new FileInputStream("./src/test/resources/WOOVIN_TestCaseData.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}
	

}
