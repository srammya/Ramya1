package com.specomm.uniqlo.accountcreation;

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
import com.specomm.uniqlo.pagecomponents.NewAccountPage;
import com.specomm.uniqlo.pagecomponents.UniqloHomePage;
import com.specomm.uniqlo.testreport.TestListener;

public class NewAccountFlow extends GeneralActions{
	
	static WebDriver driver;
	
	UniqloHomePage uniqloHomePage=new UniqloHomePage(driver);
	NewAccountPage newAccountPage=new NewAccountPage(driver);
	Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	GeneralActions genAction = new GeneralActions();
	
	
	 @BeforeClass
	  public void setUp() throws IOException {
		  driver = getDriver();
		  driver = launchBrowser(driver, "firefox");
		  uniqloHomePage=PageFactory.initElements(driver,UniqloHomePage.class);
		  newAccountPage=PageFactory.initElements(driver,NewAccountPage.class);
		  ReusableActions.loadPropFileValues();
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
	      }
	
	
	 
	 @Test(priority=1,dataProviderClass=NewAccountPage.class, dataProvider="getData")
	
	 public void userCreation(String rEmail,String title,String rFirstName,String rLastName,String rAddress,String rCity,String rProvince,String rPcode,String rPhone,String rPassword,String rCPassword,String dDay,String dMonth,String dYear){
		
		 
		 ReusableActions.waitForpageToLoad(driver);
		 uniqloHomePage.closePopup();
		 uniqloHomePage.clickRegister();
		 newAccountPage.enterAccountDetails(rEmail, title, rFirstName, rLastName, rAddress, rCity,rProvince, rPcode,rPhone, rPassword, rCPassword, dDay, dMonth, dYear);
		 newAccountPage.verifyMyAccount();
		
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