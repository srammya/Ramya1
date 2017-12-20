package com.specomm.adidas.pagecomponents;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.specomm.adidas.common.utils.Constants;
import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;



public class AdidasLoginCheckoutPage {
	WebDriver driver;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");
 
	@FindBy(how = How.ID, using ="login-email")
	public WebElement txtbx_UserName;
 
	@FindBy(how = How.ID, using = "login-password")
	public WebElement txtbx_Password;
 
	@FindBy(how = How.XPATH, using = "id('checkout-right-wrapper')/div/div[2]/div/div/div[1]/div[1]/div[2]/div/button")
	public WebElement btn_Login ;
	
	
	
	public AdidasLoginCheckoutPage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	} 
	
	
	// Enter Username
	public void enterUserName(String sUsername) {
		try{
		
		ReusableActions.isElementVisible(txtbx_UserName , "Verify if UserName field exists?");
		inAction.inputText(driver, txtbx_UserName,sUsername , "Enter username : " + sUsername);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}
	//Enter Password
	public void enterPassword(String sPassword) {
		try{
			
		
		ReusableActions.isElementVisible(txtbx_UserName , "Verify if Password field exists");
		inAction.inputText(driver, txtbx_Password, sPassword, "Enter password : " + sPassword);
    }
	catch(Exception e){
		e.printStackTrace();
		
	}
	}
	//Click Login button
	public void clickLoginButton() {
		try{
			
		inAction.buttonClick(driver, btn_Login, "Click button : btn_Login");
    }
		catch(Exception e){
			
			e.printStackTrace();
		}
		
	}
	
	public void logInUser(String sUserName, String sPassword) {
		try{
			
		
			//Assert.assertEquals(constants.LOGIN_CHECKOUT, driver.getTitle());
			enterUserName(sUserName);
	        enterPassword(sPassword);
	        clickLoginButton();
	       
	        
				
    }
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
	
	public void shipHeading(){
		
	}
	
	
	
	
	@DataProvider
	public static Object[][] getData(){
		return GeneralActions.getData("RegisteredUserLoginFlow");

	}
	
	
}