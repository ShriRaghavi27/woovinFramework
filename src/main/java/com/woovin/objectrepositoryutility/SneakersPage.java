package com.woovin.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.woovin.generic.webdriverutility.WebDriverUtility;

public class SneakersPage extends WebDriverUtility{
	
	WebDriver driver;
	public SneakersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//button[@data-slot='button']//span[normalize-space()='Sneakers']")
	private WebElement sneakersBtn;

	@FindBy(xpath = "//button[@type='button']//div[normalize-space()='Filter']")
	private WebElement filterBtn;

	@FindBy(xpath = "//div[@role='dialog']//li//button[normalize-space()='Puma']")
	private WebElement pumaBtn;

	@FindBy(xpath = "//button[normalize-space()='Done']")
	private WebElement doneBtn;

	@FindBy(xpath = "//span[normalize-space()='Puma']")
	private WebElement verifyPumaBtn;
	
	public WebElement getSneakersText() {
		return sneakersBtn;
	}
	public WebElement getFilterBtn() {
		return filterBtn;
	}
	public WebElement getPumaBtn() {
		return pumaBtn;
	}
	public WebElement getDoneBtn() {
		return doneBtn;
	}
	public WebElement getVerifyPumaBtn() {
		return verifyPumaBtn;
	}
	
	public void clickPumaProductUsingFilter() throws InterruptedException
	{
	    filterBtn.click();
	    pumaBtn.click();
	    Thread.sleep(2000);
	    waitForElementToClick(driver, doneBtn);
	    mouseMoveOnElement(driver, doneBtn);
	    doneBtn.click();
	}
	public void clickProduct(String productName)
	{
	    WebElement product = driver.findElement(By.xpath("//div[@id='woovin-browse-grid']//h3[normalize-space()='"+ productName + "']/ancestor::a"));
	    clickUsingJavaScript(driver, product);
	}
	
}
