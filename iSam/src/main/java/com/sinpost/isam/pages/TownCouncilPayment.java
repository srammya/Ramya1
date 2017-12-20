package com.sinpost.isam.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.singpost.isam.utils.Constants;
import com.singpost.isam.utils.GeneralActions;
import com.singpost.isam.utils.ReusableActions;

public class TownCouncilPayment {
	
	ReusableActions rActions=new ReusableActions();
	GeneralActions gActions=new GeneralActions();
	Constants constants=new Constants();
	WebDriver driver;

	@FindBy(how = How.XPATH, using = "html/body/table[2]/tbody/tr/td/a/img")
	public WebElement	btnTOLBill;
	
	@FindBy(how = How.XPATH, using = "html/body/table[2]/tbody/tr/td/a/img")
	public WebElement	btnAngMoKio;
	
	@FindBy(how = How.XPATH, using = "html/body/table[2]/tbody/tr/td/b")
	public WebElement	lblTownCouncil;
	
	@FindBy(how = How.XPATH, using = "html/body/form/table/tbody/tr[5]/td[2]/select")
	public List<WebElement>	drpAccountNo;
	
	@FindBy(how = How.XPATH, using = "html/body/form/table/tbody/tr[5]/td[2]/select")
	public WebElement	drpAcctNo;
	
	@FindBy(how = How.XPATH, using = "html/body/form/table/tbody/tr[6]/td[2]/input")
	public WebElement	txtEnquiry;
	
	@FindBy(how = How.XPATH, using = "html/body/form/table/tbody/tr[7]/td[2]/input[1]")
	public WebElement	btnTCDone;
	
	@FindBy(how = How.XPATH, using = "html/body/form/table/tbody/tr[7]/td[2]/input[2]")
	public WebElement	btnTCCancel;
	
	@FindBy(how = How.XPATH, using = "html/body/table[3]/tbody/tr[1]/td/b/h2")
	public WebElement	lblTownCouncilSuccess;
	
	public TownCouncilPayment(WebDriver driver){
		this.driver = driver; 
	    PageFactory.initElements(driver, this);
		
	}
	
	public void clickTOLBill(){
		try{
		rActions.buttonClick(driver, btnTOLBill, "Click TOLBill Button");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void clickAngMoKio(){
		try{
		rActions.buttonClick(driver, btnAngMoKio, "Click TOLBill Button");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void verifyHeading(){
		try{
		
		Assert.assertEquals(lblTownCouncil.getText(), constants.lblTownCouncil);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void dropSelectAcct(String nric){
		
		try{
			rActions.selectValueFromDropdown(driver, drpAcctNo, nric,"Select value from dropdown");
		}
		catch(Exception e){
			e.printStackTrace();
		
		}
	}
	
	public void inputEnquiry(String enq){
		try{
			rActions.inputText(driver, txtEnquiry, enq, "Enter Enquiry type");
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void clickDoneButton(){
		try{
		rActions.buttonClick(driver, btnTCDone, "Click done Button");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void entryValidate(String nric,String enq){
		try{
			Assert.assertEquals(lblTownCouncilSuccess.getText(), constants.lblTownCouncilSuccess);
				
			
			Select element = new Select(drpAcctNo);
			Reporter.log("NRIC :"+element.getFirstSelectedOption().getAttribute("value"));
			if(element.getFirstSelectedOption().getAttribute("value").equals(1)){
				Assert.assertEquals(element.getFirstSelectedOption().getAttribute("value"), 1);
				
			}
			
			
			Reporter.log("Enquiry Type :"+ txtEnquiry.getAttribute("value"));
			if(enq.equals(txtEnquiry.getAttribute("value"))){
				Assert.assertEquals(txtEnquiry.getAttribute("value"), enq);
			}
			
		}
		catch(Exception e){
			
		}
	}
	
	
	@DataProvider
	public static Object[][] getData(){
		
		return GeneralActions.getData("TownCBill");
	}
}
