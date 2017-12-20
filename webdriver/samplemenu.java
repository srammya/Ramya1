import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class samplemenu {
                static WebDriver driver = new FirefoxDriver();
                public static String value;
                
                public boolean exist(String xpath)
                {
                                boolean present;
                                try {
                                   driver.findElement(By.xpath(xpath));
                                   present = true;
                                } catch (NoSuchElementException e) {
                                   present = false;
                                }
                                return present;
                }
 
                public static void main(String[] args) {
                                int text;
                                ArrayList<String> mylist = new ArrayList<String>();;
                                samplemenu obj = new samplemenu();
                                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                                driver.navigate().to("http://www.ebay.in/");
 
                                driver.findElement(By.xpath("//*[@id='globalSearchInputField']"))
                                                                .sendKeys("Shoes");
                               
                                int x = 1;
                                                while (obj.exist("html/body/div[3]/div/div[1]/div[1]/ul/li["+x+"]/a")) 
                                                {
                                                
                                                                value = driver.findElement(
                                                                                                By.xpath("html/body/div[3]/div/div[1]/div[1]/ul/li["+x+"]/a")).getText();
                                                                System.out.println(value);
                                                                mylist.add(value);
                                                
                                                                x++;
                                                }
                                                text = mylist.size();
                                                for (int i = 0; i < text; i++) 
                                                {
                                                                driver.findElement(
                                                                                                By.xpath("//*[@id='globalSearchInputField']"))
                                                                                                .sendKeys(mylist.get(i));
                                                                driver.findElement(By.name("KEYWORD_GO_BUTTON")).click();
                                                                driver.navigate().to("http://www.macys.com/");
                                                }
 
                }
}
