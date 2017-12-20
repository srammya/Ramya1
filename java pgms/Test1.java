package com.demo.sample;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
//		WebDriver driver=new FirefoxDriver();
/*//		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\"+"IEDriverServer.exe");
		
//		WebDriver driver=new InternetExplorerDriver();
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\"+"chromedriver.exe");

		WebDriver driver=new ChromeDriver();*/
		WebDriver driver=new HtmlUnitDriver();
		/* Logger logger = Logger.getLogger("");
		  logger.setLevel(Level.OFF);*/
		driver.get("http://google.co.in");
		System.out.println("Browser Launched");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='sb_ifc0']")).sendKeys("Selenium");
//		driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
		System.out.println("done");
		driver.close();

	}

}
