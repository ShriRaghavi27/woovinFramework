package com.macystest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.woovin.generic.basetest.BaseClass;
import com.woovin.generic.webdriverutility.UtilityClassObject;
import com.woovin.objectrepositoryutility.ApparelPage;
import com.woovin.objectrepositoryutility.CheckoutPage;
import com.woovin.objectrepositoryutility.HomePage;
import com.woovin.objectrepositoryutility.TransactionPage;

public class ApparelTest extends BaseClass{
	@Test(groups = "smokeTest")
	public void apparelProductTest() throws IOException
	{
		// Read test data from Excel file utility
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String product = eLib.getDataFromExcelFile("app", 1, 2);
		
		// Click Apparel link
		UtilityClassObject.getTest().log(Status.INFO, "Click On Apparel Link");
		HomePage hp=new HomePage(driver);
		hp.clickApprealLink();
		
		// Verify Apparel product
		ApparelPage ap=new ApparelPage(driver);
		String aclProduct = ap.getAppProduct().getText();
		Assert.assertTrue(aclProduct.contains(product));
		UtilityClassObject.getTest().log(Status.PASS, product+"Apparel product verified successfully");
		}

	@Test(groups = "regressionTest")
	public void apparelTest() throws IOException, InterruptedException
	{
		// Read test data from Excel file utility
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String selProduct = eLib.getDataFromExcelFile("app", 7, 3);
				
		// Click Apparel link
		UtilityClassObject.getTest().log(Status.INFO, "Click On Apparel Link");
		HomePage hp=new HomePage(driver);
		hp.clickApprealLink();
		
		ApparelPage ap=new ApparelPage(driver);
		//Click Popularity dropdown
	    ap.getPopularitydd().click();

	    // Select Price high to low
	    ap.getPriceHighToLow().click();
	    
	    //Click product
	    UtilityClassObject.getTest().log(Status.INFO, "Click Product");
	    ap.getProduct(selProduct).click();
	    
	    // Verify product title
	    String actTitle = ap.getProductTitle(selProduct).getText();
	    Assert.assertEquals(actTitle, selProduct);
	    UtilityClassObject.getTest().log(Status.PASS, selProduct+" is displayed successfully");
	    Thread.sleep(2000);
	}
	@Test(groups = "systemTest")
	public void apparelProductToBuyTest() throws IOException, InterruptedException
	{
		// Read test data from Excel file utility
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String selProduct = eLib.getDataFromExcelFile("app", 7, 3);
		String selSize = eLib.getDataFromExcelFile("app", 7, 4);
		String Address = eLib.getDataFromExcelFile("app", 7, 5);
		String Postcode = eLib.getDataFromExcelFile("app", 7, 6);
		String Town = eLib.getDataFromExcelFile("app", 7, 7);
		String payUrl = eLib.getDataFromExcelFile("app", 7, 8);
		String siteUrl = eLib.getDataFromExcelFile("app", 7, 9);
		// Click Apparel link
		UtilityClassObject.getTest().log(Status.INFO, "Click On Apparel Link");
		HomePage hp=new HomePage(driver);
		hp.clickApprealLink();
		
		ApparelPage ap=new ApparelPage(driver);
		//Click Popularity dropdown
		UtilityClassObject.getTest().log(Status.INFO, "Click On Popularity DropDown");
	    ap.getPopularitydd().click();

	    // Select Price high to low
	    UtilityClassObject.getTest().log(Status.INFO, "Select Price high to low");
	    ap.getPriceHighToLow().click();
	    
	    //Click product
	    UtilityClassObject.getTest().log(Status.INFO, "Click Product");
	    ap.getProduct(selProduct).click();
	    
	    // Verify product title
	    String actTitle = ap.getProductTitle(selProduct).getText();
	    Assert.assertEquals(actTitle, selProduct);
	    UtilityClassObject.getTest().log(Status.PASS, selProduct+" is displayed successfully");

	    // Select XL size
	    UtilityClassObject.getTest().log(Status.INFO, "Select Size");
	    ap.getProductSize(selSize).click();

	    // Click Purchase
	    UtilityClassObject.getTest().log(Status.INFO, "Click On Purchase");
	    ap.getPurchaseButton().click();

	    //Click placeOrder
	    UtilityClassObject.getTest().log(Status.INFO, "Click On Place Order");
	    CheckoutPage cp=new CheckoutPage(driver);
	    cp.clickPlaceOrder(Address,Postcode, Town);
		
	    //Click CancelOrder
	    TransactionPage tp=new TransactionPage(driver);
	    tp.clickCancelOrder(payUrl, siteUrl);
	    UtilityClassObject.getTest().log(Status.PASS, "Payment page displayed successfully");
	    Thread.sleep(4000);
	}
}
