

import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.basics.Settings;
import org.sikuli.script.Env;
import org.sikuli.script.FindFailed;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Screen;




@SuppressWarnings("deprecation")
public class BillPaymentPage  {
	WebDriver driver;
	String Accountno,Amount;
	
	 Robot robot;
	public BillPaymentPage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	   	}
	
	
	
	
	
	public void clickbillPayment() throws FindFailed {
	     
	    
	     //Create and initialize an instance of Screen object    
	     Screen screen = new Screen();
	     		     Settings.OcrTextSearch = true;
	     try {
	          screen.find("A:\\adidas_latest\\TestSikuli\\images\\BillPayment.png");
	          screen.click("A:\\adidas_latest\\TestSikuli\\images\\BillPayment.png");
	          
	       Thread.sleep(2000);
	       
	       
	       
	      } 
	     catch(Exception e)
	     {
	         e.printStackTrace();
	     }

}
	
	public void clickSingtel() throws FindFailed {
	     
	    
	     //Create and initialize an instance of Screen object    
	     Screen screen = new Screen();
	     		     Settings.OcrTextSearch = true;
	     try {
	    	 Thread.sleep(2000);
	          screen.find("A:\\adidas_latest\\TestSikuli\\images\\Singtel.png");
	          screen.click("A:\\adidas_latest\\TestSikuli\\images\\Singtel.png");
	          
	       Thread.sleep(2000);
	       
	       
	       
	      } 
	     catch(Exception e)
	     {
	         e.printStackTrace();
	     }

}

	public void clickTelco() throws FindFailed {
	     
	    
	     //Create and initialize an instance of Screen object    
	     Screen screen = new Screen();
	     		     Settings.OcrTextSearch = true;
	     try {
	          screen.find("A:\\adidas_latest\\TestSikuli\\images\\Telco.png");
	          screen.click("A:\\adidas_latest\\TestSikuli\\images\\Telco.png");
	          
	       Thread.sleep(2000);
	       
	       
	       
	      } 
	     catch(Exception e)
	     {
	         e.printStackTrace();
	     }

}
	
	public void clickTelcoBills() throws FindFailed {
	     
	    
	     //Create and initialize an instance of Screen object    
	     Screen screen = new Screen();
	     		     Settings.OcrTextSearch = true;
	     try {
	          screen.find("A:\\adidas_latest\\TestSikuli\\images\\TeleBill.png");
	          screen.click("A:\\adidas_latest\\TestSikuli\\images\\TeleBill.png");
	          
	       Thread.sleep(2000);
	       
	       
	       
	      } 
	     catch(Exception e)
	     {
	         e.printStackTrace();
	     }

}
	
	
	
	public static String get() throws HeadlessException,
    UnsupportedFlavorException, IOException
{
Clipboard systemClipboard = getSystemClipboard();
Object text = systemClipboard.getData(DataFlavor.stringFlavor);

return (String) text;
}

	private static Clipboard getSystemClipboard()
	{
Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
Clipboard systemClipboard = defaultToolkit.getSystemClipboard();

return systemClipboard;
}


	
	public void inputAcountNo() throws FindFailed {
	     
	    
	     //Create and initialize an instance of Screen object    
	     Screen screen = new Screen();
	     		     Settings.OcrTextSearch = true;
	     		    Settings.OcrTextRead = true;
	     try {
	    	 screen.find("A:\\adidas_latest\\TestSikuli\\images\\Account.png");
	         screen.type("A:\\adidas_latest\\TestSikuli\\images\\Account.png","8965");
	         screen.doubleClick("A:\\adidas_latest\\TestSikuli\\images\\Account.png");
	         Thread.sleep(1000);
	         robot = new Robot();
	         robot.keyPress(KeyEvent.VK_CONTROL);
	         robot.keyPress(KeyEvent.VK_C);
	         robot.keyRelease(KeyEvent.VK_CONTROL);
	         robot.keyRelease(KeyEvent.VK_C);
	         robot.keyPress(KeyEvent.VK_CONTROL);
	         robot.keyPress(KeyEvent.VK_V);
	         robot.keyRelease(KeyEvent.VK_CONTROL);
	         robot.keyRelease(KeyEvent.VK_V);
	         
	        Accountno=get();
	        System.out.println(Accountno);
	        
	        if(Accountno.equals("8965")){
	        	System.out.println("Passed");
	        }
	        else{
	        	System.out.println("Failure");
	        }
	     }
	     catch(Exception e)
	     {
	         e.printStackTrace();
	     }

}
	
	public void inputAmount() throws FindFailed {
	     
	   Amount=Accountno;
	     //Create and initialize an instance of Screen object    
	     Screen screen = new Screen();
	     		     Settings.OcrTextSearch = true;
	     		   
	     try {
	    	 Thread.sleep(2000);
	    	 screen.find("A:\\adidas_latest\\TestSikuli\\images\\Amount.png");
	    	
	    	 screen.type("A:\\adidas_latest\\TestSikuli\\images\\Amount.png",Amount);
	    	 
	    	   
	         
	         
	          
	       
	       
	       
	       
	      } 
	     catch(Exception e)
	     {
	         e.printStackTrace();
	     }

}
	
	public void clickDone() throws FindFailed {
	     
	    
	     //Create and initialize an instance of Screen object    
	     Screen screen = new Screen();
	     		     Settings.OcrTextSearch = true;
	     try {
	    	 Thread.sleep(2000);
	    	 screen.find("A:\\adidas_latest\\TestSikuli\\images\\btnDone.png");
	         
	         screen.click("A:\\adidas_latest\\TestSikuli\\images\\btnDone.png");
	         
	         
	         
	          
	       Thread.sleep(2000);
	       
	       
	       
	      } 
	     catch(Exception e)
	     {
	         e.printStackTrace();
	     }

}
	
	public void alert() throws FindFailed {
	     
	    
	     //Create and initialize an instance of Screen object    
	     Screen screen = new Screen();
	     		     Settings.OcrTextSearch = true;
	     try {
	    	 screen.find("A:\\adidas_latest\\TestSikuli\\images\\alert.png");
	         
	         screen.click("A:\\adidas_latest\\TestSikuli\\images\\alert.png");
	         
	         
	         screen.find("A:\\adidas_latest\\TestSikuli\\images\\alertOK.png");
	         
	         screen.click("A:\\adidas_latest\\TestSikuli\\images\\alertOK.png");
	          
	       Thread.sleep(2000);
	       
	       
	       
	      } 
	     catch(Exception e)
	     {
	         e.printStackTrace();
	     }

}
	
	
}