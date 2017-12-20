package com.specomm.uniqlo.pagecomponents;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.specomm.uniqlo.common.utils.Constants;
import com.specomm.uniqlo.common.utils.GeneralActions;
import com.specomm.uniqlo.common.utils.ReusableActions;

public class ShoppingBucketPage {
	
WebDriver driver;
	
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	UniqloHomePage uniqloHomePage=new UniqloHomePage(driver);
	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");

	
	@FindBy(xpath = "//div[@class='page-title title-buttons']/h1")
	WebElement bagHeadg;

	@FindBy(xpath = "//*[@id='cart_proceed_button']")
	WebElement proToCheck;
	
	@FindBy(xpath = "html/body/div[1]/div/div[2]/div/div[1]/div/div[2]/div/p[2]/a")
	WebElement btnConShopping;
	
	@FindBy(xpath = "//*[@id='cart_email']")
	WebElement chkoutEmail;
	
	
	

	// Constructor
	public ShoppingBucketPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    /**
     * This method verifies Shop bag Page validations and Proceeds to Checkout Page.
     */
	public void verifyShopBucketAndProceed() {
		try
		{
			ReusableActions.waitForVisibilityOfElement(driver, bagHeadg);
		//Assert.assertEquals(bagHeadg.getText(), ReusableActions.getPropFileValues("ShoppingBagTitle"));
		ReusableActions.waitForpageToLoad(driver);
		ReusableActions.click(proToCheck);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
		}
	}
	
	public void clickConShopping(){
		try{
			inAction.buttonClick(driver, btnConShopping, "Click continue shopping");
		}
	catch(Exception e){
		e.printStackTrace();
	}
	}
	
}
