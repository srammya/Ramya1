package com.specomm.uniqlo.loginflow;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.specomm.uniqlo.common.utils.GeneralActions;
import com.specomm.uniqlo.common.utils.ReusableActions;
import com.specomm.uniqlo.pagecomponents.UniqloHomePage;
import com.specomm.uniqlo.pagecomponents.UniqloLoginPage;
import com.specomm.uniqlo.testreport.TestListener;

public class InvalidUserNameFlow extends GeneralActions{

	static WebDriver driver;
	
	UniqloHomePage uniqloHomePage=new UniqloHomePage(driver);
	UniqloLoginPage uniqloLoginPage=new UniqloLoginPage(driver);
	Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	GeneralActions genAction = new GeneralActions();
	
	
	 @BeforeClass
	  public void setUp() throws IOException {
		  driver = getDriver();
		  driver = launchBrowser(driver, "firefox");
		  uniqloHomePage=PageFactory.initElements(driver,UniqloHomePage.class);
		  uniqloLoginPage=PageFactory.initElements(driver,UniqloLoginPage.class);
		  ReusableActions.loadPropFileValues();
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
	      }
	
	
	 
	 @Test(priority=1)
	
	 public void invalidloginUser(){
		
		 
		 ReusableActions.waitForpageToLoad(driver);
		 uniqloHomePage.closePopup();
		 uniqloLoginPage.enterCredentials("mail2@mailinator.co", "Test$1234");
		 uniqloLoginPage.validateMessage();
		
		 }
	 
	 @AfterMethod
     public void afterMethod() throws IOException {
   
         if (driver != null) {
          File file = new File("Screenshots" + fileSeperator + "Results");
    if (!file.exists()) {
     Reporter.log("File created " + file, true);
     file.mkdir();
     System.out.println("Dir created");
    }
           File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    
    FileUtils.copyFile(screenshotFile,new File(dir+fileSeperator+"Screenshots" + fileSeperator + "Results" + fileSeperator+this.getClass().getSimpleName()+fileSeperator+TestListener.testMethodName+fileSeperator+TestListener.screenShotName));
         }
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
