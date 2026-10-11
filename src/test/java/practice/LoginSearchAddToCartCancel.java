package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.woovin.generic.basetest.BaseClass;
import com.woovin.generic.webdriverutility.WebDriverUtility;

public class LoginSearchAddToCartCancel extends BaseClass {
	@Test
	public void LoginSearchAddToCartCancel_regressionTest2() throws InterruptedException
	{
		/*WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://woovin.com/en");
		driver.findElement(By.xpath("//a[contains(@href,'/en/login')]")).click();
		
		driver.findElement(By.name("email")).sendKeys("rajan.shriraghavi@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();*/
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='https://woovin.com/en']")).click();
		driver.findElement(By.name("search")).sendKeys("Nike",Keys.ENTER);
		
		WebElement product = driver.findElement(By.xpath("//div[@id='woovin-browse-grid']/div[7]/a"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", product);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='pdp-sizes']/div[6]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'relative mb-2 overflow-hidden')]/child::button[@data-slot='button']")).click();
		driver.findElement(By.xpath("//a[@data-slot='button']")).click();
		WebElement actText = driver.findElement(By.xpath("//h3[text()='Nike Air Max 1 PRM Dirty Denim']"));
		Assert.assertEquals(actText.getText(), "Nike Air Max 1 PRM Dirty Denim");
		
		System.out.println("Product added to cart successfully");
		WebElement company = driver.findElement(By.id("company"));
		company.click();
		company.clear();
		company.sendKeys("SAN Company");
		driver.findElement(By.xpath("//label[@data-slot='label']/following-sibling::button[@data-slot='popover-trigger']")).click();
		driver.findElement(By.xpath("//div[@role='group']//div[2]")).click();
		WebElement address = driver.findElement(By.id("address"));
		address.click();
		address.sendKeys(Keys.CONTROL, "a");
		address.sendKeys(Keys.BACK_SPACE);
		address.sendKeys("Henleykaai 10");
		WebElement apartment = driver.findElement(By.id("apartment"));
		apartment.click();
		apartment.clear();
		apartment.sendKeys("Flot2");
		WebElement Postcode = driver.findElement(By.id("postal_code"));
		Postcode.click();
		Postcode.clear();
		Postcode.sendKeys("9000");
		WebElement Town = driver.findElement(By.id("city"));
		Town.click();
		Town.clear();
		Town.sendKeys("Gent");
		WebElement phone = driver.findElement(By.id("phone"));
		phone.click();
		phone.clear();
		phone.sendKeys("9876543210");
		
		WebElement place_order = driver.findElement(By.xpath("//button[@type='submit']"));
		js.executeScript("arguments[0].click();", place_order);
		
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.switchToTabOnURL(driver, "pay.ideal.nl/transactions");
		WebElement paymentPage = driver.findElement(By.xpath("//*[contains(text(),'WOOVIN B.V.')]"));
		Assert.assertTrue(paymentPage.isDisplayed());
		System.out.println("Payment page displayed successfully");
		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		driver.findElement(By.xpath("//span[text()='Cancel payment']")).click();
		Thread.sleep(2000);
		
		WebElement moveToEle = driver.findElement(By.xpath("//span[text()='My account']"));
		wLib.mouseMoveOnElement(driver, moveToEle);
		driver.findElement(By.xpath("//button[text()='Logout']")).click();
		driver.quit();
	}

}
