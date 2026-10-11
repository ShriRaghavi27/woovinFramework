package com.woovin.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApparelPage {
	WebDriver driver;
	public ApparelPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//button[@data-slot='button']/child::span[text()='Clothing']")
	private WebElement appProduct;
	
	@FindBy(xpath = "//button[@data-slot='dropdown-menu-trigger']/div")
	private WebElement popularitydd;
	
	@FindBy(xpath = "//div[@data-side='bottom']/div[4]")
	private WebElement priceHighToLow;
	
	@FindBy(xpath = "//div[@class='container']//a[text()='Purchase']")
	private WebElement purchaseButton;
	
	public WebElement getAppProduct() {
		return appProduct;
	}
	
	public WebElement getPopularitydd() {
		return popularitydd;
	}
	
	public WebElement getPriceHighToLow() {
		return priceHighToLow;
	}
	
	public WebElement getPurchaseButton() {
        return purchaseButton;
    }

	 // Product name is dynamic
    public WebElement getProduct(String product) {
        return driver.findElement(By.xpath("//div[@id='woovin-browse-grid']//div/h3[text()='"+ product + "']/ancestor::a"));
    }

    // Product title on details page
    public WebElement getProductTitle(String product) {
        return driver.findElement(By.xpath("//h1[text()='" + product + "']"));
    }

    // Select XL is dynamic
    public WebElement getProductSize(String size) {
        return driver.findElement(By.xpath("//div[text()='"+size+"']"));
    }
}
