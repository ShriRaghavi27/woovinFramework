package com.woovin.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.woovin.generic.webdriverutility.WebDriverUtility;

public class TransactionPage extends WebDriverUtility{
	WebDriver driver;

	public TransactionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//button[@data-testid='cancel-transaction-button']")
	private WebElement cancelBtn;
	
	@FindBy(xpath = "//button[@data-testid='cancel-transaction-confirm-dialog-confirm']")
	private WebElement cancelPayBtn;

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public WebElement getCancelPayBtn() {
		return cancelPayBtn;
	}
	
	public void clickCancelOrder(String payUrl,String siteUrl) {
		switchToTabOnURL(driver,payUrl);
		WebElement paymentPage = driver.findElement(By.xpath("//*[contains(text(),'WOOVIN B.V.')]"));
		Assert.assertTrue(paymentPage.isDisplayed());
		waitForElementToClick(driver, cancelBtn);
		getCancelBtn().click();
		waitForElementToClick(driver, cancelPayBtn);
		getCancelPayBtn().click();
		switchToTabOnURL(driver,siteUrl);
	}
}
