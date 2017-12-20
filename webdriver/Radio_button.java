

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Radio_button {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
			System.out.println("----------radio button----------");
		
		driver.get("http://www.quackit.com/html/codes/html_radio_button.cfm");
		
		
		List<WebElement> radio=driver.findElements(By.name("preferred_color"));

		
			System.out.println(radio.get(1).getAttribute("value"));
			System.out.println(radio.get(1).getAttribute("checked"));
			radio.get(1).click();
			System.out.println(radio.get(1).getAttribute("checked"));
	}

}
