import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class sample_menu1 {

	static WebDriver driver=new FirefoxDriver();
	public static void main(String[] args) throws IOException {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.navigate().to("http://www.macys.com/");
		String mainmenu="flexLabel_22672";
		String submenu="flexLabel_7495";
		WebElement menu=driver.findElement(By.id(mainmenu));
		WebElement smenu=driver.findElement(By.id(submenu));
		Actions action=new Actions(driver);
		action.moveToElement(menu).perform();
		smenu.click();
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,new File("C:screen\\err.jpg"));
		
		

	}

}
