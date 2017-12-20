package com.paypal.test.gops.admin.BankConfirm;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.paypal.test.bluefin.platform.asserts.BluefinAsserts;
import com.paypal.test.bluefin.platform.config.BluefinConfig;
import com.paypal.test.bluefin.platform.config.BluefinConfig.BluefinConfigProperty;
import com.paypal.test.bluefin.platform.grid.Grid;
import com.paypal.test.bluefin.platform.grid.WebTest;
import com.paypal.test.bluefin.platform.html.Button;
import com.paypal.test.bluefin.platform.html.Table;
import com.paypal.test.bluefin.testcomponents.admin.PayPalAdminLoginPage;
import com.paypal.test.bluefin.testcomponents.admin.PayPalAdminMemoPageExt;
import com.paypal.test.bluefin.testcomponents.admin.accountresearch.PayPalAdminAccountHomePage;
import com.paypal.test.bluefin.testcomponents.admin.accountresearch.PayPalAdminResearchPageExt;
import com.paypal.test.bluefin.testcomponents.admin.accountresearch.PayPalAdminRiskInfoPage;
import com.paypal.test.gops.admin.bankConfirm.BankConfirmUtilities;
import com.paypal.test.gops.admin.bankConfirm.PayPalAdminAddBankPage;
import com.paypal.test.gops.admin.utilities.AdminUsersPool;
import com.paypal.test.gops.admin.utilities.CommonUtils;
import com.paypal.test.jaws.db.DatabaseName;
import com.paypal.test.jaws.db.JDBCUtils;
import com.paypal.test.jaws.ppo.BankAccount;
import com.paypal.test.jaws.ppo.BankAccountFactory;
import com.paypal.test.jaws.ppo.BankAccountType;
import com.paypal.test.jaws.ppo.Country;
import com.paypal.test.jaws.ppo.PPAccountType;
import com.paypal.test.jaws.ppo.PPUserFactory;
import com.paypal.test.jaws.ppo.PayPalUser;
import com.paypal.test.jaws.ppo.UserBankRequest;
import com.paypal.test.jaws.ppo.impl.exception.AddUserBankFailedException;
import com.paypal.test.jaws.ppo.impl.exception.PayPalUserCreationFailedException;
import com.paypal.types.Currency.Info;




/**
 * Case ID: 	IVTJ1361527F
 * Confirm Bank for UK by Admin Agent
 * @author Shalini Subramanian
 */

public class IVTJ1361527F_ConfimBankByBypassWithOutRandomDepositUK {
	
	//Variable Declaration
	
	private PayPalUser paypaluser = null;
	String accountNumber=null;
	AdminUsersPool pool = null;
	String poolUser = null;
	BankAccount ppuserBankAccount =null;
	String strBankACHid="";
	
	
	//Page Declaration
	
	PayPalAdminLoginPage payPalAdminLoginPage = new PayPalAdminLoginPage();
	PayPalAdminResearchPageExt payPalAdminResearchPage = new PayPalAdminResearchPageExt();
	PayPalAdminAccountHomePage payPalAdminAccountHomePage = new PayPalAdminAccountHomePage();
	PayPalAdminAddBankPage payPalAdminAddBankPage = new PayPalAdminAddBankPage();
	PayPalAdminRiskInfoPage payPalAdminRiskInfoPage = new PayPalAdminRiskInfoPage();
	BankConfirmUtilities bankUtility =  new BankConfirmUtilities();
	PayPalAdminMemoPageExt ppAdminMemo = new PayPalAdminMemoPageExt();
	CommonUtils commonUtil = new CommonUtils();
		
	
	@BeforeClass
	public void Test () throws IOException, PayPalUserCreationFailedException, AddUserBankFailedException  {
		//create a US ppuser
		paypaluser =  PPUserFactory.createPayPalUser(PPAccountType.BUSINESS, Country.GB, Info.Pound_Sterling, true);
		//Add a bank to this paypal user
//		paypaluser.addBankAccount(BankAccountFactory.generateAddBankRequest(BankAccountType.CHECKING, Country.US, Info.US_Dollar,false));//, false, true);
		UserBankRequest request = BankAccountFactory.generateAddBankRequest(BankAccountType.CHECKING, Country.GB, Info.Pound_Sterling, false);
		paypaluser.addBankAccount(request);
		
	}
	
	@Test(testName = "1258784")	
	@WebTest
	public void IVTJ1361527F_Bank() throws Exception{	
		
		Grid.open(BluefinConfig.getConfigProperty(BluefinConfigProperty.PAYPAL_ADMIN_URL));
		Grid.driver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
		// Login to Admin with Default Credentials (ALL).
		pool=AdminUsersPool.getInstance();
		poolUser = pool.loginWithAdminUserPoolAccount();
		payPalAdminResearchPage.searchByEmail(paypaluser.getEmailAddress(), "Account Home",payPalAdminAccountHomePage);
		
		//Navigate to Bank Section	
		payPalAdminAccountHomePage.clickAccountHome_banksLink();
//		Table banksTable=payPalAdminAccountHomePage.getBanksTable();
//		String strBankStatus=banksTable.getCellValue(1, 4).replaceAll("(\\r|\\n)","").trim(); 
		String bstatus=Grid.driver().findElementByXPath("//*[@id='sortlist_bankinfo']/div[1]/table/tbody/tr[2]/td[5]").getText().replaceAll("(\\r|\\n)","").trim();
		System.out.println(bstatus);
		//Verification Point 1) Checking under Bank details confirmation shows as "rand dep not yet sent" before bank confirmation 
		BluefinAsserts.verifyEquals(bstatus,"Unconfirmed (rand dep not yet initiated)");
		
		//Selecting the Radio Box for the newly added bank
		//Grid.selenium().click("ach_id");
		Grid.driver().findElementByName("ach_id").click();
		
		//Submit DDI from the Bank section for UK Merchant Account
		WebElement bank_info_select = Grid.driver().findElementById("bank_info_select");
		Select select1 = new Select(bank_info_select);
		select1.selectByVisibleText("Submit DDI");
		Grid.driver().findElementByXPath("//input[@value='Go']").click();
		Thread.sleep(15000);
		
		// locate the current window from multiple windows and Navigate to 'Add Bank' Page
		Thread.sleep(5000);
		String parentWinHandle = Grid.driver().getWindowHandle();	
		BluefinAsserts.verifyTrue(isMemoErrorPresentOnConfirmInstantly());
		
		//String parentWinHandle = Grid.driver().getWindowHandle();
		
		//Navigate to Parent page : AccountHome page
		Grid.driver().switchTo().window(parentWinHandle);
		Thread.sleep(8000);	
		
		//Selecting the Radio Box for the newly added bank
		Grid.driver().findElementByName("ach_id").click();
		
		//Click on Confirm Button and click on BYPASS (This step is newly add as part of VOC_ADD Bank feature) confirmation the bank from the Agent side without Random deposit.
		Grid.driver().findElementByName("show_verify_ach").click();
		Thread.sleep(10000);
		Button bypass=new Button("//input[@value='Bypass']");
		bypass.clickonly();
//		Grid.driver().findElementByXPath("//input[@value='Bypass']").click();
		
		//Handles the Memo Pop-up screen
		String strOriginalWindow=Grid.driver().getWindowHandle();
		ppAdminMemo.handleMemo(strOriginalWindow);
		Thread.sleep(1500);
		
		//Verification point 2) Verifying the success message after initiating the BAI code for the Bank,
		BluefinAsserts.verifyEquals(payPalAdminAccountHomePage.getActionInfoMessageLabel().getText(),"Bank account verification successfully bypassed.");
		
		payPalAdminAccountHomePage.clickAccountHome_banksLink();
//		strBankStatus=banksTable.getCellValue(1, 4).replaceAll("(\\r|\\n)","").trim();
		bstatus=Grid.driver().findElementByXPath("//*[@id='sortlist_bankinfo']/div[1]/table/tbody/tr[2]/td[5]").getText().replaceAll("(\\r|\\n)","").trim();
		
		//Navigate to Risk Section Instead of refreshing the page	
		payPalAdminAccountHomePage.clickRiskInfoLink();
		payPalAdminRiskInfoPage.waitForPage();
		
		//Navigate to Account Home page
		payPalAdminRiskInfoPage.clickAccountHomeLink();
		payPalAdminAccountHomePage.waitForPage();
		
		//Navigate to Bank Section
		payPalAdminAccountHomePage.clickAccountHome_banksLink();
		
		
		//Verification Point 3) Checking under Bank details confirmation shows as confirmed by "Admin agent"  
//		payPalAdminAccountHomePage.clickAccountHome_banksLink();
//		strBankStatus=banksTable.getCellValue(1, 4).replaceAll("(\\r|\\n)","").trim();
		bstatus=Grid.driver().findElementByXPath("//*[@id='sortlist_bankinfo']/div[1]/table/tbody/tr[2]/td[5]").getText().replaceAll("(\\r|\\n)","").trim();
		System.out.println(bstatus);
		BluefinAsserts.verifyEquals(bstatus,"Confirmed (admin bypass)");
		
		
		
		//Verification Point 4) Check if the Account Type shows as Verified
		BluefinAsserts.verifyEquals(Grid.driver().findElementByXPath("//div[2]/div[2]/div[4]/div[2]/div/table/tbody/tr[6]/td").getText(),"Business - U.K. Verified - Cat10A (United Kingdom)"+"\nDowngrade Business Account");
						
	}
	
	@AfterClass
	public void tearDown(){
		//pool.putAdminUserPool(user);
	}
	
	/**
	 * This method would change the status of the bank in WUSER_ACH table and BANK_CONFIRMATION table
	 * @return 
	 * @throws InterruptedException 
	 */
	
	
    

	private boolean isMemoErrorPresentOnConfirmInstantly() throws Exception {
		boolean isMemoErr = true;
		
		String parentWinHandle = Grid.driver().getWindowHandle();	
		for (String winHandle : Grid.driver().getWindowHandles()) {
			if (!winHandle.equals(parentWinHandle)) {
				Grid.driver().switchTo().window(winHandle);
				Thread.sleep(5000);
				//Grid.driver().findElementByName("memo").click();
				Grid.driver().findElementById("memo").sendKeys("test");
				Grid.driver().findElementByName("submit.x").click();
				Thread.sleep(3000);
				Grid.driver().findElementById("closebank").click();
				Thread.sleep(7000);
				}
			else{
					isMemoErr = true; 
				}
		}	
		return isMemoErr;
	}

	
	public void uppdateBankDB(String strACHid){
		JDBCUtils jdbc = null;
        String wuser_ach_query="update wuser_ach set status='D' where id="+strACHid;
        String bankconf_query="update Bank_confirmation  set CONFIRMATION_STATE='D' where ach_id="+strACHid;
        	try {
                 jdbc = new JDBCUtils(DatabaseName.CLOC);
                 jdbc.createConnection();
                 jdbc.executeQuery(wuser_ach_query);
                 jdbc.executeQuery(bankconf_query);
                 jdbc.closeConnection();
             } catch (Exception e) {
                       e.printStackTrace();
            }                              

	}
}
