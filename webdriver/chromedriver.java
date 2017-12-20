import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class chromedriver {

	
	public static void main(String[] args) throws InterruptedException {
//		WebDriver wd = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rkaliyaperumal\\Desktop\\chromedriver.exe");
		
		WebDriver wd=new ChromeDriver();
		wd.navigate().to("http://icicibank.com/");
		Set<String>winid=wd.getWindowHandles();
		Iterator<String> it=winid.iterator();
		System.out.println(it.next());
		
		wd.findElement(By.xpath("//*[@id='bottom_links_container']/div[3]/p/a[8]")).click();
		System.out.println("----------------After new tab opened---------------");
		winid=wd.getWindowHandles();
		it=winid.iterator();
		String firstwindow=it.next();//window id of the fist window
		String tabwindow=it.next();//window id of the tab window
		//Main tab
				System.out.println(firstwindow);
				//tabbed window
		System.out.println(tabwindow);
	//switch to tab window
		wd.switchTo().window(tabwindow);
		wd.findElement(By.xpath("//*[@id='Webinars']/div[3]/table/tbody/tr[2]/td[2]/a")).click();
		System.out.println("-------------------After new pop up opened--------");
		winid=wd.getWindowHandles();
		it=winid.iterator();
		
		System.out.println(it.next());
		System.out.println(it.next());
		String popup=it.next();
		System.out.println(popup);
		Thread.sleep(20000);
		wd.switchTo().window(popup);
		wd.close();
		wd.switchTo().window(tabwindow);
		wd.close();
		wd.switchTo().window(firstwindow);
		wd.close();
		

	}



}

