package com.specomm.adidas.accountcreation;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;
import com.specomm.adidas.pagecomponents.AccountDashboardPage;
import com.specomm.adidas.pagecomponents.AdidasHomePage;
import com.specomm.adidas.pagecomponents.NewAccountCreationPage;

public class NewAccountCreationFlow extends GeneralActions{
	
	static WebDriver driver;
	NewAccountCreationPage newAccountCreationPage;
	AccountDashboardPage accountDashboardPage;
	AdidasHomePage adidasHomePage;
	Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	GeneralActions genAction = new GeneralActions();
	
	
	 @BeforeClass
	  public void setUp() throws IOException {
		  driver = getDriver();
		  driver = launchBrowser(driver, "firefox");
		  newAccountCreationPage=PageFactory.initElements(driver,NewAccountCreationPage.class);
		  accountDashboardPage=PageFactory.initElements(driver,AccountDashboardPage.class);
		  adidasHomePage=PageFactory.initElements(driver,AdidasHomePage.class);
		  ReusableActions.loadPropFileValues();
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
	      }
	
	
	 
	 @Test(priority=1,dataProviderClass=NewAccountCreationPage.class, dataProvider="getData")
	
	 public void userCreation(String rFName,String rLName,String Day,String Month,String Year,String rAddress,String rPword,String rcPword){
		 newAccountCreationPage=new NewAccountCreationPage(driver);
		 adidasHomePage=new AdidasHomePage(driver);
		 ReusableActions.waitForpageToLoad(driver);
		 adidasHomePage.popUp();
		 adidasHomePage.clickLogin();
		 adidasHomePage.clickCreateAccount();
		 newAccountCreationPage.enterNewAccountDetails(rFName, rLName, Day, Month, Year, rAddress, rPword, rcPword);
		 }
	 
	 @Test(priority=2)
	 public void userLandingPage(){
		 accountDashboardPage=new AccountDashboardPage(driver);
		 ReusableActions.waitForpageToLoad(driver);
		 accountDashboardPage.verifyThanksMessage();
	 }
	 
	 @Test(priority=3,dataProviderClass=NewAccountCreationPage.class, dataProvider="getData")
	 public void userAccountInfo(String fsName,String lsName,String biDay,String biMonth,String biYear,String Mail,String rPword,String rcPword){
		 accountDashboardPage=new AccountDashboardPage(driver);
		 accountDashboardPage.verifyAccountInfo(fsName, lsName,biDay, biMonth, biYear,Mail);
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