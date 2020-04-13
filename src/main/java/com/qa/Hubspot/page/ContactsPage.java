package com.qa.Hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Hubspot.base.BasePage;
import com.qa.Hubspot.util.ElementUtil;
import com.qa.Hubspot.util.JavaScriptUtil;

public class ContactsPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;

	By createContactButton = By.xpath("//button[@type='button']//span[text()='Create contact']");
	By createContactFormButton = By.xpath("//button/span[text()='Create contact']");

	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");

	public  ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);

	}

	public String getContactsPageTitle() {
	elementUtil.waitforTitlePresent("Contacts");
	return elementUtil.doGetPageTitle();
	}

	public void createNewContact(String mail, String FN, String LN, String jobtitle) {
		// Thread.sleep(5000);
		elementUtil.waitforElementPresent(createContactButton);
		elementUtil.doClick(createContactButton);

		elementUtil.waitforElementPresent(email);
		elementUtil.doSendKeys(email, mail);

		elementUtil.doSendKeys(firstName, FN);

		elementUtil.doSendKeys(lastName, LN);

		elementUtil.doSendKeys(jobTitle, jobtitle);

		// elementUtil.doClick(createContactFormButton);
		jsUtil.clickElementByJS(elementUtil.getElement(createContactFormButton));

	}

}

	
	
	
	


