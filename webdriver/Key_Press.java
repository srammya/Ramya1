

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Key_Press {

	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new FirefoxDriver();
//	wd.get("http://gmail.com");
		wd.navigate().to("https://login.yahoo.com/config/login_verify2?.intl=in&.src=ym");
//		
	/*	wd.findElement(By.id("Email")).sendKeys("seleniumcoach");
		wd.findElement(By.id("Passwd")).sendKeys("selenium411");
		wd.findElement(By.id("Passwd")).sendKeys(Keys.ENTER);//simulates the key press event of the Enter button*/
		
		wd.findElement(By.id("username")).sendKeys("seleniumcoach");
		wd.findElement(By.id("passwd")).sendKeys("selenium411");
		wd.findElement(By.id("passwd")).sendKeys(Keys.ENTER);
		
		/*wd.findElement(By.xpath("//*[@id='maia-header']/div/h1/a")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@id='maia-header']/div/h1/a")).sendKeys(Keys.PAGE_UP);
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@id='maia-header']/div/h1/a")).sendKeys(Keys.BACK_SPACE);*/
}
}