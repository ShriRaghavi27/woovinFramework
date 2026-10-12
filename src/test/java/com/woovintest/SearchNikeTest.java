package com.woovintest;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.woovin.generic.basetest.BaseClass;
import com.woovin.generic.webdriverutility.UtilityClassObject;
import com.woovin.objectrepositoryutility.HomePage;
import com.woovin.objectrepositoryutility.NikePage;

public class SearchNikeTest extends BaseClass{
	@Test(groups = "smokeTest")
	public void searchNikeProductTest() throws IOException, InterruptedException {
		
		// Read test data from Excel file utility
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String searchKeyword  = eLib.getDataFromExcelFile("nike", 1, 2);
		
		UtilityClassObject.getTest().log(Status.INFO, "Click On WoovinLink");
		HomePage hp=new HomePage(driver);
		hp.clickWoovinLink();
		
		//search nike product
		UtilityClassObject.getTest().log(Status.INFO, "Search Nike Product");
		hp.getSearchEdt().sendKeys(searchKeyword,Keys.ENTER);
		NikePage np=new NikePage(driver);
		
		//verify the page
		String actualText = np.getSearchResult().getText();
		Assert.assertTrue(actualText.contains(searchKeyword),"Search result not displayed");
		UtilityClassObject.getTest().log(Status.PASS, "Search result verified successfully");
	}
	@Test(groups = "regressionTest")
	public void searchNikeAndClickProductTest() throws IOException, InterruptedException {
		
		// Read test data from Excel file utility
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String searchKeyword  = eLib.getDataFromExcelFile("nike", 4, 2);
		String productName   = eLib.getDataFromExcelFile("nike", 4, 3);
		
		//Click On WoovinLink
		UtilityClassObject.getTest().log(Status.INFO, "Click On WoovinLink");
		HomePage hp=new HomePage(driver);
		hp.clickWoovinLink();
		
		//search nike product
		UtilityClassObject.getTest().log(Status.INFO, "Search Nike Product");
		hp.getSearchEdt().sendKeys(searchKeyword,Keys.ENTER);
		
		//select Nike Air Max 1 PRM Dirty Denim
		UtilityClassObject.getTest().log(Status.INFO, "select Nike Air Max 1 PRM Dirty Denim");
		NikePage np=new NikePage(driver);
		np.clickProduct(productName);
		
		//verify Nike Air Max 1 PRM Dirty Denim
		Assert.assertTrue(np.verifyProductName(productName),"Product name is not matching");
		UtilityClassObject.getTest().log(Status.PASS, productName+" displayed successfully");
		}
	@Test(groups = "systemTest")
	public void productPurchaseTest() throws IOException, InterruptedException {
		
		// Read test data from Excel file utility
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String searchKeyword  = eLib.getDataFromExcelFile("nike", 7, 2);
		String productName   = eLib.getDataFromExcelFile("nike", 7, 3);
		String size = eLib.getDataFromExcelFile("nike", 7, 4);
		
		UtilityClassObject.getTest().log(Status.INFO, "Click On WoovinLink");
		HomePage hp=new HomePage(driver);
		hp.clickWoovinLink();
		
		//search nike product
		UtilityClassObject.getTest().log(Status.INFO, "Search Nike Product");
		hp.getSearchEdt().sendKeys(searchKeyword,Keys.ENTER);
		
		//select Nike Air Max 1 PRM Dirty Denim
		UtilityClassObject.getTest().log(Status.INFO, "select Nike Air Max 1 PRM Dirty Denim");
		NikePage np=new NikePage(driver);
		np.clickProduct(productName);
		
		//select Size 38
		UtilityClassObject.getTest().log(Status.INFO, "select size");
		np.clickSize(size);
		np.getPurchaseBtn().click();
		
		//verify the page
		Assert.assertTrue(np.verifyProductName(productName),"Product name is not matching");
		UtilityClassObject.getTest().log(Status.PASS, productName+" displayed on checkout successfully");
		Thread.sleep(2000);
		}
	}
