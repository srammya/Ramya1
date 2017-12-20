                                  

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Menubar {


	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new FirefoxDriver();
		driver.navigate().to("http://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		String mainmenu="//*[@id='fk-mainhead-id']/div[2]/div/div[1]/ul/li[1]";
		
		String submenu="//*[@id='menu-electronics-tab-0-content']/ul[1]/li[2]/a";
		WebElement menu=driver.findElement(By.xpath(mainmenu));
		WebElement smenu=driver.findElement(By.xpath(submenu));
		Actions action=new Actions(driver);
		
		action.moveToElement(menu).perform();
				
		Thread.sleep(2000);
		smenu.click();
		Thread.sleep(2000);
		
		
	}

}
