package com.specomm.adidas.pagination;

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
import com.specomm.adidas.pagecomponents.ProductDetailsPage;
import com.specomm.adidas.pagecomponents.ShippingDetailsLoginPage;
import com.specomm.adidas.pagecomponents.ShoppingBucketPage;
import com.specomm.adidas.pagecomponents.SubCategoriesPage;
import com.specomm.adidas.pagecomponents.VisaPaymentDetailsPage;


	public class ValidatingPagination extends GeneralActions{
		
		static WebDriver driver;
		AdidasLoginPage adidasLoginPage;
		AdidasHomePage adidasHomePage;
		SubCategoriesPage subCategoriesPage;
		ProductDetailsPage productDetailsPage;
		ShoppingBucketPage shoppingBucketPage;
		ShippingDetailsLoginPage shippingDetailsLoginPage;
		VisaPaymentDetailsPage visapaymentDetailsPage;
		Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	

		
		
		 @BeforeClass
		  public void setUp() throws IOException {
			  
			  driver = launchBrowser(driver, "firefox");
			  adidasLoginPage = PageFactory.initElements(driver, AdidasLoginPage.class);
			  adidasHomePage=PageFactory.initElements(driver, AdidasHomePage.class);
			  subCategoriesPage=PageFactory.initElements(driver, SubCategoriesPage.class);
			  productDetailsPage=PageFactory.initElements(driver, ProductDetailsPage.class);
			  shoppingBucketPage=PageFactory.initElements(driver, ShoppingBucketPage.class);
			  shippingDetailsLoginPage=PageFactory.initElements(driver, ShippingDetailsLoginPage.class);
			  visapaymentDetailsPage=PageFactory.initElements(driver, VisaPaymentDetailsPage.class);
			  ReusableActions.loadPropFileValues();
			  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
		      }
		 
		
				
		
		@Test( priority = 1, dataProviderClass=AdidasLoginPage.class, dataProvider="getData")
		public void loginUserValidatingPagination(String username,String password) throws Exception {
			try {
				 
			      
			      adidasLoginPage.popUp();
			      adidasHomePage.mainMenuRandomSelection();
			      subCategoriesPage.displayPagination();
			      
			   				
					
			     
			} catch (Throwable e) {
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


