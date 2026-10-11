package com.macystest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.woovin.generic.basetest.BaseClass;
import com.woovin.generic.webdriverutility.UtilityClassObject;
import com.woovin.objectrepositoryutility.HomePage;
import com.woovin.objectrepositoryutility.PumaPage;
import com.woovin.objectrepositoryutility.SneakersPage;
import com.woovin.objectrepositoryutility.WishlistPage;

public class SneakersTest extends BaseClass{
	@Test(groups = "smokeTest")
	public void sneakerProductTest() throws IOException {
		// Read test data from Excel file utility
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String verifySneakerProduct  = eLib.getDataFromExcelFile("snek", 1, 2);
		
		//click sneaker link
		UtilityClassObject.getTest().log(Status.INFO, "Click On Sneakers Link");
		HomePage hp=new HomePage(driver);
		hp.getSneakersLink().click();
		
		//verify the result
		SneakersPage sp=new SneakersPage(driver);
		String actText=sp.getSneakersText().getText();
		Assert.assertTrue(actText.contains(verifySneakerProduct));
		UtilityClassObject.getTest().log(Status.PASS, "Sneakers Page displayed successfully");
		}
	@Test(groups = "regressionTest")
	public void clickPumaProductUsingFilterTest() throws IOException, InterruptedException {
		// Read test data from Excel file utility
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String verifyFilterProduct  = eLib.getDataFromExcelFile("snek", 4, 3);
		
		//click sneakers link
		UtilityClassObject.getTest().log(Status.INFO, "Click On Sneakers Link");
		HomePage hp=new HomePage(driver);
		hp.getSneakersLink().click();
		
		//click filter link
		UtilityClassObject.getTest().log(Status.INFO, "Click On SneakersPage Filter");
		SneakersPage sp=new SneakersPage(driver);
		sp.clickPumaProductUsingFilter();
		
		//verify the puma filter
		String actText=sp.getVerifyPumaBtn().getText();
		Assert.assertEquals(actText, verifyFilterProduct);
		UtilityClassObject.getTest().log(Status.PASS, "Puma filter verified successfully");
		}
	@Test(groups = "systemTest")
	public void addProductToWishlistTest() throws IOException, InterruptedException {
		// Read test data from Excel file utility
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String Product  = eLib.getDataFromExcelFile("snek", 7, 4);
		
		//click sneakers link
		UtilityClassObject.getTest().log(Status.INFO, "Click On Sneakers Link");
		HomePage hp=new HomePage(driver);
		hp.getSneakersLink().click();
		
		//click filter link
		UtilityClassObject.getTest().log(Status.INFO, "Click On SneakersPage Filter");
		SneakersPage sp=new SneakersPage(driver);
		sp.clickPumaProductUsingFilter();
		
		//click product
		UtilityClassObject.getTest().log(Status.INFO, "Click On Product");
		sp.clickProduct(Product);
		
		//click like button
		UtilityClassObject.getTest().log(Status.INFO, "Click On like Button");
		PumaPage pp=new PumaPage(driver);
		pp.clickLike();
		
		//click wishlist
		UtilityClassObject.getTest().log(Status.INFO, "Click On WishlistLink");
		hp.getWishlistLink().click();
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.INFO, "Click On like Button-->unlike");
		pp.clickLike();
		
		//verify add the product in the wishlist
		WishlistPage wp=new WishlistPage(driver);
		//wp.verifyWishlistProduct(Product);
		Assert.assertTrue(wp.verifyWishlistProduct(Product),"Product is not added to Wishlist");
		UtilityClassObject.getTest().log(Status.PASS, "Product added to Wishlist successfully");
		Thread.sleep(2000);
		
		}
}
