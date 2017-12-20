package com.sinpost.isam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.singpost.isam.utils.GeneralActions;
import com.singpost.isam.utils.ReusableActions;

public class BillPayment {
	
	ReusableActions rActions=new ReusableActions();
	GeneralActions gActions=new GeneralActions();
	WebDriver driver;

	@FindBy(how = How.XPATH, using = "html/body/table/tbody/tr/td/a/img")
	public WebElement	btnBillPayment;
		
	@FindBy(how = How.XPATH, using = "html/body/table[1]/tbody/tr/td[1]/a/img")
	public WebElement	btnTelCo;
	
	@FindBy(how = How.XPATH, using = "html/body/table[1]/tbody/tr/td[2]/a/img")
	public WebElement	btnTownCouncil;
	
	
	public BillPayment(WebDriver driver){
		this.driver = driver; 
	    PageFactory.initElements(driver, this);
		
	}
	
	public void clickBillPayment(){
		try{
		rActions.buttonClick(driver, btnBillPayment, "Click Bill Payment Button");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
		public void clickTeleCom(){
			try{
			rActions.buttonClick(driver, btnTelCo, "Click Bill Payment Button");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	
	
		public void clickTownCouncil(){
			try{
			rActions.buttonClick(driver, btnTownCouncil, "Click Bill Payment Button");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	
	
}
