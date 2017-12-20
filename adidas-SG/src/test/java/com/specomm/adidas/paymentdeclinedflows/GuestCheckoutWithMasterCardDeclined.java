package com.specomm.adidas.paymentdeclinedflows;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;
import com.specomm.adidas.pagecomponents.AdidasGuestCheckoutPage;
import com.specomm.adidas.pagecomponents.AdidasHomePage;
import com.specomm.adidas.pagecomponents.BadMasterPaymentDetailsPage;
import com.specomm.adidas.pagecomponents.MasterPaymentDetailsPage;
import com.specomm.adidas.pagecomponents.PaymentDeclinedPage;
import com.specomm.adidas.pagecomponents.ProductDetailsPage;
import com.specomm.adidas.pagecomponents.ShippingDetailsGuestPage;
import com.specomm.adidas.pagecomponents.ShoppingBucketPage;
import com.specomm.adidas.pagecomponents.SubCategoriesPage;

	
	public class GuestCheckoutWithMasterCardDeclined extends GeneralActions{
		
		static WebDriver driver;
		
		
		AdidasHomePage adidasHomePage;
		ProductDetailsPage productDetailsPage;
		ShoppingBucketPage shoppingBucketPage;
		SubCategoriesPage subCategoriesPage;
		ShippingDetailsGuestPage shippingDetailsGuestPage;
		MasterPaymentDetailsPage masterPaymentDetailsPage;
		AdidasGuestCheckoutPage adidasGuestCheckoutPage;
		PaymentDeclinedPage paymentDeclinedPage;
		BadMasterPaymentDetailsPage badMasterPaymentDetailsPage;
		
		GeneralActions genAction = new GeneralActions();
		
		
		
		
		 @BeforeClass
		  public void setUp() throws IOException {
			  driver = launchBrowser(driver, "firefox");
			  adidasHomePage=PageFactory.initElements(driver, AdidasHomePage.class);
			  productDetailsPage=PageFactory.initElements(driver, ProductDetailsPage.class);
			  shoppingBucketPage=PageFactory.initElements(driver, ShoppingBucketPage.class);
			  subCategoriesPage=PageFactory.initElements(driver, SubCategoriesPage.class);
			  shippingDetailsGuestPage=PageFactory.initElements(driver, ShippingDetailsGuestPage.class);
			  masterPaymentDetailsPage=PageFactory.initElements(driver, MasterPaymentDetailsPage.class);
			  adidasGuestCheckoutPage=PageFactory.initElements(driver, AdidasGuestCheckoutPage.class);
			  paymentDeclinedPage=PageFactory.initElements(driver, PaymentDeclinedPage.class);
			  badMasterPaymentDetailsPage=PageFactory.initElements(driver, BadMasterPaymentDetailsPage.class);
			  ReusableActions.loadPropFileValues();
			  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
		      }
		
		 // 
		 @Test(priority = 1 )
		 
		 public void checkoutAsGuestCheckoutWithMasterCardDeclined(){
			 adidasHomePage =new AdidasHomePage(driver);
			 subCategoriesPage =new SubCategoriesPage(driver);
			 adidasGuestCheckoutPage=new AdidasGuestCheckoutPage(driver);
			 productDetailsPage=new ProductDetailsPage(driver);
			 
			// adidasPageMethods=new AdidasPageMethods(driver);
			 try {
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
					//adidasGuestCheckoutPage.clickCheckout();
		
			 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 } 
		 
		 @Test(priority = 2 ,dataProviderClass=ShippingDetailsGuestPage.class,dataProvider="getData")
		 public void shipDetailsGuestCheckoutWithMasterCardDeclined(String sFName,String sLName,String sMail,String sPhone,String sAddress,String sCity,String sPostal,String sDay,String sMonth,String sYear){
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
		 @Test(priority = 3 ,dataProviderClass=BadMasterPaymentDetailsPage.class,dataProvider="getData")
		 public void paymentDetailsGuestCheckoutWithMasterCardDeclined(String cType,String cNumber,String cExpiryMonth,String cExpiryYear,String cccvv){
			 badMasterPaymentDetailsPage=new BadMasterPaymentDetailsPage(driver);
			 paymentDeclinedPage=new PaymentDeclinedPage(driver);
				try{
					ReusableActions.waitForpageToLoad(driver);
					badMasterPaymentDetailsPage.selectCardPaymentDetails(cType,cNumber,cExpiryMonth,cExpiryYear,cccvv);
					paymentDeclinedPage.verifyPamymentDeclinedMsg();
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
	
	


