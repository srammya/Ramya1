package com.specomm.adidas.validcreditcarddetails;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;
import com.specomm.adidas.pagecomponents.AdidasGuestCheckoutPage;
import com.specomm.adidas.pagecomponents.AdidasHomePage;
import com.specomm.adidas.pagecomponents.ProductDetailsPage;
import com.specomm.adidas.pagecomponents.ShippingDetailsGuestPage;
import com.specomm.adidas.pagecomponents.ShoppingBucketPage;
import com.specomm.adidas.pagecomponents.SubCategoriesPage;
import com.specomm.adidas.pagecomponents.VisaPaymentDetailsPage;

	
	public class ValidateVisaCCDetails extends GeneralActions{
		
		static WebDriver driver;
		AdidasHomePage adidasHomePage;
		ProductDetailsPage productDetailsPage;
		ShoppingBucketPage shoppingBucketPage;
		SubCategoriesPage subCategoriesPage;
		ShippingDetailsGuestPage shippingDetailsGuestPage;
		VisaPaymentDetailsPage visapaymentDetailsPage;
		AdidasGuestCheckoutPage adidasGuestCheckoutPage;
		Logger log4jlogger =Logger.getLogger("devpinoyLogger");
		GeneralActions genAction = new GeneralActions();
		
		
		
		
		 @BeforeClass
		  public void setUp() throws IOException {
			  driver = launchBrowser(driver, "chrome");
			  adidasHomePage=PageFactory.initElements(driver, AdidasHomePage.class);
			  productDetailsPage=PageFactory.initElements(driver, ProductDetailsPage.class);
			  shoppingBucketPage=PageFactory.initElements(driver, ShoppingBucketPage.class);
			  subCategoriesPage=PageFactory.initElements(driver, SubCategoriesPage.class);
			  shippingDetailsGuestPage=PageFactory.initElements(driver, ShippingDetailsGuestPage.class);
			  visapaymentDetailsPage=PageFactory.initElements(driver, VisaPaymentDetailsPage.class);
			  adidasGuestCheckoutPage=PageFactory.initElements(driver, AdidasGuestCheckoutPage.class);
			  ReusableActions.loadPropFileValues();
			  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
		      }
		
		 // 
		 @Test(priority = 1,dataProviderClass=ShoppingBucketPage.class,dataProvider="getData" )
		 
		 public void checkoutAsGuestUserValidateVisaCCDetails(String code){
			 adidasHomePage =new AdidasHomePage(driver);
			 subCategoriesPage =new SubCategoriesPage(driver);
			 adidasGuestCheckoutPage=new AdidasGuestCheckoutPage(driver);
			 productDetailsPage=new ProductDetailsPage(driver);
			 shoppingBucketPage=new ShoppingBucketPage(driver);
			 
			try{
						adidasHomePage.popUp();
						
						
						int j= ReusableActions.getRandomNumber(2,5);
						
						 System.out.println("print value for j " + j);
							for (int i = 0; i <= j; i++) 
							{
								
								adidasHomePage.mainMenuRandomSelection();
								ReusableActions.waitForpageToLoad(driver);
								subCategoriesPage.productRandomSelection();
								productDetailsPage.selectProductToCart();
								
												
								Thread.sleep(1000);
							 }
							productDetailsPage.clickShoppingBag();
							shoppingBucketPage.verifyShopBagAndProceed();
							shoppingBucketPage.clickCheckout();
						//	adidasGuestCheckoutPage.clickCheckout();
				
					 
			 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 } 
		 
		 @Test(priority = 2 ,dataProviderClass=ShippingDetailsGuestPage.class,dataProvider="getData")
		 public void shipDetailsValidateVisaCCDetails(String sFName,String sLName,String sMail,String sPhone,String sAddress,String sCity,String sPostal,String sDay,String sMonth,String sYear){
			 shippingDetailsGuestPage=new ShippingDetailsGuestPage(driver);
				
			 try{
					ReusableActions.waitForpageToLoad(driver);
					shippingDetailsGuestPage.verifyGuestShipHeading();
					shippingDetailsGuestPage.ship_DetailsGuest(sFName,sLName,sMail,sPhone,sAddress,sCity,sPostal,sDay,sMonth,sYear);
				}
				
				catch (Throwable t) {
					t.printStackTrace();
				}
				
		}
		 
		 
		 @Test(priority = 3 )
		 public void validatePaymentDetailsValidateVisaCCDetails(){
			 visapaymentDetailsPage=new VisaPaymentDetailsPage(driver);
				try{
					ReusableActions.waitForpageToLoad(driver);
					Thread.sleep(5000);
					visapaymentDetailsPage.selectCardType("Visa");
					visapaymentDetailsPage.validateCCNumber("4000000000000000");
					visapaymentDetailsPage.validateCCExpiryDate("01 - January","2015");
					visapaymentDetailsPage.enterCVV("589");
					
					
				}
				
				catch (Throwable t) {
					t.printStackTrace();
				}
				
		}
		 
		 
			
		 
		 
		 @Test(priority = 4 ,dataProviderClass=VisaPaymentDetailsPage.class,dataProvider="getData")
		 public void paymentDetailsValidateVisaCCDetails(String cType,String cNumber,String cExpiryMonth,String cExpiryYear,String cccvv){
			 visapaymentDetailsPage=new VisaPaymentDetailsPage(driver);
				try{
					ReusableActions.waitForpageToLoad(driver);
					visapaymentDetailsPage.selectCardPaymentDetails(cType,cNumber,cExpiryMonth,cExpiryYear,cccvv);
					
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
	
	


