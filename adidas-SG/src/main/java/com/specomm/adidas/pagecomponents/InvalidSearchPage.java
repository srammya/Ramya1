package com.specomm.adidas.pagecomponents;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.specomm.adidas.common.utils.Constants;
import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;

public class InvalidSearchPage {
	
	
	WebDriver driver;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");
 
	
	@FindBy(how = How.XPATH , using = "//div/div[1]/div[1]/h2")
	@CacheLookup public WebElement invalidProduct;

	public InvalidSearchPage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	} 
	
	public void verifyInvalidProduct(){
		try{
			System.out.println("+++++++++++++"+invalidProduct.getText());
			Assert.assertEquals(invalidProduct.getText(),constants.SEARCH_INVALID_ITEM);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
