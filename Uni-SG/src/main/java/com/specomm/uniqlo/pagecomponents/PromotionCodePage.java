package com.specomm.uniqlo.pagecomponents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.Assert;

import com.specomm.uniqlo.common.utils.Constants;
import com.specomm.uniqlo.common.utils.GeneralActions;
import com.specomm.uniqlo.common.utils.ReusableActions;


public class PromotionCodePage {
	
	WebDriver driver;
	ReusableActions inActions=new ReusableActions();
	Constants constants=new Constants();
	
	
		
	
	
	@FindBy(xpath = "//*[@id='id_couponcode']")
	public WebElement txtCoupon;
	
	@FindBy(xpath = "//form/fieldset/div[2]/div[4]/div[1]/div[2]/div/div[1]/span[2]")
	public WebElement msgCoupon;
	
	@FindBy(xpath = "//form/fieldset/div[2]/div[4]/div[1]/div[2]/div/div[2]/button[2]")
	public WebElement btnCoupon;
	
	
	
	
	
	public PromotionCodePage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	}
	
	public void applyInvalidPromo(String promo){
		try{
			inActions.inputText(driver, txtCoupon, promo, "Enter invalid promo");
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('onestepcheckout-coupon-add').click()");
//			inActions.buttonClick(driver,btnCoupon,"click apply button");
			
			//System.out.println(msgCoupon.getText());
			Assert.assertEquals(msgCoupon.getText(), constants.PROMO_MSG);
			
			Thread.sleep(1000);

			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	@DataProvider
	public static Object[][] getData(){
		
		return GeneralActions.getData("InValidPromoDetails");
	}
	
	 
	
	
}
