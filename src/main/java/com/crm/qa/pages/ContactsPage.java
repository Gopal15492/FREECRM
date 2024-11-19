package com.crm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase{
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//a[@href='/contacts/new']")
	WebElement clickOnCreate;

@FindBy(xpath="//i[@class='users icon']")
WebElement contactBtn;

@FindBy(xpath="//span[@class='selectable ']")
WebElement contactLabel;

@FindBy(css="*[name='first_name']")
WebElement firstName;

@FindBy(name="last_name")
WebElement lastName;


@FindBy(xpath="//div[@name='company']//input[@type='text']")
WebElement companyName;

@FindBy(xpath="//button[normalize-space()='Save']")
WebElement saveBtn;

public boolean verifycontactLabel() {
	return contactLabel.isDisplayed();
	
}
public void clickOnContacts() throws InterruptedException {
Actions act=new Actions(driver);
act.moveToElement(contactBtn).build().perform();
	contactBtn.click();
}

public void clickOnCreate() throws InterruptedException {
	Actions act=new Actions(driver);
	act.moveToElement(clickOnCreate).build().perform();
	clickOnCreate.click();
}

public void createNewContactFields(String fname, String lname, String company)  {
	firstName.sendKeys(fname);
	lastName.sendKeys(lname);
	companyName.sendKeys(company);
//	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//WebElement ntn = wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
//ntn.click();
saveBtn.click();

}
}
	

