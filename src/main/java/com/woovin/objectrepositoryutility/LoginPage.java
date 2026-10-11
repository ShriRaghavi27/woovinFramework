package com.woovin.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.woovin.generic.webdriverutility.WebDriverUtility;



public class LoginPage extends WebDriverUtility{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//a[contains(@href,'/en/login')]")
	private WebElement signInLink;
	
	@FindBy(id = "email")
	private WebElement emailEdt;
	
	@FindBy(name = "password")
	private WebElement passwordEdt;
	
	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement loginBtn;
	
	public WebElement getSignInLink() {
		return signInLink;
	}
	public WebElement getUsername() {
		return emailEdt;
	}

	public WebElement getPassword() {
		return passwordEdt;
	}

	public WebElement getLogin() {
		return loginBtn;
	}
	
	public void Login(String url,String username,String password) throws InterruptedException {
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		signInLink.click();
		emailEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
		System.out.println("Successfully login");
		Thread.sleep(2000);
	}
	
}
