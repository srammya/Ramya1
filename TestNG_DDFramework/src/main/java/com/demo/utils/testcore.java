package com.demo.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


	public class testcore {
		/*
		 * Initialize Properties, xls, creating  db connection,generating logs, initialaizing the webdriver
		 */

		
		public static Properties config=new Properties();
		public static Properties object=new Properties();
		public static Xlfile_Reader excel=null;
		public static WebDriver driver=null;
		public static Logger app_logs=Logger.getLogger("devpinoylogger");
		
		
		@BeforeSuite
		public static void init() throws IOException{
			if(driver==null){
				//Loading config property File
				FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
				config.load(file);
				app_logs.debug("Loadig the config properties file");
//				Loading oject property File
				file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\object.properties");
				object.load(file);
				app_logs.debug("Loadig the object properties file");
				excel=new Xlfile_Reader(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\testdata.xlsx"); 
				app_logs.debug("Loadig the Excel file");
				
				if(config.getProperty("browser").equals("firefox")){
					System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\geckodriver.exe");
					driver=new FirefoxDriver();
					
				}
				else if(config.getProperty("browser").equals("ie")){
					System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\IEDriverServer.exe");
					driver=new InternetExplorerDriver();
				}
				else if(config.getProperty("browser").equals("chrome")){
					System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromediver.exe");
					 ChromeOptions options = new ChromeOptions();
					  options.addArguments("chrome.switches", "--disable-extensions");
//					  WebDriver driver=new ChromeDriver(options);
					driver=new ChromeDriver(options);
				}
			
				//implict wait
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				driver.get(config.getProperty("testsite"));
			}
		
		}
		@AfterSuite
		public static void quitDriver() throws AddressException, MessagingException {
//		driver.quit();
		
		
		
	}


}
