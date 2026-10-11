package com.woovin.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	    //Product name
	    @FindBy(xpath = "//h3[text()='Nike Air Max 1 PRM Dirty Denim']")
	    private WebElement productName;

	    //Size selection
	    @FindBy(xpath = "//div[@id='pdp-sizes']/div[6]")
	    private WebElement size;

	    //Wishlist
	    @FindBy(xpath = "//div[@role='group']/following-sibling::button[@aria-label='Like product']")
	    private WebElement wishlistButton;

	    //Purchase / Checkout
	    @FindBy(xpath = "//div[contains(@class,'relative mb-2 overflow-hidden')]/child::button[@data-slot='button']")
	    private WebElement purchaseButton;

	    public WebElement getProductName() {
	        return productName;
	    }

	    public void getSize() {
	        size.click();
	    }

	    public void clickWishlist() {
	        wishlistButton.click();
	    }

	    public void clickPurchase() {
	        purchaseButton.click();
	    }
	}


