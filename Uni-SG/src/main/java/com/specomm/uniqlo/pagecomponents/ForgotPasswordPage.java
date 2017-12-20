package com.specomm.uniqlo.pagecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.specomm.uniqlo.common.utils.Constants;
import com.specomm.uniqlo.common.utils.GeneralActions;
import com.specomm.uniqlo.common.utils.ReusableActions;

public class ForgotPasswordPage {
	WebDriver driver;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='login-form']/div[1]/div[2]/ul/li[2]/div/a")
	public WebElement linkForgotPwd;
	
	@FindBy(how = How.XPATH, using = "//*[@id='email_address']")
	public WebElement enterEmailAddress;
	
	@FindBy(how = How.XPATH, using = "//*[@id='form-validate']/div/div[4]/button")
	public WebElement btn_submit;
	
	@FindBy(how = How.XPATH, using = "html/body/div[1]/div/div[1]/div/div[1]/div/div/div/div[2]/h2[1]/span/span[2]")
	public WebElement resetPasswordMsg;
	
	/*@FindBy(how = How.XPATH, using = "html/body/div[1]/div/div[1]/div/div[1]/div/div/div/div[2]/h2[1]/span")
	public WebElement resetPasswordMsg;*/
	
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
			
			Assert.assertEquals(resetPasswordMsg.getText(),constants.FORGOT_PASSWORD);
		}
		catch(Exception e){
			e.printStackTrace();
	}
}
}