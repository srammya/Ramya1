import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class readfromtable
{
    public void fn_table() throws Exception
{
    FirefoxDriver fd=new FirefoxDriver();
    fd.get("url of web");
    WebElement  t=fd.findElement(By.id("tableid"));
    List<WebElement> rows = t.findElements(By.tagName("tr"));
   
    for(WebElement r:rows)
    {
      List<WebElement> cols=r.findElements(By.tagName("td"));
      for(WebElement c:cols)
      {
    System.out.println(c.getText());
      }
    }
   
}
}