package com.specomm.uniqlo.testreport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;

import com.specomm.uniqlo.common.utils.GeneralActions;


public class TestListener extends TestListenerAdapter {
	WebDriver driver;
	public static String testClassName,  testMethodName,  screenShotName;
	private static String fileSeperator = System.getProperty("file.separator");

	private static String dir = System.getProperty("user.dir");


	

	public static String getCurrentTimeStamp() {
		SimpleDateFormat CurrentDate = new SimpleDateFormat("MM-dd-yyyy" + "_"
				+ "HH-mm-ss");
		Date now = new Date();
		String CDate = CurrentDate.format(now);
		return CDate;
	}
	
	 public static String takeScreenShot(WebDriver driver,
				String screenShotName, String testName) {
		
			try {
				

				File file = new File("Screenshots" + fileSeperator + "Results");
				if (!file.exists()) {
					Reporter.log("File created " + file, true);
					file.mkdir();
					System.out.println("Dir created");
				}
				   
		          driver=GeneralActions.getDriver();
	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	File targetFile = new File(dir+fileSeperator+"Screenshots" + fileSeperator + "Results" + fileSeperator + testName, screenShotName);
				FileUtils.copyFile(screenshotFile, targetFile);

				return screenShotName;
				
			} catch (Exception e) {
				Reporter.log(
						"An exception occured while taking screenshot "
								+ e.getCause(), true);
				return null;
			}
			
			
			
		}
	 
	 public void onTestSuccess(ITestResult result) {

		
		}
	
	


	public String getTestClassName(String testName) {
		String[] reqTestClassname = testName.split("\\.");
		int i = reqTestClassname.length - 1;
		System.out.println("Test Name : " + reqTestClassname[i]);
		Reporter.log("Test Name : " + reqTestClassname[i], true);
		return reqTestClassname[i];
	}

//	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("***** " + result.getInstanceName() + " test has Passed *****",
				true);


		
		 testClassName = getTestClassName(result.getInstanceName()).trim();

		testMethodName = result.getName().toString().trim();
		screenShotName = testMethodName + getCurrentTimeStamp() + ".png";
		
		
	
	}
		
	

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	

	 
	
}
