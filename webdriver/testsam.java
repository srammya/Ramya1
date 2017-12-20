

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testsam {
//	@Parameters("browser")
	@Test
	
	public void grid() throws MalformedURLException{
//		System.out.println(browser);
		DesiredCapabilities cap= DesiredCapabilities.firefox();
//		DesiredCapabilities cap= DesiredCapabilities.internetExplorer();
//		DesiredCapabilities cap= DesiredCapabilities.chrome();
		cap.setBrowserName("firefox");
	cap.setPlatform(Platform.ANY);
		RemoteWebDriver driver=new RemoteWebDriver(new URL("https://login.yahoo.com/config/login_verify2?&.src=ym&.intl=us"), cap);
		
		
		
		/////
		/*
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(DesiredCapabilities.internetExplorer().getBrowserName());
		URL url = new URL("http://localhost:4441/grid/register");
//		RemoteWebDriver driver = new RemoteWebDriver(url, capabilities);
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:5566/wd/hub"), capabilities);*/
		driver.get("https://mail.google.com/intl/en/mail/help/about.html");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("gmail-sign-in")).click();
		driver.findElement(By.id("Email")).sendKeys("seleniumcoach");
		driver.findElement(By.id("Passwd")).sendKeys("selenium411");
//		driver.quit();
		
	}

}
