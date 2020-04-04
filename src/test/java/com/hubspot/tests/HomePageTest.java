package com.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hubspot.base.BasePage;
import com.hubspot.pages.HomePage;
import com.hubspot.pages.LoginPage;
import com.hubspot.util.Constants;

@Listeners(com.hubspot.listeners.ExtentReportListener.class)
public class HomePageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp(){
		basePage=new BasePage();
		prop=basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		loginPage=new LoginPage(driver);		
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test(priority=1,  description="Get home page TITLE")
	public void verifyHomePageTitle(){
		String title=homePage.getHomePageTitle();
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	@Test(priority=2,  description="Get home page HEADER")
	public void getHomePageHeader(){
		String header=homePage.getHomePageHeader();
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);
	}
	
	
	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
	}
	
	
	
	
}
