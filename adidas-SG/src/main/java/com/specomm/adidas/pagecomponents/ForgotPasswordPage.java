package com.specomm.adidas.pagecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.specomm.adidas.common.utils.Constants;
import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;

public class ForgotPasswordPage {
	WebDriver driver;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='login-form']/div/div[1]/div/div/ul/li[3]/div[2]/a")
	public WebElement linkForgotPwd;
	
	@FindBy(how = How.XPATH, using = "html/body/div[1]/div/div[2]/div/div/div/form/div/ul/li/div/input")
	public WebElement enterEmailAddress;
	
	@FindBy(how = How.XPATH, using = "//*[@id='form-validate']/div/div[1]/div/button")
	public WebElement btn_submit;
	
	@FindBy(how = How.XPATH, using = "//li[@class='success-msg']")
	public WebElement resetPasswordMsg;
	
	public ForgotPasswordPage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	}
	
	public void clickForgotPassword(){
		try{
			inAction.linkClick(driver, linkForgotPwd, " Click link forgot password");
		}
		catch(Exception e){
			e.printStackTrace();
	}
}
	
	public void enterEmailAddress(String eaddress){
		try{
			
			inAction.inputText(driver, enterEmailAddress, eaddress, "Enter email address");
		}
		catch(Exception e){
			e.printStackTrace();
	}
}
	
	public void clickSubmitbutton(){
		try{
			
			inAction.buttonClick(driver, btn_submit, "Click submit button");
		}
		catch(Exception e){
			e.printStackTrace();
	}
}
	
	public void recoveryPassword(String address){
		clickForgotPassword();
		enterEmailAddress(address);
		clickSubmitbutton();
		
	}
	
	public void VerifyPasswordResetMessage(){
		try{
			
			Assert.assertEquals(constants.RESET_PWD_MESSAGE,resetPasswordMsg.getText());
		}
		catch(Exception e){
			e.printStackTrace();
	}
}
}