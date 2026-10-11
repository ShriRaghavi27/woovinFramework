package com.woovin.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.woovin.generic.webdriverutility.WebDriverUtility;

public class NikePage extends WebDriverUtility {
	
	WebDriver driver;
	public NikePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//div[@id='woovin-browse-grid']//h3")
	private WebElement searchResult;
	
	@FindBy(xpath = "//div[@id='pdp-sizes']//div[normalize-space()='38']")
	private WebElement size;
	
	@FindBy(xpath = "//a[@data-slot='button']")
	private WebElement purchaseBtn;
	
	public WebElement getSearchResult() {
		return searchResult;
	}
	public WebElement getSize()
	{
	    return size;
	}
	public WebElement getPurchaseBtn()
	{
	    return purchaseBtn;
	}
	
	public void clickProduct(String productName)
	{
	    WebElement product = driver.findElement(By.xpath("//div[@id='woovin-browse-grid']//h3[normalize-space()='"+ productName + "']/ancestor::a"));
	    clickUsingJavaScript(driver, product);
	} 
	
	public boolean verifyProductName(String productName)
	{
	    String actualName = driver.findElement(By.xpath("//h1[normalize-space()='" + productName + "']")).getText();
	    return actualName.equals(productName);
	}
	
	public void clickSize(String size)
	{
	    WebElement sizeElement = driver.findElement(By.xpath("//div[@id='pdp-sizes']//div[normalize-space()='" + size + "']"));
	    clickUsingJavaScript(driver, sizeElement);
	    purchaseBtn.click();
	}

}
