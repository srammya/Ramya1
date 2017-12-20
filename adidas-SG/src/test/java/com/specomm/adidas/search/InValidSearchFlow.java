package com.specomm.adidas.search;

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
import com.specomm.adidas.pagecomponents.InvalidSearchPage;

public class InValidSearchFlow extends GeneralActions{
	

	static WebDriver driver;
	
	AdidasHomePage adidasHomePage;
	InvalidSearchPage invalidSearchPage;
	Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	GeneralActions genAction = new GeneralActions();
	
	
	 @BeforeClass
	  public void setUp() throws IOException {
		  driver = getDriver();
		  driver = launchBrowser(driver, "firefox");
		  adidasHomePage=PageFactory.initElements(driver,AdidasHomePage.class);
		  invalidSearchPage=PageFactory.initElements(driver,InvalidSearchPage.class);
		  ReusableActions.loadPropFileValues();
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
	      }
	
	
	 
	 @Test(priority=1)
	
	 public void searchProduct(){
		 adidasHomePage=new AdidasHomePage(driver);
		 invalidSearchPage=new InvalidSearchPage(driver);
		 adidasHomePage.popUp();
		 adidasHomePage.clickSearch();
		 adidasHomePage.enterItem("**");
		 invalidSearchPage.verifyInvalidProduct();
		 
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