package com.specomm.adidas.continueshopping;

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
import com.specomm.adidas.pagecomponents.PaymentDonePage;
import com.specomm.adidas.pagecomponents.ProductDetailsPage;
import com.specomm.adidas.pagecomponents.ShippingDetailsGuestPage;
import com.specomm.adidas.pagecomponents.ShoppingBucketPage;
import com.specomm.adidas.pagecomponents.SubCategoriesPage;
import com.specomm.adidas.pagecomponents.VisaPaymentDetailsPage;

	
	public class ContinueShoppingFromPaymentDone extends GeneralActions{
		
		static WebDriver driver;
		
		
		AdidasHomePage adidasHomePage;
		ProductDetailsPage productDetailsPage;
		ShoppingBucketPage shoppingBucketPage;
		SubCategoriesPage subCategoriesPage;
		ShippingDetailsGuestPage shippingDetailsGuestPage;
		VisaPaymentDetailsPage visaPaymentDetailsPage;
		AdidasGuestCheckoutPage adidasGuestCheckoutPage;
		PaymentDonePage paymentDonePage;
		
		GeneralActions genAction = new GeneralActions();
		
		
		
		
		 @BeforeClass
		  public void setUp() throws IOException {
			  driver = launchBrowser(driver, "firefox");
			  adidasHomePage=PageFactory.initElements(driver, AdidasHomePage.class);
			  productDetailsPage=PageFactory.initElements(driver, ProductDetailsPage.class);
			  shoppingBucketPage=PageFactory.initElements(driver, ShoppingBucketPage.class);
			  subCategoriesPage=PageFactory.initElements(driver, SubCategoriesPage.class);
			  shippingDetailsGuestPage=PageFactory.initElements(driver, ShippingDetailsGuestPage.class);
			  visaPaymentDetailsPage=PageFactory.initElements(driver, VisaPaymentDetailsPage.class);
			  adidasGuestCheckoutPage=PageFactory.initElements(driver, AdidasGuestCheckoutPage.class);
			  paymentDonePage=PageFactory.initElements(driver, PaymentDonePage.class);
			 
			  ReusableActions.loadPropFileValues();
			  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
		      }
		
		 // 
		 @Test(priority = 1 )
		 
		 public void checkoutContinueShoppingFromPaymentDone(){
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
		 public void shipDetailsContinueShoppingFromPaymentDone(String sFName,String sLName,String sMail,String sPhone,String sAddress,String sCity,String sPostal,String sDay,String sMonth,String sYear){
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
		
		 @Test(priority = 3 ,dataProviderClass=VisaPaymentDetailsPage.class,dataProvider="getData")
		 public void paymentDetailsContinueShoppingFromPaymentDone(String cType,String cNumber,String cExpiryMonth,String cExpiryYear,String cccvv){
			 visaPaymentDetailsPage =new VisaPaymentDetailsPage(driver);
			 paymentDonePage=new PaymentDonePage(driver);
			
				try{
					ReusableActions.waitForpageToLoad(driver);
					visaPaymentDetailsPage.selectCardPaymentDetails(cType,cNumber,cExpiryMonth,cExpiryYear,cccvv);
					paymentDonePage.clickContinueShopping();
				}
				
				catch (Throwable t) {
					t.printStackTrace();
				}
				
		}
		 
		 
		 @Test(priority = 4 )
		 
		 public void ContinueShoppingFromPaymentDonepage(){
			 adidasHomePage =new AdidasHomePage(driver);
			 subCategoriesPage =new SubCategoriesPage(driver);
			 adidasGuestCheckoutPage=new AdidasGuestCheckoutPage(driver);
			 productDetailsPage=new ProductDetailsPage(driver);
			
			 try {

				 int j= ReusableActions.getRandomNumber(2,5);
				
				
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
		 
		 @Test(priority = 5 ,dataProviderClass=ShippingDetailsGuestPage.class,dataProvider="getData")
		 public void shipDetailsContinueGuestCheckoutWithVisaCard(String sFName,String sLName,String sMail,String sPhone,String sAddress,String sCity,String sPostal,String sDay,String sMonth,String sYear){
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
		 @Test(priority = 6 ,dataProviderClass=VisaPaymentDetailsPage.class,dataProvider="getData")
		 public void paymentDetailsContinueShoppingFromPayment(String cType,String cNumber,String cExpiryMonth,String cExpiryYear,String cccvv){
			 visaPaymentDetailsPage =new VisaPaymentDetailsPage(driver);
			 paymentDonePage=new PaymentDonePage(driver);
			
				try{
					ReusableActions.waitForpageToLoad(driver);
					visaPaymentDetailsPage.selectCardPaymentDetails(cType,cNumber,cExpiryMonth,cExpiryYear,cccvv);
					paymentDonePage.clickContinueShopping();
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
	
	


