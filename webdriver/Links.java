

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Links {

	
	
	public static void main(String[] args) throws Exception {

		WebDriver driver=new FirefoxDriver();
		
		
			
			
		System.out.println("-----------------links from webpage--------------");

		driver.get("https://www.paypal.com/in/cgybin/cmd=_login-run");
		
		driver.findElement(By.xpath("//*[@id='navPrimary']/ul/li[1]/ul/li[2]/a")).click();
		Thread.sleep(10000);
		WebElement links= driver.findElement(By.xpath("//*[@id='page']"));
		List<WebElement> alllinks=driver.findElements(By.tagName("a"));
		for(int i=0;i<alllinks.size();i++)
		{
			System.out.println(alllinks.get(i).getText());
			
		}
		
		System.out.println(alllinks.size());
	}
}