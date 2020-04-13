package com.qa.Hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Hubspot.base.BasePage;
import com.qa.Hubspot.page.HomePage;
import com.qa.Hubspot.page.LoginPage;
import com.qa.Hubspot.util.AppConstants;
import com.qa.Hubspot.util.Credentials;

public class LoginPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	Credentials userCred;
	
	
	@BeforeTest
	public void setUP() {
		
	 basePage= new BasePage(); 
     prop=	basePage.init_properties();
     String browserName= prop.getProperty("browser");
	 driver= basePage.init_driver(browserName);	
	 driver.get(prop.getProperty("url"));
	 loginPage= new LoginPage(driver);	
	 userCred= new Credentials(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {

		
	
	
	
	String title=	loginPage.getPageTitle();
	System.out.println("login page title is:"+title);
	Assert.assertEquals(title, AppConstants.HOME_PAGE_TITLE);
		
	}
	
	@Test(priority=2)
	public void verifySignUpLinkTest() {
		
		Assert.assertTrue(loginPage.checkSignupLink());
		
		
	}
	
	@Test(priority=3)
	public void loginTest() {
		
    HomePage homepage=	loginPage.dologin(userCred);
		
		
	}
	
	
	@DataProvider
	public Object[][] getLoginInvalidData() {
		
		Object data[][]= {
				
				{"test111@gmail.com","test123"},
				{"test2@gmail.com",""},
				{"","test12345"},
				{"test","test"},
				{" "," "},
				
		  };
		return data;		
				
		}
		
	
	
	@Test(priority=4, dataProvider="getLogininvalidData",enabled=false)
	public void login_InvalidTestCases(String username, String pwd) {
	userCred.setAppUsername(username);
	userCred.setAppPassword(pwd);
		
	loginPage.dologin(userCred);	
	
	Assert.assertTrue(loginPage.checkLoginErrorMesg());
		
	}
	
	
	
	
	@AfterTest
	public void tearDown() { 
		
		driver.quit();
	}
	
	
	

}
