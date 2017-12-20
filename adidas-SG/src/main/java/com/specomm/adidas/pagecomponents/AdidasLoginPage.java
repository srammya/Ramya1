package com.specomm.adidas.pagecomponents;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.DataProvider;




import com.specomm.adidas.common.utils.Constants;
import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;




public class AdidasLoginPage {
	WebDriver driver;
	String Title,Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");
 
	
	@FindBy(how = How.CSS , using = "div.home-pop-up > a.close")
	 public WebElement btn_popupclose;
	
	@FindBy(how = How.XPATH , using = "//*[@id='functionUI']/li[2]/a")
	public WebElement click_enterUI ;
	
	@FindBy(how = How.CSS, using = "a.h-login-link")
	public WebElement click_Login ;
	
	@FindBy(how = How.ID, using = "email")
	 public WebElement txtbx_UserName;
 
	@FindBy(how = How.ID, using = "pass")
	 public WebElement txtbx_Password;
 
	@FindBy(how = How.ID, using = "send2")
	 public WebElement btn_Login ;
	
	@FindBy(how = How.XPATH, using ="html/body/div[1]/div/div[2]/div/div/div/ul/li/ul/li/span")
	public WebElement invalidErrMsg ;		
	
	
	
	public AdidasLoginPage(WebDriver driver){ 
	    this.driver = driver; 
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
	public void popUp(){
		try{
					
			inAction.buttonClick(driver, btn_popupclose, "Click button : btn_popupclose");
			 
			 String delimiter = ":";
				Title=driver.getTitle();
		    	  // given string will be split by the argument delimiter provided. 
		    	  String [] temp = Title.split(delimiter);
		    	  // print substrings 
		    	  for(int i =0; i < temp.length ; ++i){
		    		  
		    		  Value=temp[++i];
		    		  System.out.println(Value);
		    	  }
				 Assert.assertEquals(constants.URL_LOADING_PAGE_TITLE, Value);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void enterLogin() {
		try{
//		ReusableActions.mouseHover(driver,enter_Login);
		inAction.buttonClick(driver, click_enterUI, "Click button : click_Login");
    }
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void clickLogin(){
		try{
		inAction.linkClick(driver, click_Login, "Click link : click_Login");
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
	public void logIn_Action(String sUserName, String sPassword) {
		try{
			
			
			System.out.println("CUSTOMER_HOME_PAGE_TITLE"+driver.getTitle());
			Assert.assertEquals(constants.CUSTOMER_HOME_PAGE_TITLE, driver.getTitle());
			enterUserName(sUserName);
	        enterPassword(sPassword);
	        Thread.sleep(2000);
	        clickLoginButton();
	       
	        
				
    }
	
	catch(Throwable t)
	{
		t.printStackTrace();
	}
}
	
	
	public void verifyLoginLandingPage() {
		try{
			
			
			System.out.println("CUSTOMER_LANDING_PAGE"+driver.getTitle());
			 Assert.assertEquals(constants.CUSTOMER_LANDING_PAGE,driver.getTitle());
			
	        
				
    }
	
	catch(Throwable t)
	{
		t.printStackTrace();
	}
}
	
	public void verifyInvalidUsername() {
		try{
			
			
			
			Assert.assertEquals(constants.INVALID_USERNAME_PASSWORD, invalidErrMsg.getText());
			
	        
				
    }
	
	catch(Throwable t)
	{
		t.printStackTrace();
	}
}
	public void verifyInvalidPassword() {
		try{
			
			
			System.out.println(invalidErrMsg.getText());
			Assert.assertEquals(constants.INVALID_USERNAME_PASSWORD, invalidErrMsg.getText());
			
	        
				
    }
	
	catch(Throwable t)
	{
		t.printStackTrace();
	}
}
	
	@DataProvider
	public static Object[][] getData(){
		
		return GeneralActions.getData("RegisteredUserLoginFlow");
	}
}
