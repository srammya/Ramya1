package com.volvo.BMS.pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.volvo.BMS.commonutilis.CommonWrapperMethods;

public class Addreport extends CommonWrapperMethods {
	private WebDriver driver;

	public Addreport(WebDriver driver) {
		this.driver = driver;	
	}
	public void addreport(String problemEventTitle, String AlertOK, String preCondition, String action,String observation, String expected) {
	anyClick("project_id", By.xpath(prop.getProperty("project_id")));
	anyClick("report_id", By.id(prop.getProperty("report_id")));
	anyClick("SaveSubmit", By.xpath(prop.getProperty("SaveSubmit")));
	if(isAlertPresent(AlertOK) == true) {
	sendKeys("problemEventTitle", By.xpath(prop.getProperty("problemEventTitle")), problemEventTitle);
	sendKeys("preCondition", By.xpath(prop.getProperty("preCondition")), preCondition);
	sendKeys("action", By.xpath(prop.getProperty("action")), action);
	sendKeys("observation", By.xpath(prop.getProperty("observation")), observation);
	sendKeys("expected", By.xpath(prop.getProperty("expected")), expected);
	anyClick("selectFunction", By.xpath(prop.getProperty("selectFunction")));
	anyClick("functionGroup", By.xpath(prop.getProperty("functionGroup")));
	anyClick("functionGroupOk", By.xpath(prop.getProperty("functionGroupOk")));
	selectRadioButtonByValue("severity", By.name(prop.getProperty("severity")), "2");
	//anyClick("frequency", By.xpath(prop.getProperty("frequency")));
	selectDropDownValue("frequency",By.xpath(prop.getProperty("frequency")),"Once");
	anyClick("SaveSubmit", By.xpath(prop.getProperty("SaveSubmit")));
		}
		else {
			System.out.println("Alertfailed");
		}
}
}