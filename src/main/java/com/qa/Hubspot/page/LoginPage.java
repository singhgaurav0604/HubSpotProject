package com.qa.Hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Hubspot.base.BasePage;
import com.qa.Hubspot.util.AppConstants;
import com.qa.Hubspot.util.Credentials;
import com.qa.Hubspot.util.ElementUtil;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	
	//1. locators -By
	
	By emailid= By.id("username");
	By password= By.id("password");
	By loginButton= By.id("loginBtn");
	By signUpLink=By.linkText("Sign up");
	By loginErrorText= By.xpath("//div[@class='private-alert__inner']/h5");
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil= new ElementUtil(driver);
		
		
	}
	
	
	//page actions:
	
	public String getPageTitle() {
		
	elementUtil.waitforTitlePresent(AppConstants.LOGIN_PAGE_TITLE);	
		
	return	elementUtil.doGetPageTitle();
	
	}
	
	
	public boolean checkSignupLink() {
	elementUtil.waitforElementPresent(signUpLink);	
	return	elementUtil.doIsDisplayed(signUpLink);
		
	}
	
	
	public HomePage dologin(Credentials userCred) {
		
   //  driver.findElement(emailid).sendKeys(username);
   //  driver.findElement(password).sendKeys(pwd);
   //  driver.findElement(loginButton).click();
		
		elementUtil.waitforElementPresent(emailid);
		elementUtil.doSendKeys(emailid, userCred.getAppUsername());
		elementUtil.doSendKeys(password, userCred.getAppPassword());
		elementUtil.doClick(loginButton);
		
     
     return new HomePage(driver);
	
		
	}
	
	public boolean checkLoginErrorMesg() {
		
		return elementUtil.doIsDisplayed(loginErrorText);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
