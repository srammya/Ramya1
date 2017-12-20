package com.specomm.adidas.checkoutflows;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.specomm.adidas.common.utils.Constants;
import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;
import com.specomm.adidas.pagecomponents.AdidasHomePage;
import com.specomm.adidas.pagecomponents.AdidasLoginCheckoutPage;
import com.specomm.adidas.pagecomponents.PaymentDonePage;
import com.specomm.adidas.pagecomponents.ProductDetailsPage;
import com.specomm.adidas.pagecomponents.Secure3DPage;
import com.specomm.adidas.pagecomponents.ShippingDetailsLoginPage;
import com.specomm.adidas.pagecomponents.ShoppingBucketPage;
import com.specomm.adidas.pagecomponents.SubCategoriesPage;
import com.specomm.adidas.pagecomponents.VisaPaymentDetailsPage;
import com.specomm.adidas.pagecomponents.VisaPaymentDetailsWith3DSecurePage;

	
	public class LoginCheckoutWith3DSecureVisaCard extends GeneralActions{
		
		static WebDriver driver;
		
		
		AdidasHomePage adidasHomePage;
		ProductDetailsPage productDetailsPage;
		ShoppingBucketPage shoppingBucketPage;
		SubCategoriesPage subCategoriesPage;
		ShippingDetailsLoginPage shippingDetailsLoginPage;
		VisaPaymentDetailsPage visapaymentDetailsPage;
		AdidasLoginCheckoutPage adidasLoginCheckoutPage;
		VisaPaymentDetailsWith3DSecurePage visaPaymentDetailsWith3DSecurePage;
		Secure3DPage secure3DPage;
		PaymentDonePage paymentDonePage;
		
		Logger log4jlogger =Logger.getLogger("devpinoyLogger");
		GeneralActions genAction = new GeneralActions();
		Constants constants=new Constants();
		
		
		
		
		 @BeforeClass
		  public void setUp() throws IOException {
			  driver = launchBrowser(driver, "firefox");
			  adidasHomePage=PageFactory.initElements(driver, AdidasHomePage.class);
			  productDetailsPage=PageFactory.initElements(driver, ProductDetailsPage.class);
			  shoppingBucketPage=PageFactory.initElements(driver, ShoppingBucketPage.class);
			  subCategoriesPage=PageFactory.initElements(driver, SubCategoriesPage.class);
			  shippingDetailsLoginPage=PageFactory.initElements(driver, ShippingDetailsLoginPage.class);
			  visapaymentDetailsPage=PageFactory.initElements(driver, VisaPaymentDetailsPage.class);
			  adidasLoginCheckoutPage=PageFactory.initElements(driver, AdidasLoginCheckoutPage.class);
			  visaPaymentDetailsWith3DSecurePage=PageFactory.initElements(driver, VisaPaymentDetailsWith3DSecurePage.class);
			  paymentDonePage=PageFactory.initElements(driver, PaymentDonePage.class);
			  secure3DPage=PageFactory.initElements(driver, Secure3DPage.class);
			  ReusableActions.loadPropFileValues();
			  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
		      }
		
		 
		 @Test(priority = 0,dataProviderClass=AdidasLoginCheckoutPage.class, dataProvider="getData" )
		 
		 public void checkoutAsLoginCheckoutWith3DSecureVisaCard(String username,String password){
			 
			 adidasHomePage =new AdidasHomePage(driver);
			 subCategoriesPage =new SubCategoriesPage(driver);
			 adidasLoginCheckoutPage=new AdidasLoginCheckoutPage(driver);
			 productDetailsPage=new ProductDetailsPage(driver);
			 
		
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
					adidasLoginCheckoutPage.logInUser(username,password);
		
			 }
		 catch(Exception e1){
			 e1.printStackTrace();
		 }
		 } 
		 
		 @Test(priority = 1 ,dataProviderClass=ShippingDetailsLoginPage.class,dataProvider="getData")
		 public void shipDetailsLoginCheckoutWith3DSecureVisaCard(String sFName,String sLName,String sPhone,String sAddress,String sCity,String sPostal,String sDay,String sMonth,String sYear){
			 shippingDetailsLoginPage=new ShippingDetailsLoginPage(driver);
				
			 try{
					ReusableActions.waitForpageToLoad(driver);
					
					shippingDetailsLoginPage.ship_DetailsLogin(sFName,sLName,sPhone,sAddress,sCity,sPostal,sDay,sMonth,sYear);
				}
				
				catch (Throwable t) {
					t.printStackTrace();
				}
				
		}
		 @Test(priority = 2 ,dataProviderClass=VisaPaymentDetailsWith3DSecurePage.class,dataProvider="getData")
		 public void paymentDetailsLoginCheckoutWith3DSecureVisaCard(String cType,String cNumber,String cExpiryMonth,String cExpiryYear,String cccvv){
			 visaPaymentDetailsWith3DSecurePage=new VisaPaymentDetailsWith3DSecurePage(driver);
				try{
					ReusableActions.waitForpageToLoad(driver);
					visaPaymentDetailsWith3DSecurePage.selectCardPaymentDetails(cType,cNumber,cExpiryMonth,cExpiryYear,cccvv);
					
				}
				
				catch (Throwable t) {
					t.printStackTrace();
				}
				
		}
		 
		 @Test(priority = 3 ,dataProviderClass=Secure3DPage.class,dataProvider="getData")
		 public void Secure3DLoginCheckoutWith3DSecureVisaCard(String sName,String sEMonth,String sEYear,String scvv,String ssnn){
			 visaPaymentDetailsWith3DSecurePage=new VisaPaymentDetailsWith3DSecurePage(driver);
			 paymentDonePage=new PaymentDonePage(driver);
			 secure3DPage=new Secure3DPage(driver);
				try{
					ReusableActions.waitForpageToLoad(driver);
					secure3DPage.enterSecuredetails(sName, sEMonth, sEYear, scvv,ssnn);
					secure3DPage.clickActivelater();
					Assert.assertEquals(driver.getTitle(),constants.PAYMENT_DONE_PAGE);
					paymentDonePage.clickContinueShopping();
				}
				
				catch (Throwable t) {
					t.printStackTrace();
				}
				
		}
		 
		 @Test(priority = 4 )
		 
		 public void continuecheckoutLoginCheckoutWith3DSecureVisaCard(){
			 adidasHomePage =new AdidasHomePage(driver);
			 subCategoriesPage =new SubCategoriesPage(driver);
			 adidasLoginCheckoutPage=new AdidasLoginCheckoutPage(driver);
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
					
		
			 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 } 
		 
		 @Test(priority = 5 ,dataProviderClass=ShippingDetailsLoginPage.class,dataProvider="getData")
		 public void shipDetailsContinueLoginCheckoutWithVisaCard(String sFName,String sLName,String sPhone,String sAddress,String sCity,String sPostal,String sDay,String sMonth,String sYear){
			 shippingDetailsLoginPage=new ShippingDetailsLoginPage(driver);
				
			 try{
					ReusableActions.waitForpageToLoad(driver);
					shippingDetailsLoginPage.verifyLoginShipHeading();
					shippingDetailsLoginPage.ship_DetailsLogin(sFName,sLName,sPhone,sAddress,sCity,sPostal,sDay,sMonth,sYear);
				}
				
				catch (Throwable t) {
					t.printStackTrace();
				}
				
		}
		 
		 @Test(priority = 6 ,dataProviderClass=VisaPaymentDetailsWith3DSecurePage.class,dataProvider="getData")
		 public void paymentDetailsLoginCheckoutWith3DSecureVisa(String cType,String cNumber,String cExpiryMonth,String cExpiryYear,String cccvv){
			 visaPaymentDetailsWith3DSecurePage=new VisaPaymentDetailsWith3DSecurePage(driver);
				try{
					ReusableActions.waitForpageToLoad(driver);
					visaPaymentDetailsWith3DSecurePage.selectCardPaymentDetails(cType,cNumber,cExpiryMonth,cExpiryYear,cccvv);
				}
				
				catch (Throwable t) {
					t.printStackTrace();
				}
				
		}
		 
		 @Test(priority = 7 ,dataProviderClass=Secure3DPage.class,dataProvider="getData")
		 public void Secure3DLoginCheckoutWith3DSecureVisa(String sName,String sEMonth,String sEYear,String scvv,String ssnn){
			 visaPaymentDetailsWith3DSecurePage=new VisaPaymentDetailsWith3DSecurePage(driver);
			 paymentDonePage=new PaymentDonePage(driver);
			 secure3DPage=new Secure3DPage(driver);
				try{
					ReusableActions.waitForpageToLoad(driver);
					secure3DPage.enterSecuredetails(sName, sEMonth, sEYear, scvv,ssnn);
					secure3DPage.clickActivenow();
					Assert.assertEquals(driver.getTitle(),constants.PAYMENT_DONE_PAGE);
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
	
	


