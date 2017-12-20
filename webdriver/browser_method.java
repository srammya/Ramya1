

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class browser_method {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
//System.setProperty("webdriver.ie.driver","C:\\Users\\rkaliyaperumal\\Desktop\\selenium\\IEDriverServer.exe");
		
//		WebDriver driver=new InternetExplorerDriver();
//		WebDriver driver=new FirefoxDriver();
System.setProperty("webdriver.chrome.driver","C:\\Users\\rkaliyaperumal\\Desktop\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("http://google.com");
		driver.findElement(By.xpath("//*[@id='fsl']/a[2]")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		

	}

}
