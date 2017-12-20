package com.specomm.adidas.pagecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.specomm.adidas.common.utils.ReusableActions;

public class AdidasGuestCheckoutPage {
	
	WebDriver driver;
	ReusableActions inAction = new ReusableActions();
	
	@FindBy(how = How.ID, using ="onepage-guest-register-button")
	 public WebElement guestCheckout;
	
	public AdidasGuestCheckoutPage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	}

	/*public void clickCheckout(){
		inAction.buttonClick(driver, guestCheckout, "Click guest checkout button");
	}*/
	
}
