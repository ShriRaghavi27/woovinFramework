package com.woovin.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {
	WebDriver driver;
	public WishlistPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyWishlistProduct(String productName)
	{
		WebElement product = driver.findElement(By.xpath("//h3[normalize-space()='" + productName + "']"));
		return product.isDisplayed();
	}

}
