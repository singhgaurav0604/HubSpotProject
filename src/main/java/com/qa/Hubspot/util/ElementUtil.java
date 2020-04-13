package com.qa.Hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Hubspot.base.BasePage;

public class ElementUtil extends BasePage {
	
	
	
	WebDriver driver;
	WebDriverWait wait;
	JavaScriptUtil jsUtil;
	
	public ElementUtil(WebDriver driver) {
		
		this.driver= driver;
		wait = new WebDriverWait(driver, AppConstants.DEFAULT_TIME_OUT);
		jsUtil = new JavaScriptUtil(driver);
		
		
	}
	
	
	public boolean waitforElementPresent(By locator) {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
		
	}
	
     public boolean waitforTitlePresent(String title) {
		
		wait.until(ExpectedConditions.titleIs(title));
		return true;
	}
	
	
	
	public boolean waitforElementVisible(By locator) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}
	
	
	public String doGetPageTitle() {
		
		return driver.getTitle();
		
		
	}
	
	
	
	public WebElement getElement(By locator) {
		WebElement element= null;
		
		try {
		 element = driver.findElement(locator);
		 if(highlightElement) {
			 jsUtil.flash(element);
		 }
		}
		catch(Exception e) {
			System.out.println("some exception got occurred while creating the web element.....");
			
		}
		return element;
	}
	
	
	public void doClick(By locator) {
		try {
		getElement(locator).click();
		}
		catch(Exception e) {
			System.out.println("some exception got occurred while creating the web element.....");
			
		}
	}
	
	
	public void doSendKeys(By locator, String value) {
		
		try {
		WebElement ele = getElement(locator);
		ele.clear();
		ele.sendKeys(value);
		}catch(Exception e) {
			System.out.println("some exception got occurred while entering value in a field.....");
			
			
		}
	}
	
	public boolean doIsDisplayed(By locator) {
		
		try {
	    return	getElement(locator).isDisplayed();
		}catch(Exception e) {
		System.out.println("some exception got occurred.....");
	}
	return false;
	
	}
	
	
	public String doGetText(By locator) {
		
		try {
		return getElement(locator).getText();
		} catch(Exception e) {
			
			System.out.println("some exception got occurred while getting text value from field....");
			
		}
		
		return null;
	}
	
	
	
	
	
	
	

	}
