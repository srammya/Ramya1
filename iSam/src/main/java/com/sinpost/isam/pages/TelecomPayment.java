package com.sinpost.isam.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.singpost.isam.utils.Constants;
import com.singpost.isam.utils.GeneralActions;
import com.singpost.isam.utils.ReusableActions;

public class TelecomPayment {

	ReusableActions rActions=new ReusableActions();
	GeneralActions gActions=new GeneralActions();
	Constants constants=new Constants();
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "html/body/table[2]/tbody/tr/td/a/img")
	public WebElement	btnSingTel;
	
	@FindBy(how = How.XPATH, using = "html/body/table[2]/tbody/tr/td/a/img")
	public WebElement	btnTelBillPayment;
	
	@FindBy(how = How.XPATH, using = "html/body/form/table/tbody/tr[1]/td[2]/input")
	public WebElement	txtAcctNumber;
	
	@FindBy(how = How.XPATH, using = "html/body/form/table/tbody/tr[2]/td[2]/input")
	public WebElement	txtAmtPaid;
	
	@FindBy(how = How.XPATH, using = "html/body/form/table/tbody/tr[3]/td[2]/input[1]")
	public WebElement	btnDone;
	
	@FindBy(how = How.XPATH, using = "html/body/form/table/tbody/tr[3]/td[2]/input[2]")
	public WebElement	btnCancel;
	
	@FindBy(how = How.XPATH, using = "html/body/table[2]/tbody/tr[1]/td/b")
	public WebElement	lblSingtel;
	
	@FindBy(how = How.XPATH, using = "html/body/table[3]/tbody/tr[1]/td/b/h2")
	public WebElement	lblSingtelSuccess;
	
	
	public TelecomPayment(WebDriver driver){
		this.driver = driver; 
	    PageFactory.initElements(driver, this);
		
	}
	
	
	public void clickSingTel(){
		try{
		rActions.buttonClick(driver, btnSingTel, "Click Bill Payment Button");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void clickTelBillPayment(){
		try{
		rActions.buttonClick(driver, btnTelBillPayment, "Click Bill Payment Button");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void verifyHeading(){
		try{
		
		Assert.assertEquals(lblSingtel.getText(), constants.lblSingtel);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	public void inputAccountNo(String acctNo){
		try{
		rActions.inputText(driver, txtAcctNumber, acctNo, "Enter Account Number");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	

	public void inputAmountPaid(String amtPaid){
		try{
		rActions.inputText(driver, txtAmtPaid, amtPaid, "Enter Amount to be paid");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickDoneButton(){
		try{
		rActions.buttonClick(driver, btnDone, "Click done Button");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void closeAlert(){
		try{
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}
		catch(Exception e){
			
		}
	}
	
	public void amountValidate(String actno,String amt){
		try{
			Assert.assertEquals(lblSingtelSuccess.getText(), constants.lblSingtelSuccess);
			Reporter.log("Account Number :"+ txtAcctNumber.getAttribute("value"));
			if(actno.equals(txtAcctNumber.getAttribute("value"))){
				Assert.assertEquals(txtAcctNumber.getAttribute("value"), actno);
			}
			Reporter.log("Account Number :"+ txtAmtPaid.getAttribute("value"));
			if(amt.equals(txtAcctNumber.getAttribute("value"))){
				Assert.assertEquals(txtAmtPaid.getAttribute("value"), amt);
			}
			
		}
		catch(Exception e){
			
		}
	}

	public void clickCancelButton(){
		try{
		rActions.buttonClick(driver, btnCancel, "Click cancel Button");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		return GeneralActions.getData("TelecomBill");
	}

}
