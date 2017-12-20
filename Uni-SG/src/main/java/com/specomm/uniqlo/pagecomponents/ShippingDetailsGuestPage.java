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

public class ShippingDetailsGuestPage {

	
	String MEGAMENU;
	String title,Value;
	WebDriver driver;
	
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	UniqloHomePage uniqloHomePage=new UniqloHomePage(driver);
	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	
	
	@FindBy(how = How.XPATH, using ="//*[@id='billing-radio-usertype1-guest']")
	public WebElement guestUser;
	
	@FindBy(how = How.XPATH, using ="//*[@id='billing:firstname']")
	public WebElement txtFirstName;
	
	@FindBy(how = How.XPATH, using ="//*[@id='billing:lastname']")
	public WebElement txtLastName;
	
	@FindBy(how = How.XPATH, using ="//*[@id='billing:email']")
	public WebElement txtEmail;
		
	@FindBy(how = How.XPATH, using ="//*[@id='billing:telephone']")
	public WebElement txtTelephone;
	
	@FindBy(how = How.XPATH, using ="//*[@id='billing:street1']")
	public WebElement txtAddress;
	
	@FindBy(how = How.XPATH, using ="//*[@id='billing:city']")
	public WebElement txtCity;
	
	@FindBy(how = How.XPATH, using ="//*[@id='billing:region_id']")
	public WebElement drpRegion ;
	
	@FindBy(how = How.XPATH, using ="//*[@id='billing:postcode']")
	public WebElement txtPostCode;
	
	@FindBy(how = How.XPATH, using ="//*[@id='billing:day']")
	public WebElement lstDay;
	
	@FindBy(how = How.CLASS_NAME, using ="dob-month")
	public List<WebElement> lst_Month;
	
	@FindBy(how = How.XPATH, using ="//*[@id='billing:month']")
	public WebElement lstMonth;
	
	@FindBy(how = How.CLASS_NAME, using ="dob-year")
	public List<WebElement> lst_Year;
	
	@FindBy(how = How.XPATH, using ="//*[@id='billing:year']")
	public WebElement lstYear;
	
	@FindBy(how = How.XPATH, using ="//*[@id='id_create_account']")
	public WebElement chkCreate;
	
	@FindBy(how = How.XPATH, using ="//*[@id='billing:customer_password']")
	public WebElement txtPassword;
	
	@FindBy(how = How.XPATH, using ="//*[@id='billing:confirm_password']")
	public WebElement txtVPassword;
	
	
	public ShippingDetailsGuestPage(WebDriver driver){ 
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	} 
	
	
	
	
	public void ship_DetailsGuest(String sFirstName,String sLastName,String sEmail,String sPhone,String sAddress,String sCity,String sRegion,String sPostal,String sDay,String sMonth,String sYear,String password,String VPassword){
		try{
			
		
			
		inAction.selectCheckbox(driver, guestUser, "Select the guest user");	
		inAction.inputText(driver,txtFirstName, sFirstName, "Enter FirstName : " + sFirstName);
		inAction.inputText(driver,txtLastName, sLastName, "Enter LastName : " + sLastName);
		inAction.inputText(driver,txtEmail, sEmail, "Enter Email : " + sEmail);
		inAction.inputText(driver,txtTelephone, sPhone, "Enter Phone : " + sPhone);
		inAction.inputText(driver,txtAddress, sAddress, "Enter Address : " + sAddress);
		inAction.inputText(driver,txtCity, sCity, "Enter Address : " + sCity);
		inAction.selectValueFromDropdown(driver, drpRegion, sRegion, "Enter day :"+sRegion);
		inAction.inputText(driver, txtPostCode, sPostal, "Enter Postal : " + sPostal);
		Thread.sleep(2000);
		inAction.selectValueFromDropdown(driver, lstDay, sDay, "Enter day :"+sDay);
		inAction.selectValueFromDropdown(driver, lstMonth, sMonth, "Enter year :"+sMonth);
		inAction.selectValueFromDropdown(driver, lstYear, sYear, "Enter year :"+sYear);
		chkCreate.click();
		
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
}
	
	
	public void ship_DetailsupgradeGuest(String sFirstName,String sLastName,String sEmail,String sPhone,String sAddress,String sCity,String sRegion,String sPostal,String sDay,String sMonth,String sYear,String password,String VPassword){
		try{
			
		
			
		inAction.selectCheckbox(driver, guestUser, "Select the guest user");	
		inAction.inputText(driver,txtFirstName, sFirstName, "Enter FirstName : " + sFirstName);
		inAction.inputText(driver,txtLastName, sLastName, "Enter LastName : " + sLastName);
		inAction.inputText(driver,txtEmail, ReusableActions.getCurrentTimeStamp()+sEmail, "Enter Email : " + sEmail);
		inAction.inputText(driver,txtTelephone, sPhone, "Enter Phone : " + sPhone);
		inAction.inputText(driver,txtAddress, sAddress, "Enter Address : " + sAddress);
		inAction.inputText(driver,txtCity, sCity, "Enter Address : " + sCity);
		inAction.selectValueFromDropdown(driver, drpRegion, sRegion, "Enter day :"+sRegion);
		inAction.inputText(driver, txtPostCode, sPostal, "Enter Postal : " + sPostal);
		inAction.selectValueFromDropdown(driver, lstDay, sDay, "Enter day :"+sDay);
		inAction.selectValueFromDropdown(driver, lstMonth, sMonth, "Enter year :"+sMonth);
		inAction.selectValueFromDropdown(driver, lstYear, sYear, "Enter year :"+sYear);
//		chkCreate.click();
		inAction.selectCheckbox(driver, chkCreate, "UnCheck the checkbox for later user");
		inAction.inputText(driver,txtPassword, password, "Enter Phone : " + password);
		inAction.inputText(driver,txtVPassword, VPassword, "Enter Phone : " + VPassword);
		
		
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
}
	
	
	
	@DataProvider
	public static Object[][] getData(){
		
		return GeneralActions.getData("ShippingDetailsGuest");
	}
	
	
}
