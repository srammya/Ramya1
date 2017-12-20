

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class javaexecutor {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20000,TimeUnit.SECONDS);
		driver.navigate().to("http://www.espncricinfo.com/");
		
		Thread.sleep(30000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("mopen('m0')");
		driver.findElement(By.xpath("//*[@id='mgDdRht']/tbody/tr[2]/td/a")).click();
		System.out.println("clicked");
		
//		WebElement menu=driver.findElement(By.xpath(mainmenu));
//		WebElement smenu=driver.findElement(By.xpath(submenu));
//		Actions action=new Actions(driver);
//		action.moveToElement(menu).perform();
//		Thread.sleep(2000);
//		smenu.click();
	}

}
