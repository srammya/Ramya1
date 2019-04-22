package com.volvo.psr.pagecomponents;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.volvo.psr.common.utils.CommonWrapperMethods;

public class MsrReport extends CommonWrapperMethods{
	
	protected WebDriver driver;
	static String directory;
	static String Name,Value,Description,Decision,pdfData;
	


	public MsrReport(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	 	}
	
	public void msrRep(String unitId, String milestoneAbrr, String milestoneLabel) {
		
		WebElement mainr=driver.findElement(By.name(prop.getProperty("HomePage.ViewReport.Button")));
		mainr.click();
		WebElement vr=driver.findElement(By.xpath(prop.getProperty("HomePage.VReport")));
		vr.click();
		
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		reportStep("View Report Page is launched", "pass", false);
		
		WebElement ProgramTasks=driver.findElement(By.xpath("//*[@id=\"esrEditToolForm.programUnitReportAuthorIdSelection\"]"));
		ProgramTasks.click();
		
		Select dropdown=new Select(driver.findElement(By.id("esrEditToolForm.programUnitReportAuthorIdSelection")));
		dropdown.selectByVisibleText("519A - 242402 - VEHICLE HARDWARE");
		
		//WebElement getReport=driver.findElement(By.id("getTheReportButton"));
		//getReport.click();
	
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS) ;

		 reportStep("ProgramTask is Selected", "pass", false);
		 
		 WebElement msrRadio=driver.findElement(By.xpath("//*[@id=\"radio_R3_RT_MSR\"]"));
		 msrRadio.click(); 
		 
		 WebElement msr=driver.findElement(By.id("esrEditToolForm.selectMilestone"));
		 msr.click();
			
		Select milestone=new Select(driver.findElement(By.id("esrEditToolForm.selectMilestone")));
		milestone.selectByVisibleText("PS - Program Start");

			
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	try{
		FileUtils.forceDelete(new File(System.getProperty("user.dir")+"\\PSR\\"));
		File theDir = new File("PSR");

		// if the directory does not exist, create it
		if (!theDir.exists()) {
		    System.out.println("creating directory: " + theDir.getName());
		    boolean result = false;

		    try{
		        theDir.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se){
		        //handle it
		    }        
		    if(result) {    
		        System.out.println("DIR created");  
		    }
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("window.scrollBy(0,300)"); 

		
		anyClick("Submit", By.xpath(prop.getProperty("Get.Psr.Report")));
		
		driver.manage().timeouts().implicitlyWait(Default_Wait_4_Page, TimeUnit.SECONDS);
		Thread.sleep(30000);
		
	     
	     File folder = new File(downloadFilepath);
			File[] listOfFiles = folder.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {
			  if (listOfFiles[i].isFile()) {
				  directory=listOfFiles[i].toString();
				  System.out.println("dir: "+directory);
			    System.out.println("File " + listOfFiles[i].getName());
			  } else if (listOfFiles[i].isDirectory()) {
			    System.out.println("Directory " + listOfFiles[i].getName());
			  }
			}
	    			Thread.sleep(5000);
		   
		     File file=new File(directory);
		     
		    // FileInputStream fileStream=new FileInputStream(file);
		     
		     PDFParser pdfParser=new PDFParser(new RandomAccessFile(file,"r"));
		     
		     pdfParser.parse();
		     COSDocument cosDoc=pdfParser.getDocument();
		     
		     PDDocument pdfDoc=new PDDocument(cosDoc);
		     PDFTextStripper strip=new PDFTextStripper();
		     
		     pdfData=strip.getText(pdfDoc);
//		    System.out.println("PDF CONTENT: "+pdfData);
		    
		    
		    		    
		    FileWriter writer = new FileWriter("C:\\Users\\RKALIYAP\\Automation\\PSR\\pdf.txt");
//		    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\RKALIYAP\\Automation\\PSR\\pdf.txt"));  
		       // String fileContent=null;
		    writer.write(pdfData);
		    writer.close();
		    System.out.println("Text file write success");
		     String uID=unitId;
		     
		     String mAbrr=milestoneAbrr;
		     
		     String mLab=milestoneLabel;
		     
		     System.out.println("uId: "+uID);
		     
		     System.out.println("mAbrr: "+mAbrr);
		     
		     System.out.println("mLab: "+mLab);
		    
	         getSkills(uID,mAbrr,mLab);
		    

		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void getSkills(String unitId, String milestoneAbrr, String milestoneLabel) throws ClassNotFoundException, InterruptedException {
	String ClassName = prop.getProperty("Test.PSR.SQLSERVER.ClassName");
	String ConnectionString = prop.getProperty("Test.PSR.SQLSERVER.Connection.String");
	String UserName = prop.getProperty("Test.PSR.SQLSERVER.User.Name");
	String Password = prop.getProperty("Test.PSR.SQLSERVER.Password");

	ResultSet rs;
	Connection conn;
	String query = "exec dbo.showMSRReport ?,?,?";
try {        
	Class.forName(ClassName);
	conn = DriverManager.getConnection(ConnectionString,UserName,Password);
	CallableStatement stmt = conn.prepareCall(query); 
    	stmt.setString(1,unitId);
    	
    	stmt.setString(2,milestoneAbrr);
    	
    	stmt.setString(3,milestoneLabel);
    	
      System.out.println("callable success");


rs = stmt.executeQuery();
System.out.println("Query success");
Thread.sleep(2000);
while (rs.next()) {    
  
	   Name = rs.getString("name");
	   Value = rs.getString("value"); 
	   Description=rs.getString("description");
	   Decision=rs.getString("Decision");
	    System.out.println("DATABASE Name: "+Name);
	    System.out.println("DATABASE Value: "+Value);
	    System.out.println("DATABASE Description: "+Description);
	    System.out.println("DATABASE Decision: "+Decision);    
  
}

}
	catch (SQLException ex) {
System.out.println(ex.getMessage());
}
}

public void validatePDFReport() throws IOException {
	File file=new File("C:\\Users\\RKALIYAP\\Automation\\PSR\\pdf.txt");
	FileInputStream fileInput;
	fileInput=new FileInputStream(file);
	byte[] fileValue=new byte[(int) file.length()];
	fileInput.read(fileValue);
	fileInput.close();
	String fileContent=new String(fileValue,"UTF-8");
//	System.out.println(fileContent);
	/*FileReader reader = new FileReader("C:\\Users\\RKALIYAP\\Automation\\PSR\\pdf.txt");
	BufferedReader bufferedReader = new BufferedReader(reader);  
	    String line = null;
	    
	    while ((line = bufferedReader.readLine()) != null) {*/
          //  System.out.println(line);
        
        
		
	/*if(line.contains(Name)) {
		System.out.println("Name found");
		reportStep("Name data found in PDF " + Name + " - Completed", "pass", false);
	}
	
	else {
		System.out.println("Name NOT found");
		reportStep("Name data NOT found in PDF " + Name + " - Completed", "fail", false);
	}
	
	if(line.contains(Value)) {
		System.out.println("Value found");
				
				reportStep("Value data found in PDF " + Value + " - Completed", "pass", false);
			}
			
			else {
				System.out.println("Value NOT found");
				reportStep("Value data NOT found in PDF " + Value + " - Completed", "fail", false);
			}*/

	if(fileContent.contains("he purpose at <PS> is to start the program and set prerequisites,\r\n" + 
			"mission, targets and program finance and to get program funding\r\n" + 
			"approval up to <PC> (Program Confirmation).")) {
		System.out.println("Description found");
		
		reportStep("Description data found in PDF " + Description + " - Completed", "pass", false);
	}
	
	else {
		System.out.println("Description NOT found");
		reportStep("Description data NOT found in PDF " + Description + " - Completed", "fail", false);
	}
	
	/*if(line.contains(Decision)) {
		System.out.println("Decision found");
		
		reportStep("Decision data found in PDF " + Decision + " - Completed", "pass", false);
	}
	
	else {
		System.out.println("Decision NOT found");
		reportStep("Decision data NOT found in PDF " + Decision + " - Completed", "fail", false);
	}
	
	*/
   
}
	
	
	/*public void msrRepDropDown(String unitId, String milestoneAbrr, String milestoneLabel) {
		
		WebElement mainr=driver.findElement(By.name(prop.getProperty("HomePage.ViewReport.Button")));
		mainr.click();
		WebElement vr=driver.findElement(By.xpath(prop.getProperty("HomePage.VReport")));
		vr.click();
		
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		reportStep("View Report Page is launched", "pass", false);
		
		WebElement ProgramTasks=driver.findElement(By.xpath("//*[@id=\"esrEditToolForm.programUnitReportAuthorIdSelection\"]"));
		ProgramTasks.click();
		
		Select dropdown=new Select(driver.findElement(By.id("esrEditToolForm.programUnitReportAuthorIdSelection")));
		dropdown.selectByVisibleText("519A - 242402 - VEHICLE HARDWARE");
		
		WebElement msrRadio=driver.findElement(By.xpath("//*[@id=\"radio_R3_RT_MSR\"]"));
		msrRadio.click(); 
		
		WebElement msr=driver.findElement(By.xpath("//*[@id=\"esrEditToolForm.selectMilestone\"]"));
		msr.click();
		
		Select milestone=new Select(driver.findElement(By.id("allMilestones")));
		milestone.selectByValue("PS - Program Start");
		
		
		//WebElement getReport=driver.findElement(By.id("getTheReportButton"));
		//getReport.click();
	
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS) ;

		 reportStep("ProgramTask is Selected", "pass", false);
		 
		 
		 
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	try{
		FileUtils.forceDelete(new File(System.getProperty("user.dir")+"\\PSR\\"));
		File theDir = new File("PSR");

		// if the directory does not exist, create it
		if (!theDir.exists()) {
		    System.out.println("creating directory: " + theDir.getName());
		    boolean result = false;

		    try{
		        theDir.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se){
		        //handle it
		    }        
		    if(result) {    
		        System.out.println("DIR created");  
		    }
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("window.scrollBy(0,300)"); 

		
		anyClick("Submit", By.xpath(prop.getProperty("Get.Psr.Report")));
		
		driver.manage().timeouts().implicitlyWait(Default_Wait_4_Page, TimeUnit.SECONDS);
		Thread.sleep(30000);
		
	     
	     File folder = new File(downloadFilepath);
			File[] listOfFiles = folder.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {
			  if (listOfFiles[i].isFile()) {
				  directory=listOfFiles[i].toString();
				  System.out.println("dir: "+directory);
			    System.out.println("File " + listOfFiles[i].getName());
			  } else if (listOfFiles[i].isDirectory()) {
			    System.out.println("Directory " + listOfFiles[i].getName());
			  }
			}
	    			Thread.sleep(5000);
		   
		     File file=new File(directory);
		     
		    // FileInputStream fileStream=new FileInputStream(file);
		     
		     PDFParser pdfParser=new PDFParser(new RandomAccessFile(file,"r"));
		     
		     pdfParser.parse();
		     COSDocument cosDoc=pdfParser.getDocument();
		     
		     PDDocument pdfDoc=new PDDocument(cosDoc);
		     PDFTextStripper strip=new PDFTextStripper();
		     
		     pdfData=strip.getText(pdfDoc);
		    System.out.println("PDF CONTENT: "+pdfData);
		    
		    String uID=unitId;
		     
		     String mAbrr=milestoneAbrr;
		     
		     String mLab=milestoneLabel;
		     
		     System.out.println("uId: "+uID);
		     
		     System.out.println("mAbrr: "+mAbrr);
		     
		     System.out.println("mLab: "+mLab);
		    
		    
	         getSkill(uID,mAbrr,mLab);
		    

		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void getSkill(String unitId, String milestoneAbrr, String milestoneLabel) throws ClassNotFoundException, InterruptedException {
	String ClassName = prop.getProperty("Test.PSR.SQLSERVER.ClassName");
	String ConnectionString = prop.getProperty("Test.PSR.SQLSERVER.Connection.String");
	String UserName = prop.getProperty("Test.PSR.SQLSERVER.User.Name");
	String Password = prop.getProperty("Test.PSR.SQLSERVER.Password");

	ResultSet rs;
	Connection conn;
	String query = "exec dbo.showMSRReport ?,?,?";
try {        
	Class.forName(ClassName);
	conn = DriverManager.getConnection(ConnectionString,UserName,Password);
	CallableStatement stmt = conn.prepareCall(query); 
    	stmt.setString(1,unitId);
    	
      System.out.println("callable success");


rs = stmt.executeQuery();
System.out.println("Query success");
Thread.sleep(2000);
while (rs.next()) {    
  
   Name = rs.getString("name");
   Value = rs.getString("value"); 
   Description=rs.getString("description");
   Decision=rs.getString("Decision");
    System.out.println("DATABASE Name: "+Name);
    System.out.println("DATABASE Value: "+Value);
    System.out.println("DATABASE Description: "+Description);
    System.out.println("DATABASE Decision: "+Decision);
    }

}
	catch (SQLException ex) {
System.out.println(ex.getMessage());
}
} */

public void htmlMsr() {
	
	WebElement mainr=driver.findElement(By.name(prop.getProperty("HomePage.ViewReport.Button")));
	mainr.click();
	WebElement vr=driver.findElement(By.xpath(prop.getProperty("HomePage.VReport")));
	vr.click();
	
    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
	reportStep("View Report Page is launched", "pass", false);
	
	WebElement ProgramTasks=driver.findElement(By.xpath("//*[@id=\"esrEditToolForm.programUnitReportAuthorIdSelection\"]"));
	ProgramTasks.click();
	
	Select dropdown=new Select(driver.findElement(By.id("esrEditToolForm.programUnitReportAuthorIdSelection")));
	dropdown.selectByVisibleText("519A - 242402 - VEHICLE HARDWARE");
	
	//WebElement getReport=driver.findElement(By.id("getTheReportButton"));
	//getReport.click();
	
	WebElement msrRadio=driver.findElement(By.xpath("//*[@id=\"radio_R3_RT_MSR\"]"));
	msrRadio.click(); 

	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 //driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS) ;

	 reportStep("ProgramTask is Selected", "pass", false);

	 WebElement msr=driver.findElement(By.id("esrEditToolForm.selectMilestone"));
	 msr.click();
		
	Select milestone=new Select(driver.findElement(By.id("esrEditToolForm.selectMilestone")));
	milestone.selectByVisibleText("PS - Program Start");

	
	//WebElement excel=driver.findElement(By.xpath("//*[@id=\"radio_R5_OF_Xls\"]"));
   // excel.click();
	
	WebElement html=driver.findElement(By.xpath("//*[@id=\"radio_R5_OF_Html\"]"));
	html.click();
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver; 
	js.executeScript("window.scrollBy(0,300)"); 
	
	anyClick("Submit", By.xpath(prop.getProperty("Get.Psr.Report")));
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	reportStep("Html report is displayed", "pass", false);
	
}

	
}
