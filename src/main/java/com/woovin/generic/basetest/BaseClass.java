package com.woovin.generic.basetest;

import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.woovin.generic.databaseutility.DataBaseUtility;
import com.woovin.generic.fileutility.ExcelUtility;
import com.woovin.generic.fileutility.FileUtility;
import com.woovin.generic.webdriverutility.JavaUtility;
import com.woovin.generic.webdriverutility.UtilityClassObject;
import com.woovin.objectrepositoryutility.HomePage;
import com.woovin.objectrepositoryutility.LoginPage;

public class BaseClass {
	public WebDriver driver=null;
	public DataBaseUtility dbLib=new DataBaseUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	
	
	@BeforeSuite(groups = {"smokeTest","regressionTest","systemTest"})
	public void configBS()
	{
		System.out.println("====Connect to DB,Report config===");
		dbLib.getDbconnection();
	}
	
	@BeforeClass(groups = {"smokeTest","regressionTest","systemTest"})
	public void configBC() throws IOException
	{
		System.out.println("====Launch the Browser===");
		String BROWSER=fLib.getDataFromPropertiesFile("browser");
		System.out.println(BROWSER);
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
		UtilityClassObject.setDriver(driver);
		driver.manage().window().maximize();
	}
	@BeforeMethod(groups = {"smokeTest","regressionTest","systemTest"})
	public void configBM() throws IOException, InterruptedException
	{
		System.out.println("====Login===");
		String URL=fLib.getDataFromPropertiesFile("url");
		String EMAIL=fLib.getDataFromPropertiesFile("email");
		String PASSWORD=fLib.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.Login(URL, EMAIL, PASSWORD);
	}
	@AfterMethod(groups = {"smokeTest","regressionTest","systemTest"})
	public void configAM()
	{
		System.out.println("====Logout===");
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	@AfterClass(groups = {"smokeTest","regressionTest","systemTest"})
	public void configAC()
	{
		System.out.println("====Close the Browser===");
		driver.quit();
	}
	@AfterSuite(groups = {"smokeTest","regressionTest","systemTest"})
	public void configAF() throws SQLException
	{
		System.out.println("====Close to DB,Report config===");
		dbLib.closeDbConnection();
	}
}
