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

public class ShippingNewDetailsLoginPage {

	
	String MEGAMENU;
	String title,Value;
	WebDriver driver;
	
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	UniqloHomePage uniqloHomePage=new UniqloHomePage(driver);
	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	
	
	@FindBy(how = How.ID, using ="onestepcheckout-login-link")
	public WebElement alRegister;
	
	@FindBy(how = How.XPATH, using ="html/body/div[4]/div[1]/div/div[2]/form/div[3]/div[1]/div[2]/input")
	public WebElement txtLoginEmail;
	
	@FindBy(how = How.XPATH, using ="html/body/div[4]/div[1]/div/div[2]/form/div[3]/div[2]/div[2]/input")
	public WebElement txtLoginPassword;
	
	@FindBy(how = How.XPATH, using ="html/body/div[4]/div[1]/div/div[2]/form/div[3]/div[3]/button")
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
	
	@FindBy(how = How.XPATH, using ="//*[@id='billing:region_id']")
	public WebElement drpRegion;
	
	
	public ShippingNewDetailsLoginPage(WebDriver driver){ 
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	} 
	
	
	
	
	public void ship_DetailsLogin(String rLoginEmail,String rLoginPassword){
		try{
			
		
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
	
	public void selectNewAddress(){
		try{
			

			Thread.sleep(2000);
			inAction.selectItemFromDropdown(driver,drpNewAddress, "New Address","Select New Address");
		
		
	}
	catch(Exception e){
		//e.printStackTrace();
	}
	
}
	
	public void ship_NewAddress(String sFirstName,String sLastName,String sPhone,String sAddress,String sCity,String sRegion,String sPostal){
		try{
			
		System.out.println("Shipping address in");
//		ReusableActions.waitForpageToLoad(driver);
			Thread.sleep(2000);
		//ReusableActions.selectItemFromDropdown(driver,drpNewAddress, "New Address","Select New Address");
		inAction.inputText(driver,txtFirstName, sFirstName, "Enter FirstName : " + sFirstName);
		inAction.inputText(driver,txtLastName, sLastName, "Enter LastName : " + sLastName);
		inAction.inputText(driver,txtTelephone, sPhone, "Enter Phone : " + sPhone);
		inAction.inputText(driver,txtAddress, sAddress, "Enter Address : " + sAddress);
		inAction.inputText(driver,txtCity, sCity, "Enter Address : " + sCity);
		inAction.selectValueFromDropdown(driver, drpRegion, sRegion, "Enter day :"+sRegion);
		inAction.inputText(driver, txtPostCode, sPostal, "Enter Postal : " + sPostal);
		
		System.out.println("Shipping address out");
	}
	catch(Exception e){
	//	e.printStackTrace();
	}
	
}
	
	
	@DataProvider
	public static Object[][] getData(){
		
		return GeneralActions.getData("ShippingDetailsLogin");
	}
	
	
}
