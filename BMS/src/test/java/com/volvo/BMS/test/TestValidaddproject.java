package com.volvo.BMS.test;

import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import com.volvo.BMS.pagecomponents.Loginpage;

public class TestValidaddproject extends TestBase{
		
	private WebDriver driver;
	
	Loginpage loginpage=new Loginpage(driver);
	
	@Test(dataProvider="TestDataProvider")
		
       public void BMS_Homepage(LinkedHashMap<String,String>testData)
	{
		loginpage.getlogin(testData.get("userID"),testData.get("Password"));	  
	}
	   
	/*@Test(dataProvider="TestDataProvider",priority=2)

	public void addproject_Session_Report(LinkedHashMap<String,String>testData) 
	{
	//loginpage.getlogin(testData.get("userID"),testData.get("Password"));
//	loginpage.getlogin(testData.get("userID"),testData.get("Password"),testData.get("problemEventTitle"),testData.get("preCondition"),testData.get("action"),testData.get("observation"), testData.get("expected"));
	sessreport.addSessionReport(testData.get("session_Report_Project_id"), testData.get("sessionID"),testData.get("AlertOK"),testData.get("fuelVolume"),testData.get("tripFuelConsumption"), testData.get("avgSpeed"),testData.get("calculatedFuel"),testData.get("oilConsumption"), testData.get("cycles"), testData.get("comments"));
	}
	
	@Test(dataProvider="TestDataProvider",priority=3)
	
	public void Driver_Reporting(LinkedHashMap<String,String>testData) 
	{
	//loginpage.getlogin(testData.get("userID"),testData.get("Password"));
	driverReport.Driver_Reporting(testData.get("regField"), testData.get("problemEventTitle"), testData.get("AlertOK"), testData.get("preCondition"), testData.get("action"), testData.get("observation"), testData.get("expected"));
	}
	
	@Test(dataProvider="TestDataProvider",priority=4)
	public void Open_Report(LinkedHashMap<String,String>testData) 
	{
	//loginpage.getlogin(testData.get("userID"),testData.get("Password"));
	openReport.Open_Report(testData.get("AlertOK"));
	}
	*/
		
}
