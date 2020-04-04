package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.base.BasePage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;

public class LoginPage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	
	//locators
	//Non page factory
	By emailId=By.id("username");
	By password =By.id("password");
	By loginBtn= By.id("loginBtn");
	
	//Constructor
	public LoginPage(WebDriver driver){
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	//Page.actions
	public String getLoginTitle(){
		return elementUtil.waitForGetPageTitle(Constants.LOGIN_PAGE_TITLE);
	}
	public HomePage doLogin(String username,String pswrd){
		elementUtil.waitForElementPresentBy(emailId);
		elementUtil.doSendKeys(emailId, username);
		elementUtil.doSendKeys(password, pswrd);
		elementUtil.doClick(loginBtn);
		return new HomePage(driver);
	}
		
}
