import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class sample_Ajax1 {

	static WebDriver driver=new FirefoxDriver();
	public static String value;
	
	public boolean exist(String xpath){
		boolean present;
		
		try{
			driver.findElement(By.xpath(xpath));
			present=true;
		}
	catch(NoSuchElementException e){
		
		present=false;
	}
	return present;
	}
	public static void main(String[] args) {
		int text;
		ArrayList<String> mylist=new ArrayList<String>();
		sample_Ajax1 obj=new sample_Ajax1();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("http://www.macys.com/");
		int x=1;
		while(obj.exist("html/body/ul/li["+ x +"]/a/div")){
			value=driver.findElement(By.xpath("html/body/ul/li["+ x +"]/a/div")).getText();
			mylist.add(value);
			x++;
		}
		text=mylist.size();
			for(int i=0;i<text;i++){
				driver.findElement(By.id("globalSearchInputField")).sendKeys(mylist.get(i));
				driver.findElement(By.id("subnavSearchSubmit")).click();
				driver.navigate().to("http://www.macys.com/");
				
			}
		}
	}


