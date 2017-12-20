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



public class LoginTest extends testcore {
	TestUtil testutil=new TestUtil();
	
//	is executable
	
	@BeforeTest
	public void isSkip(){
		if(!TestUtil.isExecutable("LoginTest")){
			throw new SkipException("Skipping the testcase as the runmode is set as NO");
		}
	}
	@Test(dataProvider="getData")
	public void doLogin(String username,String password){
		try{
		app_logs.debug("Executing Login Test");
		driver.get(config.getProperty("testsite"));
		
		driver.findElement(By.id(object.getProperty("email"))).sendKeys(username);
		driver.findElement(By.id(object.getProperty("enext"))).click();
		
		WebDriverWait wait = new WebDriverWait(driver,30 );
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(object.getProperty("password"))));
		
		driver.findElement(By.xpath(object.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath(object.getProperty("signin"))).click();
		
		}
		catch(Throwable t){ 
			TestUtil.captureScreenshot();
			t.printStackTrace();
	}
	}
	
	@AfterTest
	public void closeBrowser(){
		driver.quit();
	}
@DataProvider
public Object[][] getData(){
	
	return TestUtil.getData("LoginTest");
}
}
