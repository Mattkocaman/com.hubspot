package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.base.BasePage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;

public class HomePage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	
	By header =By.xpath("//h1[contains(text(),'Sales Dashboard')]");
	By contactMainTab = By.id("nav-primary-contacts-branch");
	By contatcChildTab = By.id("nav-secondary-contacts");
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	public String getHomePageTitle(){
		return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
	}
	
	public String getHomePageHeader(){
		elementUtil.waitForElementPresentBy(header);
		return elementUtil.doGetText(header);
	}
	//helper method
	private void clickOnContacs(){
		elementUtil.doClick(contactMainTab);
		elementUtil.doClick(contatcChildTab);
	}

	public ContactsPage gotoContactsPage() {
		clickOnContacs();
		return new ContactsPage(driver);
	}

	
	
}
