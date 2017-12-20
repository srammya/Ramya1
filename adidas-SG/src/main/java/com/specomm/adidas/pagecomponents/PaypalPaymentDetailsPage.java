package com.specomm.adidas.pagecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.specomm.adidas.common.utils.Constants;
import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;

public class PaypalPaymentDetailsPage {
	
	WebDriver driver;
	ReusableActions inActions=new ReusableActions();
	Constants constants=new Constants();
	

	
	@FindBy(how = How.XPATH, using ="//html/body/div[1]/div/div[3]/div[2]/div/ol/li[2]/div/form/fieldset/ul/li/fieldset/div[1]")
	public WebElement paymentHeading;
	
	@FindBy(how = How.ID, using ="p_method_cybersource")
	@CacheLookup public WebElement paymentSource;
	
	@FindBy(how = How.ID, using ="cybersource_cc_type")
	@CacheLookup public WebElement cardType;
	
	@FindBy(how = How.ID, using ="cybersource_cc_number")
	@CacheLookup public WebElement cardNumber;
	
	@FindBy(how = How.ID, using ="cybersource_expiration")
	@CacheLookup public WebElement cardExpiryMonth;
	
	@FindBy(how = How.ID, using ="cybersource_expiration_yr")
	@CacheLookup public WebElement cardExpiryYear;
	
	@FindBy(how = How.ID, using ="cybersource_cc_cid")
	@CacheLookup public WebElement cardId;

	@FindBy(how = How.ID, using ="continue-order-summary")
	@CacheLookup public WebElement continueOrder;	
	
	//paypal
	
	@FindBy(how = How.XPATH, using ="//*[@id='p_method_paypal_express']")
	public WebElement payment_Paypal;
	
	@FindBy(how = How.XPATH, using ="//*[@id='login_email']")
	public WebElement emailPaypal;
	
	@FindBy(how = How.XPATH, using ="//*[@id='login_password']")
	public WebElement pwdPaypal;
	
	@FindBy(how = How.XPATH, using ="//*[@id='submitLogin']")
	public WebElement loginPaypal;
	
	@FindBy(how = How.ID, using ="funding_select")
	public WebElement changeFunding;
	
	@FindBy(how = How.ID, using ="Card_2")
	public WebElement selectCC;
	
	@FindBy(how = How.ID, using ="continue")
	public WebElement contiuePaymentType;
	
	@FindBy(how = How.ID, using ="continue_abovefold")
	public WebElement payNow;
	
	
	//Constructor
	
	public PaypalPaymentDetailsPage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	}
	
	

	
	
	
	public void selectPaypalPaymentDetails(String pLoginid,String pPassword) throws InterruptedException{
		try{
		ReusableActions.waitForpageToLoad(driver);
		Thread.sleep(5000);
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
		ReusableActions.selectedRadioButton(driver,payment_Paypal,"Select the payment source Paypal radio button");
		inActions.buttonClick(driver, continueOrder, "Click Continue order");
		Thread.sleep(2000);
		inActions.inputText(driver,emailPaypal,pLoginid,"Enter Paypal Login id");
		inActions.inputText(driver,pwdPaypal,pPassword,"Enter Paypal Password");
		inActions.buttonClick(driver, loginPaypal, "Click paypal login button");
		Thread.sleep(5000);
		inActions.linkClick(driver,changeFunding,"Click fund changing link");
		Thread.sleep(5000);
		ReusableActions.selectedRadioButton(driver,selectCC,"Select the payment source as creditcard from paymentmethod page");
		inActions.buttonClick(driver, contiuePaymentType, "Click Continue from payment method page");
		inActions.buttonClick(driver,payNow,"Click paynow button");
		Thread.sleep(5000);
		Assert.assertEquals(constants.PAYMENT_DONE_PAGE, driver.getTitle());
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
	
	
	@DataProvider
	public static Object[][] getData(){
		
		return GeneralActions.getData("PaypalPaymentDetails");
	}
	
	
	
}
