import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ajax_call {
	public static void main(String[] args) throws InterruptedException  {
		WebDriver driver=new FirefoxDriver();
		driver.navigate().to("http://www.google.com");
		
		driver.findElement(By.xpath("//*[@id='gbqfq']")).sendKeys("Selenium");
//		Thread.sleep(3000);
		
		int x=1;
		try{
		while(true){
			
			String value=driver.findElement(By.xpath("//*[@id='gsr']/table/tbody/tr/td[2]/table/tbody/tr["+x+"]/td/div/table/tbody/tr[1]/td[1]/span")).getText();
			System.out.println(value);
			x++;
			
			}
		
		}catch(Throwable e){
		
					System.out.println("End of list");
		
			
		}
	}
}
