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




public class LogoutPage {
	WebDriver driver;
	
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");
 
	
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")
	 public WebElement btnChange;
	
	@FindBy(how = How.XPATH, using = "html/body/div[7]/div[3]/div/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[4]/div[2]/div[3]/div[2]/a")
	 public WebElement btnLogout;
	
	 
	public LogoutPage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
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
			
			public void validateLogoutPage(){
				String  s= driver.getTitle();
				System.out.println("LogoutPage "+ s);
			}
			

			

	
		
	
}
