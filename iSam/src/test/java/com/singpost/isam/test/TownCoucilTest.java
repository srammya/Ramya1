package com.singpost.isam.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.singpost.isam.report.TestListener;
import com.singpost.isam.utils.GeneralActions;
import com.singpost.isam.utils.ReusableActions;
import com.sinpost.isam.pages.BillPayment;
import com.sinpost.isam.pages.TownCouncilPayment;

public class TownCoucilTest extends GeneralActions {

	static WebDriver driver;
	GeneralActions bPayment=new GeneralActions();
	TestListener testListener=new TestListener();
	
	TownCouncilPayment townCouncilPayment;
	BillPayment billPayment; 
	
	@BeforeClass
	
	public void setup() throws IOException{
		
		  driver = getDriver();
		  driver = launchBrowser(driver, "firefox");
		  townCouncilPayment=PageFactory.initElements(driver,TownCouncilPayment.class);
		  billPayment=PageFactory.initElements(driver,BillPayment.class);
		  ReusableActions.loadPropFileValues();
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
	}
	
	
 @Test(priority=1,dataProviderClass=TownCouncilPayment.class, dataProvider="getData")
	 
	 public void townCBillPayment(String nric,String enq) throws Exception{
	 testListener.startRecording();
	 billPayment.clickBillPayment();
	 Thread.sleep(3000);
	 billPayment.clickTownCouncil();
	 Thread.sleep(3000);
	 townCouncilPayment.clickTOLBill();
	 Thread.sleep(3000);
	 townCouncilPayment.clickAngMoKio();
	 Thread.sleep(3000);
	 townCouncilPayment.dropSelectAcct(nric);
	 Thread.sleep(3000);
	 townCouncilPayment.inputEnquiry(enq);
	 Thread.sleep(3000);
	 townCouncilPayment.clickDoneButton();
	 townCouncilPayment.entryValidate(nric, enq);
	 testListener.stopRecording();
	 
 }

 
 @AfterClass
	public static void quitDriver()  {
	 try{
		 
		 
		 driver.quit();
		 }
		  catch (Exception e) {
		 e.printStackTrace();
		 }
	
}
 
}
