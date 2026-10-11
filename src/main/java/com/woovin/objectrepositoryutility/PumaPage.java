package com.woovin.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.woovin.generic.webdriverutility.WebDriverUtility;

public class PumaPage extends WebDriverUtility{
	WebDriver driver;
	public PumaPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//button[@aria-label='Like product']")
	private WebElement likeBtn;
	
	public WebElement getLikeBtn() {
		return likeBtn;
	}
	public void clickLike()
	{
		waitForElementToClick(driver, likeBtn);
		likeBtn.click();
	}
}
