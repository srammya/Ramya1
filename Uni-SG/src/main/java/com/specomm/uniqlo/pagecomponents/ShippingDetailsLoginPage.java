package com.specomm.uniqlo.pagecomponents;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.specomm.uniqlo.common.utils.Constants;
import com.specomm.uniqlo.common.utils.GeneralActions;
import com.specomm.uniqlo.common.utils.ReusableActions;

public class ShippingDetailsLoginPage {

	
	String MEGAMENU;
	String title,Value;
	WebDriver driver;
	public static String user;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	UniqloHomePage uniqloHomePage=new UniqloHomePage(driver);
	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	
	
	@FindBy(how = How.ID, using ="onestepcheckout-login-link")
	public WebElement alRegister;
	
	@FindBy(how = How.XPATH, using ="//*[@id='id_onestepcheckout_username']")
	public WebElement txtLoginEmail;
	
	@FindBy(how = How.XPATH, using ="//*[@id='id_onestepcheckout_password']")
	public WebElement txtLoginPassword;
	
	@FindBy(how = How.XPATH, using ="//*[@id='onestepcheckout-login-button']")
	public WebElement btnRegisterLogin;
		
	@FindBy(how = How.XPATH, using ="//*[@id='billing:firstname']")
	public WebElement txtFirstName;
	
	@FindBy(how = How.XPATH, using ="//*[@id='billing:lastname']")
	public WebElement txtLastName;
	
	@FindBy(how = How.XPATH, using ="//*[@id='billing:telephone']")
	public WebElement txtTelephone;
	
	@FindBy(how = How.XPATH, using ="//*[@id='billing:street1']")
	public WebElement txtAddress;
	
	@FindBy(how = How.XPATH, using ="//*[@id='billing-address-select']")
	public WebElement drpNewAddress;
	
	@FindBy(how = How.XPATH, using ="//*[@id='billing:postcode']")
	public WebElement txtPostCode;
	
	@FindBy(how = How.XPATH, using ="//*[@id='billing:city']")
	public WebElement txtCity;
	
	
	
	public ShippingDetailsLoginPage(WebDriver driver){ 
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	} 
	
	
	
	
	public void ship_DetailsLogin(String rLoginEmail,String rLoginPassword){
		try{
			
		//	user=ReusableActions.getCurrentTimeStamp()+rLoginEmail;
		ReusableActions.waitForpageToLoad(driver);
		inAction.buttonClick(driver, alRegister, "Select the already registerd user");	
		inAction.inputText(driver,txtLoginEmail, rLoginEmail, "Enter Login Email : " + rLoginEmail);
		inAction.inputText(driver,txtLoginPassword, rLoginPassword, "Enter LastName : " + rLoginPassword);
		inAction.buttonClick(driver, btnRegisterLogin, "Select the already registerd user");	
		
		
	}
	catch(Exception e){
	//	e.printStackTrace();
	}
	
}
	

	
	public void ship_NewAddress(String sFirstName,String sLastName,String sPhone,String sAddress,String sCity,String sPostal){
		try{
			
		
		Thread.sleep(2000);
		inAction.inputText(driver,txtFirstName, sFirstName, "Enter FirstName : " + sFirstName);
		inAction.inputText(driver,txtLastName, sLastName, "Enter LastName : " + sLastName);
		inAction.inputText(driver,txtTelephone, sPhone, "Enter Phone : " + sPhone);
		inAction.inputText(driver,txtAddress, sAddress, "Enter Address : " + sAddress);
		inAction.inputText(driver, txtPostCode, sPostal, "Enter Postal : " + sPostal);
		
	}
	catch(Exception e){
		//e.printStackTrace();
	}
	
}
	
	
	@DataProvider
	public static Object[][] getData(){
		
		return GeneralActions.getData("RegisteredUserLoginFlow");
	}
	
	
}
