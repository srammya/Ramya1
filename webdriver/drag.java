import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class drag {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement draggable=driver.findElement(By.id("draggable"));
		
		WebElement droppable=driver.findElement(By.id("droppable"));
		
		Actions action =new Actions(driver);
//		action.dragAndDrop(source, target)
		action.dragAndDrop(draggable, droppable).perform();
		Thread.sleep(2000);

	}

}
