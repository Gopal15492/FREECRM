package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();   //to call parent class conts to init method
	}
	@BeforeMethod
	public void setup()
	{
		initialization();         //before this 1st call superclass cnstr then init browser until url open
			 loginPage=new LoginPage();		
		}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
	String title = loginPage.validateTitle();     //to access method need to crt obj lpc
	Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void loginTest() { //dologin is return homepg class object and we r store in ref of it 
		homePage=	loginPage.doLogin(prop.getProperty("email"),prop.getProperty("password"));
	}
	
	@AfterMethod 
	public void tearDown() 
	{
		driver.quit();
		
	}
		
		
	}
	


