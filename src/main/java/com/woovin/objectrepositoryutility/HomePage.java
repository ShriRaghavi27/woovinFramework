package com.woovin.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.woovin.generic.webdriverutility.WebDriverUtility;


public class HomePage extends WebDriverUtility{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[@href='https://woovin.com/en']")
	private WebElement woovinLogo;
	
	@FindBy(name = "search")
	private WebElement searchEdt;
	
	@FindBy(xpath = "//span[text()='Sneakers']")
	private WebElement sneakersLink;
	
	@FindBy(xpath = "//span[text()='Apparel']")
	private WebElement apparelLink;
	
	@FindBy(xpath = "//a[normalize-space()='Denim Tears']")
	private WebElement denimLink;
	
	@FindBy(xpath  = "//a[text()='Wishlist']")
	private WebElement wishlistLink;
	
	@FindBy(xpath = "//a[contains(@href,'/dashboard/account-settings')]//span[normalize-space()='My account']")
	private WebElement MyAccountLink;
	
	@FindBy(xpath = "//button[normalize-space()='Logout']")
	private WebElement LogoutBtn;
	
	
	public WebElement getWoovinLogo() {
		return woovinLogo;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}
	
	public WebElement getSneakersLink() {
		return sneakersLink;
	}
	
	public WebElement getLink() {
		return apparelLink;
	}
	
	public WebElement getdenimLink() {
		return denimLink;
	}

	public WebElement getWishlistLink() {
		return wishlistLink;
	}

	public WebElement getMyAccountLink() {
		return MyAccountLink;
	}

	public WebElement getLogoutBtn() {
		return LogoutBtn;
	}
	
	public void clickWoovinLink()
	{
	waitForElementToClick(driver, woovinLogo); 
	}
	
	public void clickSneakerLink()
	{
		sneakersLink.click();
	}
	
	public void clickApprealLink()
	{
		apparelLink.click();
	}

	public void logout()
	{
		mouseMoveOnElement(driver, MyAccountLink);
	    LogoutBtn.click();
	}
	
}
