package com.qa.Hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.Hubspot.base.BasePage;
import com.qa.Hubspot.page.HomePage;
import com.qa.Hubspot.page.LoginPage;
import com.qa.Hubspot.util.AppConstants;
import com.qa.Hubspot.util.Credentials;

public class HomePageTest {
	
	
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	Credentials userCred;
	
	@BeforeTest
	public void setUP() throws InterruptedException {
		
	 basePage= new BasePage(); 
     prop=	basePage.init_properties();
     String browserName= prop.getProperty("browser");
	 driver= basePage.init_driver(browserName);	
	 driver.get(prop.getProperty("url"));
	 loginPage= new LoginPage(driver);
	 userCred= new Credentials(prop.getProperty("username"),prop.getProperty("password"));
	 homePage= loginPage.dologin(userCred);
	 Thread.sleep(5000);
		
	}
	
	@Test(priority=1)
	public void verifyHomePgageTitleTest() {
		
	String exphtitle=	homePage.getHomePageTitle();
	System.out.println("home page title is"+exphtitle);
	Assert.assertEquals(exphtitle, AppConstants.HOME_PAGE_TITLE);
		
		
	}
	
	
	@Test(priority=2)
	public void verifyHomePageHeaderTest() {
		
	String header=	homePage.getHomePageHeader();
	System.out.println("home page header is:"+header);
	Assert.assertEquals(header, AppConstants.HOME_PAGE_HEADER);
	
	
		
	}
	
	@Test(priority =3)
	public void getUserNameTest(){
	String user= homePage.getUserName();
	System.out.println(user);
	Assert.assertEquals(user, prop.getProperty("accountname"));
	}
	
	
	

	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
	
}
