

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class call_listerner extends AbstractWebDriverEventListener {
	
	public void afterClickOn(WebElement element, WebDriver eventdriver){
		
		System.out.println("Object Clicked");
		
	}
	public void afterNavigateForward(WebDriver driver){
		System.out.println("Forward Clicked");
	}

}
