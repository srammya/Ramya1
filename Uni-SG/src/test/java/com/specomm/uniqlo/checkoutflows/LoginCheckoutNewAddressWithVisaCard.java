package com.specomm.uniqlo.checkoutflows;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
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
import com.specomm.uniqlo.pagecomponents.MasterPaymentDetailsPage;
import com.specomm.uniqlo.pagecomponents.NewAccountPage;
import com.specomm.uniqlo.pagecomponents.ProductDetailsPage;
import com.specomm.uniqlo.pagecomponents.ShippingDetailsLoginPage;
import com.specomm.uniqlo.pagecomponents.ShippingNewDetailsLoginPage;
import com.specomm.uniqlo.pagecomponents.ShoppingBucketPage;
import com.specomm.uniqlo.pagecomponents.UniqloHomePage;
import com.specomm.uniqlo.pagecomponents.UniqloLoginPage;
import com.specomm.uniqlo.pagecomponents.VisaPaymentDetailsPage;
import com.specomm.uniqlo.testreport.TestListener;

public class LoginCheckoutNewAddressWithVisaCard extends GeneralActions{

	
	static WebDriver driver;
	
	UniqloHomePage uniqloHomePage=new UniqloHomePage(driver);
	UniqloLoginPage uniqloLoginPage=new UniqloLoginPage(driver);
	NewAccountPage newAccountPage =new NewAccountPage(driver);
	CategoryPage categoryPage=new CategoryPage(driver);
	ProductDetailsPage productDetailsPage=new ProductDetailsPage(driver);
	ShoppingBucketPage shoppingBucketPage=new ShoppingBucketPage(driver);
	ShippingNewDetailsLoginPage shippingNewDetailsLoginPage=new ShippingNewDetailsLoginPage(driver);
	ShippingDetailsLoginPage shippingDetailsLoginPage=new ShippingDetailsLoginPage(driver);
	VisaPaymentDetailsPage visaPaymentDetailsPage=new VisaPaymentDetailsPage(driver);
	Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	GeneralActions genAction = new GeneralActions();
	
	
	
	
	
	 @BeforeClass
	  public void setUp() throws IOException, InterruptedException {
		  driver = launchBrowser(driver, "firefox");
		  uniqloHomePage=PageFactory.initElements(driver,UniqloHomePage.class);
		  uniqloLoginPage=PageFactory.initElements(driver,UniqloLoginPage.class);
		  newAccountPage=PageFactory.initElements(driver,NewAccountPage.class);
		  categoryPage=PageFactory.initElements(driver,CategoryPage.class);
		  productDetailsPage=PageFactory.initElements(driver,ProductDetailsPage.class);
		  shoppingBucketPage=PageFactory.initElements(driver,ShoppingBucketPage.class);
		  shippingDetailsLoginPage=PageFactory.initElements(driver,ShippingDetailsLoginPage.class);
		  shippingNewDetailsLoginPage=PageFactory.initElements(driver,ShippingNewDetailsLoginPage.class);
		  visaPaymentDetailsPage=PageFactory.initElements(driver,VisaPaymentDetailsPage.class);
		  
		  ReusableActions.loadPropFileValues();
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
		 
	      }
	
	
	 
	 @Test(priority=1,dataProviderClass=NewAccountPage.class, dataProvider="getData")
		
	 public void userCreationcheckoutAsLoginCheckoutNewAddWithVisaCard(String rEmail,String title,String rFirstName,String rLastName,String rAddress,String rCity,String rProvince,String rPcode,String rPhone,String rPassword,String rCPassword,String dDay,String dMonth,String dYear){
		
		 uniqloHomePage =new UniqloHomePage(driver);
		 NewAccountPage newAccountPage =new NewAccountPage(driver);
		 ReusableActions.waitForpageToLoad(driver);
		 uniqloHomePage.closePopup();
		 uniqloHomePage.clickRegister();
		 
		 newAccountPage.enterAccountDetails(rEmail, title, rFirstName, rLastName, rAddress, rCity,rProvince, rPcode,rPhone, rPassword, rCPassword, dDay, dMonth, dYear);
		 
		 uniqloHomePage.clickLogout();
		
		 }
	 
	 
	 
	  
	 @Test(priority = 2,dataProviderClass=UniqloLoginPage.class, dataProvider="getData")
	 
	 public void checkoutAsLoginCheckoutNewAddWithVisaCard(String username,String password){
		 uniqloHomePage =new UniqloHomePage(driver);
		 categoryPage =new CategoryPage(driver);
		 productDetailsPage=new ProductDetailsPage(driver);
		 
		
		 try {
			 
			 
			 int j= ReusableActions.getRandomNumber(2,5);
			
			 System.out.println("print value for j " + j);
			 
				for (int i = 0; i <= 2; i++) 
				{
					
					uniqloHomePage.mainMenuRandomSelection();
					ReusableActions.waitForpageToLoad(driver);
					categoryPage.productRandomSelection();
					ReusableActions.waitForpageToLoad(driver);
					productDetailsPage.selectProductToCart();
					ReusableActions.waitForpageToLoad(driver);
					
					
				}
				shoppingBucketPage.verifyShopBucketAndProceed();
					Thread.sleep(2000);
				
					shippingDetailsLoginPage.ship_DetailsLogin(NewAccountPage.Email,password);
					try{
					Alert alert=driver.switchTo().alert();
					alert.accept();
					
				}
				catch(Exception e){
					//e.printStackTrace();
				}
				
	
		
		 }
	 catch(Exception e){
		 e.printStackTrace();
	 }
	 } 
	 
	 @Test(priority = 3 ,dataProviderClass=ShippingNewDetailsLoginPage.class,dataProvider="getData")
	 public void shipDetailsLoginCheckoutNewAddWithVisaCard(String sFirstName,String sLastName,String sPhone,String sAddress,String sCity,String sRegion,String sPostal){
		 shippingNewDetailsLoginPage=new ShippingNewDetailsLoginPage(driver);
			
		 try{
				
				
			 shippingNewDetailsLoginPage.selectNewAddress();
			 shippingNewDetailsLoginPage.ship_NewAddress(sFirstName,sLastName,sPhone,sAddress,sCity,sRegion,sPostal);
				
				
			}
			
			catch (Throwable t) {
			t.printStackTrace();
			}
			
	}
	 
	 
	 /*@Test(priority = 3 ,dataProviderClass=ShippingDetailsLoginPage.class,dataProvider="getData")
	 public void shipDetailsLoginCheckoutWithMasterCard(String rLoginEmail,String rLoginPassword){
		 shippingDetailsLoginPage=new ShippingDetailsLoginPage(driver);
			
		 try{
				ReusableActions.waitForpageToLoad(driver);
				
				
				shippingDetailsLoginPage.ship_DetailsLogin(rLoginEmail,rLoginPassword);
				
			}
			
			catch (Throwable t) {
				t.printStackTrace();
			}
			
	}*/
	 @Test(priority = 4 ,dataProviderClass=VisaPaymentDetailsPage.class,dataProvider="getData")
	 public void paymentDetailsLoginCheckoutWithVisaCard(String cType,String cNumber,String cExpiryMonth,String cExpiryYear,String cccvv){
		 visaPaymentDetailsPage=new VisaPaymentDetailsPage(driver);
			
		 try{
			  visaPaymentDetailsPage.selectCardType("Visa");
				visaPaymentDetailsPage.selectPaymentDetails(cType,cNumber,cExpiryMonth,cExpiryYear,cccvv);
				
				
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