package com.paypal.test.gops.admin.MaestroEnablement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.paypal.test.bluefin.platform.asserts.BluefinAsserts;
import com.paypal.test.bluefin.platform.config.BluefinConfig;
import com.paypal.test.bluefin.platform.config.BluefinConfig.BluefinConfigProperty;
import com.paypal.test.bluefin.platform.grid.Grid;
import com.paypal.test.bluefin.platform.grid.WebTest;
import com.paypal.test.bluefin.platform.html.Table;
import com.paypal.test.bluefin.testcomponents.admin.PayPalAdminLoginPage;
import com.paypal.test.bluefin.testcomponents.admin.accountresearch.PayPalAdminAccountHomePageExt;
import com.paypal.test.bluefin.testcomponents.admin.accountresearch.PayPalAdminResearchPageExt;
import com.paypal.test.gops.admin.utilities.AdminUsersPool;
import com.paypal.test.gops.admin.utilities.CommonUtils;
import com.paypal.test.jaws.db.DatabaseName;
import com.paypal.test.jaws.db.JDBCUtils;
import com.paypal.test.jaws.ppo.CreditCard;
import com.paypal.test.jaws.ppo.PayPalUser;

// TODO: Auto-generated Javadoc
/**
 * TC ID:GGOG1349379F
 * Verify whether admin can able to verify the credit card
 * section is present in admin account home page or not
 * Author: Prem.
 * Modifier : Lakavath Satish Kumar <lakkumar@paypal.com>
 */

public class GGOG1349379F {

	AdminUsersPool pool = null;
	String adminUser = null;

	PayPalAdminLoginPage payPalAdminLoginPage = new PayPalAdminLoginPage();
	PayPalAdminResearchPageExt payPalAdminResearchPage = new PayPalAdminResearchPageExt();
	PayPalAdminAccountHomePageExt payPalAdminAccountHomePage = new PayPalAdminAccountHomePageExt();

	CommonUtils commonUtils = new CommonUtils();

	/**
	 * Verify credit card section.
	 *
	 * @param buyer the buyer
	 * @param creditCard1 the credit card1
	 * @throws Exception the exception
	 */
	@WebTest
	@Test(testName = "541",groups={"Acc_Home","Financial_CC"},dataProvider = "createBuyerAndCreditCard", dataProviderClass = StaticDataProvider.class)
	public void verifyCreditCardSection(PayPalUser buyer, CreditCard  creditCard) throws Exception {
		
		buyer.addCreditCard(creditCard, true, true, false);
		pool = AdminUsersPool.getInstance();
		Grid.driver().get(BluefinConfig.getConfigProperty(BluefinConfigProperty.PAYPAL_ADMIN_URL));
		Grid.driver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		adminUser = pool.loginWithAdminUserPoolAccount();
		// Searching the user
		payPalAdminResearchPage.searchByEmail(buyer.getEmailAddress(), "Account Home", payPalAdminAccountHomePage);
		
		String cc_number = commonUtils.getCCNum(buyer);
		System.out.println("PRINTING THE NUMBER: " + cc_number.substring(cc_number.length() - 4) + "    " + cc_number + "    " +  payPalAdminAccountHomePage.getCcLast4Label().getText());
		// Clicking on CC Last 4 digit link present in the user account info section
		BluefinAsserts.verifyTrue(payPalAdminAccountHomePage.getCcLast4Label().getText().contains(
				cc_number.substring(cc_number.length() - 4)), "verifying last 4 digit in verification section");
		payPalAdminAccountHomePage.clickCCLast4Link(payPalAdminAccountHomePage);

		Table table = payPalAdminAccountHomePage.getCreditAndDebitCardsTable();
		String [] verifications = {/**"Debit",**/ "CVV2", "Trusted", buyer.getFirstName(), buyer.getLastName(), "Action", "Type", "CC Number", "Issuer",
				"Exp", "Currency", "Status", "Auth\'d", };
		
		// Verifications in the credit and debit cards section
		for (int i = 0; i < verifications.length; i++)
			BluefinAsserts.verifyTrue(table.getText().trim().contains(verifications[i]), "Verifying the " + verifications[i] + " in cc section");

		payPalAdminAccountHomePage.clickCc_selection_Button();
		//Clicking on CC Mask button
		payPalAdminAccountHomePage.clickCcNumberExpansionLink();
		int tries = 15;
		String content = null;
		
		// waiting for cc number to appear in the label
		while (tries > 0 && !(content = payPalAdminAccountHomePage.getCcNumberExpandedLabel().getText().trim()).contains(
				cc_number)) {
			System.out.println("PRINTING: " + payPalAdminAccountHomePage.getCcNumberExpandedLabel().getText().trim() + "        "  +
					creditCard.getCreditCardNumber() + "     " + cc_number);
			tries --;
		//	Thread.sleep(1000);
		}
		
		// Verifying actual CC Number with the value present in the Masked label in Credit Card Section
		// BluefinAsserts.verifyTrue(content.contains(cc_number), "verify the CC Number is displayed on expanding the mask image");
		
		//Clicking on expiry mask label
		payPalAdminAccountHomePage.clickCcExpDateExpansionLink();
	
		// waiting for cc expiry date to appear in the label
		tries = 15;
		while (tries > 0 && !(content = payPalAdminAccountHomePage.getCcExpDateExpandedLabel().getText().trim()).contains(
				getExpiryDate(buyer.getAccountNumber()))) {
			System.out.println("PRINTING2: " + content);
			tries --;
		//	Thread.sleep(1000);
		}

		// BluefinAsserts.verifyTrue(content.contains(getExpiryDate(buyer.getAccountNumber())), 
		// 		"verify the Masked expirty date is displayed on expanding the mask image");
	}

	/**
	 * Tear down - Putting the admin user back to pool
	 */
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		if (pool != null) pool.putAdminUserPool(adminUser);
	}


	/**
	 * Input   :- account number, Return  :String.
	 *
	 */
	public  String getExpiryDate(String strAccNumber) throws InterruptedException, SQLException, ClassNotFoundException {

		//query to fetch data
		String strDBQueryToGetExpMonth = "select EXPDATE_MONTH,EXPDATE_YEAR from wuser_cc where account_number='" + strAccNumber + "'";
		JDBCUtils dbUtils = new JDBCUtils(DatabaseName.CLOC, true);
		ResultSet rs = (ResultSet) dbUtils.executeQuery(strDBQueryToGetExpMonth);
		String resultSet = null;

		while (rs.next()) resultSet = rs.getString(1)+"/"+rs.getString(2);

		String expDate= resultSet;
		return expDate;

	}
}
