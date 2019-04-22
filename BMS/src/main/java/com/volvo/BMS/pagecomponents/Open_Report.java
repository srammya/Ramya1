package com.volvo.BMS.pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.volvo.BMS.commonutilis.CommonWrapperMethods;

public class Open_Report extends CommonWrapperMethods {
	private WebDriver driver;

	public Open_Report(WebDriver driver) {
		this.driver = driver;	
	}
	public void Open_Report(String AlertOK) {
	anyClick("open_reporting", By.xpath(prop.getProperty("open_reporting")));
	anyClick("openReportID", By.id(prop.getProperty("openReportID")));
	if(isAlertPresent(AlertOK) == true) {
	//anyClick("save&submit", By.xpath(prop.getProperty("save&submit")));
		}		else {
			System.out.println("Alertfailed");
		}
	anyClick("save_submit", By.xpath(prop.getProperty("save_submit")));
}
}