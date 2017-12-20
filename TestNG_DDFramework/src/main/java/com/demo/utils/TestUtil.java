package com.demo.utils;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;





public class TestUtil extends testcore {
	
	public static boolean isExecutable(String tcid){
		for (int rownum=2; rownum<=excel.getRowCount("test_suite"); rownum++){
			if(excel.getCellData("test_suite","tcid",rownum).equals(tcid)){
				if(excel.getCellData("test_suite","runmode", rownum).equals("Y")){
					return true;
				}
				else {
					return false;
				}
			}
			
		
		}
		
		return false;
	}
	//Reading the data from the excel file
	public static Object[][] getData(String sheetName){
		int rows=excel.getRowCount(sheetName)-1;
		if(rows<=0){
			Object data[][]=new Object[1][0];
			return data;
		}
//		String sheetName="LoginTest";
		rows =excel.getRowCount(sheetName);//Get Row Count
		int cols=excel.getColumnCount(sheetName);//Get Col Count
		Object data[][]=new Object[rows-1][cols];//-1
		for (int rowNum=2;rowNum<=rows;rowNum++){//2
			for(int colNum=0;colNum<cols;colNum++){
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
				
			}
		}
		return data;
	}
	
public static void captureScreenshot(){
	Calendar cal=new GregorianCalendar();
	int month=cal.get(Calendar.MONTH);//10
	int year=cal.get(Calendar.YEAR);//2014
	int sec=cal.get(Calendar.SECOND);
	int min=cal.get(Calendar.MINUTE);
	int date=cal.get(Calendar.DATE);
	int day=cal.get(Calendar.HOUR_OF_DAY);
	
	File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try{
		String mailscreenshotpath=System.getProperty("user.dir")+"\\screenshots\\"+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_"+sec+".jpeg";
		FileUtils.copyFile(srcFile, new File(mailscreenshotpath));
	}catch (IOException e){
		e.printStackTrace();
	}
		
	}


public void implicitWaitWithTime(WebDriver driver) {
	try {		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		log4jlogger.debug("Implicit wait for given time : 200");
		} 
	catch (Exception e) {
//		log4jlogger.error("Exception encountered while waiting");
		e.printStackTrace();
	}
	System.out.println("Long wait completed");
}



}


