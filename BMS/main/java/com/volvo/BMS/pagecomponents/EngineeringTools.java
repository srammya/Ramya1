package com.volvo.BMS.pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.volvo.BMS.commonutilis.CommonWrapperMethods;

public class EngineeringTools extends CommonWrapperMethods {
	private WebDriver driver;

	public EngineeringTools(WebDriver driver) {
		this.driver = driver;	
	}
	public void EngineeringTools(String regNO, String AlertOK, String chassisNo, String preCondition, String POid,String mainType, String VINno, String issueType) {
	anyClick("project_id", By.xpath(prop.getProperty("project_id")));
	anyClick("report_id", By.id(prop.getProperty("report_id")));
	anyClick("SaveSubmit", By.xpath(prop.getProperty("SaveSubmit")));
	if(isAlertPresent(AlertOK) == true) {
	sendKeys("regNO", By.xpath(prop.getProperty("regNO")), regNO);
	sendKeys("preCondition", By.xpath(prop.getProperty("preCondition")), preCondition);
	sendKeys("chassisNo", By.xpath(prop.getProperty("chassisNo")), chassisNo);
	sendKeys("preCondition", By.xpath(prop.getProperty("preCondition")), preCondition);
	sendKeys("POid", By.xpath(prop.getProperty("POid")), POid);
	sendKeys("mainType", By.xpath(prop.getProperty("mainType")), mainType);
	sendKeys("VINno", By.xpath(prop.getProperty("VINno")), VINno);
	sendKeys("issueType", By.xpath(prop.getProperty("issueType")), issueType);	
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