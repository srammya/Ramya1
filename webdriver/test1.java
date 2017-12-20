

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class test1 {


	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new FirefoxDriver();
//	wd.get("http://gmail.com");
		wd.navigate().to("http://gmail.com");
//		driver.findElement(By.xpath("//*[@id='topicItem']")).sendKeys("Conversion, Area");
		/*wd.findElement(By.id("Email")).sendKeys("seleniumcoach");
		wd.findElement(By.id("Passwd")).sendKeys("selenium411");
		wd.findElement(By.id("Passwd")).sendKeys(Keys.ENTER);//simulates the key press event of the Enter button*/
		
		wd.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[3]/div[3]/p/a")).click();
		
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@id='maia-header']/div/h1/a")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@id='maia-header']/div/h1/a")).sendKeys(Keys.PAGE_UP);
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@id='maia-header']/div/h1/a")).sendKeys(Keys.BACK_SPACE);
		
		/*wd.findElement(By.id("signIn")).click();
		List<WebElement> che=wd.findElements(By.id("PersistentCookie"));
		System.out.println(che.get(0).getAttribute("value"));
		System.out.println(che.get(0).getAttribute("checked"));
		che.get(0).click();
		System.out.println(che.get(0).getAttribute("checked"));
		che.get(0).click();
		System.out.println(che.get(0).getAttribute("checked"));*/
		
		
		
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//*[@id='navPrimary']/ul/li[1]/ul/li[2]/a")).click();
		
	/*	wd.findElement(By.xpath("//*[@id='topicItem']")).sendKeys("Conversion, Area");
//		WebElement dropdown = driver.findElement(By.xpath("//*[@id='topicItem']"));
		List<WebElement> dropoption=wd.findElements(By.tagName("option"));
		for (int i=0;i<dropoption.size();i++)
		{
			System.out.println(dropoption.get(i).getText());
		}
			System.out.println(dropoption.size());*/
			
		
		

	}

}
