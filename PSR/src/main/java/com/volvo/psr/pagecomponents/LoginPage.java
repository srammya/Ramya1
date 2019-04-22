package com.volvo.psr.pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.volvo.psr.common.utils.CommonWrapperMethods;



public class LoginPage extends CommonWrapperMethods {
	
	protected WebDriver driver;
	
		

	
	
	public LoginPage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	   	}
	 
	
	

	public void loginPage(String uName,String pWord){
		
		try{
			sendKeys("UserName", By.xpath(prop.getProperty("LoginPage.User.Name")), uName);
			sendKeysPassword("Password", By.xpath(prop.getProperty("LoginPage.User.Password")), pWord);
			anyClick("Submit", By.xpath(prop.getProperty("LoginPage.Login.Button")));
			reportStep("Verify the functionality of logging into Psr application", "pass", false);
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
