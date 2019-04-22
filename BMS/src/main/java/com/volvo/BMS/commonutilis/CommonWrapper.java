package com.volvo.BMS.commonutilis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonWrapper {
			public static WebDriver driver;
			//public WebDriverWait wait = new WebDriverWait(driver,50);
			//browserLaunch swait = new browserLaunch();
	
public static WebDriver getdriver(){
		if(driver==null){
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://bms.qa.volvocars.net");
			driver.manage().window().maximize();
			return driver;
			}
		else {
			return driver;
	 		 }
	}
}
