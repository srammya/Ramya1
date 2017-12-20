package com.specomm.adidas.loginflow;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;
import com.specomm.adidas.pagecomponents.AdidasHomePage;
import com.specomm.adidas.pagecomponents.AdidasLoginPage;
import com.specomm.adidas.pagecomponents.PaymentDetailsPage;
import com.specomm.adidas.pagecomponents.ProductDetailsPage;
import com.specomm.adidas.pagecomponents.ShippingDetailsLoginPage;
import com.specomm.adidas.pagecomponents.ShoppingBucketPage;
import com.specomm.adidas.pagecomponents.SubCategoriesPage;

public class RegisteredLoginUserFlow {
	static WebDriver driver;
	AdidasLoginPage AdidasLoginPage;
	AdidasHomePage adidasHomePage;
	SubCategoriesPage subCategoriesPage;
	ProductDetailsPage productDetailsPage;
	ShoppingBucketPage shoppingBucketPage;
	ShippingDetailsLoginPage shippingDetailsLoginPage;
	PaymentDetailsPage paymentDetailsPage;
	Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	GeneralActions genAction = new GeneralActions();

	
	
	 @BeforeTest
	  public void bTest() throws IOException {
		  driver = GeneralActions.launchBrowser(driver, "firefox");
		 
		  AdidasLoginPage = PageFactory.initElements(driver, AdidasLoginPage.class);
		  adidasHomePage=PageFactory.initElements(driver, AdidasHomePage.class);
		  subCategoriesPage=PageFactory.initElements(driver, SubCategoriesPage.class);
		  productDetailsPage=PageFactory.initElements(driver, ProductDetailsPage.class);
		  shoppingBucketPage=PageFactory.initElements(driver, ShoppingBucketPage.class);
		  shippingDetailsLoginPage=PageFactory.initElements(driver, ShippingDetailsLoginPage.class);
		  paymentDetailsPage=PageFactory.initElements(driver, PaymentDetailsPage.class);
		  ReusableActions.loadPropFileValues();
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
	      }
	 
	/**
	 * Login Checkout Flow Test Script
     */

	@Test( priority = 0, dataProviderClass=AdidasLoginPage.class, dataProvider="getData")
	public void checkoutAsloginUser(String username,String password) throws Exception {
		try {
			  AdidasLoginPage.popUp();
		      ReusableActions.waitForpageToLoad(driver);
		      Thread.sleep(5000);
		      AdidasLoginPage.enterLogin();
		      AdidasLoginPage.clickLogin();
		      AdidasLoginPage.logIn_Action(username, password);
		
		} catch (Throwable e) {
			e.printStackTrace();
		}
		}
	
	@Test(priority=1)
	public void checkoutAddingProducts() throws InterruptedException{
		
		 subCategoriesPage =new SubCategoriesPage(driver);
		 productDetailsPage=new ProductDetailsPage(driver);
		 int j = ReusableActions.getRandomNumber(2,5);
		 
		for (int i = 0; i <= j; i++) {
      adidasHomePage.mainMenuRandomSelection();
      ReusableActions.waitForpageToLoad(driver);
      subCategoriesPage.productRandomSelection();
	  ReusableActions.waitForpageToLoad(driver);
	  productDetailsPage.selectProductToCart();
     
		}  
		productDetailsPage.clickShoppingBag();
		shoppingBucketPage.verifyShopBagAndProceed();
		shoppingBucketPage.clickCheckout();
		
		
	     
	}
	
	
	@Test(priority = 2 ,dataProviderClass=ShippingDetailsLoginPage.class,dataProvider="getData")
	 public void shipDetails(String sFName,String sLName,String sPhone,String sAddress,String sCity,String sPostal,String sDay,String sMonth,String sYear){
		 shippingDetailsLoginPage=new ShippingDetailsLoginPage(driver);
			
		 try{
				ReusableActions.waitForpageToLoad(driver);
				shippingDetailsLoginPage.ship_DetailsLogin(sFName,sLName,sPhone,sAddress,sCity,sPostal,sDay,sMonth,sYear);
				
			}
			
			catch (Throwable t) {
				t.printStackTrace();
			}
			
	}
	
	
	
	@Test(priority = 3,dataProviderClass=PaymentDetailsPage.class, dataProvider="getData")
	public void checkoutPaymentloginUser(String cType,String cNumber,String cExpiryMonth,String cExpiryYear,String cccvv) throws Exception {
		try {
			
		     
		      
			ReusableActions.waitForpageToLoad(driver);
	
			
			paymentDetailsPage.selectPaymentDetails(cType,cNumber,cExpiryMonth,cExpiryYear,cccvv);
		     
				
				
		     
		} catch (Throwable e) {
			e.printStackTrace();
		}
		}
	
	
	
	@AfterTest
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
