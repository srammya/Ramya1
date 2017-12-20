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
import com.sinpost.isam.pages.TelecomPayment;




public class TelecomPaymentTest extends GeneralActions  {
	
	static WebDriver driver;
	GeneralActions bPayment=new GeneralActions();
	TestListener testListener=new TestListener();
	
	TelecomPayment telecomPayment;
	BillPayment billPayment; 
	
	@BeforeClass
	
	public void setup() throws IOException{
		
		  driver = getDriver();
		  driver = launchBrowser(driver, "firefox");
		  telecomPayment=PageFactory.initElements(driver,TelecomPayment.class);
		  billPayment=PageFactory.initElements(driver,BillPayment.class);
		  ReusableActions.loadPropFileValues();
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
	}

	 @Test(priority=1,dataProviderClass=TelecomPayment.class, dataProvider="getData")
	 
	 public void telComBillPayment(String acctNo,String amt) throws Exception{
		 testListener.startRecording();
		 billPayment.clickBillPayment();
		 Thread.sleep(3000);
		 billPayment.clickTeleCom();
		 Thread.sleep(3000);
		 telecomPayment.clickSingTel();
		 Thread.sleep(3000);
		 telecomPayment.clickTelBillPayment();
		 Thread.sleep(3000);
		 telecomPayment.verifyHeading();
		 Thread.sleep(3000);
		 telecomPayment.inputAccountNo(acctNo);
		 telecomPayment.inputAmountPaid(amt);
		 telecomPayment.clickDoneButton();
		 Thread.sleep(3000);
		 telecomPayment.closeAlert();
		 telecomPayment.amountValidate(acctNo,amt);
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
