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
import com.specomm.adidas.pagecomponents.MasterPaymentDetailsPage;
import com.specomm.adidas.pagecomponents.ProductDetailsPage;
import com.specomm.adidas.pagecomponents.ShippingDetailsGuestPage;
import com.specomm.adidas.pagecomponents.ShoppingBucketPage;
import com.specomm.adidas.pagecomponents.SubCategoriesPage;

	
	public class ValidateMasterCCDetails extends GeneralActions{
		
		static WebDriver driver;
		AdidasHomePage adidasHomePage;
		ProductDetailsPage productDetailsPage;
		ShoppingBucketPage shoppingBucketPage;
		SubCategoriesPage subCategoriesPage;
		ShippingDetailsGuestPage shippingDetailsGuestPage;
		MasterPaymentDetailsPage masterPaymentDetailsPage;
		AdidasGuestCheckoutPage adidasGuestCheckoutPage;
		Logger log4jlogger =Logger.getLogger("devpinoyLogger");
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
			  ReusableActions.loadPropFileValues();
			  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
		      }
		
		 // 
		 @Test(priority = 1,dataProviderClass=ShoppingBucketPage.class,dataProvider="getData" )
		 
		 public void checkoutAsGuestUserValidateMasterCCDetails(String code){
			 adidasHomePage =new AdidasHomePage(driver);
			 subCategoriesPage =new SubCategoriesPage(driver);
			 adidasGuestCheckoutPage=new AdidasGuestCheckoutPage(driver);
			 productDetailsPage=new ProductDetailsPage(driver);
			 shoppingBucketPage=new ShoppingBucketPage(driver);
			 
			try{
						adidasHomePage.popUp();
						adidasHomePage.mainMenuRandomSelection();
						ReusableActions.waitForpageToLoad(driver);
						subCategoriesPage.productRandomSelection();
						productDetailsPage.selectProductToCart();
						
						/*int j= ReusableActions.getRandomNumber(2,5);
						
						 System.out.println("print value for j " + j);
							for (int i = 0; i <= j; i++) 
							{
								
								adidasHomePage.mainMenuRandomSelection();
								ReusableActions.waitForpageToLoad(driver);
								subCategoriesPage.productRandomSelection();
								productDetailsPage.selectProductToCart();
								
												
								Thread.sleep(1000);
							 }*/
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
		 public void shipDetailsValidateMasterCCDetails(String sFName,String sLName,String sMail,String sPhone,String sAddress,String sCity,String sPostal,String sDay,String sMonth,String sYear){
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
		 public void validatePaymentDetailsValidateMasterCCDetails(){
			 masterPaymentDetailsPage=new MasterPaymentDetailsPage(driver);
				try{
					ReusableActions.waitForpageToLoad(driver);
					masterPaymentDetailsPage.selectCardType("MasterCard");
					masterPaymentDetailsPage.validateCCNumber("4200000000000000");
					masterPaymentDetailsPage.validateCCExpiryDate("01 - January","2015");
					masterPaymentDetailsPage.enterCVV("589");
					
					
				}
				
				catch (Throwable t) {
					t.printStackTrace();
				}
				
		}
		 
		 
		 
		 @Test(priority = 4 ,dataProviderClass=MasterPaymentDetailsPage.class,dataProvider="getData")
		 public void paymentDetailsValidateMasterCCDetails(String cType,String cNumber,String cExpiryMonth,String cExpiryYear,String cccvv){
			 masterPaymentDetailsPage=new MasterPaymentDetailsPage(driver);
				try{
					ReusableActions.waitForpageToLoad(driver);
					masterPaymentDetailsPage.selectCardPaymentDetails(cType,cNumber,cExpiryMonth,cExpiryYear,cccvv);
					
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
	
	


