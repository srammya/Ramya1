

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class handle_javascript {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new FirefoxDriver();
		
			wd.navigate().to("http://rediff.com");
			Thread.sleep(3000);
			wd.findElement(By.xpath("//*[@id='signin_info']/a[1]")).click();
			Thread.sleep(3000);
			wd.findElement(By.xpath("//*[@id='btn_login']")).click();
			
			Alert alert=wd.switchTo().alert();
			  System.out.println(alert.getText());
			alert.accept();
			

	}

}
