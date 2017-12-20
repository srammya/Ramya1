package com.specomm.adidas.loginflow;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;
import com.specomm.adidas.pagecomponents.AdidasHomePage;
import com.specomm.adidas.pagecomponents.AdidasLoginPage;
import com.specomm.adidas.pagecomponents.ForgotPasswordPage;

public class ForgotPasswordFlow extends GeneralActions{
	

	static WebDriver driver;
	ForgotPasswordPage forgotPasswordPage;
	AdidasHomePage adidasHomePage;
	AdidasLoginPage adidasLoginPage;
	Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	GeneralActions genAction = new GeneralActions();
	
	
	 @BeforeClass
	  public void setUp() throws IOException {
		  driver = getDriver();
		  driver = launchBrowser(driver, "firefox");
		  adidasHomePage=PageFactory.initElements(driver,AdidasHomePage.class);
		  adidasLoginPage=PageFactory.initElements(driver,AdidasLoginPage.class);
		  forgotPasswordPage=PageFactory.initElements(driver,ForgotPasswordPage.class);
		  ReusableActions.loadPropFileValues();
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
	      }
	
	
	 
	 @Test(priority=1)//,dataProviderClass=NewAccountCreationPage.class, dataProvider="getData")
	
	 public void recoveryPwd(){
		 adidasHomePage=new AdidasHomePage(driver);
		 adidasLoginPage=new AdidasLoginPage(driver);
		 forgotPasswordPage=new ForgotPasswordPage(driver);
		 adidasHomePage.popUp();
		
		 adidasHomePage.clickLogin();
		 forgotPasswordPage.recoveryPassword("ramay@mailinator.com");
		 forgotPasswordPage.VerifyPasswordResetMessage();
		 
		 }
	 
	 
	 @AfterClass
		public static void quitDriver()  {
		 try{
			 
			 Thread.sleep(5000);
			 driver.quit();
			 }
			  catch (Exception e) {
			 e.printStackTrace();
			 }
		
	}
}