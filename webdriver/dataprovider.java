
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider {

	
		//This method will provide data to any test method that declares that its Data Provider  

		//is named "test1"  

		@DataProvider(name = "test1")  

		public Object[][] createData1() {  

		 return new Object[][] {  

		   { "user1","password1"},  

		   { "user2","password2"},
		   { "user3","password3"},
		   { "user4","password4"},
		   

		 };  

		}  

		   

		//This test method declares that its data should be supplied by the Data Provider  

		//named "test1"  

		@Test(dataProvider = "test1")

		public void verifyData1(String un, String pw) throws InterruptedException {
			WebDriver wd=new FirefoxDriver();
			wd.get("https://login.yahoo.com/config/login_verify2?&.src=ym&.intl=us");
//		
			Thread.sleep(2000);
			wd.findElement(By.id("username")).sendKeys(un);
			wd.findElement(By.id("passwd")).sendKeys(pw);
			wd.findElement(By.id(".save")).click();
			wd.close();
		 System.out.println(un + " " + pw);  

		} 




		
	}

