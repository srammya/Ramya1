package com.specomm.adidas.pagecomponents;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.specomm.adidas.common.utils.Constants;
import com.specomm.adidas.common.utils.ReusableActions;

public class PaymentDeclinedPage {
	
	
	WebDriver driver;
	Constants constants=new Constants();
	ReusableActions inActions =new ReusableActions();
	
	@FindBy(how = How.XPATH, using = "html/body/div[1]/div/div[2]/div/div/div/h1")
	public WebElement msgDeclined;
	
	@FindBy(how = How.XPATH, using = "html/body/div[1]/div/div[2]/div/div/p/a")
	public WebElement lnkContinueShopping;
	
	
	public PaymentDeclinedPage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	   	}
	
	
	public void verifyPamymentDeclinedMsg(){
		try{
			Assert.assertEquals(msgDeclined.getText(), constants.PAYMENT_DECLINED_PAGE);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void clickContinueShopping(){
		try{
			inActions.linkClick(driver, lnkContinueShopping, "Click continue shopping from payment declined page");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
}
