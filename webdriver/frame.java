import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class frame {
 
       /**
       * @param args
       * @throws InterruptedException 
        */
       public static void main(String[] args) throws InterruptedException {
              WebDriver driver=new FirefoxDriver();
              driver.navigate().to("http://www.firstcry.com");
              driver.findElement(By.id("loginID")).click();
              System.out.println("Opening Login Form");
              Thread.sleep(10000);
              driver.switchTo().frame("iframe_Login");
              System.out.println("Frame Located");
              driver.findElement(By.id("Login1_UserName")).sendKeys("Seleniumcoach@gmail.com");
              System.out.println("Type Successful");
              driver.switchTo().defaultContent();
              driver.findElement(By.className("closebig")).click();
 
       }
 
}
