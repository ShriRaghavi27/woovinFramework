package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.woovin.generic.basetest.BaseClass;
import com.woovin.generic.fileutility.ExcelUtility;
import com.woovin.generic.webdriverutility.WebDriverUtility;

public class demo{
	ExcelUtility excel=new ExcelUtility();
	
	@Test
	public void demoTest() throws IOException {
		FileInputStream file =
		        new FileInputStream("./src/test/resources/WOOVIN_TestCaseData.xlsx");

		Workbook wb = WorkbookFactory.create(file);

		System.out.println("Number of sheets: " + wb.getNumberOfSheets());

		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
		    System.out.println("Sheet " + i + " = " + wb.getSheetName(i));
		}

		wb.close();
	//String campusProduct  = excel.getDataFromExcelFile("data", 4, 1);
	
	}

}
