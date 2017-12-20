package com.specomm.uniqlo.pagecomponents;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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




public class NewAccountPage {
	WebDriver driver;
	 String Title,Value;
	 public static String Email;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");
 
	
	
	@FindBy(how = How.ID, using ="email_address")
	WebElement txtEmail;
	
	@FindBy(how = How.ID, using ="prefix")
	WebElement drpPrefix;
	
	@FindBy(how = How.ID, using ="firstname")
	WebElement txtFirstname;
		
	@FindBy(how = How.ID, using ="lastname")
	WebElement txtLastname;
	
	@FindBy(how = How.ID, using ="street_1")
	WebElement txtStreet_1;
	
	@FindBy(how = How.ID, using ="city")
	WebElement txtCity;
	
	@FindBy(how = How.ID, using ="region_id")
	WebElement drpRegion;
	
	@FindBy(how = How.ID, using ="postcode")
	WebElement txtPostcode;
	
	@FindBy(how = How.ID, using ="country")
	WebElement drpCountry;
	
	@FindBy(how = How.ID, using ="telephone")
	WebElement txtTelephone;
	
	@FindBy(how = How.ID, using ="password")
	WebElement txtPassword;
	
	@FindBy(how = How.ID, using ="confirmation")
	WebElement txtConfirmation;
	
	@FindBy(how = How.ID, using ="day")
	WebElement drpDay;
	
	@FindBy(how = How.ID, using ="month")
	WebElement drpMonth;
	
	@FindBy(how = How.ID, using ="year")
	WebElement drpYear;
	
	@FindBy(how = How.XPATH, using ="//*[@id='search_mini_form']/div/button")
	WebElement search;
	
	@FindBy(how = How.ID, using ="terms_conditions")
	WebElement chkTerms_conditions;
	
	@FindBy(how = How.CSS, using ="#pre-confirm > span")
	WebElement btnPreConfirm;
	
	@FindBy(how = How.XPATH, using ="//*[@id='form-validate']/div/div[3]/button[1]")
	WebElement btnRegister;
	
	@FindBy(how = How.CSS, using ="button.button:nth-child(1)")
	WebElement btnGoToMyAccount;
	
	@FindBy(how = How.XPATH, using ="html/body/div[1]/div/div[1]/div/div[1]/div/div[2]/ul/li/ul/li/span")
	WebElement msgAlreadyExists;
	
	@FindBy(how = How.LINK_TEXT, using ="To delete account")
	WebElement deleteAccount;
	
	@FindBy(how = How.XPATH, using ="html/body/div[1]/div/div[1]/div/div[1]/div/div/div[1]/div/h1/span[2]")
	WebElement myAccount;
	
	 
	public NewAccountPage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	} 
	
	
public void enterAccountDetails(String rEmail,String rTitle,String rFirstName,String rLastName,String rAddress,String rCity,String rProvince,String rPcode,String rPhone,String rPassword,String rCPassword,String dDay,String dMonth,String dYear) {
	
	try
	{
	
	//	Assert.assertEquals(driver.getTitle(),constants.REGISTER_NEW_USER_PAGE);
		Thread.sleep(3000);
		Email=ReusableActions.getCurrentTimeStamp()+rEmail;
		inAction.inputText(driver, txtEmail, Email, "Enter Firstname : " + Email);
		inAction.selectValueFromDropdown(driver, drpPrefix, rTitle, "Enter day :"+rTitle);
		inAction.inputText(driver, txtFirstname,rFirstName , "Enter Firstname : " + rFirstName);
		inAction.inputText(driver, txtLastname,rLastName , "Enter Lastname : " + rLastName);
		inAction.inputText(driver, txtStreet_1,rAddress , "Enter Address : " + rAddress);
		inAction.inputText(driver, txtCity,rCity , "Enter City : " + rCity);
		inAction.selectValueFromDropdown(driver, drpRegion, rProvince, "Enter day :"+rProvince);
		inAction.inputText(driver, txtPostcode,rPcode , "Enter Postal Code : " + rPcode);
		inAction.inputText(driver, txtTelephone,rPhone , "Enter Postal Code : " + rPhone);
		inAction.inputText(driver, txtPassword,rPassword , "Enter Postal Code : " + rPassword);
		inAction.inputText(driver, txtConfirmation,rCPassword , "Enter Postal Code : " + rCPassword);
		inAction.selectItemFromDropdown(driver, drpDay, dDay, "Enter day :"+dDay);
		inAction.selectValueFromDropdown(driver, drpMonth, dMonth, "Enter month :"+dMonth);
		inAction.selectItemFromDropdown(driver, drpYear, dYear, "Enter year :"+dYear);
		search.click();
		inAction.selectCheckbox(driver, chkTerms_conditions, "check the terms and condition checkbox");
		clickSubmitButton();
		clickRegisterButton();
		
		clickGoToMyAccount();
		
		
	
	}
	
catch(Exception e){
	//e.printStackTrace();
}
	
	try{
		if(ReusableActions.displayElement(driver,msgAlreadyExists)){
			inAction.inputText(driver, txtEmail,ReusableActions.getCurrentTimeStamp()+rEmail , "Enter Firstname : " + rEmail);
			inAction.inputText(driver, txtStreet_1,rAddress , "Enter Address : " + rAddress);
			inAction.inputText(driver, txtPassword,rPassword , "Enter Postal Code : " + rPassword);
			inAction.inputText(driver, txtConfirmation,rCPassword , "Enter Postal Code : " + rCPassword);
			inAction.selectItemFromDropdown(driver, drpDay, dDay, "Enter day :"+dDay);
			inAction.selectItemFromDropdown(driver, drpMonth, dMonth, "Enter month :"+dMonth);
			inAction.selectItemFromDropdown(driver, drpYear, dYear, "Enter year :"+dYear);
			clickSubmitButton();
			clickRegisterButton();
			clickGoToMyAccount();
		}
	}
	catch(Exception e){
		//e.printStackTrace();
	}
}
	
		
	public void enterNewAccountDetails(String rEmail,String rTitle,String rFirstName,String rLastName,String rAddress,String rCity,String rPcode,String rPhone,String rPassword,String rCPassword,String dDay,String dMonth,String dYear) {
		
		try
		{
		
		//	Assert.assertEquals(driver.getTitle(),constants.REGISTER_NEW_USER_PAGE);
			Thread.sleep(3000);
			inAction.inputText(driver, txtEmail,rEmail , "Enter Firstname : " + rEmail);
			inAction.selectItemFromDropdown(driver, drpPrefix, rTitle, "Enter day :"+rTitle);
			inAction.inputText(driver, txtFirstname,rFirstName , "Enter Firstname : " + rFirstName);
			inAction.inputText(driver, txtLastname,rLastName , "Enter Lastname : " + rLastName);
			inAction.inputText(driver, txtStreet_1,rAddress , "Enter Address : " + rAddress);
			inAction.inputText(driver, txtCity,rCity , "Enter City : " + rCity);
			inAction.inputText(driver, txtPostcode,rPcode , "Enter Postal Code : " + rPcode);
			inAction.inputText(driver, txtTelephone,rPhone , "Enter Postal Code : " + rPhone);
			inAction.inputText(driver, txtPassword,rPassword , "Enter Postal Code : " + rPassword);
			inAction.inputText(driver, txtConfirmation,rCPassword , "Enter Postal Code : " + rCPassword);
			inAction.selectItemFromDropdown(driver, drpDay, dDay, "Enter day :"+dDay);
			inAction.selectItemFromDropdown(driver, drpMonth, dMonth, "Enter month :"+dMonth);
			inAction.selectItemFromDropdown(driver, drpYear, dYear, "Enter year :"+dYear);
			inAction.selectCheckbox(driver, chkTerms_conditions, "check the terms and condition checkbox");
			clickSubmitButton();
			clickRegisterButton();
			
			clickGoToMyAccount();
			
			
		
		}
		
	catch(Exception e){
		//e.printStackTrace();
	}
		
		try{
			if(ReusableActions.displayElement(driver,msgAlreadyExists)){
				inAction.inputText(driver, txtEmail,ReusableActions.getCurrentTimeStamp()+rEmail , "Enter Firstname : " + rEmail);
				inAction.inputText(driver, txtStreet_1,rAddress , "Enter Address : " + rAddress);
				inAction.inputText(driver, txtPassword,rPassword , "Enter Postal Code : " + rPassword);
				inAction.inputText(driver, txtConfirmation,rCPassword , "Enter Postal Code : " + rCPassword);
				inAction.selectItemFromDropdown(driver, drpDay, dDay, "Enter day :"+dDay);
				inAction.selectItemFromDropdown(driver, drpMonth, dMonth, "Enter month :"+dMonth);
				inAction.selectItemFromDropdown(driver, drpYear, dYear, "Enter year :"+dYear);
				clickSubmitButton();
				clickRegisterButton();
				clickGoToMyAccount();
			}
		}
		catch(Exception e){
			//e.printStackTrace();
		}
}

		
		public void verifyMyAccount(){
			try{
				System.out.println(myAccount.getText());
				Assert.assertEquals(myAccount.getText(),constants.MY_ACCOUNT_PAGE);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		//Click Register button
		public void clickSubmitButton() {
			try{
			inAction.buttonClick(driver, btnPreConfirm, "Click button : btn_Login");
	    }
			catch(Exception e){
				
				e.printStackTrace();
			}
			
		}	
			
		public void clickRegisterButton() {
			try{
			inAction.buttonClick(driver, btnRegister, "Click button : Register");
	    }
			catch(Exception e){
				
				e.printStackTrace();
			}
			
		}	
		

		public void clickGoToMyAccount() {
			try{
			inAction.buttonClick(driver, btnGoToMyAccount, "Click button : btnGoToMyAccount");
	    }
			catch(Exception e){
				
				//e.printStackTrace();
			}
			
		}	
		
		public void clickDeleteAccount() {
			try{
				Thread.sleep(5000);
			inAction.linkClick(driver, deleteAccount, "Click button : deleteAccount");
			
			
			Alert alert=driver.switchTo().alert();
			Thread.sleep(2000);
			alert.accept();
	    }
			catch(Exception e){
				
				//e.printStackTrace();
			}
			
		}	
		
		
		
	@DataProvider
	public static Object[][] getData(){
		
		return GeneralActions.getData("NewUserCreationFlow");
	}
}
