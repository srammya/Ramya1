package com.specomm.adidas.continueshopping;

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
import com.specomm.adidas.pagecomponents.ProductDetailsPage;
import com.specomm.adidas.pagecomponents.ShippingDetailsLoginPage;
import com.specomm.adidas.pagecomponents.ShoppingBucketPage;
import com.specomm.adidas.pagecomponents.SubCategoriesPage;
import com.specomm.adidas.pagecomponents.VisaPaymentDetailsPage;

public class ContinueShoppingFromCheckout extends GeneralActions{

	
	static WebDriver driver;
	
	AdidasLoginCheckoutPage adidasLoginCheckoutPage;
	AdidasHomePage adidasHomePage;
	ProductDetailsPage productDetailsPage;
	ShoppingBucketPage shoppingBucketPage;
	SubCategoriesPage subCategoriesPage;
	ShippingDetailsLoginPage shippingDetailsLoginPage;
	VisaPaymentDetailsPage visapaymentDetailsPage;
	
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
		  visapaymentDetailsPage=PageFactory.initElements(driver, VisaPaymentDetailsPage.class);
		  
		  ReusableActions.loadPropFileValues();
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
		 
	      }
	
	  
	 @Test(priority = 1 ,dataProviderClass=AdidasLoginCheckoutPage.class, dataProvider="getData")
	 
	 public void checkoutAsloginUserContinueShoppingFromCheckout(String username,String password){
		 adidasHomePage =new AdidasHomePage(driver);
		 subCategoriesPage =new SubCategoriesPage(driver);
		 productDetailsPage=new ProductDetailsPage(driver);
		 
		
		 try {
			 
			adidasHomePage.popUp();
			 int j= ReusableActions.getRandomNumber(2,5);
			
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
					Thread.sleep(2000);
					productDetailsPage.clickShoppingBag();
					shoppingBucketPage.verifyShopBagAndProceed();
					
					Thread.sleep(2000);
				
					shoppingBucketPage.clickContinueShopping();
					adidasHomePage.mainMenuRandomSelection();
					ReusableActions.waitForpageToLoad(driver);
					subCategoriesPage.productRandomSelection();
					ReusableActions.waitForpageToLoad(driver);
					productDetailsPage.selectProductToCart();
					ReusableActions.waitForpageToLoad(driver);
					productDetailsPage.clickShoppingBag();
					shoppingBucketPage.verifyShopBagAndProceed();
					shoppingBucketPage.clickCheckout();
					
					
					
					
					
					
					Thread.sleep(2000);
				
				adidasLoginCheckoutPage.logInUser(username,password);
				
		
		 }
	 catch(Exception e){
		 e.printStackTrace();
	 }
	 } 
	 
	 @Test(priority = 2 ,dataProviderClass=ShippingDetailsLoginPage.class,dataProvider="getData")
	 public void shipDetailsContinueShoppingFromCheckout(String sFName,String sLName,String sPhone,String sAddress,String sCity,String sPostal,String sDay,String sMonth,String sYear){
		 shippingDetailsLoginPage=new ShippingDetailsLoginPage(driver);
			
		 try{
				ReusableActions.waitForpageToLoad(driver);
				shippingDetailsLoginPage.verifyLoginShipHeading();
				shippingDetailsLoginPage.ship_DetailsLogin(sFName,sLName,sPhone,sAddress,sCity,sPostal,sDay,sMonth,sYear);
//				shippingDetailsLoginPage.shippingContinue();
			}
			
			catch (Throwable t) {
				t.printStackTrace();
			}
			
	}
	 @Test(priority = 3 ,dataProviderClass=VisaPaymentDetailsPage.class,dataProvider="getData")
	 public void paymentDetailsContinueShoppingFromCheckout(String cType,String cNumber,String cExpiryMonth,String cExpiryYear,String cccvv){
		 visapaymentDetailsPage=new VisaPaymentDetailsPage(driver);
			
		 try{
				ReusableActions.waitForpageToLoad(driver);
				
				visapaymentDetailsPage.selectCardPaymentDetails(cType,cNumber,cExpiryMonth,cExpiryYear,cccvv);
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