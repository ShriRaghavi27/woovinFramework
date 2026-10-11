package com.woovin.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.woovin.generic.webdriverutility.WebDriverUtility;

public class CheckoutPage extends WebDriverUtility{

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[@data-slot='label']/following-sibling::button[@data-slot='popover-trigger']")
	private WebElement countryDropdown;

	@FindBy(xpath = "//div[@role='group']//div[2]")
	private WebElement countryOption;

	@FindBy(id = "address")
	private WebElement address;

	@FindBy(id = "postal_code")
	private WebElement postcode;

	@FindBy(id = "city")
	private WebElement town;
	
	@FindBy(xpath = "//button[@type='submit']")
    private WebElement placeOrder;
	
	public WebElement getCountryDropdown() {
		return countryDropdown;
	}

	public WebElement getCountryOption() {
		return countryOption;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getPostcode() {
		return postcode;
	}

	public WebElement getTown() {
		return town;
	}

	public WebElement getPlaceOrder() {
		return placeOrder;
	}

	public void clickPlaceOrder(String address,String postcode,String town) {
		getCountryDropdown().click();
		getCountryOption().click();
		waitForElementToClick(driver, countryDropdown);
		getAddress().sendKeys(Keys.CONTROL, "a");
		getAddress().sendKeys(address);
		getPostcode().clear();
		getPostcode().sendKeys(postcode);
		getTown().clear();
		getTown().sendKeys(town);
        clickUsingJavaScript(driver, placeOrder);
    }

}
