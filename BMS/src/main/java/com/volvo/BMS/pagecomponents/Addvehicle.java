package com.volvo.BMS.pagecomponents;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.volvo.BMS.commonutilis.CommonWrapperMethods;

public class Addvehicle extends CommonWrapperMethods  {
	
	private WebDriver driver;
	
	public Addvehicle(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	public void addvehicle(String fuelId) {
		
		//selecting the vehicle drop-down from Home page
		anyClick("vehicle_drpdown",By.xpath(prop.getProperty("vehicle_drpdown")));
		
		//selecting Add Vehicle from the work order drop-down
		anyClick("addvehicle_drpdwn",By.xpath(prop.getProperty("addvehicle_drpdwn")));
		
		//saving the vehicle
		anyClick("veh_save",By.name(prop.getProperty("veh_save")));
		
		if(verifyAlertText("Fuel_alert") == true) {
			System.out.println("Expected alert present:");
		//if(isAlertPresent("AlertOK")){
			selectDropDownByIndex("fuel_dropdown" ,By.name(prop.getProperty("fuel_dropdown")), fuelId);
			//selectDropDownValue("fuel_dropdown", By.name(prop.getProperty("fuel_dropdown")), fuelId);	
		}
		else {
			System.out.println("Alert not present");
		}
	}
}
	  


				


	

	
