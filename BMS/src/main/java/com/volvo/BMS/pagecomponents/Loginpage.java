package com.volvo.BMS.pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.volvo.BMS.commonutilis.CommonWrapperMethods;

public class Loginpage extends CommonWrapperMethods {

	private WebDriver driver;

	@Test
	public Loginpage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getlogin(String userID, String Password){

		anyClick("bms_home_url", By.xpath(prop.getProperty("bms_home_url")));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("test");
		sendKeys("bms_user_id_name", By.name(prop.getProperty("bms_user_id_name")), "yuvaraj");
		sendKeysPassword("bms_user_password_name", By.name(prop.getProperty("bms_user_password_name")), "test");
		anyClick("bms_login_button", By.id(prop.getProperty("bms_login_button")));
		
	}
}
