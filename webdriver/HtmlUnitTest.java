import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class HtmlUnitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver wd = new HtmlUnitDriver();
		wd.get("http://gmail.com");
//			wd.navigate().to("http://gmail.com");

			wd.findElement(By.xpath("//*[@id='Email']")).sendKeys("seleniumcoach");
			System.out.println("Entered Email");
			wd.findElement(By.xpath("//*[@id='Passwd']")).sendKeys("selenium411");
			System.out.println("Entered Password");
			wd.findElement(By.xpath("//*[@id='signIn']")).click();
			System.out.println("Clicked Signin button");

	}

}
