

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Handling_Frame {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver=new FirefoxDriver();
//		 WebDriver driver=new InternetExplorerDriver();
		driver.navigate().to("http://www.firstcry.com");
//		Thread.sleep(1000);
		
		
		Set<String>winid=driver.getWindowHandles();
		Iterator<String> it=winid.iterator();
	
		String mainwindow=it.next();
		
//		driver.findElement(By.id("ctl00_LoginView2")).click();
		driver.switchTo().frame("iframeCode" );
		driver.findElement(By.id("firstname")).sendKeys("Selenium");
		driver.switchTo().window(mainwindow);
		driver.findElement(By.xpath("//*[@id='modal']/div[1]/div[1]/div")).click();
		System.out.println("sucessfully closed the frame");

	}

}
