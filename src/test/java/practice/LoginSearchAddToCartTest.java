package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.woovin.generic.basetest.BaseClass;
import com.woovin.objectrepositoryutility.HomePage;
import com.woovin.objectrepositoryutility.ProductPage;

public class LoginSearchAddToCartTest extends BaseClass{
	@Test
	public void loginSearchAddToCartTest() throws IOException, InterruptedException {
		String productName = eLib.getDataFromExcelFile("data", 1, 2);
		HomePage hp=new HomePage(driver);
		hp.getWoovinLogo().clear();
		hp.getSearchEdt().sendKeys(productName,Keys.ENTER);
		ProductPage pp=new ProductPage(driver);
		pp.getProductName().click();
		Thread.sleep(5000);
		pp.getSize();
		pp.getProductName();
		Assert.assertTrue(false, productName);
		
		/*driver.findElement(By.xpath("//div[contains(@class,'relative mb-2 overflow-hidden')]/child::button[@data-slot='button']")).click();
		driver.findElement(By.xpath("//a[@data-slot='button']")).click();
		WebElement actText = driver.findElement(By.xpath("//h3[text()='Nike Air Max 1 PRM Dirty Denim']"));
		Assert.assertEquals(actText.getText(), "Nike Air Max 1 PRM Dirty Denim");
		
		System.out.println("Product added to cart successfully");*/
		}

}
