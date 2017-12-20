package com.specomm.uniqlo.checkoutflows;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.specomm.uniqlo.common.utils.GeneralActions;
import com.specomm.uniqlo.common.utils.ReusableActions;
import com.specomm.uniqlo.pagecomponents.CategoryPage;
import com.specomm.uniqlo.pagecomponents.ProductDetailsPage;
import com.specomm.uniqlo.pagecomponents.ShippingDetailsGuestPage;
import com.specomm.uniqlo.pagecomponents.ShoppingBucketPage;
import com.specomm.uniqlo.pagecomponents.UniqloHomePage;
import com.specomm.uniqlo.pagecomponents.VisaPaymentDetailsPage;
import com.specomm.uniqlo.testreport.TestListener;

public class GuestCheckoutWithVisaCard extends GeneralActions{

	
static WebDriver driver;
	
	UniqloHomePage uniqloHomePage=new UniqloHomePage(driver);
	CategoryPage categoryPage=new CategoryPage(driver);
	ProductDetailsPage productDetailsPage=new ProductDetailsPage(driver);
	ShoppingBucketPage shoppingBucketPage=new ShoppingBucketPage(driver);
	ShippingDetailsGuestPage shippingDetailsGuestPage=new ShippingDetailsGuestPage(driver);
	VisaPaymentDetailsPage paymentDetailsPage=new VisaPaymentDetailsPage(driver);
	Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	GeneralActions genAction = new GeneralActions();
	
	
	
	
	
	
	
	 @BeforeClass
	  public void setUp() throws IOException, InterruptedException {
		 driver = getDriver();
		  driver = launchBrowser(driver, "firefox");
		  uniqloHomePage=PageFactory.initElements(driver,UniqloHomePage.class);
		  categoryPage=PageFactory.initElements(driver,CategoryPage.class);
		  productDetailsPage=PageFactory.initElements(driver,ProductDetailsPage.class);
		  shoppingBucketPage=PageFactory.initElements(driver,ShoppingBucketPage.class);
		  shippingDetailsGuestPage=PageFactory.initElements(driver,ShippingDetailsGuestPage.class);
		  paymentDetailsPage=PageFactory.initElements(driver,VisaPaymentDetailsPage.class);
		  ReusableActions.loadPropFileValues();
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
		 
	      }
	
	  
	 @Test(priority = 1 )
	 
	 public void checkoutAsGuestCheckoutWithVisaCard(){
		 
		 		 
		
		 try {
			 
			 uniqloHomePage.closePopup();
			 int j= ReusableActions.getRandomNumber(2,6);
			
			
				for (int i = 0; i <= j; i++) 
				{
					
					uniqloHomePage.mainMenuRandomSelection();
					ReusableActions.waitForpageToLoad(driver);
					categoryPage.productRandomSelection();
					ReusableActions.waitForpageToLoad(driver);
					productDetailsPage.selectProductToCart();
					ReusableActions.waitForpageToLoad(driver);
					
					
				}
				
				shoppingBucketPage.verifyShopBucketAndProceed();
				
				
				
				
	
		
		 }
	 catch(Exception e){
		 e.printStackTrace();
	 }
	 } 
	 
	 @Test(priority = 2 ,dataProviderClass=ShippingDetailsGuestPage.class,dataProvider="getData")
	 public void shipDetailscheckoutAsGuestWithVisaCard(String sFirstName,String sLastName,String sEmail,String sPhone,String sAddress,String sCity,String sRegion,String sPostal,String sDay,String sMonth,String sYear,String password,String vpassword ){
		
			
		 try{
				ReusableActions.waitForpageToLoad(driver);
		
				shippingDetailsGuestPage.ship_DetailsGuest(sFirstName,sLastName,sEmail,sPhone,sAddress,sCity,sRegion,sPostal,sDay,sMonth,sYear,password,vpassword);
				
			}
			
			catch (Throwable t) {
				t.printStackTrace();
			}
			
	}
	 @Test(priority = 3 ,dataProviderClass=VisaPaymentDetailsPage.class,dataProvider="getData")
	 public void paymentDetailscheckoutAsGuestWithVisaCard(String cType,String cNumber,String cExpiryMonth,String cExpiryYear,String cccvv){
		
			
		 try{
				ReusableActions.waitForpageToLoad(driver);
				
				paymentDetailsPage.selectPaymentDetails(cType,cNumber,cExpiryMonth,cExpiryYear,cccvv);
				
				Thread.sleep(10000);
				
			}
			
			catch (Throwable t) {
				t.printStackTrace();
			}
			
	}
	 
	 @AfterMethod
     public void afterMethod() throws IOException {
   
         if (driver != null) {
          File file = new File("Screenshots" + fileSeperator + "Results");
    if (!file.exists()) {
     Reporter.log("File created " + file, true);
     file.mkdir();
     System.out.println("Dir created");
    }
           File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    
    FileUtils.copyFile(screenshotFile,new File(dir+fileSeperator+"Screenshots" + fileSeperator + "Results" + fileSeperator+this.getClass().getSimpleName()+fileSeperator+TestListener.testMethodName+fileSeperator+TestListener.screenShotName));
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