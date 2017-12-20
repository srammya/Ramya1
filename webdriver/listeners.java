

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class listeners {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		
		EventFiringWebDriver eventdriver=new EventFiringWebDriver(driver);
		call_listerner listener=new call_listerner();
		eventdriver.register(listener);
		
		
		eventdriver.navigate().to("http://google.com");
		
		
		eventdriver.findElement(By.xpath("//*[@id='fsl']/a[2]")).click();
		Thread.sleep(2000);
		eventdriver.navigate().back();
		Thread.sleep(2000);
		eventdriver.navigate().forward();
		
	}

}
