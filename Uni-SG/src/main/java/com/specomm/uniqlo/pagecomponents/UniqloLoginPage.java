package com.specomm.uniqlo.pagecomponents;

import junit.framework.Assert;

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

public class UniqloLoginPage {
	
	WebDriver driver;
	String Title,Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");
 
	
	
	@FindBy(how = How.XPATH, using ="//*[@id='navHeader']/li[9]/a")
	WebElement login;
	
	@FindBy(how = How.ID, using ="email")
	WebElement txtEmail;
	
	@FindBy(how = How.ID, using ="pass")
	WebElement txtPass;
		
	@FindBy(how = How.XPATH, using ="//*[@id='send2']")
	WebElement btnSignIn;
	
	@FindBy(how = How.XPATH, using ="//*[@id='navHeader']/li[9]/a")
	WebElement logout;
	
	/*@FindBy(how = How.XPATH, using ="html/body/div[1]/div/div[1]/div/div[1]/div[2]/ul/li/ul/li/span")
	WebElement msgInvalid;   */       
	
	
			@FindBy(how = How.XPATH, using =" html/body/div[1]/div/div[1]/div/div[1]/div[2]/ul/li/ul/li/span/span[2]")
	WebElement msgInvalid; 
	
	public UniqloLoginPage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	} 
	
	
	public void clickLogin() {
		try{
			
		
		
		inAction.buttonClick(driver, login ,"Click Login");
    }
	catch(Exception e){
		e.printStackTrace();
		
	}
	}
	
	
	
	public void enterUserName(String username) {
		try{
		
		ReusableActions.isElementVisible(txtEmail , "Verify if UserName field exists?");
		inAction.inputText(driver, txtEmail,username , "Enter username : " + username);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}
	//Enter Password
	public void enterPassword(String sPassword) {
		try{
			
		
		ReusableActions.isElementVisible(txtEmail , "Verify if Password field exists");
		inAction.inputText(driver, txtPass, sPassword, "Enter password : " + sPassword);
    }
	catch(Exception e){
		e.printStackTrace();
		
	}
	}
	//Click Login button
	public void clickLoginButton() {
		try{
		inAction.buttonClick(driver, btnSignIn, "Click button : btn_Login");
    }
		catch(Exception e){
			
			e.printStackTrace();
		}
		
	}
	
	
	public void validateMessage(){
		try{
			Assert.assertEquals(msgInvalid.getText(), constants.INVALID_CREDENTIALS);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void enterCredentials(String username,String password){
		try{
			inAction.buttonClick(driver, login, "Click button : btn_Login");
			enterUserName(username);
			enterPassword(password);
			clickLoginButton();
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		return GeneralActions.getData("RegisteredUserLoginFlow");
	}

}
