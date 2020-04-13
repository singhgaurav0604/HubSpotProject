package com.qa.Hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BasePage {
	
	WebDriver driver;
	Properties prop;
	public static boolean highlightElement;
	
//	public static ThreadLocal<WebDriver> tldriver= new ThreadLocal<WebDriver>();
//	
//	public static synchronized WebDriver getDriver() {
//		
//		return tldriver.get();
//	}
//	
	
	
	
	
	public WebDriver init_driver(String browserName) {
		highlightElement = prop.getProperty("highlight").equals("yes")? true : false;
		
		System.out.println("browser name is: "+ browserName);
		
		if(browserName.equals("chrome")) {
			
			if(prop.getProperty("headless").equals("yes")){
				
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				
				driver= new ChromeDriver(co);
				
			}
			
			else {
				driver= new ChromeDriver();
				
			}
			
			
			
			
			
		}
		
		else if(browserName.equals("firefox")) {
			
			driver = new FirefoxDriver();

			
		}
		
		else if(browserName.equals("safari")) {
			
			driver= new SafariDriver();
			
		}
		
		else {
			System.out.println("browser name"+ browserName+ "is not found, please pass the correct browser");
			
		}
		
		driver.manage().deleteAllCookies();
	//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	//	driver.get(url);
		
		
		
		
		return driver;	
		
		
	}
	
	
	public Properties init_properties() {
		
		prop= new Properties();
		String path = null;
		String env = null;

		try {
			env = System.getProperty("env");

			if (env.equals("qa")) {
				path = "./src/main/java/com/qa/Hubspot/config/qa.config.properties";
			} else if (env.equals("stg")) {
				path = "./src/main/java/com/qa/Hubspot/config/stg.config.properties";
			}
		} catch (Exception e) {
			path = "./src/main/java/com/qa/Hubspot/config/config.properties";
			
		}

		try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("some issue with config properties....Please correct your config...");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
		}


	/**
	 * 
	 * 
	 * 
	 */
		
	
	public String getScreenshot() {
		
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path= System.getProperty("user.dir")+ "/screenshots"+ System.currentTimeMillis()+".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			
			System.out.println("screenshot captured failed.......");
		}
		return path;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
