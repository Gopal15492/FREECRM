package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	@FindBy (name="email")
	WebElement email;
	
	@FindBy (name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement 	loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	public LoginPage() { //init page obj
		PageFactory.initElements(driver, this);//this>LoginPage.class
	}
	
	public String validateTitle() { //actions on page
		return driver.getTitle();
	}
	public HomePage doLogin(String eml, String pwd) {
		email.sendKeys(eml);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
		
	}
		
}
