package com.volvo.BMS.pagecomponents;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.volvo.BMS.commonutilis.CommonWrapperMethods;

public class Addproject extends CommonWrapperMethods  {
	
	private WebDriver driver;
	
	public Addproject(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	public void addproject(String projectNo ) {
		
		//selecting the project drop-down from Home page
		anyClick("project_dd",By.xpath(prop.getProperty("project_dd")));
		
		//selecting Add Project from the work order drop-down
		anyClick("addproject_dd",By.xpath(prop.getProperty("addproject_dd")));
		
		//Entering value in Project Number field
		sendKeys("prj_no", By.name(prop.getProperty("prj_no")), projectNo);
		
		anyClick("inactive_addproject", By.name(prop.getProperty("inactive_addproject")));
		
		//Saving newly added project
		anyClick("prj_save",By.name(prop.getProperty("prj_save")));
	}
}
	  


				


	

	
