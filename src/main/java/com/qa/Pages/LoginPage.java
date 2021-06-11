package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	/**
	 * 1.page lib using by locators or OR
	 */
	private By emailId = By.id("email");
	private By password= By.id("passwd");
	private By signInButton= By.id("SubmitLogin");
	private By forgetLink = By.xpath("//p/a[contains(text(),'Forgot your password?')]");
	
	//2. Constructor of the class
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	//3. page actions: features of the page in the form of methods
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean isForgetPwdLink() {
		return driver.findElement(forgetLink).isDisplayed();
	}
	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	public void clickOnSignInButton() {
		driver.findElement(signInButton).click();
	}
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("logined with "+un+" and "+pwd );
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		return new AccountsPage(driver);
	}
	
	
	
	
	
}
