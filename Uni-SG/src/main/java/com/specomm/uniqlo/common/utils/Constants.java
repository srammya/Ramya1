package com.specomm.uniqlo.common.utils;

public class Constants {
	
	public static final String sBrowserFirefox="firefox";
	public static final String sBrowserChrome="chrome";
	public static final String sBrowserIe="ie";
	
	public static final String FOLDER_PATH="./";
	public static String sPropertiesPath=FOLDER_PATH+"src/test/resources/";
	public final static String sConfigFileName = "Config.properties";
	public final static String LOG4J_PROPERTY_FILE = "log4j.properties";
	
	public static String sPageLoadTimeout = "30000";
	public static long lUpLoadTimeout = 600000;
	public static long lElementVisibleTimeout = 20000;
	public static long lElementVisibleDefaultTimeout = 30000;
	public static long lWaitForTimeout = 2000;
	
	
	
	//Messages :  
	public static final String LOGOUT_MSG = "You have been logged out";
	
	//Page Titles and message validations
	public String LOGOUT_PAGE_TITLE = "";
	public String URL_LOADING_PAGE_TITLE=" Official Online Store | Shoes, Apparel, Accessories";
	public String CUSTOMER_HOME_PAGE_TITLE = "Create New Customer Account  | UNIQLO";
	public String CUSTOMER_LANDING_PAGE="My Account";
	public String SHOPPING_BUCKET_PAGE_TITLE = "Shopping Cart";
	public String SHIPPING_DETAILS ="Shipping Details";
	public String PAYMENT_DETAILS="Payment Method";
	public String LOGIN_CHECKOUT="Checkout";
	public String PAYMENT_DONE_PAGE="Thank you for your order!";
	public String PAYMENT_DECLINED_PAGE="your order has been declined. please try again or contact your bank.";
	
	public String REGISTER_NEW_USER_PAGE="Create New Customer Account | UNIQLO";
	public String MY_ACCOUNT_PAGE="MY ACCOUNT";
//	public String MY_ACCOUNT_PAGE="My Account | UNIQLO"; 
	public String ACCOUNT_ALREADY_EXISTS="There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account."; 
	public String INVALID_CREDENTIALS="Invalid login or password.";
	public String FORGOT_PASSWORD="We sent a confirmation email to the following email address that you entered.  ";
//	public String FORGOT_PASSWORD="We sent a confirmation email to the following email address that you entered.  mail3@mailinator.com";
	
	public String INVALID_SEARCH="ไม่พบสินค้า / No items found.";
//	 public String INVALID_SEARCH="No items found.";
	public String PAYMENT_ERROR_PAGE="AN ERROR OCCURRED IN THE PROCESS OF PAYMENT";
	public String PROMO_MSG="Coupon code \"CB50\" is not valid.";
	
}
