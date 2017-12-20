package com.specomm.adidas.promotioncode;

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

public class RegisteredLoginUserCheckoutWithGuestPromotionCode extends GeneralActions {
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
	 
	
	
	
	


	/**
	 * Login Checkout Flow Test Script
     */


	
		
	
	@Test( priority = 1, dataProviderClass=AdidasLoginPage.class, dataProvider="getData")
	public void checkoutAsRegisteredLoginUserFlow(String username,String password) throws Exception {
		try {
			 
		      
		      adidasLoginPage.popUp();
		      adidasLoginPage.enterLogin();
		      adidasLoginPage.clickLogin();
		      log4jlogger.info("##########-------Login application-------##########");
		      adidasLoginPage.logIn_Action(username, password);
		      adidasLoginPage.verifyLoginLandingPage();
		      log4jlogger.info("##########-------Login Successfully,----------############");
		     /* adidasHomePage.mainMenuRandomSelection();
		      subCategoriesPage.displayPagination();*/
		      
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
				shoppingBucketPage.verifyInvalidPromocode("GUEST20");
				shoppingBucketPage.validateInvalidLoginPromocodemsg();
				Thread.sleep(2000);
				shoppingBucketPage.clickCheckout();
				
				
				
				
		     
		} catch (Throwable e) {
			e.printStackTrace();
		}
		}
	
	@Test(priority = 2 ,dataProviderClass=ShippingDetailsLoginPage.class,dataProvider="getData")
	 public void shipDetailsRegisteredLoginUserFlow(String sFName,String sLName,String sPhone,String sAddress,String sCity,String sPostal,String sDay,String sMonth,String sYear){
		 shippingDetailsLoginPage=new ShippingDetailsLoginPage(driver);
			
		 try{
				ReusableActions.waitForpageToLoad(driver);
				shippingDetailsLoginPage.ship_DetailsLogin(sFName,sLName,sPhone,sAddress,sCity,sPostal,sDay,sMonth,sYear);
				
			}
			
			catch (Throwable t) {
				t.printStackTrace();
			}
			
	}
	
	
	
	@Test(priority = 3,dataProviderClass=VisaPaymentDetailsPage.class, dataProvider="getData")
	public void paymentDetailsRegisteredLoginUserFlow(String cType,String cNumber,String cExpiryMonth,String cExpiryYear,String cccvv) throws Exception {
		try {
			
		     
		      
			ReusableActions.waitForpageToLoad(driver);
		//	paymentDetailsPage.verifyPaymentHeading();
			
			visapaymentDetailsPage.selectCardPaymentDetails(cType,cNumber,cExpiryMonth,cExpiryYear,cccvv);
		     
				
				
		     
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
