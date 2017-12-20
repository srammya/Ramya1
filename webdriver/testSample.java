

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

public class testSample {

	@Test
	
	public void grid() throws MalformedURLException{
		
//		DesiredCapabilities cap= DesiredCapabilities.firefox();
		DesiredCapabilities cap= DesiredCapabilities.internetExplorer();
		cap.setBrowserName("iexplore");
		cap.setPlatform(Platform.ANY);
//	cap.setPlatform(Platform.ANY);
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		
		
		
		
		driver.get("https://login.yahoo.com/config/login_verify2?&.src=ym&.intl=us");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("kp_rammya");
		driver.findElement(By.id("passwd")).sendKeys("ramya");
		driver.findElement(By.id(".save")).click();
		driver.close();
		
	}

}
