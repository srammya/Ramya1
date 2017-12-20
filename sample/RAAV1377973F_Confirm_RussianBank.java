package com.paypal.test.gops.admin.BankConfirm;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import com.paypal.test.bluefin.testcomponents.admin.accountresearch.PayPalAdminAccountHomeBankPage;
import com.paypal.test.bluefin.testcomponents.admin.accountresearch.PayPalAdminAccountHomePage;
import com.paypal.test.bluefin.testcomponents.admin.accountresearch.PayPalAdminResearchPageExt;
import com.paypal.test.bluefin.testcomponents.admin.bankConfirm.PayPalAdminAddBankPage;
import com.paypal.test.bluefin.testcomponents.admin.bankConfirm.PayPalAdminConfirmBankPage;
import com.paypal.test.gops.admin.bankConfirm.BankConfirmUtilities;
import com.paypal.test.gops.admin.bankConfirm.RandomDeposits;
import com.paypal.test.gops.admin.utilities.AdminUsersPool;
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
import com.paypal.types.Currency.Info;

// TODO: Auto-generated Javadoc
/************
 * Case ID: RAAV1377973F Confirm Russian bank thru Random deposit and verify the
 * display of Russian Bank in Account Home Page.
 * 
 * author Shalini Subramanian
 */

public class RAAV1377973F_Confirm_RussianBank {

	/**
	 * Test.
	 * 
	 * @throws Exception
	 */
    
    
    
    
	@BeforeClass
	public void Test() throws Exception {
		// Try to use admin user pool
		/*pool = AdminUsersPool.getInstance();

		// create a RU ppuser
		paypaluser = PPUserFactory.createPayPalUser(PPAccountType.BUSINESS,
				Country.RU, Info.Russian_Ruble);

		// Add a bank to this paypal user
		ppuserBankAccount = BankAccountFactory.generateAddBankRequest(
				BankAccountType.CHECKING, Country.RU, Info.Russian_Ruble,false) ;
		paypaluser.addBankAccount(ppuserBankAccount);//, false, true);
		
		User_bank_details=getBankDetails(paypaluser);
		// send random deposit to this bank
		updateBankDB();
		dep = getDepositDigit(paypaluser.getAccountNumber());*/
		paypaluser =  PPUserFactory.createPayPalUser(PPAccountType.BUSINESS, Country.RU, Info.Russian_Ruble, true);
		//Add a bank to this paypal user
//		paypaluser.addBankAccount(BankAccountFactory.generateAddBankRequest(BankAccountType.CHECKING, Country.US, Info.US_Dollar,false));//, false, true);
		UserBankRequest request = BankAccountFactory.generateAddBankRequest(BankAccountType.CHECKING, Country.RU, Info.Russian_Ruble, false);
		paypaluser.addBankAccount(request);
		User_bank_details=getBankDetails(paypaluser);
		// send random deposit to this bank
		updateBankDB();
		dep = getDepositDigit(paypaluser.getAccountNumber());
		 
	}

	/**
	 * Verify confirm bank thru random deposit.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test(testName = "516")
	@WebTest
	public void VerifyConfirmBankThruRandomDeposit() throws Exception {

		// open browser
		Grid.driver()
				.get(BluefinConfig
						.getConfigProperty(BluefinConfigProperty.PAYPAL_ADMIN_URL));
		Grid.driver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Grid.driver()
				.waitForPageToLoad(
						BluefinConfig
								.getConfigProperty(BluefinConfigProperty.EXECUTION_TIMEOUT));

		// Login ADMIN using default admin user name 'All'
		pool=AdminUsersPool.getInstance();
		user = pool.loginWithAdminUserPoolAccount();
		payPalAdminResearchPage.searchByEmail("rkaliyaperumal-rub@paypal.com",
				"Account Home", payPalAdminAccountHomePage);

		// Navigate to Bank Section
		payPalAdminAccountHomePage.clickAccountHome_banksLink();
		Thread.sleep(15000);

//		Table banksTable = payPalAdminAccountHomePage.getBanksTable();

		// Verification Point 1) Checking under Bank details the Type of the
		
		
				BluefinAsserts.verifyTrue(payPalAdminAccountHomePage.getBanksTable().getText().toString().contains("N/A"),"1)Verify the type N/A");
		
		
//				"1) Checking under Bank details the Type of the Bank is N/A");

		// Verification Point 2) Checking under Bank details confirmation shows
		// as "rand dep sent" before bank confirmation
		String ucon=Grid.driver().findElementByXPath("//li[5]/div/table/tbody/tr[2]/td[5]").getText().replaceAll("(\\r|\\n)","").trim();
		System.out.println(ucon);
		BluefinAsserts.assertEquals(ucon,"Unconfirmed (rand dep sent)","2)Checking under Bank details confirmation shows as (rand dep sent) before bank confirmation");
		
		
		BluefinAsserts.verifyTrue(payPalAdminAccountHomePage.getBanksTable().getText().replaceAll("(\\r|\\n)","").trim().contains(paypaluser.getFirstName() + " " + paypaluser.getLastName() + "(Business)"));
		
	
		BluefinAsserts.verifyTrue(payPalAdminAccountHomePage.getBanksTable().getText().toString().contains("RU"),"4) Checking under Bank details the Country of the Bank is RU");
	
		BluefinAsserts.verifyTrue(payPalAdminAccountHomePage.getBanksTable().getText().replaceAll("(\\r|\\n)","").trim().contains(User_bank_details.getRoutingNumber()+ " " + "(Bank Identification Code)"));
	
		
		// Click confirm button
		Grid.driver()
				.findElementByXPath(
						"//li[@id='sortlist_bankinfo']/div/table/tbody/tr[2]/td/form/input[@value='Confirm']")
				.click();
		Thread.sleep(5000);

		// Calling Confirm Bank Method to confirm bank
		String parentWinHandle = Grid.driver().getWindowHandle();
		ConfirmBank();

		// Navigate to Bank Section
		payPalAdminAccountHomePage.clickAccountHome_banksLink();
		Thread.sleep(15000);

		// Verification Point 9) Checking under Bank details if Unconfirm Bank
		// button is present
		
		String unconfirm=Grid.driver().findElementByName("confirm_unconfirm_ach").getAttribute("value").toString();
				
		
		BluefinAsserts.assertEquals("Unconfirm",unconfirm,"Verified the presence of unconfirm button");
	
		// Verification Point 10) Checking under Bank details confirmation shows
		// as Confirmed after bank Confirmation
		String con=Grid.driver().findElementByXPath("//li[5]/div/table/tbody/tr[2]/td[5]").getText().replaceAll("(\\r|\\n)","").trim();
		System.out.println(con);
		BluefinAsserts.assertEquals(con,"Confirmed (admin rand dep)","10)Checking under Bank details confirmation shows as Confirmed after bank Confirmation");

//		Confirmed (admin rand dep)
		// click logout link
		Grid.driver().findElementByXPath("//span[@id='bannerNav']/a[1]")
				.click();
	}

	/**
	 * Tear down.
	 */
	@AfterClass
	public void tearDown() {
		pool.putAdminUserPool(user);
	}

	/**
	 * Checks if is confirm bank success.
	 * 
	 * @return true, if is confirm bank success
	 * @throws Exception
	 *             the exception
	 */
	private void ConfirmBank() throws Exception {

		String parentWinHandle = Grid.driver().getWindowHandle();

		Grid.driver().switchTo().window(parentWinHandle);

		// Verification Point 6) Checking the Confirm Bank Page if Routing
		// Number is present corresponding to the Bank is replaced by Bank Name
		
		String routing=(User_bank_details.getRoutingNumber());
		BluefinAsserts.assertEquals("111111111",routing,"Verified the routing value from Bank table");
	
		// Verification Point 7) Checking the Confirm Bank Page RUB label is
		// present next to the RD Text Box
		
		BluefinAsserts.verifyTrue(Grid.driver().getPageSource().contains("RUB"));
		
		payPalAdminConfirmBankPage.setDepositOneOneTextFieldValue(dep[0]);
		payPalAdminConfirmBankPage.setDepositOneTwoTextFieldValue(dep[1]);
		payPalAdminConfirmBankPage.setDepositTwoOneTextFieldValue(dep[2]);
		payPalAdminConfirmBankPage.setDepositTwoTwoTextFieldValue(dep[3]);

		Grid.driver().findElementByXPath("//input[@value='Confirm']").click();

		// Handle the Memo
		String strOriginalWindow = Grid.driver().getWindowHandle();
		ppAdminMemo.handleMemo(strOriginalWindow);
		

		// Verification Point 8)Checking for the success message Bank account
		// confirmation successful
		BluefinAsserts.verifyTrue(payPalAdminAccountHomePage.getSuccessMsgBoxLabel().getText().contains("Bank account confirmation successful"),
						"8) Checking for the success message Bank account confirmation successful");
		
		

	}

	

	
	private String[] getDepositDigit(String ppuserAcct) throws Exception {

		
		randomDeposits = bankUtility.getRandomDeposits(paypaluser.getAccountNumber());
		
		depositOne = String.format("%2s", randomDeposits.getDepositOne()).replace(' ', '0');
		
		
        depositTwo = String.format("%2s", randomDeposits.getDepositTwo()).replace(' ', '0');
        
        return new String[] {depositOne.substring(0, 1),depositOne.substring(1),depositTwo.substring(0, 1),depositTwo.substring(1)};

	
		}
	/**
	 * Retrieving Bank Details from the PPUser
	 */

	public BankAccount getBankDetails(PayPalUser paypaluser) {
		
		BankAccount bank = null;
		Set<BankAccount> bankAccount = paypaluser.getBankAccounts();
		Iterator<BankAccount> banks = bankAccount.iterator();
		while (banks.hasNext()) {
			bank = banks.next();
			
		}

		 return bank;
		
		

	}

	/** The paypaluser. */
	private PayPalUser paypaluser = null;

	/** The account number. */
	String accountNumber = null;

	/** The pool. */
	AdminUsersPool pool = null;

	/** The user. */
	String user = null;

	/** The ppuser bank account. */
	UserBankRequest ppuserBankAccount = null;

	/**
	 * This method would change the status of the bank in WUSER_ACH table and
	 * BANK_CONFIRMATION table
	 */
	
	private void updateBankDB() {
		
		JDBCUtils jdbc = null;
		long timestamp = System.currentTimeMillis() / 1000;
		String wuser_ach_query = "update wuser_ach set status='D' , AUTH_DEPOSIT_TIME="
				+ timestamp + " where id=" +User_bank_details.getBankId() ;
		String bankconf_query = "update Bank_confirmation  set CONFIRMATION_STATE='D', TIME_DEPOSITED="
				+ timestamp + "  where ach_id=" + User_bank_details.getBankId();
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

	/** The memomsg. */
	String memomsg = "Memo:Confirm this bank thru Random deposit";

	/** The deposit one. */
	String depositOne = null;

	/** The deposit two. */
	String depositTwo = null;

	/** The pay pal admin login page. */
	PayPalAdminLoginPage payPalAdminLoginPage = new PayPalAdminLoginPage();

	/** The pay pal admin research page. */
	PayPalAdminResearchPageExt payPalAdminResearchPage = new PayPalAdminResearchPageExt();

	/** The pay pal admin account home page. */
	PayPalAdminAccountHomePage payPalAdminAccountHomePage = new PayPalAdminAccountHomePage();

	/** The pay pal admin add bank page. */
	PayPalAdminAddBankPage payPalAdminAddBankPage = new PayPalAdminAddBankPage();

	/** The pay pal admin account home bank page. */
	PayPalAdminAccountHomeBankPage payPalAdminAccountHomeBankPage = new PayPalAdminAccountHomeBankPage();

	/** The pay pal admin confirm bank page. */
	PayPalAdminConfirmBankPage payPalAdminConfirmBankPage = new PayPalAdminConfirmBankPage();

	
	

	
	/** The pay pal admin memo page. */
	PayPalAdminMemoPageExt ppAdminMemo = new PayPalAdminMemoPageExt();

	/** The bank utility. */
	BankConfirmUtilities bankUtility = new BankConfirmUtilities();

	/** The random deposits. */
	RandomDeposits randomDeposits = new RandomDeposits();

	/** The dep. */
	String[] dep = new String[4];

	/** The Bank Details. */
	String[] bankDetails = new String[3];
	BankAccount User_bank_details;
}
