package com.specomm.adidas.pagecomponents;

import org.openqa.selenium.JavascriptExecutor;
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

public class PaymentDetailsPage {
	
	WebDriver driver;
	ReusableActions inActions=new ReusableActions();
	Constants constants=new Constants();
	
	//indonesia
	
	/*@FindBy(how = How.ID, using ="continue-order-summary")
	@CacheLookup public WebElement continue_order;
	
	@FindBy(how = How.NAME, using ="visa_button")
	@CacheLookup public WebElement visa_Btton;		
	
	@FindBy(how = How.NAME, using ="creditCardNum")
	@CacheLookup public WebElement card_Num;	
	
	
	@FindBy(how = How.NAME, using ="expMonth")
	@CacheLookup public WebElement card_expMonth;	
	
	@FindBy(how = How.NAME, using ="expYear")
	@CacheLookup public WebElement card_expYear;	
	
	@FindBy(how = How.NAME, using ="creditCardCvv2")
	@CacheLookup public WebElement card_cardcvv;
	
	@FindBy(how = How.NAME, using ="creditCardName")
	@CacheLookup public WebElement	card_HolderName;	*/
	
	//singapore
	
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
	
	@FindBy(how = How.ID, using ="p_method_paypal_express")
	public WebElement payment_Paypal;
	
	@FindBy(how = How.XPATH, using ="//*[@id='login_email']")
	public WebElement emailPaypal;
	
	@FindBy(how = How.XPATH, using ="//*[@id='login_password']")
	public WebElement pwdPaypal;
	
	@FindBy(how = How.XPATH, using ="//*[@id='submitLogin']")
	public WebElement loginPaypal;
	
	public PaymentDetailsPage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	}
	
	
	/*public void verifyPaymentHeading(){
		try{
			Assert.assertEquals(paymentHeading.getText(),constants.PAYMENT_DETAILS);
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	}*/
	
	public void selectPaymentDetails(String ccType,String ccNumber,String ccExpiryMonth,String ccExpiryYear,String cvv) throws InterruptedException{
		Thread.sleep(2000);
		
//		
		System.out.println("Paymentdetails page");
		Thread.sleep(2000);
		ReusableActions.selectedRadioButton(driver,paymentSource,"Select the payment source radio button");
		ReusableActions.selectItemFromDropdown(driver,cardType,ccType,"Select the card type as Visa");
		inActions.inputText(driver,cardNumber,ccNumber,"Enter Credit Card Number");
		ReusableActions.selectItemFromDropdown(driver,cardExpiryMonth,ccExpiryMonth,"Select the card expiry month");
		ReusableActions.selectItemFromDropdown(driver,cardExpiryYear,ccExpiryYear,"Select the card expiry Year");
		inActions.inputText(driver,cardId,cvv,"Enter Credit Card cvv");
		inActions.buttonClick(driver, continueOrder, "Click Continue order");
		Thread.sleep(10000);
		Assert.assertEquals(constants.PAYMENT_DONE_PAGE, driver.getTitle());
		
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		return GeneralActions.getData("VisaPaymentDetails");
	}
	
	
	
}
