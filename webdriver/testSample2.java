

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testSample2 {
	@Parameters("browser")
	
	@Test(dataProvider="dp1")
//	@Test
	
//	public void grid(String browser) throws MalformedURLException{
	public void grid(String username,String password,String browser) throws MalformedURLException{
		System.out.println(browser);
//		DesiredCapabilities cap= DesiredCapabilities.internetExplorer();
		DesiredCapabilities cap= null;
				if(browser.equals("firefox")){
					cap=DesiredCapabilities.firefox();
					cap.setBrowserName("firefox");
					cap.setPlatform(Platform.ANY);
				}
				
				else if(browser.equals("chrome")){
					cap=DesiredCapabilities.chrome();
					cap.setBrowserName("chrome");
					cap.setPlatform(Platform.ANY);
				}
				else if(browser.equals("iexplore")){
					cap=DesiredCapabilities.internetExplorer();
					cap.setBrowserName("iexplore");
					cap.setPlatform(Platform.WINDOWS);
				}
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.get("https://login.yahoo.com/config/login_verify2?&.src=ym&.intl=us");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("passwd")).sendKeys(password);
		driver.findElement(By.id(".save")).click();
//		driver.quit();
		
	}
	@DataProvider(name = "dp1",parallel=true)  

	public Object[][] createData1() {  

	 return new Object[][] {  

	   {"seleniumcoach","selenium411","firefox"},  

	   {"selenium","selenium411","iexplore"},
	   {"seleniumcoach2","selenium411","chrome"}
	   
	   

	 };
	
	}
}
