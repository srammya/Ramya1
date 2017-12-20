package com.specomm.adidas.pagecomponents;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.specomm.adidas.common.utils.Constants;
import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;




public class LoginAccountPage {
	WebDriver driver;
	
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	
	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");
 
	
	
	@FindBy(how = How.ID, using = "Email")
	public WebElement txtUname;
 
	@FindBy(how = How.ID, using = "next")
	public WebElement btnNext;
		
	@FindBy(how = How.XPATH, using = "//form/div[2]/div/div[2]/div/div/input[2]")
	public WebElement txtPassword;
	
	@FindBy(how = How.XPATH, using = "html/body/div[1]/div[2]/div[2]/div[1]/form/div[2]/div/input[1]")
	 public WebElement btnSignin;
	
	@FindBy(how = How.XPATH, using = "//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")
	 public WebElement btnChange;
	
	@FindBy(how = How.XPATH, using = "html/body/div[7]/div[3]/div/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[4]/div[2]/div[3]/div[2]/a")
	 public WebElement btnLogout;
	
	
	 
	public LoginAccountPage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	} 
	
	
		
			
			// Enter Firstname
			public void enterEmail(String lEmail) {
				try{
				
				//inAction.isElementVisible(txtbx_Firstname , "Verify if FirstName field exists");
				inAction.inputText(driver, txtUname,lEmail , "Enter Firstname : " + lEmail);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			}
			
			
			public void clickEmailNextButton() {
				try{
				inAction.buttonClick(driver, btnNext, "Click button : btn_Login");
		    }
				catch(Exception e){
					
					e.printStackTrace();
				}
				
			}	
			
			
				
			//Enter Password
			public void enterPassword(String lPassword) {
				try{
					
				
				ReusableActions.isElementVisible(txtPassword , "Verify if Password field exists");
				inAction.inputText(driver, txtPassword, lPassword, "Enter password : " + lPassword);
		    }
			catch(Exception e){
				e.printStackTrace();
				
			}
			}
			
			public void clickSigninButton() {
				try{
				inAction.buttonClick(driver, btnSignin, "Click button : btnSignin");
		    }
				catch(Exception e){
					
					e.printStackTrace();
				}
				
			}	
			
			public void validateLandingPage(){
				
				Assert.assertEquals(driver.getTitle(), Constants.LandingPage);
			}
			
			public void clickChangeButton() {
				try{
				inAction.buttonClick(driver, btnChange, "Click button : btnChange");
		    }
				catch(Exception e){
					
					e.printStackTrace();
				}
				
			}	
			
			
				
			
			
			public void clickLogoutButton() {
				try{
				inAction.buttonClick(driver, btnLogout, "Click button : btnLogout");
		    }
				catch(Exception e){
					
					e.printStackTrace();
				}
				
			}	
			
			
	
		
	@DataProvider
	public static Object[][] getData(){
		
		return GeneralActions.getData("LoginAccount");
	}
}
