package com.hubspot.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hubspot.base.BasePage;
import com.hubspot.pages.LoginPage;
import com.hubspot.util.Constants;

@Listeners(com.hubspot.listeners.ExtentReportListener.class)
public class LoginPageTest {

	Logger log =Logger.getLogger("LoginPageTest");
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUP(){
		basePage=new BasePage();
		log.info("Browser is launching...");
		prop=basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		loginPage=new LoginPage(driver);
	}
	
	@Test(priority=1, enabled=true   ,description="HubSpot login Get title")
	public void getTitle(){
		log.info("LogIn test GetTitle is Starting");
		String title=loginPage.getLoginTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE,"Title is in-correct");
		log.info("LogIn test GetTitle is ending");
	}
	
	@Test(priority=2, enabled=true   ,description="Login test using incorrect username and title")
	public void loginTest(){
		loginPage.doLogin(prop.getProperty("incorrectUser"), prop.getProperty("incorrectPassword"));
	}
	@Test(priority=3, enabled=true   ,description="Login test using correct username and title")
	public void loginTest2(){
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
	}
	
}
