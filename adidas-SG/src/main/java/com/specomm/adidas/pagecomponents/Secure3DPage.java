package com.specomm.adidas.pagecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;

public class Secure3DPage {
	
	WebDriver driver;
	ReusableActions inActions=new ReusableActions();
	
	@FindBy(how = How.XPATH, using ="//table/tbody/tr[3]/td/font/input[1]")
	public WebElement seName;
	
	@FindBy(how = How.XPATH, using ="//table/tbody/tr[3]/td/font/input[2]")
	public WebElement seMonth;
	
	@FindBy(how = How.XPATH, using ="//table/tbody/tr[3]/td/font/input[3]")
	public WebElement seYear;
	
	@FindBy(how = How.XPATH, using ="//tbody/tr[3]/td/font/input[5]")
	public WebElement seCVV;
	
	@FindBy(how = How.XPATH, using ="//table/tbody/tr[3]/td/font/input[8]")
	public WebElement seSSN;
	
	@FindBy(how = How.XPATH, using ="//table/tbody/tr[3]/td/font/input[10]")
	public WebElement seEmail;
	
	@FindBy(how = How.XPATH, using ="//table/tbody/tr[4]/td/div/input[1]")
	public WebElement seActivateNow;
		
	@FindBy(how = How.XPATH, using ="//table/tbody/tr[4]/td/div/input[2]")
	public WebElement seActivateLater;
	
	public Secure3DPage(WebDriver driver)
	{ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	}
	
	public void enterSecuredetails(String sName,String sMonth,String sYear,String sCVV,String sSSN){
		try{
			inActions.inputText(driver, seName, sName, "Enter name of the card holder");
			inActions.inputText(driver, seMonth, sMonth, "Enter name of the card holder");
			inActions.inputText(driver, seYear, sYear, "Enter name of the card holder");
			inActions.inputText(driver, seCVV, sCVV, "Enter name of the card holder");
			inActions.inputText(driver, seSSN, sSSN, "Enter name of the card holder");
			
		}
		catch(Exception e){
			
			
		}
		
	}
	
	public void clickActivenow(){
		try{
			inActions.buttonClick(driver, seActivateNow, "Click Acivenow button");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void clickActivelater(){
		try{
			inActions.buttonClick(driver, seActivateLater, "Click Acivelater button");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@DataProvider
	public static Object[][] getData(){
		
		return GeneralActions.getData("3DSecureDetails");
	}
	
	
	
}
