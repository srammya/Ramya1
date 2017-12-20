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
		
		driver.get("http://shop.adidas.com.sg");
		driver.findElement(By.xpath("html/body/div[1]/div/div[6]/div[1]/div[1]/a[1]")).click();
		
		File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		
		 FileUtils.copyFile(srcFile, new File("C:\\Users\\v-ramya.k\\Desktop\\err.jpg"));
		 
		/* try
		 {
		 driver.findElement(By.cssSelector("a.h-login-lin"));
		 }
		 catch(Throwable t){
			 FileUtils.copyFile(srcFile, new File("C:\\Users\\v-ramya.k\\Desktop\\err.jpg"));

		 }*/
			 
		 }
		 
		 

	}
