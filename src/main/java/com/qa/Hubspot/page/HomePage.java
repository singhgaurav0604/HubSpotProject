package com.qa.Hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Hubspot.util.AppConstants;
import com.qa.Hubspot.util.ElementUtil;

public class HomePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	By header= By.xpath("//span/h1[text()='Service Dashboard']");
    By account = By.id("account-menu");
    By userName = By.className("user-info-name");
    
	By mainContactsLink = By.id("nav-primary-contacts-branch");
	By childContactsLink = By.id("nav-secondary-contacts");
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		elementUtil= new ElementUtil(driver);
	}
	

	
	  public String getHomePageTitle() {
		elementUtil.waitforTitlePresent(AppConstants.HOME_PAGE_TITLE);
		
		return elementUtil.doGetPageTitle();
		
		
		
	}
	
	
	
	public String getHomePageHeader() {
		
	return	elementUtil.doGetText(header);
		
		
	}
	
	public String getUserName() {
	driver.findElement(By.xpath("//a[@id='account-menu']")).click();
	return driver.findElement(userName).getText();
	}
	
	
	public void clickOnContacts() {
		elementUtil.waitforElementPresent(mainContactsLink);
		elementUtil.doClick(mainContactsLink);
		
		elementUtil.waitforElementPresent(childContactsLink);
		elementUtil.doClick(childContactsLink);
		
	}

	public ContactsPage goToContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}

	
	
	
	
}
