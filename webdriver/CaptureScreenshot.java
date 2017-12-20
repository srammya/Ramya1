

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CaptureScreenshot {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		WebDriver driver=new FirefoxDriver();
		
		driver.get("http://gmail.com");
		 
		File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		
		 FileUtils.copyFile(srcFile, new File("C:\\Users\\rkaliyaperumal\\Documents\\selenium\\err.jpg"));
		 
		 try
		 {
		 driver.findElement(By.xpath("//*[@id='signn']"));
		 }
		 catch(Throwable t){
			 FileUtils.copyFile(srcFile, new File("C:\\Users\\rkaliyaperumal\\Documents\\selenium\\err1.jpg"));

		 }
			 
		 }
		 
		 

	}


