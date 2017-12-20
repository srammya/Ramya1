


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class drop_down {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://webmath.com");
		
//		-----dropdown-----
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='topicItem']")).sendKeys("Conversion, Area");
		WebElement dropdown = driver.findElement(By.xpath("//*[@id='topicItem']"));
		List<WebElement> dropoption=driver.findElements(By.tagName("option"));
		for (int i=0;i<dropoption.size();i++)
		{
			System.out.println(dropoption.get(i).getText());
		}
			System.out.println(dropoption.size());
			

	}

}
