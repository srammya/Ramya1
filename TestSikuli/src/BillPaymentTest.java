import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;





public class BillPaymentTest {
	static WebDriver driver;
BillPaymentPage billPaymentPage;

	 @BeforeMethod(alwaysRun = true) 
	  public void beforeMethod(Method method) {
		 WebDriver driver=new FirefoxDriver();
		 driver.get("http://192.168.21.172:8080/ISAMNew/");
		 driver.manage().window().maximize();
		 billPaymentPage = PageFactory.initElements(driver, BillPaymentPage.class);
		  
		 

}
	 
	 @Test()
	 public void billPayTest() throws FindFailed, InterruptedException{
		 billPaymentPage.clickbillPayment();
		 billPaymentPage.clickTelco();
		 billPaymentPage.clickSingtel();
		 billPaymentPage.clickTelcoBills();
		 billPaymentPage.inputAcountNo();
		 billPaymentPage.inputAmount();
		 Thread.sleep(2000);
		 billPaymentPage.clickDone();
		 billPaymentPage.alert();
	 }
	 
	 
}