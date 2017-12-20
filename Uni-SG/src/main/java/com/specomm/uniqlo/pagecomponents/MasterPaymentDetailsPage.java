package com.specomm.uniqlo.pagecomponents;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.specomm.uniqlo.common.utils.Constants;
import com.specomm.uniqlo.common.utils.GeneralActions;
import com.specomm.uniqlo.common.utils.ReusableActions;

public class MasterPaymentDetailsPage {
	
	WebDriver driver;
	ReusableActions inActions=new ReusableActions();
	Constants constants=new Constants();
	
	
		
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

	@FindBy(how = How.ID, using ="id_accept_terms")
	 public WebElement chkTermsCondition;	
	
	@FindBy(how = How.ID, using ="//form/fieldset/div[2]/div[5]/div/div[4]/label/a")
	 public WebElement lnkTermsCondition;	
	
		
	@FindBy(how = How.XPATH, using ="//*[@id='onestepcheckout-place-order']")
	 public WebElement continueOrder;	
	
	@FindBy(how = How.XPATH, using ="html/body/div[1]/div/div[1]/div/div[1]/div[1]/h1/span[2]")
	 public WebElement msgDeclined;	
	
	
	
	public MasterPaymentDetailsPage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	}
	
	
	
	
	public void selectPaymentDetails(String ccType,String ccNumber,String ccExpiryMonth,String ccExpiryYear,String cvv) throws InterruptedException{
		
		try{
//		
		System.out.println("Paymentdetails page");
		Thread.sleep(5000);
		
		inActions.selectItemFromDropdown(driver,cardType,ccType,"Select the card type as Visa");
		inActions.inputText(driver,cardNumber,ccNumber,"Enter Credit Card Number");
		inActions.selectValueFromDropdown(driver,cardExpiryMonth,ccExpiryMonth,"Select the card expiry month");
		inActions.selectItemFromDropdown(driver,cardExpiryYear,ccExpiryYear,"Select the card expiry Year");
		inActions.inputText(driver,cardId,cvv,"Enter Credit Card cvv");
		proceedPayment();
		
		/*try{
			Alert alert=driver.switchTo().alert();
			alert.accept();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}*/
		Assert.assertEquals(msgDeclined.getText(),constants.PAYMENT_ERROR_PAGE);
		}
		catch(Exception e1){
			e1.printStackTrace();
		}
	}
	
	public void proceedPayment(){
	
	try{
		inActions.selectCheckbox(driver, chkTermsCondition, "Check the terms and condition");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('onestepcheckout-place-order').click()");
		
		Thread.sleep(10000);
	}
	catch(Exception e){

	}
	}
	@DataProvider
	public static Object[][] getData(){
		
		return GeneralActions.getData("MasterPaymentDetails");
	}
	
	
	
}
