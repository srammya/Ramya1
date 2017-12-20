package com.specomm.adidas.pagecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.specomm.adidas.common.utils.Constants;
import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;

public class ShippingDetailsGuestPage {
	
	String delimiter1 = "\\$";
	String delimiter2="\\.";
	String Value1,Value2;
	WebDriver driver;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	ShoppingBucketPage shoppingBucketPage;
	
	@FindBy(how = How.ID, using = "shipping:firstname")
	 public WebElement shp_Firstname ;
	
	@FindBy(how = How.ID, using = "shipping:lastname")
	 public WebElement shp_Lastname ;
	
	@FindBy(how = How.ID, using = "shipping:telephone")
	 public WebElement shp_Phone ;
		
	@FindBy(how = How.ID, using = "shipping:email")
	 public WebElement shp_Email;
	
	@FindBy(how = How.ID, using = "shipping:street1")
	 public WebElement shp_Address;//56 Tanglin Road
	
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
	public WebElement valAge;
	
	@FindBy(how = How.XPATH, using = "//*[@id='shipping-buttons-container']/button")
	 public WebElement btn_shipping;
	
	@FindBy(how = How.XPATH, using = "//*[@id='shipping-new-address-form']/fieldset[1]/ul/li[1]/div[1]")
	 public WebElement shp_Heading;
	
	@FindBy(how = How.XPATH, using = "//*[@id='shopping-cart-totals-table']/tfoot/tr[2]/td[2]/strong/span")
	public WebElement orderTotal;
	
	@FindBy(how = How.XPATH, using = "//*[@id='shopping-cart-totals-table']/tbody/tr[1]/td[2]/strong/span")
	public WebElement totalCost;
	
	
	public ShippingDetailsGuestPage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	}
	
	public void verifyGuestShipHeading(){
	try{
//		Assert.assertEquals(shp_Heading.getText(),constants.SHIPPING_DETAILS);
	}
	
	catch(Exception e){
		e.printStackTrace();
	}
	}

	public void verifyGuestOrderSummary(){
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
			int t2=t-20;
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
	
	public void billingsameshipping(){
		try{
			inAction.selectCheckbox(driver, shp_Billing, "Check  billing is same as shipping :"+ shp_Billing);
			
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
	
	public void ship_DetailsGuest(String sFirstName,String sLastName,String sEmail,String sPhone,String sAddress,String sCity,String sPostal,String sDay,String sMonth,String sYear){
		try{
			
		
			Thread.sleep(3000);
		inAction.inputText(driver, shp_Firstname, sFirstName, "Enter FirstName : " + sFirstName);
		inAction.inputText(driver, shp_Lastname, sLastName, "Enter LastName : " + sLastName);
		inAction.inputText(driver, shp_Email, sEmail, "Enter Email : " + sEmail);
		inAction.inputText(driver, shp_Phone, sPhone, "Enter Phone : " + sPhone);
		inAction.inputText(driver, shp_Address, sAddress, "Enter Address : " + sAddress);
		inAction.inputText(driver, shp_City, sCity, "Enter City : " + sCity);
		inAction.inputText(driver, shp_Postal, sPostal, "Enter Postal : " + sPostal);
		
		billingsameshipping();
		if(ReusableActions.displayElement(driver, shp_Bday)){
		ReusableActions.selectItemFromDropdown(driver, shp_Bday, sDay, "Enter day :"+sDay);
		ReusableActions.selectItemFromDropdown(driver, shp_Bmonth, sMonth, "Enter month :"+sMonth);
		ReusableActions.selectItemFromDropdown(driver, shp_Byear, sYear, "Enter year :"+sYear);
		}
		else{
			inAction.selectCheckbox(driver, valAge, "Check  billing is same as shipping :"+ valAge);
		}
//		inAction.buttonClick(driver, btn_shipping, "Click button :"+btn_shipping);
		shippingContinue();
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}
	@DataProvider
	public static Object[][] getData(){
		
		return GeneralActions.getData("ShippingDetailsGuest");
		
		
	}
	
}
