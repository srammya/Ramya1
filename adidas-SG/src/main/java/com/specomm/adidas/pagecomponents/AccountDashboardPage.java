package com.specomm.adidas.pagecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.specomm.adidas.common.utils.Constants;
import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;

public class AccountDashboardPage {
	
	WebDriver driver;
	String Title,Value;
	Constants constants=new Constants();
	ReusableActions inActions=new ReusableActions();
	
	@FindBy(how = How.XPATH, using = "//ul[@class='messages']")
	public WebElement	msg_Welcome;
	
	@FindBy(how = How.XPATH, using = "html/body/div[1]/div/div[3]/div/div[1]/div/div/ul/li[2]")
	public WebElement	tabAccountInformation;
	
	@FindBy(how = How.ID, using = "firstname")
	public WebElement	textFirstName;
	
	@FindBy(how = How.ID, using = "lastname")
	public WebElement	textLastName;
	
	@FindBy(how = How.ID, using = "email")
	public WebElement	textEmail;
	
	@FindBy(how = How.XPATH, using = "//*[@id='day']")
	public WebElement	lstDay;
	
	@FindBy(how = How.XPATH, using = "//*[@id='month']")
	public WebElement	lstMonth;
	
	@FindBy(how = How.XPATH, using = "//*[@id='year']")
	public WebElement	lstYear;
	
	
	public AccountDashboardPage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	   	}
	 
	
	

	public void verifyThanksMessage(){
		
		try{
			String delimiter = "adidas";
			Title=msg_Welcome.getText();
	    	  
	    	  String [] temp = Title.split(delimiter);
	    	 
	    	  for(int i =0; i < temp.length ; ++i){
	    		  
	    		  Value=temp[++i];
	    		  System.out.println(Value);
	    	  }
			System.out.println(Value+ msg_Welcome.getText());
			Assert.assertEquals(constants.FIRST_ACCOUNT_DASHBOARD +Value, msg_Welcome.getText());
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void verifyAccountInfo(String fName,String lName,String bDay,String bMonth,String bYear,String eMail){
		
		try{
			String mailing=eMail;
			System.out.println("Mailing"+mailing);
			String day=bDay;
			System.out.println("day"+day);
			String month=bMonth;
			System.out.println("month"+month);
			String year=bYear;
			System.out.println("year"+year);
			inActions.buttonClick(driver, tabAccountInformation, "Click Account Information tab from left side of dashboard page");
			
			System.out.println(textFirstName.getAttribute("value"));
			
			if(fName.equals(textFirstName.getAttribute("value"))){
				Assert.assertEquals(textFirstName.getAttribute("value"), fName);
			}
			else{
				Reporter.log("Account information FirstName is not matching");
			}
			
			System.out.println(textLastName.getAttribute("value"));
			
			if(lName.equals(textLastName.getAttribute("value"))){
				Assert.assertEquals(textLastName.getAttribute("value"), lName);
			}
			else{
				Reporter.log("Account information LastName is not matching");
			}
			
			System.out.println(textEmail.getAttribute("value"));
			
			if(textEmail.getAttribute("value").equals(mailing)){
				Assert.assertEquals(textEmail.getAttribute("value"), mailing);
				
			}
			else{
				Reporter.log("Account information Email is not matching");
			}
			Select select1 = new Select(lstDay);
			
			System.out.println(select1.getFirstSelectedOption().getAttribute("value"));
			if(select1.getFirstSelectedOption().getAttribute("value").equals(day)){
				Assert.assertEquals(select1.getFirstSelectedOption().getAttribute("value"), day);
				
			}
			else{
				Reporter.log("Account information DOB day is not matching");
			}
		
			
			Select select2 = new Select(lstMonth);
			System.out.println(select2.getFirstSelectedOption().getAttribute("value"));
			if(select2.getFirstSelectedOption().getAttribute("value").equals(month)){
				Assert.assertEquals(select2.getFirstSelectedOption().getAttribute("value"), month);
				
			}
			else{
				Reporter.log("Account information DOB Month is not matching");
			}
			
			
			Select select3 = new Select(lstYear);
			System.out.println(select3.getFirstSelectedOption().getAttribute("value"));
			if(select3.getFirstSelectedOption().getAttribute("value").equalsIgnoreCase(year)){
				Assert.assertEquals(select3.getFirstSelectedOption().getAttribute("value"), year);
				
			}
			else{
				Reporter.log("Account information DOB Year is not matching");
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	

@DataProvider
public static Object[][] getData(){
	
	return GeneralActions.getData("NewUserCreationFlow");
}

}
