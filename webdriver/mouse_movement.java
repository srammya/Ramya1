import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.internal.EventFiringMouse;

public class mouse_movement {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		EventFiringWebDriver eventdriver=new EventFiringWebDriver(driver);
		call_listerner listener=new call_listerner();
		eventdriver.register(listener);
		
		EventFiringMouse mouse=new EventFiringMouse(eventdriver,listener);
		eventdriver.navigate().to("http://google.com");
		Thread.sleep(2000);
		Locatable hoverItem=(Locatable)eventdriver.findElement(By.xpath("//*[@id='gb']/div[1]/div[1]/div[1]/div[2]/a"));
		Coordinates co=hoverItem.getCoordinates();
		
		try{
			mouse.mouseMove(co);
			
		}
		catch(Exception e){
			
		}
		System.out.println("Mouse Hover Found");
		Thread.sleep(2000);
	}

}
