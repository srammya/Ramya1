package com.specomm.adidas.pagecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.specomm.adidas.common.utils.Constants;
import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;

public class ShippingDetailsLoginPage {
	
	
	String delimiter1 = "\\$";
	String delimiter2="\\.";
	String Value1,Value2;
	WebDriver driver;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	ShoppingBucketPage shoppingBucketPage;
	Constants constants=new Constants();
	
	
	//indonesia
	
	@FindBy(how = How.ID, using = "shipping:region")
	public WebElement shp_Region ;
	
	
	
	@FindBy(how = How.ID, using = "shipping-address-select")
	public WebElement shp_Addressselect ;
	
	@FindBy(how = How.ID, using = "shipping:firstname")
	public WebElement shp_Firstname ;
	
	@FindBy(how = How.ID, using = "shipping:lastname")
	public WebElement shp_Lastname ;
	
	@FindBy(how = How.ID, using = "shipping:telephone")
	public WebElement shp_Phone ;
		
	@FindBy(how = How.ID, using = "shipping:email")
	public WebElement shp_mail;
	
	@FindBy(how = How.ID, using = "shipping:street1")
	public WebElement shp_address;//56 Tanglin Road
	
	@FindBy(how = How.ID, using = "shipping:city")
	public WebElement shp_City;
	
	@FindBy(how = How.ID, using = "shipping:postcode")
	public WebElement shp_Postal;//247964
	
	@FindBy(how = How.XPATH, using = "//*[@id='shipping:use_for_billing']")
	public WebElement shp_Billing;
	
	@FindBy(how = How.ID, using = "shipping:day")
	public WebElement shp_Bday;
	
	@FindBy(how = How.ID, using = "shipping:month")
	public WebElement shp_Bmonth;
	
	@FindBy(how = How.ID, using = "shipping:year")
	public WebElement shp_Byear;
	
	@FindBy(how = How.XPATH, using = "//*[@id='shipping:agevalidation']")
	public WebElement shp_Age;          
	
	@FindBy(how = How.XPATH, using = "//*[@id='shipping-buttons-container']/button")
	 public WebElement btn_shipping;
									 
	@FindBy(how = How.XPATH, using = "//*[@id='co-shipping-form']/ul/li[1]/fieldset/div[1]")
	public WebElement shp_Heading;
	
	@FindBy(how = How.XPATH, using = "//*[@id='shopping-cart-totals-table']/tfoot/tr[2]/td[2]/strong/span")
	public WebElement orderTotal;
	
	@FindBy(how = How.XPATH, using = "//*[@id='shopping-cart-totals-table']/tbody/tr[1]/td[2]/strong/span")
	public WebElement totalCost;
	
	
	
	public ShippingDetailsLoginPage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	}
	
	public void verifyLoginShipHeading(){
		try{
			Assert.assertEquals(shp_Heading.getText(),constants.SHIPPING_DETAILS);
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	}

	
	public void billingsameshipping(){
		try{
			inAction.selectCheckbox(driver, shp_Billing, "Check  billing is same as shipping :"+shp_Billing);
		}
		catch(Exception e){
			e.printStackTrace();
		} 
		 
	} 
	
	public void verifyOrderSummary(){
		shoppingBucketPage=new ShoppingBucketPage(driver);
		try{
			String tot=totalCost.getText();
			

			String [] temp = tot.split(delimiter1);
			
			for (int i=0;i<temp.length;i++){
				Value1=temp[1];
				
				
			
			String [] temp1=Value1.split(delimiter2);
	  	 for(int j=0; j<temp1.length;j++){
	  		
			  Value2=temp1[0];
			  
	  		
	  	 }

			}
			System.out.println(Value2);
			int t=Integer.valueOf(Value2);
			int t2=t-50;
			String t3="S$"+t2+".00";
			System.out.println("The total amount payable is"+t2);
			System.out.println(orderTotal.getText());
			
			if(orderTotal.getText().equals(t3)){
				Reporter.log("The amount is deducted according to the promo applied");
				Assert.assertEquals(orderTotal.getText(),"S$"+t2+".00");
				}
				else{
							Reporter.log("The amount is NOT deducted according to the promo applied");
						}
				
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	public void ship_DetailsLogin(String sFirstName,String sLastName,String sPhone,String sAddress,String sCity,String sPostal,String sDay,String sMonth,String sYear){
		try{
			if(ReusableActions.displayElement(driver,shp_Addressselect)){
			 
				shippingContinue();
			}
			else{
		ReusableActions.waitForVisibilityOfElement(driver, shp_Heading);
		inAction.inputText(driver, shp_Firstname, sFirstName, "Enter password : " + sFirstName);
		inAction.inputText(driver, shp_Lastname, sLastName, "Enter password : " + sLastName);
		inAction.inputText(driver, shp_Phone, sPhone, "Enter password : " + sPhone);
		inAction.inputText(driver, shp_address, sAddress, "Enter password : " + sAddress);
		inAction.inputText(driver, shp_City, sCity, "Enter password : " + sCity);
		inAction.inputText(driver, shp_Postal, sPostal, "Enter password : " + sPostal);
		/*ReusableActions.selectItemFromDropdown(driver, shp_Bday, sDay, "Enter day :"+sDay);
		ReusableActions.selectItemFromDropdown(driver, shp_Bmonth, sMonth, "Enter month :"+sMonth);
		ReusableActions.selectItemFromDropdown(driver, shp_Byear, sYear, "Enter year :"+sYear);*/
		billingsameshipping();
		inAction.selectCheckbox(driver, shp_Age, "Select the checkbox");
		Thread.sleep(2000);
		shippingContinue();
			}
		
	}
		
	catch(Exception e){
		e.printStackTrace();
	}
	}
	
	
	public void shippingContinue(){
		try{
			
			inAction.buttonClick(driver, btn_shipping, "Click button :"+btn_shipping);
		}
		catch(Exception e){
			e.printStackTrace();
		} 
		 
	} 
	
	
	
	/*public void ship_DetailsGuest(String sFirstName,String sLastName,String sEmail,String sPhone,String sAddress,String sCity,String sPostal,String sDay,String sMonth,String sYear){
		try{
			
		
		ReusableActions.waitForVisibilityOfElement(driver, shp_Heading);
		inAction.inputText(driver, shp_Firstname, sFirstName, "Enter password : " + sFirstName);
		inAction.inputText(driver, shp_Lastname, sLastName, "Enter password : " + sLastName);
		inAction.inputText(driver, shp_Phone, sPhone, "Enter password : " + sPhone);
		inAction.inputText(driver, shp_Phone, sEmail, "Enter password : " + sPhone);
		inAction.inputText(driver, shp_address, sAddress, "Enter password : " + sAddress);
		inAction.inputText(driver, shp_City, sCity, "Enter password : " + sCity);
		inAction.inputText(driver, shp_Postal, sPostal, "Enter password : " + sPostal);
		ReusableActions.selectItemFromDropdown(driver, shp_Bday, sDay, "Enter day :"+sDay);
		ReusableActions.selectItemFromDropdown(driver, shp_Bmonth, sMonth, "Enter month :"+sMonth);
		ReusableActions.selectItemFromDropdown(driver, shp_Byear, sYear, "Enter year :"+sYear);
		billingsameshipping();
		inAction.buttonClick(driver, btn_shipping, "Click button :"+btn_shipping);
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}*/
	@DataProvider
	public static Object[][] getData(){
		
		return GeneralActions.getData("ShippingDetailsLogin");
		
		
	}
	
}
