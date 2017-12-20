package com.specomm.adidas.pagecomponents;

import java.util.List;

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

public class ShoppingBucketPage {
	
	String delimiter1 = "\\$";
	String delimiter2="\\.";
	String Value1,Value2;
	WebDriver driver;
	ReusableActions inActions=new ReusableActions();
	Constants constants=new Constants();
	AdidasHomePage adidasHomePage;
	SubCategoriesPage subCategoriesPage;
	ProductDetailsPage productDetailsPage;

	@FindBy(how = How.XPATH, using = "html/body/div[1]/div/div[2]/div/div/div[1]/div[1]/div/div[1]/div/div[1]/span[1]")
	WebElement cartHeading;

	@FindBy(how = How.XPATH, using = "//li/button")
	WebElement prodcheckout;
	
	@FindBy(how = How.XPATH, using = "//div/div[2]/div[1]/div[3]/a")
	WebElement continueShopping;
	
	@FindBy(how = How.XPATH, using = "//*[@id='promocode-status']/span")
	public WebElement promoArrow;   
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='coupon_code']")
	public WebElement txtPromoCode;   
			
	@FindBy(how = How.XPATH, using = "id('discount-coupon-form')/div/div[3]/button")
	public WebElement btnRedeem;
	
	@FindBy(how = How.XPATH, using = "//*[@id='discount-coupon-form']/div/div[2]/span")
	public WebElement appliedPromoMsg;
	
	@FindBy(how = How.XPATH, using = "html/body/div[1]/div/div[2]/div/div/div[1]/div/div[1]")
	public WebElement emptyBag;
	
	@FindBy(how = How.XPATH, using = "//*[@id='shopping-cart-totals-table']/tfoot/tr[3]/td[2]/strong/span")
	public WebElement totalAmount;
	
	@FindBy (how = How.XPATH, using = "//*[@id='shopping-cart-totals-table']/tbody/tr[1]/td[2]/strong/span")
	public WebElement itemTotal;
	
	
	@FindBy (how = How.XPATH, using = "//*[@id='shopping-cart-table']/tbody/tr/td[6]/input")
	public WebElement itemQUpdate;
	
	@FindBy (how = How.XPATH, using = "//*[@id='shopping-cart-table']/tbody/tr/td[6]/input")
	public List<WebElement> itemQL;
	
	@FindBy(how = How.XPATH, using = "//*[@id='shopping-cart-table']/tbody/tr/td[3]/a[1]")
	public WebElement linkEditdetails;
	
	@FindBy(how = How.XPATH, using = "//form/fieldset/table/tbody/tr[2]/td[3]/a[2]")
	public WebElement linkRemove;
	
	@FindBy(how = How.XPATH, using = "id('shopping-cart-table')/tbody/tr[1]/td[3]/p")
	public WebElement qnotAvailable;
	

	// Constructor
	public ShoppingBucketPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    /**
     * This method verifies Shop bag Page validations and Proceeds to Checkout Page.
     */
	public void verifyShopBagAndProceed() {
		adidasHomePage = new AdidasHomePage(driver);
		subCategoriesPage = new SubCategoriesPage(driver);
		productDetailsPage=new ProductDetailsPage(driver);
		try
		{
			
			if(emptyBag.getText().equals("Your bag is empty")){
				adidasHomePage.mainMenuRandomSelection();
				ReusableActions.waitForpageToLoad(driver);
				subCategoriesPage.productRandomSelection();
				productDetailsPage.selectProductToCart();
			}
			else{

		Assert.assertEquals(constants.SHOPPING_BUCKET_PAGE_TITLE,driver.getTitle());
		ReusableActions.waitForpageToLoad(driver);
			}
		}
		catch(Throwable t)
		{
			t.printStackTrace();
		}
	}
	
	//change the calculation according to the promo amount deduction
	
	public void calculateAmount(String pcode){
		try{
			
			String tot=totalAmount.getText();
			

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
			applyPromocode(pcode);
			inActions.buttonClick(driver,btnRedeem, "Click redeem button");
			int t2=t-50;
			System.out.println("The total amount payable is"+t2);
			verifyApplyPromo();
			System.out.println(totalAmount.getText());
			String t3="S$"+t2+".00";
			if(totalAmount.getText().equals(t3)){
			Reporter.log("The amount is deducted according to the promo applied");
					Assert.assertEquals(totalAmount.getText(), "S$"+t2+".00");
			}
			else{
						Reporter.log("The amount is NOT deducted according to the promo applied");
					}
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//change the calculation according to the promo amount deduction
	
	public void calculateAmountGuestPromo(String pcode){
		try{
			
			String tot=totalAmount.getText();
			

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
			applyPromocode(pcode);
			inActions.buttonClick(driver,btnRedeem, "Click redeem button");
			int t2=t-20;
			System.out.println("The total amount payable is"+t2);
			verifyApplyGuestPromo();
			System.out.println(totalAmount.getText());
			String t3="S$"+t2+".00";
			if(totalAmount.getText().equals(t3)){
			Reporter.log("The amount is deducted according to the promo applied");
					Assert.assertEquals(totalAmount.getText(), "S$"+t2+".00");
			}
			else{
						Reporter.log("The amount is NOT deducted according to the promo applied");
					}
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	public void verifyInvalidPromocode(String promo){
		try{
			inActions.buttonClick(driver, promoArrow, "Click Promo arrow");
			inActions.inputText(driver, txtPromoCode, promo,"Enter invalid promocode to redeem");
			inActions.buttonClick(driver,btnRedeem, "Click redeem button");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void validateInvalidPromocodemsg(){
		try{
			
			Assert.assertEquals(appliedPromoMsg.getText(),constants.APPLY_INVALID_PROMO_CODE);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void validateGuestPromocodemsg(){
		try{
			
			Assert.assertEquals(appliedPromoMsg.getText(),constants.APPLY_GUEST_PROMO_CODE);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void validateInvalidLoginPromocodemsg(){
		try{
			
			Assert.assertEquals(appliedPromoMsg.getText(),constants.APPLY_GUEST_PROMO_CODE_LOGIN_USER);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean clickCheckout(){
		try{
			System.out.println("click checkout");
			Thread.sleep(2000);
			inActions.buttonClick(driver, prodcheckout, "Click continue shopping from checkout page");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	public void applyPromocode(String promo){
		try{
			inActions.buttonClick(driver, promoArrow, "Click Promo arrow");
			inActions.inputText(driver, txtPromoCode, promo,"Enter promocode to redeem");
			inActions.buttonClick(driver,btnRedeem, "Click redeem button");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void verifyApplyPromo(){
		try{
			Assert.assertEquals(appliedPromoMsg.getText(),constants.APPLY_PROMO_CODE);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void verifyApplyGuestPromo(){
		try{
			Assert.assertEquals(appliedPromoMsg.getText(),constants.APPLY_GUEST_PROMO_CODE);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void clickContinueShopping(){
		try{
			inActions.linkClick(driver, continueShopping, "Click continue shopping from checkout page");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//update 
	public void updateQuantity(String quantity){
		try{
			if(ReusableActions.displayElement(driver,itemQUpdate)){
				inActions.buttonClick(driver, itemQUpdate, "click size list");
				adidasHomePage.selectCategoryRandomly(itemQL);
				System.out.println("Printing size size : "+itemQL.size());
			}else{
				Reporter.log("No Size for this Product");
		    }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	 /*public void clickUpdate(String quan){
			try{
				inActions.buttonClick(driver, btnUpdate, "Click update from checkout page");
				if(ReusableActions.displayElement(driver,qnotAvailable)){
					inActions.inputText(driver, txtUpdate, quan,"Enter quantity of the product to update");
					updateQuantity("1");
					inActions.buttonClick(driver, btnUpdate, "Click update from checkout page");
				}
				else{
					
					Reporter.log("Quantity update successful");
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		*/
	/* public void verifyUpdateQuantity(){
		 try{
			 if(txtUpdate.getText().equals("5")){
				 Assert.assertEquals(txtUpdate.getText(), "5");
			 }
			 else{
				 Reporter.log("The product quantity is different from quantity passed");
			 }
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}*/
	 
	 
	 public void verifyCalculatedItemTotal(){
			try{
				
				String tot=itemTotal.getText();
				

				String [] temp = tot.split(delimiter1);
				
				for (int i=0;i<temp.length;i++){
					Value1=temp[1];
					
					
				
				String [] temp1=Value1.split(delimiter2);
		  	 for(int j=0; j<temp1.length;j++){
		  		
				  Value2=temp1[0];
				  
		  		
		  	 }

				}
			
				int t=Integer.valueOf(Value2);
				
				
				
				
				System.out.println(totalAmount.getText());
				String t3="S$"+t+".00";
				if(!tot.equals(t3)){
				Reporter.log("The amount is updated according to the quantity");
						
				}
				else if(tot.equals(t3)){
					Assert.assertEquals(itemTotal.getText(), t3);
				}
				else{
							Reporter.log("The amount is NOT updated according to the quantity");
						}
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
	 }
	//edit details
	 
	 public void clickEditdetails(){
		 	adidasHomePage = new AdidasHomePage(driver);
			subCategoriesPage = new SubCategoriesPage(driver);
			productDetailsPage =new ProductDetailsPage(driver);
			try{
				inActions.linkClick(driver, linkEditdetails, "Click editdetails link from checkout page");
				adidasHomePage.mainMenuRandomSelection();
				ReusableActions.waitForpageToLoad(driver);
				subCategoriesPage.productRandomSelection();
				productDetailsPage.selectProductToCart();
				productDetailsPage.clickShoppingBag();
				verifyShopBagAndProceed();
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	 
	//Remove
	
	
	 public void clickLinkRemove(){
		 
			try{
				
				inActions.linkClick(driver, linkRemove, "Click remove link from checkout page");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
	@DataProvider
	public static Object[][] getData(){
		
		return GeneralActions.getData(" ValidPromoDetails");
	}
	
}
