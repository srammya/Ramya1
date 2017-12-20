

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webtable {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		int total=0;
		WebDriver driver=new FirefoxDriver();
		driver.navigate().to("http://www.cricbuzz.com/cricket-scorecard-archives/scorecard/10719");
        Thread.sleep(3000);
//        driver.manage().timeouts().implicitlyWait(20000,TimeUnit.SECONDS);
   //row data & row count
		String xp_rstart = "//*[@id='Inngs_1']/div[3]/div[";
		String xp_rend = "]/div[1]";
		Thread.sleep(5000);
		int rownum=0;
		for(int i=1;i<=11;i++){
			String rdet=driver.findElement(By.xpath(xp_rstart + i + xp_rend)).getText();
			rownum++;
			System.out.println(rdet);
		}
		System.out.println("Row count is:"+rownum);
		
		//Column count & column data
		
		String xp_cstart = "//*[@id='Inngs_1']/div[3]/div[1]/div[";
		String xp_cend = "]";
		int colnum=0;
		for(int i=1;i<=7;i++){
			String cdet=driver.findElement(By.xpath(xp_cstart + i + xp_cend)).getText();
			colnum++;
			System.out.println(cdet);
		}
		System.out.println("column count is:"+colnum);
		
		//Extract all data from the table
		String xp_tstart = "//*[@id='Inngs_1']/div[3]/div[";
		String xp_tmid="]/div[";
		String xp_tend = "]";
		for(int row=1;row<=rownum;row++){
			for(int col=1;col<=colnum;col++){
			String tdet=driver.findElement(By.xpath(xp_tstart + row + xp_tmid+ col
					+ xp_tend)).getText();
			System.out.println(tdet);
			
			}
			
			}
	}

}
