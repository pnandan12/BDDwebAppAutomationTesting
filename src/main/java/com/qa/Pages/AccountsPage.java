package com.qa.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	private WebDriver driver;
	private By accountSection = By.cssSelector("div#center_column span");
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
	}
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
	public int getAccountSectionCount() {
		return driver.findElements(accountSection).size();
	}
	public List<String> getAccountSectionList() {
		List<String> acountsList = new ArrayList<String>();
		List<WebElement>accountHeadersList= driver.findElements(accountSection);
		for(WebElement e:accountHeadersList ) {
			String text=e.getText();
			System.out.println(text);
			acountsList.add(text);
		}
		return acountsList;
	}
	
}
