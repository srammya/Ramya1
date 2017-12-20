

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class captcha {
	
//static String ad="+";
//static String su="-";
static int t;
String op=null;
	public static void main(String[] args) {
		String ad="+";
		WebDriver driver=new FirefoxDriver();
		driver.navigate().to("http://timesofindia.indiatimes.com/pollopinions/11769367.cms");
		
		String text=driver.findElement(By.xpath("//*[@id='mathq']")).getText();
		System.out.println(text);
		System.out.println(text.substring(0,2));
		System.out.println(text.substring(3,4));
		String op=text.substring(3,4);
		System.out.println(text.substring(5,6));
		
		int a=Integer.parseInt(text.substring(0,2));
		int b=Integer.parseInt(text.substring(5,6));
		
		if(op.equals(ad)){
			
			 System.out.println(t=a+b);
		}
		
		else {
			System.out.println(t=a-b);
		}
			
		
		
//		System.out.println(t);
		String total=String.valueOf(t);
		driver.findElement(By.xpath("//*[@id='mathuserans']")).sendKeys(total);
		System.out.println(text + total);
	

}
}
