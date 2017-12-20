package com.object.test.app;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.object.common.utils.Xlfile_Reader;

public class KeywordsApp extends DriverApp {

    public static Random randomGenerator = new Random();
    public static Calendar cal = new GregorianCalendar(); // used for adding current date in variable and then used in paths
    public static int date = cal.get(Calendar.DATE); // used for adding current date in variable and then used in paths
    public static int month = cal.get(Calendar.MONTH); // used for adding current date in variable and then used in paths
    public static int year = cal.get(Calendar.YEAR); // used for adding current date in variable and then used in paths
    public static int sec = cal.get(Calendar.SECOND); // used for adding current date in variable and then used in paths
    public static int day = cal.get(Calendar.HOUR_OF_DAY); // used for adding current date in variable and then used in paths
    public static int hour = cal.get(Calendar.HOUR); // used for adding current date in variable and then used in paths
    public static int min = cal.get(Calendar.MINUTE); // used for adding current date in variable and then used in paths
    public static String sMin = new Integer(randomGenerator.nextInt(60)).toString(); // Converted Integer value to String and then used in paths
    public static String sSec = new Integer(randomGenerator.nextInt(60)).toString(); // Converted Integer value to String and then used in paths
    public static String sHour = new Integer(randomGenerator.nextInt(24)).toString(); // Converted Integer value to String and then used in paths
    public static String sDate = new Integer(date).toString(); // Converted Integer value to String and then used in paths
    public static String upload = System.getProperty("user.dir");
   public static String call_id; // Used in GetText() and DBQuerycheck() to store the call id to be used for Eval UI
    public static String sUser = null;
    public static String sUser_Name;
    public static Xlfile_Reader datareader = null;
    public static Xlfile_Reader datawriter = null;
    public static String objectType;// = oa.doObjectAnalysis(object);
    public static float round;
    public static float round1;
    public static int i = 0;
    public boolean acceptNextAlert = true;
    public static String script_error = null;
    public static int globalwait;
    public static int value;

   
     public static String setText() throws IOException {
        APPLICATION_LOGS.debug("Executing select Keyword");

        // extract the test data
         String data =testData.getCellData(currentTest, data_column_name , testRepeat);

       
        	
        	try {
    			
        		WebElement text=driver.findElement(lparser.getobjectLocator((object)));
        		text.sendKeys(data);
    		          

        } catch (NoSuchElementException e) {
            // report error
            APPLICATION_LOGS.debug("No Element Found to enter text -" + object + e.getMessage());

            return "Fail" ;
            	
        }

        return "Pass";
    }
    
    /*public static String clickButton() throws IOException {
        APPLICATION_LOGS.debug("Executing select Keyword");

      
       
        	
        	try {
        		
    		  
        		WebElement button=driver.findElement(lparser.getobjectLocator((object)));
        		button.click();
//        		Assert.assertEquals(driver.findElement(By.xpath("html/body/div[3]/div/div/div[2]/div[1]/div[1]/div[1]/span[1]")),"Nikhil");
        		
        } catch (NoSuchElementException e) {
            // report error
            APPLICATION_LOGS.debug("No Element Found to click -" + object + e.getMessage());

            return "Fail" ;
            	
        }

        return "Pass";
    }*/
    
     public static String clickButton() {
         APPLICATION_LOGS.debug("Executing clickButton Keyword");

         try {
        		WebElement button=driver.findElement(lparser.getobjectLocator((object)));
       	    JavascriptExecutor jsExecutor =(JavascriptExecutor) driver;
   			jsExecutor.executeScript("arguments[0].focus;",button);
   			jsExecutor.executeScript("arguments[0].click();",button);
          

         } catch (Throwable t) {
             // report error
             APPLICATION_LOGS.debug("Error while clicking on Button -" + object + t.getMessage());
             return "Fail - " + t.getMessage();
         }

         return "Pass";
     }
    public static String enter() throws IOException {
        APPLICATION_LOGS.debug("Executing select Keyword");

      
       
        	
        	try {
        		
    		  
        		WebElement enter=driver.findElement(lparser.getobjectLocator((object)));
        		enter.sendKeys(Keys.ENTER);
        		
        		
//        		Assert.assertEquals(driver.findElement(By.xpath("html/body/div[3]/div/div/div[2]/div[1]/div[1]/div[1]/span[1]")),"Nikhil");
        		
        } catch (NoSuchElementException e) {
            // report error
            APPLICATION_LOGS.debug("No Element Found to click -" + object + e.getMessage());

            return "Fail" ;
            	
        }

        return "Pass";
    }
    
    

    public static String navigatePage() throws Exception  {
        APPLICATION_LOGS.debug("Executing select Keyword");

      
        //String data =testData.getCellData(currentTest, data_column_name , testRepeat);
        	
        	try {
        		WebElement ele=driver.findElement(lparser.getobjectLocator((object)));
        		
        		System.out.println(ele.getText());
        		if(ele.getText().equalsIgnoreCase("Your email-password doesn't match! Please try again.")){
        			return "Fail" ;	
        		}
        		/*else{
        			return "Pass";
        		}
    		     */    		
//        		Assert.assertEquals(ele.getText(),"ele.getText()");
        		
        } catch (NoSuchElementException e) {
            // report error
            APPLICATION_LOGS.debug("No Element Found to click -" + object + e.getMessage());

            return "Fail" ;
            	
        }

        return "Pass";
    }

    
    public static String getText() {
        APPLICATION_LOGS.debug("Executing select Keyword");

                	
        	try {
        		
    		  
        		driver.findElement(lparser.getobjectLocator((object))).getText();

        } catch (NoSuchElementException e) {
            // report error
            APPLICATION_LOGS.debug("No Text found -" + object + e.getMessage());

            return "Fail" ;
            	
        }

        return "Pass";
    }

   
    public static String errorpage() {
        APPLICATION_LOGS.debug("Executing select Keyword");

                	
        	try {
        		
    		  
        		WebElement error_page = driver.findElement(lparser.getobjectLocator((object)));
        		error_page.getText();
        		        		

        } catch (NoSuchElementException e) {
            // report error
            APPLICATION_LOGS.debug("No Text found -" + object + e.getMessage());

            return "Fail" ;
            	
        }

        return "Pass";
    }

    
    public static String checkBox() {
        APPLICATION_LOGS.debug("Executing select Keyword");

                	
        	try {
        		
        		if (driver.findElement(lparser.getobjectLocator((object))).getAttribute("checked") != null) {
                    System.out.println("Check Box Checked");
                } else {
                	driver.findElement(lparser.getobjectLocator((object))).click();
                    System.out.println("Check Box not Checked");
                }

        		

        } catch (NoSuchElementException e) {
            // report error
            APPLICATION_LOGS.debug("Checkbox not found -" + object + e.getMessage());

            return "Fail" ;
            	
        }

        return "Pass";
    }

    public static String radioButton() {
        APPLICATION_LOGS.debug("Executing select Keyword");

                	
        	try {
        		
        		if (driver.findElement(lparser.getobjectLocator((object))).getAttribute("checked") != null) {
                    System.out.println("Check Box Checked");
                } else {
                	driver.findElement(lparser.getobjectLocator((object))).click();
                    System.out.println("Check Box not Checked");
                }

        		

        } catch (NoSuchElementException e) {
            // report error
            APPLICATION_LOGS.debug("Checkbox not found -" + object + e.getMessage());

            return "Fail" ;
            	
        }

        return "Pass";
    }
    
    public static String clearText() throws Exception {
        APPLICATION_LOGS.debug("Executing input Keyword");
        // extract the test data

        String data = testData.getCellData(currentTest, data_column_name, testRepeat);

        try {
        	driver.findElement(lparser.getobjectLocator((object))).clear();

            System.out.println("Input keyword data :" + data);

        } catch (Exception t) {
            // report error
            APPLICATION_LOGS.debug("Error in clearing text -" + object + t.getMessage());

            script_error = "Timed out after " + globalwait + " miliseconds";

            return "Fail " + t.getMessage();

        }

        return "Pass";
    }
    
    
   
    public static String compareAccName() {
        APPLICATION_LOGS.debug("Executing select Keyword");

         	
        	try {
        		WebElement acc = driver.findElement(lparser.getobjectLocator((object)));
        		acc.getText();
        		//System.out.println("Data Matches" +acc.getText());
        		if(acc.getText().equalsIgnoreCase("VENDOR / ACCOUNT NAME"))
        		{
			//System.out.println("Data Matches" +acc.getText());
        		}
        
        	} catch (NoSuchElementException e) {
            // report error
            APPLICATION_LOGS.debug("No Text found -" + object + e.getMessage());

            return "Fail" ;
            	
        }
        return "Pass";
    
    }
    
   

    public static String selectText() throws Exception {
        APPLICATION_LOGS.debug("Executing input Keyword");
        // extract the test data

        String data = testData.getCellData(currentTest, data_column_name, testRepeat);

        try {
        	
        	 Select select = new Select(driver.findElement(lparser.getobjectLocator((object))));
        	List<WebElement> Size = select.getOptions();
        	 
    	    int iListSize = Size.size();
     
    	    // Setting up the loop to print all the options
     
    	    for(int i =0; i < iListSize ; i++){
     
    		    // Storing the value of the option	
     
    		    String sValue = select.getOptions().get(i).getText();
     
    		    // Printing the stored value
     
    		    System.out.println(sValue);
     
    		    // Putting a check on each option that if any of the option is equal to 'Africa" then select it 
     
    		    if(sValue.equals(data)){
     
    			    select.selectByIndex(i);
     
    			    break;
     
    			    }
     
    	    }
            System.out.println("Input keyword data :" + data);

        } catch (Exception t) {
            // report error
            APPLICATION_LOGS.debug("Error in selecting text -" + object + t.getMessage());

            script_error = "Timed out after " + globalwait + " miliseconds";

            return "Fail " + t.getMessage();

        }

        return "Pass";
    }
    
    
    
    public static String selectDate() throws Exception {
        APPLICATION_LOGS.debug("Executing input Keyword");
        // extract the test data

        String data = testData.getCellData(currentTest, data_column_name, testRepeat);

        try {
        	 WebElement dates1=driver.findElement(lparser.getobjectLocator((object)));
        		
        		dates1.clear();
        		dates1.click();
        		Thread.sleep(5000);

        		 

        		WebElement dateWidget1 = driver.findElement(lparser.getobjectLocator((object)));
        		java.util.List<WebElement> tableRows1 = dateWidget1.findElements(By.xpath("//tr"));
        		for (WebElement row : tableRows1) {
        			java.util.List<WebElement> cells = row.findElements(By.xpath("//td"));

        			for (WebElement cell : cells) {
        				
        				if (cell.getText().equals(data)) {
        					
        					//Thread.sleep(200);
        					
        					System.out.println("cell.isSelected()>>>"+cell.isSelected());
        					cell.click();
        					
        					break;
        				}
        			}
        			break;
        		}

        			 
        		System.out.println("Input keyword data :" + data);
        

                

        } catch (Exception t) {
            // report error
            APPLICATION_LOGS.debug("Error in date selection -" + object + t.getMessage());

            script_error = "Timed out after " + globalwait + " miliseconds";

            return "Fail " + t.getMessage();

        }

        return "Pass";
    }
    
  //*[@id='mainHeader']/div/div[3]/ul/li[1]/a


    public static String logOut() throws Exception {
        APPLICATION_LOGS.debug("Executing input Keyword");
        // extract the test data

        

        try {
        	WebElement element=driver.findElement(lparser.getobjectLocator((object)));
        	
        	Actions action=new Actions(driver);
        	action.moveToElement(element).perform();
        	element.click();
        	
            

        } catch (Exception t) {
            // report error
            APPLICATION_LOGS.debug("Error in clearing text -" + object + t.getMessage());

            script_error = "Timed out after " + globalwait + " miliseconds";

            return "Fail " + t.getMessage();

        }

        return "Pass";
    }


    
    public static String waitfor() throws NumberFormatException, InterruptedException{
    	String data = testData.getCellData(currentTest, data_column_name, testRepeat);
        APPLICATION_LOGS.debug("Executing wait Keyword"); 
         try{
         
         float test = (Float.parseFloat(data)); int test1 = (int) test; 
         Thread.sleep(test1); globalwait = test1/1000; }
         
         catch(Throwable t){
         APPLICATION_LOGS.debug("Error while waiting -"+ object + t.getMessage());
         return "Fail - "+t.getMessage();
         } 
         return "Pass"; }
        

   }
    
    
    

    
    
    
