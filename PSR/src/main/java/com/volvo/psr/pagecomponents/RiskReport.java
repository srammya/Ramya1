package com.volvo.psr.pagecomponents;

import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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


public class RiskReport extends CommonWrapperMethods {

	protected WebDriver driver;
	static String directory;
	static String Severity,Issue,Corrective_Action,Variant,Sop,Flow,A,B,C,D,E,Responsible,Focus,Status,pdfData;
	
	public RiskReport(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	 	}
	
	public void ristRep(String unitId) {
		
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
		 
		 WebElement riskRadio=driver.findElement(By.xpath("//*[@id=\"radio_R3_RT_Risk\"]"));
		 riskRadio.click(); 
		 
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
		     
		     System.out.println("uId: "+uID);
		    
	         getSkills(uID);
		    

		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void getSkills(String unitId) throws ClassNotFoundException, InterruptedException {
	String ClassName = prop.getProperty("Test.PSR.SQLSERVER.ClassName");
	String ConnectionString = prop.getProperty("Test.PSR.SQLSERVER.Connection.String");
	String UserName = prop.getProperty("Test.PSR.SQLSERVER.User.Name");
	String Password = prop.getProperty("Test.PSR.SQLSERVER.Password");

	ResultSet rs;
	Connection conn;
	String query = "exec dbo.showCurrentRiskList ?";
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
  
   Severity = rs.getString("severity");
   Issue = rs.getString("issue_description"); 
   Corrective_Action=rs.getString("corrective_action");
   Variant=rs.getString("variant_affected");
   Sop=rs.getString("sop");
   Flow=rs.getString("aims");
   A=rs.getString("action_step_a");
   B=rs.getString("action_step_b");
   C=rs.getString("action_step_c");
   D=rs.getString("action_step_d");
   E=rs.getString("action_step_e");
   Responsible=rs.getString("responsible");
   Focus=rs.getString("focus_flag");
   Status=rs.getString("status_flag");
    System.out.println("DATABASE Severity: "+Severity);
    System.out.println("DATABASE Issue: "+Issue);
    System.out.println("DATABASE Corrective_Action: "+Corrective_Action);
    System.out.println("DATABASE Variant: "+Variant);
    System.out.println("DATABASE Sop: "+Sop);
    System.out.println("DATABASE Flow: "+Flow);
    System.out.println("DATABASE A: "+A);
    System.out.println("DATABASE B: "+B);
    System.out.println("DATABASE C: "+C);
    System.out.println("DATABASE D: "+D);
    System.out.println("DATABASE E: "+E);
    System.out.println("DATABASE Responsible: "+Responsible);
    System.out.println("DATABASE Focus: "+Focus);
    System.out.println("DATABASE Status: "+Status);
    
  
}

}
	catch (SQLException ex) {
System.out.println(ex.getMessage());
}
}

public void validatePDFReport() {
	
	if(pdfData.contains(Severity)) {
		System.out.println("Severity found");
		reportStep("Severity data found in PDF " + Severity + " - Completed", "pass", false);
	}
	
	else {
		System.out.println("Severity NOT found");
		reportStep("Severity data NOT found in PDF " + Severity + " - Completed", "fail", false);
	}
	
	if(pdfData.contains(Issue)) {
		System.out.println("Issue found");
				
				reportStep("Issue data found in PDF " + Issue + " - Completed", "pass", false);
			}
			
			else {
				System.out.println("Issue NOT found");
				reportStep("Issue data NOT found in PDF " + Issue + " - Completed", "fail", false);
			}

	if(pdfData.contains(Corrective_Action)) {
		System.out.println("Corrective_Action found");
		
		reportStep("Corrective_Action data found in PDF " + Corrective_Action + " - Completed", "pass", false);
	}
	
	else {
		System.out.println("Corrective_Action NOT found");
		reportStep("Corrective_Action data NOT found in PDF " + Corrective_Action + " - Completed", "fail", false);
	}
	
	if(pdfData.contains(Variant)) {
		System.out.println("Variant found");
		
		reportStep("Variant data found in PDF " + Variant + " - Completed", "pass", false);
	}
	
	else {
		System.out.println("Variant NOT found");
		reportStep("Variant data NOT found in PDF " + Variant + " - Completed", "fail", false);
	}
	
	if(pdfData.contains(Sop)) {
		System.out.println("Sop found");
		
		reportStep("Sop data found in PDF " + Sop + " - Completed", "pass", false);
	}
	
	else {
		System.out.println("Sop NOT found");
		reportStep("Sop data NOT found in PDF " + Sop + " - Completed", "fail", false);
	}
	
	if(pdfData.contains(Flow)) {
		System.out.println("Flow found");
		
		reportStep("Flow data found in PDF " + Flow + " - Completed", "pass", false);
	}
	
	else {
		System.out.println("Flow NOT found");
		reportStep("Flow data NOT found in PDF " + Flow + " - Completed", "fail", false);
	}
	
	if(pdfData.contains(A)) {
		System.out.println("A found");
		
		reportStep("A data found in PDF " + A + " - Completed", "pass", false);
	}
	
	else  {
		System.out.println("A NOT found");
		reportStep("A data NOT found in PDF " + A + " - Completed", "fail", false);
	}
	
			
	if(pdfData.contains(B)) {
		System.out.println("B found");
		reportStep("B data found in PDF " + B + " - Completed", "pass", false);
	}
	
	else {
		System.out.println("B NOT found");
		reportStep("B data NOT found in PDF " + B + " - Completed", "fail", false);
	}
		
	if(pdfData.contains(C)) {
		System.out.println("C found");
				
				reportStep("C data found in PDF " + C + " - Completed", "pass", false);
			}
			
			else {
				System.out.println("C NOT found");
				reportStep("C data NOT found in PDF " + C + " - Completed", "fail", false);
			}
	if(pdfData.contains(D)) {
		System.out.println("D found");
		
		reportStep("D data found in PDF " + D + " - Completed", "pass", false);
	}
	
	else {
		System.out.println("D NOT found");
		reportStep("D data NOT found in PDF " + D + " - Completed", "fail", false);
	}
	
	if(pdfData.contains(E)) {
		System.out.println("E found");
				
				reportStep("E data found in PDF " + E + " - Completed", "pass", false);
			}
			
			else {
				System.out.println("E NOT found");
				reportStep("E data NOT found in PDF " + E + " - Completed", "fail", false);
			}
	if(pdfData.contains(Responsible)) {
		System.out.println("Responsible found");
				
				reportStep("Responsible data found in PDF " + Responsible + " - Completed", "pass", false);
			}
			
			else {
				System.out.println("Responsible NOT found");
				reportStep("Responsible data NOT found in PDF " + Responsible + " - Completed", "fail", false);
			}
	if(pdfData.contains(Status)) {
		System.out.println("Status found");
				
				reportStep("Status data found in PDF " + Status + " - Completed", "pass", false);
			}
			
			else {
				System.out.println("Status NOT found");
				reportStep("Status data NOT found in PDF " + Status + " - Completed", "fail", false);
			}
	if(pdfData.contains(Focus)) {
		System.out.println("Focus found");
				
				reportStep("Focus data found in PDF " + Focus + " - Completed", "pass", false);
			}
			
			else {
				System.out.println("Focus NOT found");
				reportStep("Focus data NOT found in PDF " + Focus + " - Completed", "fail", false);
			}
    }


	
	public void ristRepDropDown(String unitId) {
		
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
		
		WebElement riskRadio=driver.findElement(By.xpath("//*[@id=\"radio_R3_RT_Risk\"]"));
		riskRadio.click(); 
		
		WebElement risk=driver.findElement(By.id("riskReportType"));
		risk.click();
		
		Select riskSpecial=new Select(driver.findElement(By.id("riskReportType")));
		riskSpecial.selectByVisibleText("PCM Meetings");
		
		
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
		     
		     System.out.println("uId: "+uID);
		    
	         getSkill(uID);
		    

		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void getSkill(String unitId) throws ClassNotFoundException, InterruptedException {
	String ClassName = prop.getProperty("Test.PSR.SQLSERVER.ClassName");
	String ConnectionString = prop.getProperty("Test.PSR.SQLSERVER.Connection.String");
	String UserName = prop.getProperty("Test.PSR.SQLSERVER.User.Name");
	String Password = prop.getProperty("Test.PSR.SQLSERVER.Password");

	ResultSet rs;
	Connection conn;
	String query = "exec dbo.showCurrentRiskList ?";
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
  
   Severity = rs.getString("severity");
   Issue = rs.getString("issue_description"); 
   Corrective_Action=rs.getString("corrective_action");
   Variant=rs.getString("variant_affected");
   Sop=rs.getString("sop");
   Flow=rs.getString("aims");
   A=rs.getString("action_step_a");
   B=rs.getString("action_step_b");
   C=rs.getString("action_step_c");
   D=rs.getString("action_step_d");
   E=rs.getString("action_step_e");
   Responsible=rs.getString("responsible");
   Focus=rs.getString("focus_flag");
   Status=rs.getString("status_flag");
    System.out.println("DATABASE Severity: "+Severity);
    System.out.println("DATABASE Issue: "+Issue);
    System.out.println("DATABASE Corrective_Action: "+Corrective_Action);
    System.out.println("DATABASE Variant: "+Variant);
    System.out.println("DATABASE Sop: "+Sop);
    System.out.println("DATABASE Flow: "+Flow);
    System.out.println("DATABASE A: "+A);
    System.out.println("DATABASE B: "+B);
    System.out.println("DATABASE C: "+C);
    System.out.println("DATABASE D: "+D);
    System.out.println("DATABASE E: "+E);
    System.out.println("DATABASE Responsible: "+Responsible);
    System.out.println("DATABASE Focus: "+Focus);
    System.out.println("DATABASE Status: "+Status);
    
  
}

}
	catch (SQLException ex) {
System.out.println(ex.getMessage());
}
}

public void htmlRisk() {
	
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
	
	WebElement riskRadio=driver.findElement(By.xpath("//*[@id=\"radio_R3_RT_Risk\"]"));
	riskRadio.click(); 

	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 //driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS) ;

	 reportStep("ProgramTask is Selected", "pass", false);


	
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

//Risk -MSR Report



public void riskMsr(String unitId) {
	
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
	 
	 WebElement riskRadio=driver.findElement(By.xpath("//*[@id=\"radio_R3_RT_Risk\"]"));
	 riskRadio.click(); 
	 
	 
	   WebElement msrRadio=driver.findElement(By.xpath("//*[@id=\"radio_R4_RF_Milestone\"]"));
		msrRadio.click(); 
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
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
	    System.out.println("PDF CONTENT: "+pdfData);
	    
	     String uID=unitId;
	     
	     System.out.println("uId: "+uID);
	    
         getSkill1(uID);
	    

	
}
catch(Exception e){
	e.printStackTrace();
}
}

public void getSkill1(String unitId) throws ClassNotFoundException, InterruptedException {
String ClassName = prop.getProperty("Test.PSR.SQLSERVER.ClassName");
String ConnectionString = prop.getProperty("Test.PSR.SQLSERVER.Connection.String");
String UserName = prop.getProperty("Test.PSR.SQLSERVER.User.Name");
String Password = prop.getProperty("Test.PSR.SQLSERVER.Password");

ResultSet rs;
Connection conn;
String query = "exec dbo.showCurrentRiskList ?";
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

Severity = rs.getString("severity");
Issue = rs.getString("issue_description"); 
Corrective_Action=rs.getString("corrective_action");
Variant=rs.getString("variant_affected");
Sop=rs.getString("sop");
Flow=rs.getString("aims");
A=rs.getString("action_step_a");
B=rs.getString("action_step_b");
C=rs.getString("action_step_c");
D=rs.getString("action_step_d");
E=rs.getString("action_step_e");
Responsible=rs.getString("responsible");
Focus=rs.getString("focus_flag");
Status=rs.getString("status_flag");
System.out.println("DATABASE Severity: "+Severity);
System.out.println("DATABASE Issue: "+Issue);
System.out.println("DATABASE Corrective_Action: "+Corrective_Action);
System.out.println("DATABASE Variant: "+Variant);
System.out.println("DATABASE Sop: "+Sop);
System.out.println("DATABASE Flow: "+Flow);
System.out.println("DATABASE A: "+A);
System.out.println("DATABASE B: "+B);
System.out.println("DATABASE C: "+C);
System.out.println("DATABASE D: "+D);
System.out.println("DATABASE E: "+E);
System.out.println("DATABASE Responsible: "+Responsible);
System.out.println("DATABASE Focus: "+Focus);
System.out.println("DATABASE Status: "+Status);


}

}
catch (SQLException ex) {
System.out.println(ex.getMessage());
}
}


}
