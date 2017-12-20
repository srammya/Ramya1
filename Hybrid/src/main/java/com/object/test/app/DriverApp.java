package com.object.test.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.object.action.utils.TestUtil;
import com.object.common.utils.Locatorsparser;
import com.object.common.utils.Xlfile_Reader;
import com.object.test.report.TestReports;

public class DriverApp {

	public static Properties CONFIG;
	public static Properties Objects;
	public static Properties APPTEXT;
	public static Xlfile_Reader Core;
	public static Xlfile_Reader testData = null;
	public static Xlfile_Reader DBresults = null;
	public static Random randomGenerator = new Random(); // Random Port Number
	public static Locatorsparser lparser = null;
	public static String currentTest;
	public static String keyword;
	public static WebDriver driver = null;
	public static String object;
	public static String currentTSID;
	public static String stepDescription;
	public static String proceedOnFail;
	public static String testStatus;
	public static String data_column_name;
	public static int testRepeat;
	public static int nSelPort;
	public static String sSelPort;
	public static Calendar cal = new GregorianCalendar();
	public static int month = cal.get(Calendar.MONTH);
	public static int year = cal.get(Calendar.YEAR);
	public static int sec = cal.get(Calendar.SECOND);
	public static int min = cal.get(Calendar.MINUTE);
	public static int date = cal.get(Calendar.DATE);
	public static int day = cal.get(Calendar.HOUR_OF_DAY);
	public static String strDate;
	public static String result;
	public static String cdir = System.getProperty("user.dir");

	public static String mailresult = " - Script successfully executed - no errors found";
	public static String mailscreenshotpath;
	public static DriverApp propertiesObj = null;
	public static FileInputStream stream;
	public static String RepositoryFile;
	public static Properties propertyFile = null;
	// Added for Report
	public static String reportBasePath = cdir
			+ System.getProperty("file.separator");
	public static File ImageDirectory;

	public static String fsep = System.getProperty("file.separator");
	// moving image to report directory
	File src1 = new File(cdir + System.getProperty("file.separator") + "src" + fsep + "test" + fsep + "resources" + fsep + "logo.png");
	

	
	// Get the current system time - used for generated unique file ids (ex:
	// Screenshots, Reports etc on every test run)
	public static String getCurrentTimeStamp() {
		SimpleDateFormat CurrentDate = new SimpleDateFormat("MM-dd-yyyy" + "_"
				+ "HH-mm-ss");
		Date now = new Date();
		String CDate = CurrentDate.format(now);
		return CDate;
	}

	// Loaded the Selenium and Application log files

	public static final Logger SELENIUM_LOGS = Logger.getRootLogger();
	public static final Logger APPLICATION_LOGS = Logger
			.getLogger("devpinoyLogger");
	
	@BeforeSuite
	@Parameters({ "browser", "appURL" })
	public void startTesting(@Optional("el") String browser,
			@Optional("elm") String appURL) throws Exception {

		try {
			setDriver(browser, appURL);

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}

		// Code to Generate random numbers

		nSelPort = randomGenerator.nextInt(40000);
		strDate = getCurrentTimeStamp();
		System.out.println("date time stamp :" + strDate);
		

		String newDir = reportBasePath + "TestExecutionReport_" + strDate;
		File theDir = new File(newDir);

		// if the directory does not exist, create it
		if (!theDir.exists()) {
			System.out
					.println("creating directory: " + "TestReport_" + strDate);
			boolean result = false;

			try {
				theDir.mkdir();
				result = true;

				//
				// I decided to replace already existing files with same name

			} catch (SecurityException se) {
				// handle it
			}
			if (result) {
				System.out.println("DIR created");
			}
		}

		File imgDir1 = new File(newDir + System.getProperty("file.separator")
				+ "logo.png");
		

		// if the directory does not exist, create it
		if (!imgDir1.exists()) {
			System.out.println("Copying log files");
			boolean result = false;
			try {
				/*
				 * imgDir.mkdir(); result = true; ImageDirectory= imgDir;
				 */

				TestUtil.copyFile(src1, imgDir1);


			}

			catch (SecurityException se) {
				// handle it
			}

			if (result) {
				System.out.println("IMG DIR created");
			}
		}
		// Start testing method will start generating the Test Reports from the
		// beginning

		TestReports.startTesting(newDir + System.getProperty("file.separator")
				+ "TestReport_" + strDate + ".html",
				TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"), "ABC",
				"3.0");

		

		// Loading Config File
		CONFIG = new Properties();
		InputStream fs = new FileInputStream(System.getProperty("user.dir")
				+ System.getProperty("file.separator") + "src" + fsep + "test"
				+ fsep + "resources" + fsep + "config.properties");
		CONFIG.load(fs);

		// LOAD Objects properties File
		
		lparser=new Locatorsparser(System.getProperty("user.dir")
				+ System.getProperty("file.separator") + "src" + fsep + "test"
				+ fsep + "resources" + fsep + "ObjectRepo.properties");
	
//		wordPaste=new ScreenPaste()
	
		// Load datatable
		Core = new Xlfile_Reader(System.getProperty("user.dir")
				+ System.getProperty("file.separator") + "src" + fsep + "test"
				+ fsep + "resources" + fsep + "Core.xlsx");
		testData = new Xlfile_Reader(System.getProperty("user.dir")
				+ System.getProperty("file.separator") + "src" + fsep + "test"
				+ fsep + "resources" + fsep + "TestData.xlsx");

			}

	private void setDriver(String browser, String appURL) {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = initFirefoxDriver(appURL);
			driver.manage().window().maximize();

		}

		else if (browser.equalsIgnoreCase("ie")) {

			

			driver = initIEDriver(appURL);
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("chrome")) {

			driver = initChromeDriver(appURL);
			driver.manage().window().maximize();

		}
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches", "--disable-extensions");
		System.setProperty(
				"webdriver.chrome.driver",
				System.getProperty("user.dir")
						+ System.getProperty("file.separator") + "src" + fsep
						+ "test" + fsep + "resources" + fsep
						+ "chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		System.setProperty(
				"webdriver.gecko.driver",
				System.getProperty("user.dir")
						+ System.getProperty("file.separator") + "src"
						+ fsep + "test" + fsep + "resources" + fsep
						+ "geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initIEDriver(String appURL) {
		System.out.println("Launching IE browser..");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	
	
	
	
	@Parameters({ "runmode"})
	
	// report ends
	@Test
    
    public void testApp() throws Throwable, FileNotFoundException, IOException, InvalidFormatException {

        String startTime = null;

        TestReports.startSuite("Suite 1");

        for (int tcid = 2; tcid <= Core.getRowCount("Suite1"); tcid++) {
            currentTest = Core.getCellData("Suite1", "TCID", tcid);

            // initilize start time of test
            if (Core.getCellData("Suite1", "Runmode", tcid).equals("Y")) {

                // executed the keywords

                // loop again - rows in test data
                int totalSets = testData.getRowCount(currentTest + "1");
                ; // holds total rows in test data sheet. IF sheet does not exist then 2 by default
                if (totalSets <= 1) {
                    totalSets = 2; // run atleast once
                }

                for (testRepeat = 2; testRepeat <= totalSets; testRepeat++) {
                    startTime = TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa");

                    APPLICATION_LOGS.debug("Executing the test " + currentTest);

                    // implemented keywords file
                    try {
                        for (int tsid = 2; tsid <= Core.getRowCount(currentTest); tsid++) {

                            // Get values from xls file

                            keyword = Core.getCellData(currentTest, "Keyword", tsid);
                            object = Core.getCellData(currentTest, "Object", tsid);
                            currentTSID = Core.getCellData(currentTest, "TSID", tsid);
                            stepDescription = Core.getCellData(currentTest, "Decription", tsid);
                            proceedOnFail = Core.getCellData(currentTest, "ProceedOnFail", tsid);
                            data_column_name = Core.getCellData(currentTest, "Data_Column_Name", tsid);

                            Method method = KeywordsApp.class.getMethod(keyword);
                            result = (String) method.invoke(method);
                            APPLICATION_LOGS.debug("***Result of execution -- " + result);

                            // take screenshot - every keyword
                            String fileName = "Suite1_TC" + (tcid - 1) + "_TS" + tsid + "_" + keyword + testRepeat + ".jpeg";
                            // TestUtil.startRecording();


                            if (result.startsWith("Pass")) {
                                testStatus = result;

                               
                                TestUtil.captureScreenshot(cdir+System.getProperty("file.separator")+"Screenshots"+fsep+TestUtil.imageName1+".jpeg");
                                
                               
                                
//                                TestReports.addKeyword(stepDescription, keyword, result, "file:///"+cdir+System.getProperty("file.separator")+"Screenshots"+fsep+TestUtil.imageName1+".jpeg");
                                TestReports.addKeyword(stepDescription, keyword, result, "file:///"+TestUtil.imageName1+".jpeg");

                     	       
                            }

                            else if (result.startsWith("Fail")) {
                                testStatus = result;
                               
                                TestUtil.captureScreenshot(cdir+System.getProperty("file.separator")+"Screenshots"+fsep+TestUtil.imageName1+".jpeg");
                               
                               
                                // changed to make the screenshot path generic
//                                TestReports.addKeyword(stepDescription, keyword, result, "file:///"+cdir+System.getProperty("file.separator")+"Screenshots"+fsep+TestUtil.imageName1+".jpeg");
                                TestReports.addKeyword(stepDescription, keyword, result, "file:///"+TestUtil.imageName1+".jpeg");
                                if (proceedOnFail.equalsIgnoreCase("N")) {

                                    break;

                                }
                                break;

                            }

                        }

                    } catch (Throwable t) {
                        APPLICATION_LOGS.debug("Error came");

                    }

                    // report pass or fail in HTML Report

                    if (testStatus == null) {
                        testStatus = "Pass";
                    }
                    APPLICATION_LOGS.debug("######################" + currentTest + " --- " + testStatus);
                    TestReports.addTestCase(currentTest, startTime, TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"), testStatus);

                    if (result.startsWith("Fail")) {

//                        break;
                    }

                }// test data

            } else {
                APPLICATION_LOGS.debug("Skipping the test " + currentTest);
                testStatus = "Skip";

                // report skipped
                APPLICATION_LOGS.debug("#######################" + currentTest + " --- " + testStatus);
                TestReports.addTestCase(currentTest, TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"), TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"), testStatus);

            }

            testStatus = null;

            if (result.startsWith("Fail")) {
              //  break;
            }

        }
        TestReports.endSuite();
    }

    @AfterSuite
    public static void endScript() throws Exception {

        // Once the test is completed update the end time in HTML report
        TestReports.updateEndTime(TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"));
        
        driver.close();
        driver.quit();

       
    }

}