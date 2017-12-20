package com.paypal.test.gops.admin.BankConfirm;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.paypal.test.bluefin.platform.asserts.BluefinAsserts;
import com.paypal.test.bluefin.platform.config.BluefinConfig;
import com.paypal.test.bluefin.platform.config.BluefinConfig.BluefinConfigProperty;
import com.paypal.test.bluefin.platform.grid.Grid;
import com.paypal.test.bluefin.platform.grid.WebTest;
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
import com.paypal.test.gops.admin.utilities.PPUserUtility;
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
import com.paypal.test.jaws.ppo.impl.exception.AddUserCreditCardFailedException;
import com.paypal.test.jaws.ppo.impl.exception.PayPalUserCreationFailedException;
import com.paypal.types.Currency.Info;




/**
 * Case ID: 	IVTJ1361519F
 * Confirm Bank for US by Admin Agent
 * @author Shalini Subramanian
 * @Modified by kpulagam
 */

public class IVTJ1361519F_ConfimBankByBypassWithOutRandomDepositUS {
	
	//Variable Declaration
	
	private PayPalUser paypaluser = null;
	String accountNumber=null;
	AdminUsersPool pool = null;
	String poolUser =null;
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
	public void Test () throws IOException, PayPalUserCreationFailedException, AddUserBankFailedException, AddUserCreditCardFailedException  {
		
		//create a US ppuser
		paypaluser =  PPUserFactory.createPayPalUser(PPAccountType.BUSINESS, Country.US, Info.US_Dollar);
		//Add a bank to this paypal user
//		paypaluser.addBankAccount(BankAccountFactory.generateAddBankRequest(BankAccountType.CHECKING, Country.US, Info.US_Dollar,false));//, false, true);
		UserBankRequest request = BankAccountFactory.generateAddBankRequest(BankAccountType.CHECKING, Country.US, Info.US_Dollar, false);
		paypaluser.addBankAccount(request);
		
		/*String strBank=paypaluser.getUserBankAccounts().toString();
		System.out.println(strBank);
		int a=strBank.indexOf("bankId:");
		System.out.println(a);
		int b=strBank.indexOf("confirmed:");
		System.out.println(b);
		strBankACHid=strBank.substring(a+8,b);
		System.out.println(paypaluser.getEmailAddress()+"--"+strBankACHid);*/
	}
	
	@Test(testName = "1258783")	
	@WebTest
	public void IVTJ1361519F_VerifyBank() throws Exception{	
		
		Grid.open(BluefinConfig.getConfigProperty(BluefinConfigProperty.PAYPAL_ADMIN_URL));
		
		// Login to Admin - not using pool users because of the permissions which is assigned to the admin
		/*pool=AdminUsersPool.getInstance();
		user = pool.loginWithAdminUserPoolAccount();
		*/
		
		// Login to Admin with Default Credentials (ALL).
		pool=AdminUsersPool.getInstance();
		poolUser = pool.loginWithAdminUserPoolAccount();
		Grid.driver().manage().window().maximize();
		payPalAdminResearchPage.searchByEmail(paypaluser.getEmailAddress(), "Account Home",payPalAdminAccountHomePage);
		
		//Navigate to Bank Section	
		payPalAdminAccountHomePage.clickAccountHome_banksLink();
		Table banksTable=payPalAdminAccountHomePage.getBanksTable();
		Thread.sleep(20000);
//		String strBankStatus=banksTable.getCellValue(1, 5).replaceAll("(\\r|\\n)","").trim();
		
		String bstatus=Grid.driver().findElementByXPath("//*[@id='table_bank_info']/tbody/tr[2]/td[5]").getText().replaceAll("(\\r|\\n)","").trim();
		System.out.println(bstatus);
		//Verification Point 1) Checking under Bank details confirmation shows as "rand dep not yet sent" before bank confirmation 
		BluefinAsserts.verifyEquals(bstatus,"Unconfirmed (rand dep not yet sent)");

		//Selecting the Radio Box for the newly added bank
		//Grid.selenium().click("ach_id");
		Grid.driver().findElementByName("ach_id").click();
		
		//Click on Confirm Button and click on BYPASS (This step is newly add as part of VOC_ADD Bank feature) confirmation the bank from the Agent side without Random deposit.
		Grid.driver().findElementByName("show_verify_ach").click();
		Thread.sleep(10000);
		Grid.driver().findElementByXPath("//input[@value='Bypass']").click();
		
		//Handle the Memo
		String strOriginalWindow=Grid.driver().getWindowHandle();
		ppAdminMemo.handleMemo(strOriginalWindow);
		Thread.sleep(1500);
		
		//Verification point 2) Verifying the success message after initiating the BAI code for the Bank,
		BluefinAsserts.verifyEquals(payPalAdminAccountHomePage.getActionInfoMessageLabel().getText(),"Bank account verification successfully bypassed.");
		
		payPalAdminAccountHomePage.clickAccountHome_banksLink();
//		strBankStatus=banksTable.getCellValue(1, 4).replaceAll("(\\r|\\n)","").trim(); 
		bstatus=Grid.driver().findElementByXPath("//*[@id='table_bank_info']/tbody/tr[2]/td[4]").getText().replaceAll("(\\r|\\n)","").trim();

		//Navigate to Risk Section Instead of refreshing the page
		payPalAdminAccountHomePage.clickRiskInfoLink();
		payPalAdminRiskInfoPage.waitForPage();
		
		//Navigate to Account Home Page	
		payPalAdminRiskInfoPage.clickAccountHomeLink();
		payPalAdminAccountHomePage.waitForPage();
		
		//Navigate to Bank Section	
		payPalAdminAccountHomePage.clickAccountHome_banksLink();
		
		//Verification Point 3) Checking under Bank details confirmation shows as confirmed by "Admin agent"
//		strBankStatus=banksTable.getCellValue(1, 4).replaceAll("(\\r|\\n)","").trim();
		bstatus=Grid.driver().findElementByXPath("//*[@id='table_bank_info']/tbody/tr[2]/td[5]").getText().replaceAll("(\\r|\\n)","").trim();
		BluefinAsserts.verifyEquals(bstatus,"Confirmed (admin bypass)");
		
		
		//Verification Point 4) Check if the Account Type shows as Verified
		
		BluefinAsserts.verifyEquals(Grid.driver().findElementByXPath("//div[2]/div[2]/div[4]/div[2]/div/table/tbody/tr[6]/td").getText(),"Business - Verified - Cat10A"+"\nDowngrade Business Account");
		
	}
	
	@AfterClass
	public void tearDown(){
		//pool.putAdminUserPool(user);
	}
	
	/**
	 * This method would change the status of the bank in WUSER_ACH table and BANK_CONFIRMATION table
	 */
	
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
