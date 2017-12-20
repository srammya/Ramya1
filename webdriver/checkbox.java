

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class checkbox {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new FirefoxDriver();
//		wd.get("http://gmail.com");
			wd.navigate().to("http://www.checkbox.com/pricing/FreeTrial_Online/b77306d3a87e417eb639517e1d013f6d");

			wd.findElement(By.xpath("//*[@id='MainContent__email']")).sendKeys("seleniumcoach@gmail.com");
			wd.findElement(By.xpath("//*[@id='MainContent__password']")).sendKeys("selenium411");
			wd.findElement(By.xpath("//*[@id='MainContent__accountName']")).sendKeys((" http://ACCOUNTNAME.checkboxonline.com"));

			List<WebElement> che=wd.findElements(By.xpath("//*[@id='MainContent__ckbxSLA']"));
			System.out.println(che.get(0).getAttribute("value"));
			System.out.println(che.get(0).getAttribute("checked"));
			che.get(0).click();
			System.out.println(che.get(0).getAttribute("checked"));
		Thread.sleep(2000);
		che.get(0).click();

	}

}
