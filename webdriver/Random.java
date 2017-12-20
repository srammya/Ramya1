import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Random {
 public String baseURL = "http://demo.lateralcode.com/css-drop-down-menus/";
// public WebDriver driver = new FirefoxDriver();
 public WebDriver driver=new ChromeDriver();
 
 public Actions action = new Actions(driver);
 public List<WebElement> elements;
 public int size;

 @BeforeTest
 public void launchBrowser()
 {
  driver.get(baseURL);
 }

 @AfterTest
 public void closeBrowser()
 {
  driver.quit();
 }

 @Test
 public void test() throws InterruptedException
 {
 System.setProperty("webdriver.chrome.driver","C:\\Users\\rkaliyaperumal\\Desktop\\chromedriver.exe");
  WebElement home = driver.findElement(By.linkText("Home"));
  WebElement about = driver.findElement(By.linkText("About"));
  WebElement contact = driver.findElement(By.linkText("Contact"));
 
  action.moveToElement(home).build().perform();//MouseOver of Menu 
  driver.findElement(By.xpath("//*[@id='menu']/ul/li[1]/ul/li[1]/a")).click(); //Clicking Sub Menu
  Thread.sleep(3000);
  elements = driver.findElements(By.xpath(".//*[@id='menu']/ul/li[1]/ul/li/a"));
  for (WebElement element : elements) {
   System.out.println(element.getText());
  }
 
  action.moveToElement(about).build().perform();//MouseOver of Menu 
  driver.findElement(By.xpath("//*[@id='menu']/ul/li[2]/ul/li[1]/a")).click(); //Clicking Sub Menu
  Thread.sleep(3000);
  elements = driver.findElements(By.xpath(".//*[@id='menu']/ul/li[2]/ul/li/a"));
  for (WebElement element : elements) {
   System.out.println(element.getText());
  }
 
  action.moveToElement(contact).build().perform();//MouseOver of Menu 
  driver.findElement(By.xpath("//*[@id='menu']/ul/li[3]/ul/li[1]/a")).click(); //Clicking Sub Menu
  Thread.sleep(3000);
  elements = driver.findElements(By.xpath(".//*[@id='menu']/ul/li[3]/ul/li/a"));
  for (WebElement element : elements) {
   System.out.println(element.getText());
  }
 }
}