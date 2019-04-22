package com.volvo.BMS.pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.volvo.BMS.commonutilis.CommonWrapperMethods;

public class SessionReport extends CommonWrapperMethods {

	private WebDriver driver;

	public SessionReport(WebDriver driver) {
		this.driver = driver;
	}

	//public void getlogin(String userID, String Password, String ProblemEvent, String preCondition, String action, String observation, String expected) 
	public void addSessionReport(String session_Report_Project_id, String sessionID, String AlertOK, String fuelVolume, String tripFuelConsumption, String avgSpeed, String calculatedFuel, String oilConsumption, String cycles, String comments ) {
		//getlogin(userID, password);
		//sendKeys("user_id", By.name(prop.getProperty("user_id")), userID);
		//sendKeysPassword("pwd", By.name(prop.getProperty("pwd")), Password);
		//anyClick("loginsub_btn", By.name(prop.getProperty("loginsub_btn")));
		System.out.println("Inside Session Report");
		anyClick("session_Report_Project_id", By.xpath(prop.getProperty("session_Report_Project_id")));
		anyClick("sessionID", By.id(prop.getProperty("sessionID")));
		sendKeys("fuelVolume", By.id(prop.getProperty("fuelVolume")), fuelVolume);
		sendKeys("tripFuelConsumption", By.xpath(prop.getProperty("tripFuelConsumption")), tripFuelConsumption);
		sendKeys("avgSpeed", By.xpath(prop.getProperty("avgSpeed")), avgSpeed);
		sendKeys("calculatedFuel", By.xpath(prop.getProperty("calculatedFuel")), calculatedFuel);
		sendKeys("oilConsumption", By.xpath(prop.getProperty("oilConsumption")), oilConsumption);
		sendKeys("cycles", By.xpath(prop.getProperty("cycles")), cycles);
		sendKeys("comments", By.id(prop.getProperty("comments")), comments);
		anyClick("save", By.xpath(prop.getProperty("save")));
		
	}
}
