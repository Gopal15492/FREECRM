package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy (xpath="//span[contains(text(),'Gopal Ade')]")
	WebElement loggedUser;
	
	@FindBy(xpath="(//span[@class='header'])[1]")
	WebElement upcomingCallsMenu;
	
	@FindBy(xpath="//i[@class='users icon']")
	WebElement contactBtn;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
WebElement dealsLink;
	
public HomePage() {
	PageFactory.initElements(driver, this);
}
public boolean verifyLogUser() {
	return loggedUser.isDisplayed();
}
public boolean verifyCallsMenu() {
	return upcomingCallsMenu.isDisplayed();
}
public ContactsPage clickOnContact() {
	contactBtn.click();
	return new ContactsPage();
}
//public DealsPage clickOnDeals() {
//	dealsLink.click();
//	return new DealsPage();
//}



}