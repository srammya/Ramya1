

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class webtable {

/**
* @param args
*/
static WebDriver driver=new FirefoxDriver();
static String Value;
public static void main(String[] args) throws InterruptedException {
driver.get("https://www.irctc.co.in");
driver.findElement(By.id("usernameId")).sendKeys("sramya2");
driver.findElement(By.name("j_password")).sendKeys("karanthai");

Thread.sleep(30000);
 driver.findElement(By.id("loginbutton")).click();
 driver.findElement(By.id("jpform:fromStation")).sendKeys("CHENNAI CENTRAL - MAS");
 driver.findElement(By.id("jpform:toStation")).sendKeys("NELLORE - NLR"); driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[4]/div/div[3]/div/form/table/tbody/tr[3]/td[2]/input")).sendKeys(Keys.TAB);
 driver.findElement(By.id("jpform:journeyDatePopup")).click();
 
 WebElement dateWidget = driver.findElement(By.id("jpform:journeyDateContent"));  
 List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
 List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
   
 for (WebElement cell: columns){  
    
  if (cell.getText().equals("13")){  
	  Actions action=new Actions(driver);
	  action.build().perform();
	  cell.click();
	 	 
  break;  
  }  
 }  
driver.findElement(By.xpath("html/body/div[3]/div[1]/div[4]/div/div[3]/div/form/table/tbody/tr[12]/td/input[1]")).click();


 
WebElement Webtable=driver.findElement(By.id("avlAndFareForm:trainbtwnstns")); // Replace TableID with Actual Table ID or Xpath

List<WebElement> TotalRowCount=Webtable.findElements(By.tagName("tr"));

System.out.println("No. of Rows in the WebTable: "+TotalRowCount.size());
String tname= "JAN SHATABDI";
for(WebElement rowElement:TotalRowCount)
{
List<WebElement> TotalColumnCount=rowElement.findElements(By.tagName("td"));
     
for(WebElement colElement:TotalColumnCount)
{
if (colElement.getText().equals(tname))
{           
System.out.println("*******Text Found " );
System.out.println(rowElement.getText());
rowElement.findElement(By.linkText("2S")).click();


break;   

}
}
}
driver.findElement(By.linkText("Book Now")).click();
}
}