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
import com.specomm.adidas.pagecomponents.ProductDetailsPage;

public class ValidSearchFlow extends GeneralActions{
	

	static WebDriver driver;
	
	AdidasHomePage adidasHomePage;
	ProductDetailsPage productDetailsPage;
	Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	GeneralActions genAction = new GeneralActions();
	
	
	 @BeforeClass
	  public void setUp() throws IOException {
		  driver = getDriver();
		  driver = launchBrowser(driver, "firefox");
		  adidasHomePage=PageFactory.initElements(driver,AdidasHomePage.class);
		  productDetailsPage=PageFactory.initElements(driver,ProductDetailsPage.class);
		  ReusableActions.loadPropFileValues();
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
	      }
	
	
	 
	 @Test(priority=1)
	
	 public void searchProduct(){
		 adidasHomePage=new AdidasHomePage(driver);
		 productDetailsPage=new ProductDetailsPage(driver);
		 adidasHomePage.popUp();
		 adidasHomePage.clickSearch();
		 adidasHomePage.enterItem("shirts");
		 productDetailsPage.verifyProuctSearch();
		 productDetailsPage.searchCount();
//		 productDetailsPage.verifyProductCountDisplayed();
		 
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