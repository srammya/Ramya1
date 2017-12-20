package com.specomm.adidas.pagecomponents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.specomm.adidas.common.utils.Constants;
import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;

public class BadMasterPaymentDetailsPage {
	
	WebDriver driver;
	ReusableActions inActions=new ReusableActions();
	Constants constants=new Constants();
	
	
	
	@FindBy(how = How.XPATH, using ="//html/body/div[1]/div/div[3]/div[2]/div/ol/li[2]/div/form/fieldset/ul/li/fieldset/div[1]")
	public WebElement paymentHeading;
	
	@FindBy(how = How.ID, using ="p_method_cybersource")
	public WebElement paymentSource;
	
	@FindBy(how = How.ID, using ="cybersource_cc_type")
	 public WebElement cardType;
	
	@FindBy(how = How.ID, using ="cybersource_cc_number")
	 public WebElement cardNumber;
	
	@FindBy(how = How.ID, using ="cybersource_expiration")
	 public WebElement cardExpiryMonth;
	
	@FindBy(how = How.ID, using ="cybersource_expiration_yr")
	 public WebElement cardExpiryYear;
	
	@FindBy(how = How.ID, using ="cybersource_cc_cid")
	 public WebElement cardId;

	@FindBy(how = How.ID, using ="continue-order-summary")
	 public WebElement continueOrder;	
	
	@FindBy(how = How.XPATH, using ="//*[@id='advice-validate-cc-type-cybersource_cc_number']")
	public WebElement validateCC;
	
	@FindBy(how = How.XPATH, using ="//*[@id='advice-validate-cc-exp-cybersource_expiration']")
	public WebElement validateCCExpiry;
	
	@FindBy(how = How.XPATH, using ="//*[@id='advice-validate-cc-type-select-cybersource_cc_type']")
	public WebElement validCardType;
	
	
	
	
	//Constructor
	
	public BadMasterPaymentDetailsPage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	}
	
	
	public void validateCCNumber(String cc){
		try{
			
			inActions.inputText(driver,cardNumber,cc,"Enter invalid Credit Card Number");
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void selectCardType(String ccType){
		try{
			JavascriptExecutor jsx = (JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,450)", "");
			Thread.sleep(2000);
			ReusableActions.selectedRadioButton(driver,paymentSource,"Select the payment source radio button");
			ReusableActions.selectItemFromDropdown(driver,cardType,ccType,"Select the card type as Visa");
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void validateCCExpiryDate(String mon,String yr){
		try{
			
			ReusableActions.selectItemFromDropdown(driver,cardExpiryMonth,mon,"Select the card expiry month");
			ReusableActions.selectItemFromDropdown(driver,cardExpiryYear,yr,"Select the card expiry Year");
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void enterCVV(String cvv){
		try{
			
			inActions.inputText(driver,cardId,cvv,"Enter Credit Card cvv");
			inActions.buttonClick(driver, continueOrder, "Click Continue order");
			Assert.assertEquals(validCardType.getText(), constants.VALID_CARD_TYPE);
			Assert.assertEquals(validateCC.getText(),constants.INVALID_MC_NUMBER);
			Assert.assertEquals(validateCCExpiry.getText(),constants.INVALID_CC_EXPIRY);
			
			
			/*Thread.sleep(10000);
			Assert.assertEquals(constants.PAYMENT_DONE_PAGE, driver.getTitle());*/
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void selectCardPaymentDetails(String ccType,String ccNumber,String ccExpiryMonth,String ccExpiryYear,String cvv) throws InterruptedException{
		try{
		
		ReusableActions.waitForpageToLoad(driver);
Thread.sleep(5000);
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
		
		
		ReusableActions.selectedRadioButton(driver,paymentSource,"Select the payment source radio button");
		ReusableActions.selectItemFromDropdown(driver,cardType,ccType,"Select the card type as MasterCard");
		inActions.inputText(driver,cardNumber,ccNumber,"Enter Credit Card Number");
		ReusableActions.selectItemFromDropdown(driver,cardExpiryMonth,ccExpiryMonth,"Select the card expiry month");
		ReusableActions.selectItemFromDropdown(driver,cardExpiryYear,ccExpiryYear,"Select the card expiry Year");
		inActions.inputText(driver,cardId,cvv,"Enter Credit Card cvv");
		inActions.buttonClick(driver, continueOrder, "Click Continue order");
		Thread.sleep(10000);
		
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
	
	
	public void validateCardPaymentDetails(String ccType) throws InterruptedException{
		try{
		Thread.sleep(2000);
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
		
		System.out.println("Paymentdetails page");
		Thread.sleep(2000);
		ReusableActions.selectedRadioButton(driver,paymentSource,"Select the payment source radio button");
		ReusableActions.selectItemFromDropdown(driver,cardType,ccType,"Select the card type as MasterCard");
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
	
	
	@DataProvider
	public static Object[][] getData(){
		
		return GeneralActions.getData("BadMasterPaymentDetails");
	}
	
	
	
}
