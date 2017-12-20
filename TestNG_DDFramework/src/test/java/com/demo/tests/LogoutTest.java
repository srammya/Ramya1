package com.demo.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.utils.TestUtil;
import com.demo.utils.testcore;


public class LogoutTest extends testcore {
	
	
//	is executable
	@BeforeTest
	public void isSkip(){
		if(!TestUtil.isExecutable("LogoutTest")){
			throw new SkipException("Skipping the testcase as the runmode is set as NO");
		}
	}
	@Test()
	public void doLogout() throws InterruptedException{
		try{
			WebDriverWait wait = new WebDriverWait(driver,30 );
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(object.getProperty("change"))));
		driver.findElement(By.xpath(object.getProperty("change"))).click();
		driver.findElement(By.xpath(object.getProperty("logout"))).click();
		
		}
		catch(Throwable t){ 
			TestUtil.captureScreenshot();
			Assert.assertTrue(false,t.getMessage());
	}
		}
	
	
	@AfterTest
	public void closeBrowser(){
		driver.quit();
	}
}
