package com.paypal.test.gops.admin.MaestroEnablement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.paypal.test.bluefin.platform.asserts.BluefinAsserts;
import com.paypal.test.bluefin.platform.config.BluefinConfig;
import com.paypal.test.bluefin.platform.config.BluefinConfig.BluefinConfigProperty;
import com.paypal.test.bluefin.platform.grid.Grid;
import com.paypal.test.bluefin.platform.grid.ScreenShotRemoteWebDriver;
import com.paypal.test.bluefin.platform.grid.WebTest;
import com.paypal.test.bluefin.platform.html.Table;
import com.paypal.test.bluefin.testcomponents.admin.PayPalAdminLoginPage;
import com.paypal.test.bluefin.testcomponents.admin.PayPalAdminMemoPageExt;
import com.paypal.test.bluefin.testcomponents.admin.accountresearch.PayPalAdminAccountHomePage;
import com.paypal.test.bluefin.testcomponents.admin.accountresearch.PayPalAdminActivityLogPage;
import com.paypal.test.bluefin.testcomponents.admin.accountresearch.PayPalAdminResearchPageExt;
import com.paypal.test.bluefin.testcomponents.admin.accountresearch.PayPalAdminRiskInfoPage;
import com.paypal.test.bluefin.testcomponents.paypal.PayPalEmailAddressPage;
import com.paypal.test.bluefin.testcomponents.paypal.PayPalFundingOptionsPage;
import com.paypal.test.bluefin.testcomponents.paypal.PayPalLoginPageExt;
import com.paypal.test.bluefin.testcomponents.paypal.PayPalMyAccountPage;
import com.paypal.test.bluefin.testcomponents.paypal.PayPalProfilePage;
import com.paypal.test.bluefin.testcomponents.paypal.PayPalReviewSendMoneyPage;
import com.paypal.test.bluefin.testcomponents.paypal.PayPalSendMoneyPage;
import com.paypal.test.gops.admin.utilities.AdminUsersPool;
import com.paypal.test.gops.admin.utilities.CommonUtils;
import com.paypal.test.jaws.config.JawsConfig;
import com.paypal.test.jaws.config.JawsConfig.JawsConfigProperty;
import com.paypal.test.jaws.ppo.CreditCard;
import com.paypal.test.jaws.ppo.PayPalUser;



// TODO: Auto-generated Javadoc
/**
 * TC ID:GGOG1349391F
 * Confirm the Activity Log shows the appropriate details on disabling and reenabling the toggle option
 * for maestro credit card in Risk Info Attributes section and also the buyer should not be able
 * to send money from the maestro credit card to this seller.
 *
 * @author Prem
 */

public class GGOG1349391F {
	 ScreenShotRemoteWebDriver webDriver = Grid.driver();
    /** The pay pal admin login page. */
    PayPalAdminLoginPage payPalAdminLoginPage = new PayPalAdminLoginPage();
    
    /** The pay pal admin research page. */
    PayPalAdminResearchPageExt payPalAdminResearchPage = new PayPalAdminResearchPageExt();
    
    /** The pay pal admin account home page. */
    PayPalAdminAccountHomePage payPalAdminAccountHomePage = new PayPalAdminAccountHomePage();
    
    /** The pay pal admin activity log page. */
    PayPalAdminActivityLogPage payPalAdminActivityLogPage = new PayPalAdminActivityLogPage();
    
    /** The pay pal my account page. */
    PayPalMyAccountPage payPalMyAccountPage=new PayPalMyAccountPage();
    
    /** The pay pal login page. */
    PayPalLoginPageExt payPalLoginPage = new PayPalLoginPageExt();
    
    /** The pay pal email address page. */
    PayPalEmailAddressPage payPalEmailAddressPage = new PayPalEmailAddressPage();
  	
	  /** The pay pal admin risk info page. */
	  PayPalAdminRiskInfoPage payPalAdminRiskInfoPage = new PayPalAdminRiskInfoPage();
 	
	 /** The pay pal admin memo page. */
	 PayPalAdminMemoPageExt payPalAdminMemoPage = new PayPalAdminMemoPageExt();
 	
	 /** The pay pal send money page. */
	 PayPalSendMoneyPage payPalSendMoneyPage = new PayPalSendMoneyPage();
 	
	 /** The pay pal funding options page. */
	 PayPalFundingOptionsPage payPalFundingOptionsPage = new PayPalFundingOptionsPage();
	
	/** The pp send money. */
	PayPalSendMoneyPage ppSendMoney = new PayPalSendMoneyPage();
	
	/** The pp review send money. */
	PayPalReviewSendMoneyPage ppReviewSendMoney = new PayPalReviewSendMoneyPage();
	
	/** The pp funding options. */
	PayPalFundingOptionsPage ppFundingOptions = new PayPalFundingOptionsPage();
	PayPalProfilePage payPalProfilePage= new PayPalProfilePage();
    /** The str original window. */
    String strOriginalWindow;
    
    /** The file name. */
    String fileName = "userslist.yaml";
	
	/** The pool. */
	AdminUsersPool pool = null;
	
	/** The admin user. */
	String adminUser=null;
 
    /**
     * Credit card switch disable.
     *
     * @param buyer the buyer
     * @param creditCard1 the credit card1
     * @param seller the seller
     * @param creditCard2 the credit card2
     * @param currency the currency
     * @throws Exception the exception
     */
    @WebTest
    @Test(testName = "533",groups={"Other","Financial_CC"},dataProvider = "createBuyerSellerAndCreditCard", dataProviderClass = StaticDataProvider.class)
    public void creditCardSwitchDisable(PayPalUser buyer, CreditCard  creditCard1, PayPalUser seller, CreditCard creditCard2,String currency) throws Exception{  
    	
    	pool = AdminUsersPool.getInstance();
		
    	//adds a credit card to buyer
		buyer.addCreditCard(creditCard1, true, true, false);
		seller.addCreditCard(creditCard2, true, true, false);

		//toggleCreditCard(seller);
		ScreenShotRemoteWebDriver webDriver = Grid.driver();
		Grid.open(BluefinConfig.getConfigProperty(BluefinConfigProperty.PAYPAL_ADMIN_URL));
		Grid.driver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	adminUser = pool.loginWithAdminUserPoolAccount();

        payPalAdminResearchPage.searchByEmail(seller.getEmailAddress(), "Risk Info", payPalAdminRiskInfoPage);
       //Clicking on disable link in Maestro row in Risk info-> Account Attributes section        
     //   Grid.driver().executeScript("oc_toggle_cc_switch('maestro')");
        Grid.driver().findElementByXPath("//*[@id='rightside_content_wrapper']/table/tbody/tr[17]/td/div/a").click();
       
        //Handle memo window
        String windowHandle = Grid.driver().getWindowHandle();
        payPalAdminMemoPage.handleMemo(windowHandle);
        //Verification point: Verifying the text 'credit card flag toggle'
        BluefinAsserts.verifyTrue(Grid.driver().findElementByXPath("//*[@id='div_msg']/div").getText().contains("Credit card flag toggled successfully."));
        
        //Clicking on activity log link
        payPalAdminAccountHomePage.clickActivitylogLink(payPalAdminActivityLogPage);
//		Thread.sleep(15000);
        
        //Verification point : Verifying credit card switch enabled and disabled
        
        Table activityLogData = payPalAdminActivityLogPage.getActivityLogDataTable();
		BluefinAsserts.verifyEquals(CommonUtils.verifyTextInTable("Credit Card Switch Disabled", activityLogData) , true, "Verify that activity admin Authenticated Credit Card Number is displayed when specific transaction type is displayed");		


//        verifyWhetherTextPresentInActivityLog("Credit Card Switch Enabled");
//        verifyWhetherTextPresentInActivityLog("Credit Card Switch Disabled");
		
         //Directing to paypal url
			Grid.driver().get("https://www."+JawsConfig.getConfigProperty(JawsConfigProperty.STAGE_NAME)+".qa.paypal.com/login");
		//Login as buyer
		payPalLoginPage.logIn(buyer.getEmailAddress(), "11111111",
				payPalMyAccountPage);
        //Clicks on Send money tab
        payPalMyAccountPage.clickSendMoneyLink(payPalSendMoneyPage);
//		Grid.driver().findElement(By.linkText("Send Money")).click();
			
			
            String sell=seller.getEmailAddress();
        //Enter the seller email address, amount and Click on continue button
//    payPalSendMoneyPage.getRecipientsTextField().type(seller.getEmailAddress());
//        Grid.driver().waitUntilPageTitlePresent("Send Money");
//            Thread.sleep(2000);
//		payPalMyAccountPage.clickProfileLink(payPalProfilePage);
            
//		payPalProfilePage.clickFinancialSettingsLink();
////		Grid.driver().findElementById("FINANCIAL_SETTING").click();
//		String actual=Grid.driver().findElementById("creditCards").getText();
//		BluefinAsserts.assertEquals(actual, "You haven.t added a credit card.");
//         
            
		Grid.driver().findElement(By.id("email")).clear();
		Grid.driver().findElement(By.id("email")).sendKeys(sell);
		Grid.driver().findElement(By.id("amount")).clear();
		Grid.driver().findElement(By.id("amount")).sendKeys("11");
		Grid.driver().findElement(By.id("GoodsServices")).click();
//		Thread.sleep(1000);
		Grid.driver().findElement(By.id("submit")).click();
//		BluefinAsserts.verifyTrue(Grid.driver().isTextPresent("You may not use your existing credit cards to fund this payment. Please use a different type of card."));
//        Thread.sleep(2000);
        //BluefinAsserts.verifyEquals("Add debit or credit card - PayPal", webDriver.getTitle());
//		BluefinAsserts.verifyTrue(Grid.driver().isTextPresent("You may not use your existing credit cards to fund this payment. Please use a different type of card."));
//        BluefinAsserts.verifyTrue(Grid.driver().getPageSource().contains("You haven.t added a credit card."));
        //Change the funding option from paypal balance to credit card
        //Grid.driver().findElementByLinkText("Change").click();
       //Grid.driver().waitUntilTextPresent("Funding Options");
       
    // payPalFundingOptionsPage.getCCOptionsRadioButton().check();
        
       //Getting the list of values present in Credit card list box for verifying whether
       // disabled maestro credit card is not present in list
      //checkWhetherDisabledMaestroCardIsNotPresentInFundingOptions();
        
        
//			Thread.sleep(2000);
    
		
			Grid.open(BluefinConfig.getConfigProperty(BluefinConfigProperty.PAYPAL_ADMIN_URL));
	    	adminUser = pool.loginWithAdminUserPoolAccount();

	        payPalAdminResearchPage.searchByEmail(seller.getEmailAddress(), "Risk Info", payPalAdminRiskInfoPage);
	       //Clicking on disable link in Maestro row in Risk info-> Account Attributes section        
	     //   Grid.driver().executeScript("oc_toggle_cc_switch('maestro')");
	       // Grid.driver().findElementByXPath("//table[@class='table_lvp']/tbody/tr[17]/td/div/a").click();
	      //  /html/body/form/div[2]/div[2]/div[4]/div[2]/div/table/tbody/tr[17]/td/div/a
	        Grid.driver().findElementByXPath("//a[contains(text(),'[Enable]')]").click();
	        //Handle memo window
	        String windowHandle1 = Grid.driver().getWindowHandle();
	        payPalAdminMemoPage.handleMemo(windowHandle1);
	        //Verification point: Verifying the text 'credit card flag toggle'
	    //    BluefinAsserts.verifyTrue(Grid.driver().isTextPresent("Credit card flag toggled successfully."));
	        
	        //Clicking on activity log link
	        payPalAdminAccountHomePage.clickActivitylogLink(payPalAdminActivityLogPage);   
	        Table activityLogData1 = payPalAdminActivityLogPage.getActivityLogDataTable();
			BluefinAsserts.verifyEquals(CommonUtils.verifyTextInTable("Credit Card Switch Enabled", activityLogData1) , true, "Verify that activity admin Authenticated Credit Card Number is displayed when specific transaction type is displayed");
   //toggleCreditCard(seller);
        
         }

    /**
     * This method will fetch the values from Credit card fundition options.
     */
   /* public void checkWhetherDisabledMaestroCardIsNotPresentInFundingOptions(){
    	  String array[]=payPalFundingOptionsPage.getCCSelectList().getSelectOptions();
        
          Boolean blnFound=false;
          for(int i=0;i<array.length;i++){
      	 
      	   if( array[i].contains("Bancontact Mr Cash")){
      		   blnFound=false;
      		   break;
      	   }
      	   else
      	   {
      		   blnFound=true;
      	   }
          }
          
      	  BluefinAsserts.verifyTrue(blnFound, "Verify that Maestro Card is not available as funding source.");
    }*/

    /**
     * Tear down.
     */
    @AfterClass
    public void tearDown(){   
    	
    //	pool.putAdminUserPool(adminUser);
    }
    
    /**
     * Toggle credit card.
     *
     * @param seller the seller
     */
   // private void toggleCreditCard(PayPalUser seller){
    //	Grid.open(BluefinConfig.getConfigProperty(BluefinConfigProperty.PAYPAL_ADMIN_URL));
    	//adminUser = pool.loginWithAdminUserPoolAccount();

      //  payPalAdminResearchPage.searchByEmail(seller.getEmailAddress(), "Risk Info", payPalAdminRiskInfoPage);
       //Clicking on disable link in Maestro row in Risk info-> Account Attributes section        
     //   Grid.driver().executeScript("oc_toggle_cc_switch('maestro')");
      //  Grid.driver().findElementByXPath("//table[@class='table_lvp']/tbody/tr[17]/td/div/a").click();
       
        //Handle memo window
     //   String windowHandle = Grid.driver().getWindowHandle();
      //  payPalAdminMemoPage.handleMemo(windowHandle);
        //Verification point: Verifying the text 'credit card flag toggle'
       // BluefinAsserts.verifyTrue(Grid.driver().isTextPresent("Credit card flag toggled successfully."));
        
        //Clicking on activity log link
       // payPalAdminAccountHomePage.clickActivitylogLink(payPalAdminActivityLogPage);
    	
    	
    }

