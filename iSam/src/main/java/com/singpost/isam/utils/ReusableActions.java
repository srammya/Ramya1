package com.singpost.isam.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.singpost.isam.exception.ElementNotEditable;
import com.singpost.isam.exception.ElementNotVisible;


public class ReusableActions {
	public static Properties propConfigFile;
	public static WebDriver driver;
	public static WebElement element;
	public static int timeoutsec=60;
	public static Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	public static GeneralActions gActions = new GeneralActions();
	public static String msgText;
	public static String fsep=System.getProperty("file.separator");
	
	
	/**
	 * Description:This function clicks the button object.
	 * @param Webdriver , WebElement, msg
	 */
	
	public void buttonClick(WebDriver driver, WebElement element, String msg){
		log4jlogger.debug(msg);
		try{
			if(element.getText()!=null){
				msgText = element.getText();}
			else{
				msgText = element.getTagName();}				
			
			if(element.isDisplayed() && element.isEnabled()){
					try{
						element.click();
						log4jlogger.debug("	Clicked on " + msgText + " button");
					}
					catch(WebDriverException webex){
						String message = webex.getMessage();
						if(message.toLowerCase().contains("unknown error".toLowerCase())){
							element.click();
						}else{
							log4jlogger.debug("Button can't be Clicked ");
							throw webex;}
					}
				}else{
					
					throw new ElementNotEditable("Button[WebElement] is non Editable : " );
			}
			log4jlogger.debug("In " + driver.getTitle() + " page, Clicked on :" + msgText + " button field.");
			}
			catch(Throwable thr){
			if(thr instanceof ElementNotVisible){
				String message = "In " + driver.getTitle() + " page, " + msgText + " button field is not visible."; 
				log4jlogger.debug(message, thr);
				throw new ElementNotVisible(message, thr);
			}else if(thr instanceof ElementNotEditable){
				String message = "In " + driver.getTitle() + " page, " + msgText + " button field is not editable.";
				log4jlogger.debug(message, thr);
				throw new ElementNotEditable(message, thr);
			
			}
		}		
	}

	/**
	 * Description:This function selects the value from drop box object.
	 * @param Webdriver , WebElement, Value
	 */
	
	public void selectValueFromDropdown(WebDriver driver, WebElement element , String valToBeSelected, String msg){
		log4jlogger.debug(msg);
		try{
			if(element.getText()!=null){
				msgText = element.getText();}
			else{
				msgText = element.getTagName();}
		//	List <WebElement> options = driver.findElements(By.tagName("option"));
			Select selectOption = new Select(element);
			
			    		
			    		selectOption.selectByValue(valToBeSelected);
			    						    	
			log4jlogger.debug("In " + driver.getTitle() + " page, Select : " + valToBeSelected + " for " + msgText + " from dropdown field field.");
			
		}catch(NoSuchElementException nex){
			String message = "In " + driver.getTitle() + " page, " + msgText + " is not present."; 
			log4jlogger.error(message, nex);
			
			throw new NoSuchElementException(message, nex);
		}catch(Throwable thr){
			if(thr instanceof ElementNotVisible){
				String message = "In " + driver.getTitle() + " page, " + msgText + " textbox field is not visible."; 
				log4jlogger.error(message, thr);
				throw new ElementNotVisible(message, thr);
			}else if(thr instanceof ElementNotEditable){
				String message = "In " + driver.getTitle() + " page, " + msgText + " textbox field is not editable.";
				log4jlogger.debug(message, thr);
				throw new ElementNotEditable(message, thr);
			}else{
				String message = "In " + driver.getTitle() + " page, Got some exception while performing action " + msgText + " textbox field.";
				log4jlogger.error(message,  thr);
				
				throw new RuntimeException(message, thr);
			}
		}
	}
	
	/**
	 * Description:This function sets the value passed in an edit/text box object.
	 * @param Webdriver , WebElement, Value, msg
	 */
	
			
	public void inputText(WebDriver driver, WebElement element , CharSequence value, String msg){
		log4jlogger.debug(msg);
		try{
			if(element.getText()!=null){
				msgText = element.getText();}
			else{
				msgText = element.getTagName();}
			element.clear();
			element.sendKeys(value);
			log4jlogger.debug("In " + driver.getTitle() + " page, entered the value : " + value + " for " + msgText + " textbox field.");
		}catch(NoSuchElementException nex){
			String message = "In " + driver.getTitle() + " page, " + msgText + " is not present."; 
			log4jlogger.debug(message, nex);
			
			throw new NoSuchElementException(message, nex);
		}catch(Throwable thr){
			if(thr instanceof ElementNotVisible){
				String message = "In " + driver.getTitle() + " page, " + msgText + " textbox field is not visible."; 
				log4jlogger.debug(message, thr);
				throw new ElementNotVisible(message, thr);
			}else if(thr instanceof ElementNotEditable){
				String message = "In " + driver.getTitle() + " page, " + msgText + " textbox field is not editable.";
				log4jlogger.debug(message, thr);
				throw new ElementNotEditable(message, thr);
			}else{
				String message = "In " + driver.getTitle() + " page, Got some exception while performing action " + msgText + " textbox field.";
				log4jlogger.debug(message,  thr);
				
				throw new RuntimeException(message, thr);
			}
		}
	}
	
	public static void loadPropFileValues() throws IOException
	   {
		 String configFilePath = System.getProperty("user.dir")+ File.separator +"src"+ File.separator +"test" + File.separator + "resources"+ File.separator +"Config.properties";
		 System.out.println("configpath::::::::" + configFilePath);
		 propConfigFile = new Properties();
		 InputStream inputStream = null;
		 inputStream = new FileInputStream(configFilePath);
		 propConfigFile.load(inputStream);
    }
	
	/**
	 *  Get value from Configuration property file
	 * @param key
	 * @return
	 * @throws IOException
     */
	 public static String getPropFileValues(String key) throws IOException 
	  {
		 String value = propConfigFile.getProperty(key);
                 return value;
	  }
	 
	 
	 public static void openUrl(WebDriver driver,String url)
	 {
		 driver.navigate().to(url);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 
	 }

	 
}
