package com.volvo.BMS.test;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.volvo.BMS.pagecomponents.Loginpage;
import com.volvo.BMS.pagecomponents.SessionReport;

public class SessionReportValidate extends TestBase{
		
	private WebDriver driver;
	
	SessionReport loginpage=new SessionReport(driver);
	@Test(dataProvider="TestSessionDataProvider")
			
       public void addproject_Session_Report(LinkedHashMap<String,String>testData) 
	{
		//loginpage.getlogin(testData.get("userID"),testData.get("Password"),testData.get("problemEventTitle"),testData.get("preCondition"),testData.get("action"),testData.get("observation"), testData.get("expected"));
	   loginpage.addSessionReport(testData.get("AlertOK"),testData.get("session_Report_Project_id"), testData.get("sessionID"),testData.get("fuelVolume"),testData.get("tripFuelConsumption"), testData.get("avgSpeed"),testData.get("calculatedFuel"),testData.get("oilConsumption"), testData.get("cycles"), testData.get("comments"));
    }
	
	/*@Test(dataProvider="TestSessionDataProvider")
	
    public void addproject_test_Session_Report(LinkedHashMap<String,String>testSessionData) {
		//loginpage.getlogin(testData.get("userID"),testData.get("Password"),testData.get("problemEventTitle"),testData.get("preCondition"),testData.get("action"),testData.get("observation"), testData.get("expected"));
	   loginpage.getlogin(testSessionData.get("userID"),testSessionData.get("Password"));
	   sessreport.addSessionReport(testSessionData.get("userID"),testSessionData.get("Password"),testSessionData.get("session_Report_Project_id"), testSessionData.get("sessionID"), testSessionData.get("fuelVolume"), testSessionData.get("tripFuelConsumption"), testSessionData.get("avgSpeed"), testSessionData.get("calculatedFuel"), testSessionData.get("oilConsumption"),testSessionData.get("cycles"),testSessionData.get("comments"));
}*/
}