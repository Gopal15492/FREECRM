package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import com.crm.qa.util.MyListener2;
import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver org_driver;
	public static Properties prop;
	public static 	WebDriver driver;
	public static MyListener2 listener;
	public static 	EventFiringDecorator<WebDriver> decorator;
	
	public TestBase(){
		
		try {
		 prop =new Properties();

			FileInputStream ip=new FileInputStream("C:\\Users\\Gopal Ade\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		
			prop.load(ip);	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		
		} catch (IOException e) {
			e.printStackTrace();	
	}
	}
	
	public static void initialization() {
	String browserName = prop.getProperty("browser");
	
	if(browserName.equals("chrome")) {
		org_driver=new ChromeDriver();
		
	}else if(browserName.equals("ff")) {	
		org_driver=new FirefoxDriver();
		
	}else if(browserName.equals("edge")) {
		 org_driver=new EdgeDriver();
}
	 listener=new MyListener2();
	decorator=new EventFiringDecorator<WebDriver>(listener);

	driver= decorator.decorate(org_driver);	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT_TIMEOUT));
	
	driver.get(prop.getProperty("url"));
}
}


