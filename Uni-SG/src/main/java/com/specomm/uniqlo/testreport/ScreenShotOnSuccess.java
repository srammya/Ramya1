package com.specomm.uniqlo.testreport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.specomm.uniqlo.common.utils.GeneralActions;

public class ScreenShotOnSuccess extends TestListenerAdapter {
	
 @Override
 public void onTestFailure(ITestResult result) {
  WebDriver driver = GeneralActions.getDriver();
  if(driver!=null){
   System.out.println("Snapshot for: " + result.getMethod().getMethodName());
  File file=new File("Screenshot_File");
  if(!result.isSuccess()){
   File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       //Needs Commons IO library
       try {
         FileUtils.copyFile(scrFile, new File(file.getAbsolutePath()+ "/screenshot/shot_" + result.getMethod().getMethodName()  + "()" + ".jpg")); 
         } 
       catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
     Reporter.setCurrentTestResult(result);
     }
  }
  }
 }
