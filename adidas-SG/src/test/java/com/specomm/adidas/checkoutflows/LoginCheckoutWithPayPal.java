package com.specomm.adidas.checkoutflows;

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
import com.specomm.adidas.pagecomponents.AdidasLoginCheckoutPage;
import com.specomm.adidas.pagecomponents.PaypalPaymentDetailsPage;
import com.specomm.adidas.pagecomponents.ProductDetailsPage;
import com.specomm.adidas.pagecomponents.ShippingDetailsLoginPage;
import com.specomm.adidas.pagecomponents.ShoppingBucketPage;
import com.specomm.adidas.pagecomponents.SubCategoriesPage;


public class LoginCheckoutWithPayPal extends GeneralActions{

	
	static WebDriver driver;
	
	AdidasLoginCheckoutPage adidasLoginCheckoutPage;
	AdidasHomePage adidasHomePage;
	ProductDetailsPage productDetailsPage;
	ShoppingBucketPage shoppingBucketPage;
	SubCategoriesPage subCategoriesPage;
	ShippingDetailsLoginPage shippingDetailsLoginPage;
	PaypalPaymentDetailsPage paypalPaymentDetailsPage;
	
	Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	
	
	
	
	
	 @BeforeClass
	  public void setUp() throws IOException, InterruptedException {
		  driver = launchBrowser(driver, "firefox");
		  adidasLoginCheckoutPage = PageFactory.initElements(driver, AdidasLoginCheckoutPage.class);
		  adidasHomePage=PageFactory.initElements(driver, AdidasHomePage.class);
		  productDetailsPage=PageFactory.initElements(driver, ProductDetailsPage.class);
		  shoppingBucketPage=PageFactory.initElements(driver, ShoppingBucketPage.class);
		  subCategoriesPage=PageFactory.initElements(driver, SubCategoriesPage.class);
		  shippingDetailsLoginPage=PageFactory.initElements(driver, ShippingDetailsLoginPage.class);
		  paypalPaymentDetailsPage=PageFactory.initElements(driver, PaypalPaymentDetailsPage.class);
		  
		  ReusableActions.loadPropFileValues();
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
		 
	      }
	
	  
	 @Test(priority = 0 ,dataProviderClass=AdidasLoginCheckoutPage.class, dataProvider="getData")
	 
	 public void checkoutAsLoginCheckoutWithPayPal(String username,String password){
		 adidasHomePage =new AdidasHomePage(driver);
		 subCategoriesPage =new SubCategoriesPage(driver);
		 productDetailsPage=new ProductDetailsPage(driver);
		 
		
		 try {
			 
			adidasHomePage.popUp();
			 int j= ReusableActions.getRandomNumber(2,6);
			
			 System.out.println("print value for j " + j);
			 
				for (int i = 0; i <= 2; i++) 
				{
					
					adidasHomePage.mainMenuRandomSelection();
					ReusableActions.waitForpageToLoad(driver);
					subCategoriesPage.productRandomSelection();
					ReusableActions.waitForpageToLoad(driver);
					productDetailsPage.selectProductToCart();
					ReusableActions.waitForpageToLoad(driver);
					
				}
				Thread.sleep(5000);
					productDetailsPage.clickShoppingBag();
					shoppingBucketPage.verifyShopBagAndProceed();
					shoppingBucketPage.clickCheckout();
					
					
				
				adidasLoginCheckoutPage.logInUser(username,password);
				
				
	
		
		 }
	 catch(Exception e){
		 e.printStackTrace();
	 }
	 } 
	 
	 @Test(priority = 1 ,dataProviderClass=ShippingDetailsLoginPage.class,dataProvider="getData")
	 public void shipDetailsLoginCheckoutWithPayPal(String sFName,String sLName,String sPhone,String sAddress,String sCity,String sPostal,String sDay,String sMonth,String sYear){
		 shippingDetailsLoginPage=new ShippingDetailsLoginPage(driver);
			
		 try{
				ReusableActions.waitForpageToLoad(driver);
				
				shippingDetailsLoginPage.ship_DetailsLogin(sFName,sLName,sPhone,sAddress,sCity,sPostal,sDay,sMonth,sYear);
				
			}
			
			catch (Throwable t) {
				t.printStackTrace();
			}
			
	}
	 @Test(priority = 2 ,dataProviderClass=PaypalPaymentDetailsPage.class,dataProvider="getData")
	 public void paymentDetailsLoginCheckoutWithPayPal(String pLogin,String pPwd){
		 paypalPaymentDetailsPage=new PaypalPaymentDetailsPage(driver);
			
		 try{
				ReusableActions.waitForpageToLoad(driver);
				
				paypalPaymentDetailsPage.selectPaypalPaymentDetails(pLogin,pPwd);
				
				Thread.sleep(10000);
				
			}
			
			catch (Throwable t) {
				t.printStackTrace();
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