package com.singpost.isam.utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;



public class GeneralActions {
	//private static PropertyReader pr = new PropertyReader(Constants.sPropertiesPath+Constants.sConfigFileName);
		public static Logger log4jlogger =Logger.getLogger("devpinoyLogger");
		public static String fsep=System.getProperty("file.separator");
		public static Xlfile_Reader excel=new Xlfile_Reader(System.getProperty("user.dir")+fsep+"src"+fsep+"test"+fsep+"resources"+fsep+"testdata"+fsep+"InputData.xlsx");
		public static WebDriver driver;
		
		
		public static WebDriver getDriver() {
			return driver;
		}

		/**
		 * @return Returns the current working directory path.
		 */
		public static String getWorkingDir(){
			String workingDir = "";
			try{
				workingDir = new File(".").getCanonicalPath();
			}catch(IOException io){
				io.printStackTrace();
			}
			return workingDir;
		}
		
		public static WebDriver launchBrowser(WebDriver driver, String browserType){

			log4jlogger.debug("Instantiating the driver :" + browserType);
			
			if (browserType.equalsIgnoreCase(Constants.sBrowserFirefox)){
				log4jlogger.debug("Browser to launch is firefox..");				
				
				FirefoxProfile profile = new FirefoxProfile();
				profile.setEnableNativeEvents(true);
				driver = new FirefoxDriver(profile);				
				driver.manage().window().maximize();
				log4jlogger.debug("Browser launched is firefox and maximized..");
			}
			
			else if(browserType.equalsIgnoreCase(Constants.sBrowserIe)) {
			System.setProperty("webdriver.ie.driver", (System.getProperty("user.dir")+fsep+"src"+fsep+"test"+fsep+"resources"+fsep+"IEDriverServer.exe"));
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();	
			log4jlogger.debug("Browser launched is IE and maximized..");
			log4jlogger.debug("launching the "+browserType+" browser");
			}
			
			else if(browserType.equalsIgnoreCase(Constants.sBrowserChrome)){
				System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+fsep+"src"+fsep+"test"+fsep+"resources"+fsep+"chromedriver.exe"));
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			log4jlogger.debug("launching the "+browserType+" browser");
			}				
			getBrowserVersion(driver);
			return driver;
		}

		private static String getBrowserVersion(WebDriver driver){
			String browserVersion = ((RemoteWebDriver) driver).getCapabilities().getVersion();
			return browserVersion;
		}
		
		/**
		 * @return Returns true if element is enabled, else return false. 
		 */
		public boolean isElementEnabled(WebElement element) {
			return element.isEnabled();
		}
		
		
		
				
		public void implicitWaitWithTime(WebDriver driver) {
			try {		
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				log4jlogger.debug("Implicit wait for given time : 200");} 
			catch (Exception e) {
				log4jlogger.error("Exception encountered while waiting");
				e.printStackTrace();
			}
			System.out.println("Long wait completed");
		}
		
		
		
		
		
		//Reading the data from the excel file
			public static Object[][] getData(String sheetName){
				int rows=excel.getRowCount(sheetName)-1;
				if(rows<=0){
					Object data[][]=new Object[1][0];
					return data;
				}
//				String sheetName="LoginTest";
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

}
