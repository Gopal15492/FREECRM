package com.crm.qa.testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
public 	HomePageTest() {
	super();
}
@BeforeMethod
public void setup()
{
	initialization();  
	testUtil =new TestUtil(); 
		 loginPage=new LoginPage();		
			homePage=	loginPage.doLogin(prop.getProperty("email"),prop.getProperty("password"));
	}
@Test(priority=1)   //seprt browser for each tc so tc shold be indepned
public void verifyLogUserTest() {
   Assert.assertTrue( homePage.verifyLogUser());   
}
@Test(priority=2)
public void verifycallTest() {
   Assert.assertTrue( homePage.verifyCallsMenu());   //true/false
}
@Test(priority=3)
public void clickOnContact() {
	
	contactsPage=homePage.clickOnContact();
}

@AfterMethod
public void tearDown() 
{
	driver.quit();
	
}

}
