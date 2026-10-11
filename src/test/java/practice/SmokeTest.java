package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.woovin.generic.basetest.BaseClass;
import com.woovin.objectrepositoryutility.HomePage;
import com.woovin.objectrepositoryutility.ProductPage;
import com.woovin.objectrepositoryutility.SneakersPage;

public class SmokeTest extends BaseClass {

	@Test
	public void sneakerProductTest() throws IOException, InterruptedException {
		String verifySneakerProduct  = eLib.getDataFromExcelFile("smokeData", 4, 2);
		HomePage hp=new HomePage(driver);
		hp.clickSneakerLink();
		SneakersPage sp=new SneakersPage(driver);
		String actText=sp.getSneakersText().getText();
		Assert.assertTrue(actText.contains(verifySneakerProduct));
		System.out.println("Sneakers Page displayed successfully");
		}
	@Test
	public void apparelrProductTest() {
		HomePage hp=new HomePage(driver);
		hp.clickApprealLink();
	}
	
}
