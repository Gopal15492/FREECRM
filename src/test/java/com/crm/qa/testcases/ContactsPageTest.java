/* 
 *@author commited by Gopal ade
  */

package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest  extends TestBase{
		LoginPage loginPage;
		HomePage homePage;
		TestUtil testUtil;
		ContactsPage contactsPage;
		String sheetName="contacts";
		
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup()
	{  
		initialization();  
		 testUtil =new TestUtil(); 
		 contactsPage = new ContactsPage();
		 loginPage=new LoginPage();		
		homePage=	loginPage.doLogin(prop.getProperty("email"),prop.getProperty("password"));
		contactsPage=	homePage.clickOnContact();
		
	}

@Test(priority=1)
	public void clickOnContact() throws InterruptedException {
		
		Assert.assertTrue(contactsPage.verifycontactLabel());
	}
	
	@Test(priority=2)
	public void verifycheckBoxIsSelectedOrNot() throws InterruptedException {
	contactsPage.clickOnContacts();
	}
	

	@DataProvider
	public Object[][] getCRMTestData() {

		Object data[][]=TestUtil.getTestData(sheetName);	
		
		return data;
	}
	@Test(priority=3,dataProvider="getCRMTestData")
	public void clickOnCreates(String firstname, String lastname, String company) throws InterruptedException {
		contactsPage.clickOnCreate();
		
		//contactsPage.createNewContactFields("Gopa","Ade","XYZ");	
		contactsPage.createNewContactFields(firstname, lastname, company);
		contactsPage.clickOnContacts();
		} 

	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
		
	}
	

	
}
