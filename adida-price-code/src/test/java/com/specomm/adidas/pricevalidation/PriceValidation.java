package com.specomm.adidas.pricevalidation;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;
import com.specomm.adidas.pagecomponents.PriceValidationPage;

public class PriceValidation extends GeneralActions {

static WebDriver driver;
public static String cdir = System.getProperty("user.dir");
	
	
	
	
	PriceValidationPage priceValidationPage;

	Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	
	
	
	
	
	 @BeforeClass
	  public void setUp() throws IOException, InterruptedException {
		  
		  driver = launchBrowser(driver, "firefox");
		  
		  priceValidationPage=PageFactory.initElements(driver,PriceValidationPage.class);
		  ReusableActions.loadPropFileValues();
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
		 
	      }
	
	  
	 @Test
	 
	 public void priceValidate(){
		 try{
			 priceValidationPage.closePopUp();
			 priceValidationPage.csvFileReading();
			 
			 
		 }
		 catch (Exception e) {
			 e.printStackTrace();
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