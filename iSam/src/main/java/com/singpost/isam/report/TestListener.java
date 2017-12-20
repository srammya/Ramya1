package com.singpost.isam.report;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.singpost.isam.utils.GeneralActions;
import com.singpost.isam.utils.SpecializedScreenRecorder;



public class TestListener extends TestListenerAdapter {

	WebDriver driver;
	String testClassName;
	private static String fileSeperator = System.getProperty("file.separator");
	private ScreenRecorder screenRecorder;
	private static String dir = System.getProperty("user.dir");

	// @Override
	public static String getCurrentTimeStamp() {
		SimpleDateFormat CurrentDate = new SimpleDateFormat("MM-dd-yyyy" + "_"
				+ "HH-mm-ss");
		Date now = new Date();
		String CDate = CurrentDate.format(now);
		return CDate;
	}

	public void onTestFailure(ITestResult result) {
		Reporter.log("***** Error " + result.getName()
				+ " test has failed *****", true);

		driver = GeneralActions.getDriver();

		String testClassName = getTestClassName(result.getName()).trim();

		String testMethodName = result.getName().toString().trim();
		String screenShotName = testMethodName + getCurrentTimeStamp() + ".png";

		if (driver != null) {
			String imagePath = fileSeperator + "Screenshots" + fileSeperator
					+ "Results" + fileSeperator + testMethodName + fileSeperator
					+ takeScreenShot(driver, screenShotName, testMethodName);

			Reporter.log(
					"<a href="
							+ dir
							+ imagePath
							+ "><img src="
							+ dir
							+ imagePath
							+ " style=width:100px;height:100px;/> screenshot </a><br/>",
					true);
		}	
	}

	public static String takeScreenShot(WebDriver driver,
			String screenShotName, String testClassName) {
		try {
			File file = new File("Screenshots" + fileSeperator + "Results");
			if (!file.exists()) {
				Reporter.log("File created " + file, true);
				file.mkdir();
			}

			File screenshotFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			File targetFile = new File("Screenshots" + fileSeperator
					+ "Results" + fileSeperator + testClassName, screenShotName);
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

		Reporter.log("***** " + result.getName() + " test has Passed *****",
				true);

		driver = GeneralActions.getDriver();

		testClassName = getTestClassName(result.getName()).trim();

		String testMethodName = result.getName().toString().trim();
		String screenShotName = testMethodName + getCurrentTimeStamp() + ".png";

		if (driver != null) {
			String imagePath = fileSeperator + "Screenshots" + fileSeperator
					+ "Results" + fileSeperator + testMethodName + fileSeperator
					+ takeScreenShot(driver, screenShotName, testMethodName);
			// + getCurrentTimeStamp());	
			Reporter.log(
					"<a href="
							+ dir
							+ imagePath
							+ "><img src="
							+ dir
							+ imagePath
							+ " style=width:100px;height:100px;/> screenshot </a><br/>",
					true);
		}

	}

	
	
	
	public void onTestSkipped(ITestResult result) {

		Reporter.log("***** Error " + result.getName()
				+ " test has Skipped *****", true);

	}

	public String getTestClassName(String testName) {
		String[] reqTestClassname = testName.split("\\.");
		int i = reqTestClassname.length - 1;
		Reporter.log("Test Name : " + reqTestClassname[i], true);
		return reqTestClassname[i];
	}
	
	
	public void startRecording() throws Exception
    {    
           File file = new File(System.getProperty("user.dir"));
                         
           Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
           int width = screenSize.width;
           int height = screenSize.height;
                          
           Rectangle captureSize = new Rectangle(0,0, width, height);
                          
         GraphicsConfiguration gc = GraphicsEnvironment
            .getLocalGraphicsEnvironment()
            .getDefaultScreenDevice()
            .getDefaultConfiguration();

        this.screenRecorder = new SpecializedScreenRecorder(gc, captureSize,
            new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
            new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                 CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                 DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                 QualityKey, 1.0f,
                 KeyFrameIntervalKey, 15 * 60),
            new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
                 FrameRateKey, Rational.valueOf(30)),
            null, file, "iSam");
       this.screenRecorder.start();
    
    }

    public void stopRecording() throws Exception
    {
      this.screenRecorder.stop();
    }
    
    
    public void onTestStart(ITestResult result) {   
    	driver = GeneralActions.getDriver();

		testClassName = getTestClassName(result.getName()).trim();

		String testMethodName = result.getName().toString().trim();
		String screenShotName = testMethodName + getCurrentTimeStamp() + ".png";

		if (driver != null) {
			String imagePath = fileSeperator + "Screenshots" + fileSeperator
					+ "Results" + fileSeperator + testMethodName + fileSeperator
					+ takeScreenShot(driver, screenShotName, testMethodName);
			// + getCurrentTimeStamp());	
			Reporter.log(
					"<a href="
							+ dir
							+ imagePath
							+ "><img src="
							+ dir
							+ imagePath
							+ " style=width:100px;height:100px;/> screenshot </a><br/>",
					true);
		}
		
    }
	 
}
