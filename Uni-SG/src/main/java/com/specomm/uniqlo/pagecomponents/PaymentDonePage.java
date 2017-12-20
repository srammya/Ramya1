package com.specomm.uniqlo.pagecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.specomm.uniqlo.common.utils.Constants;
import com.specomm.uniqlo.common.utils.ReusableActions;

public class PaymentDonePage {
	
	WebDriver driver;
	ReusableActions inActions=new ReusableActions();
	Constants constants=new Constants();
	
	@FindBy(how = How.XPATH, using = "//*[@id='printDiv']/div[1]/div[2]/button")
	public WebElement btnContinueShopping;
	
	// Constructor
		public PaymentDonePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	
		public void clickContinueShopping(){
			try{
				inActions.linkClick(driver, btnContinueShopping, "Click continue shopping from payment done page");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

}
