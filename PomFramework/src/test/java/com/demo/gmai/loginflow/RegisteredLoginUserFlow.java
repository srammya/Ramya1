package com.demo.gmai.loginflow;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;
import com.specomm.adidas.pagecomponents.LoginAccountPage;

public class RegisteredLoginUserFlow {
	static WebDriver driver;
	LoginAccountPage loginAccountPage;
	Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	GeneralActions genAction = new GeneralActions();

	
	
	 @BeforeTest
	  public void bTest() throws IOException {
		  driver = GeneralActions.launchBrowser(driver, "firefox");
		 
		  loginAccountPage = PageFactory.initElements(driver, LoginAccountPage.class);
		
		  ReusableActions.loadPropFileValues();
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
	      }
	 
	/**
	 * Login Flow Test Script
     */

	@Test( priority = 1, dataProviderClass=LoginAccountPage.class, dataProvider="getData")
	public void checkLoginUser(String username,String password) throws Exception {
		try {
			  
		      loginAccountPage.enterEmail(username);
		      loginAccountPage.clickEmailNextButton();
		      loginAccountPage.enterPassword(password);
		      loginAccountPage.clickSigninButton();

		      loginAccountPage.validateLandingPage();
		      
		     
		
		} catch (Throwable e) {
			e.printStackTrace();
		}
		}
	
	@Test( priority = 2)
	public void checkLogoutUser() throws Exception {
		try {
			  
		      
		      
		      loginAccountPage.clickChangeButton();
		      loginAccountPage.clickLogoutButton();
		     
		     
		
		} catch (Throwable e) {
			e.printStackTrace();
		}
		}
	
	
	
	@AfterTest
	public static void quitDriver()  {
	 try{
		 
		 
		 driver.quit();
		 }
		  catch (Exception e) {
		 e.printStackTrace();
		 }
	
}
}
