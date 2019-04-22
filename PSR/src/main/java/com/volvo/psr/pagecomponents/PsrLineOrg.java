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

public class PsrLineOrg extends CommonWrapperMethods {

	protected WebDriver driver;
	static String directory;
	static String Area,KPI,KPIInstance,H2,H3,H4,H5,V5,H6,V6,H7,pdfData;
	
	public PsrLineOrg(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
}
	
	public void PsrLineTask(String unitId,String flag,String kpi) {
		
		WebElement mainr=driver.findElement(By.name(prop.getProperty("HomePage.ViewReport.Button")));
		mainr.click();
		WebElement vr=driver.findElement(By.xpath(prop.getProperty("HomePage.VReport")));
		vr.click();
		
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		reportStep("View Report Page is launched", "pass", false);
		
		WebElement ProgramTasks=driver.findElement(By.xpath("//*[@id=\"esrEditToolForm.lineOrgSelection\"]"));
		ProgramTasks.click();
		
		Select dropdown=new Select(driver.findElement(By.id("esrEditToolForm.lineOrgSelection")));
		dropdown.selectByVisibleText("57200 - Service Readiness");
		
		WebElement childTask=driver.findElement(By.xpath("//*[@id=\"apa1\"]"));
		childTask.click();
		
		
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
		
		//WebElement excel=driver.findElement(By.xpath("//*[@id=\"radio_R5_OF_Xls\"]"));
	   // excel.click();
		
		//WebElement html=driver.findElement(By.xpath("//*[@id=\"radio_R5_OF_Html\"]"));
		//html.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		anyClick("Submit", By.xpath(prop.getProperty("Get.Psr.Report")));
		
		driver.manage().timeouts().implicitlyWait(Default_Wait_4_Page, TimeUnit.SECONDS);
		Thread.sleep(20000);
		
	     
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
		     String kkpi=kpi;
		     System.out.println("uId: "+uID);
		     System.out.println("kkpi: "+kkpi);
	     			     	
		     getSkills(uID,flag,kkpi);
		    

		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void getSkills(String unitId,String flag,String kpi) throws ClassNotFoundException, InterruptedException {
	String ClassName = prop.getProperty("Test.PSR.SQLSERVER.ClassName");
	String ConnectionString = prop.getProperty("Test.PSR.SQLSERVER.Connection.String");
	String UserName = prop.getProperty("Test.PSR.SQLSERVER.User.Name");
	String Password = prop.getProperty("Test.PSR.SQLSERVER.Password");

	ResultSet rs;
	Connection conn;
	String query = "exec dbo.showCurrentPSRReport ?,?,?";
try {        
	Class.forName(ClassName);
	conn = DriverManager.getConnection(ConnectionString,UserName,Password);
	CallableStatement stmt = conn.prepareCall(query); 
    	stmt.setString(1,unitId);
    	
    	stmt.setString(2,flag);
    
		stmt.setString(3,kpi);
        
    	System.out.println("callable success");


rs = stmt.executeQuery();
System.out.println("Query success");
Thread.sleep(2000);
while (rs.next()) {
  // System.out.println(String.format("%s - %s",rs.getString("PuDesc"),rs.getString("KPI"),rs.getString("KPIInstance"),rs.getString("H2"),rs.getString("H3"),rs.getString("H4"),rs.getString("H5"),rs.getString("V5"),rs.getString("H6"),rs.getString("V6")));
    
  
   Area = rs.getString("Area");
   KPI = rs.getString("KPI"); 
   KPIInstance=rs.getString("KPIInstance");
   H2=rs.getString("H2");
   H3=rs.getString("H3");
   H4=rs.getString("H4");
   V5=rs.getString("V5");
   H5=rs.getString("H5");
   H6=rs.getString("H6");
   V6=rs.getString("V6");
   H7=rs.getString("H7");
    System.out.println("DATABASE Area: "+Area);
    System.out.println("DATABASE KPI: "+KPI);
    System.out.println("DATABASE KPIInstance: "+KPIInstance);
    System.out.println("DATABASE H2: "+H2);
    System.out.println("DATABASE H3: "+H3);
    System.out.println("DATABASE H4: "+H4);
    System.out.println("DATABASE H5: "+H5);
    //System.out.println("DATABASE V5: "+V5);
    System.out.println("DATABASE H6: "+H6);
    //System.out.println("DATABASE V6: "+V6);
    System.out.println("DATABASE H7: "+H7);
    
  
}

}
	catch (SQLException ex) {
System.out.println(ex.getMessage());
}
}

public void validatePDFReport() {
	
	if(pdfData.contains(Area)) {
		System.out.println("Area found");
		reportStep("Area data found in PDF " + Area + " - Completed", "pass", false);
	}
	
	else {
		System.out.println("Area NOT found");
		reportStep("Area data NOT found in PDF " + Area + " - Completed", "fail", false);
	}
	
	if(pdfData.contains(KPI)) {
		System.out.println("KPI found");
				
				reportStep("KPI data found in PDF " + KPI + " - Completed", "pass", false);
			}
			
			else {
				System.out.println("KPI NOT found");
				reportStep("KPI data NOT found in PDF " + KPI + " - Completed", "fail", false);
			}

	if(pdfData.contains(KPIInstance)) {
		System.out.println("KPIInstance found");
		
		reportStep("KPIInstance data found in PDF " + KPIInstance + " - Completed", "pass", false);
	}
	
	else {
		System.out.println("KPIInstance NOT found");
		reportStep("KPIInstance data NOT found in PDF " + KPIInstance + " - Completed", "fail", false);
	}
	
	if(pdfData.contains(H2)) {
		System.out.println("H2 found");
		
		reportStep("H2 data found in PDF " + H2 + " - Completed", "pass", false);
	}
	
	else {
		System.out.println("H2 NOT found");
		reportStep("H2 data NOT found in PDF " + H2 + " - Completed", "fail", false);
	}
	
	if(pdfData.contains(H3)) {
		System.out.println("H3 found");
		
		reportStep("H3 data found in PDF " + H3 + " - Completed", "pass", false);
	}
	
	else {
		System.out.println("H3 NOT found");
		reportStep("H3 data NOT found in PDF " + H3 + " - Completed", "fail", false);
	}
	
	if(pdfData.contains(H4)) {
		System.out.println("H4 found");
		
		reportStep("H4 data found in PDF " + H4 + " - Completed", "pass", false);
	}
	
	else {
		System.out.println("H4 NOT found");
		reportStep("H4 data NOT found in PDF " + H4 + " - Completed", "fail", false);
	}
	
	if(pdfData.contains(H5)) {
		System.out.println("H5 found");
		
		reportStep("H5 data found in PDF " + H5 + " - Completed", "pass", false);
	}
	
	else  {
		System.out.println("H5 NOT found");
		reportStep("H5 data NOT found in PDF " + H5 + " - Completed", "fail", false);
	}
	
			
	/*if(pdfData.contains(V5)) {
		System.out.println("V5 found");
		reportStep("V5 data found in PDF " + V5 + " - Completed", "pass", false);
	}
	
	else {
		System.out.println("V5 NOT found");
		reportStep("V5 data NOT found in PDF " + V5 + " - Completed", "fail", false);
	}*/
		
	if(pdfData.contains(H6)) {
		System.out.println("H6 found");
				
				reportStep("H6 data found in PDF " + H6 + " - Completed", "pass", false);
			}
			
			else {
				System.out.println("H6 NOT found");
				reportStep("H6 data NOT found in PDF " + H6 + " - Completed", "fail", false);
			}
	/*if(pdfData.contains(V6)) {
		System.out.println("V6 found");
		
		reportStep("V6 data found in PDF " + V6 + " - Completed", "pass", false);
	}
	
	else {
		System.out.println("V6 NOT found");
		reportStep("V6 data NOT found in PDF " + V6 + " - Completed", "fail", false);
	}*/
	
	if(pdfData.contains(H7)) {
		System.out.println("H7 found");
				
				reportStep("H7 data found in PDF " + H7 + " - Completed", "pass", false);
			}
			
			else {
				System.out.println("H7 NOT found");
				reportStep("H7 data NOT found in PDF " + H7 + " - Completed", "fail", false);
			}
    }


public void psrLineDropdown(String unitId,String flag,String kpi) {
	
	WebElement mainr=driver.findElement(By.name(prop.getProperty("HomePage.ViewReport.Button")));
	mainr.click();
	WebElement vr=driver.findElement(By.xpath(prop.getProperty("HomePage.VReport")));
	vr.click();
	
    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
	reportStep("View Report Page is launched", "pass", false);
	
	WebElement ProgramTasks=driver.findElement(By.xpath("//*[@id=\"esrEditToolForm.lineOrgSelection\"]"));
	ProgramTasks.click();
	
	Select dropdown=new Select(driver.findElement(By.id("esrEditToolForm.lineOrgSelection")));
	dropdown.selectByVisibleText("57200 - Service Readiness");
	
	WebElement childTask=driver.findElement(By.xpath("//*[@id=\"apa1\"]"));
	childTask.click();
		
	WebElement psr=driver.findElement(By.xpath("//*[@id=\"esrEditToolForm.kpiSpecificDocumentSelection\"]"));
	psr.click();
	
	Select psrSpecial=new Select(driver.findElement(By.id("esrEditToolForm.kpiSpecificDocumentSelection")));
	psrSpecial.selectByVisibleText("Plant Launch Readiness");
	
	//WebElement getReport=driver.findElement(By.id("getTheReportButton"));
	//getReport.click();

	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 //driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS) ;

	 reportStep("Special Report is Selected", "pass", false);
	


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
       
	//WebElement excel=driver.findElement(By.xpath("//*[@id=\"radio_R5_OF_Xls\"]"));
	//excel.click();
	
	//WebElement html=driver.findElement(By.xpath("//*[@id=\"radio_R5_OF_Html\"]"));
	//html.click();
	
	anyClick("Submit", By.xpath(prop.getProperty("Get.Psr.Report")));
	
	driver.manage().timeouts().implicitlyWait(Default_Wait_4_Page, TimeUnit.SECONDS);
	Thread.sleep(20000);
	
     
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
	     String kkpi=kpi;
	     System.out.println("uId: "+uID);
	     System.out.println("kkpi: "+kkpi);
     			     	
	     getSkill(uID,flag,kkpi);
	    

	
}
catch(Exception e){
	e.printStackTrace();
}
}

public void getSkill(String unitId,String flag,String kpi) throws ClassNotFoundException, InterruptedException {
String ClassName = prop.getProperty("Test.PSR.SQLSERVER.ClassName");
String ConnectionString = prop.getProperty("Test.PSR.SQLSERVER.Connection.String");
String UserName = prop.getProperty("Test.PSR.SQLSERVER.User.Name");
String Password = prop.getProperty("Test.PSR.SQLSERVER.Password");

ResultSet rs;
Connection conn;
String query = "exec dbo.showCurrentPSRReport ?,?,?";
try {        
Class.forName(ClassName);
conn = DriverManager.getConnection(ConnectionString,UserName,Password);
CallableStatement stmt = conn.prepareCall(query); 
	stmt.setString(1,unitId);
	
	stmt.setString(2,flag);

	stmt.setString(3,kpi);
    
	System.out.println("callable success");


rs = stmt.executeQuery();
System.out.println("Query success");
Thread.sleep(2000);
while (rs.next()) {
// System.out.println(String.format("%s - %s",rs.getString("PuDesc"),rs.getString("KPI"),rs.getString("KPIInstance"),rs.getString("H2"),rs.getString("H3"),rs.getString("H4"),rs.getString("H5"),rs.getString("V5"),rs.getString("H6"),rs.getString("V6")));


Area = rs.getString("Area");
KPI = rs.getString("KPI"); 
KPIInstance=rs.getString("KPIInstance");
H2=rs.getString("H2");
H3=rs.getString("H3");
H4=rs.getString("H4");
V5=rs.getString("V5");
H5=rs.getString("H5");
H6=rs.getString("H6");
V6=rs.getString("V6");
H7=rs.getString("H7");
System.out.println("DATABASE Area: "+Area);
System.out.println("DATABASE KPI: "+KPI);
System.out.println("DATABASE KPIInstance: "+KPIInstance);
System.out.println("DATABASE H2: "+H2);
System.out.println("DATABASE H3: "+H3);
System.out.println("DATABASE H4: "+H4);
System.out.println("DATABASE H5: "+H5);
//System.out.println("DATABASE V5: "+V5);
System.out.println("DATABASE H6: "+H6);
//System.out.println("DATABASE V6: "+V6);
System.out.println("DATABASE H7: "+H7);


}

}
catch (SQLException ex) {
System.out.println(ex.getMessage());
}
}

public void htmlLineProgramtask() {

WebElement mainr=driver.findElement(By.name(prop.getProperty("HomePage.ViewReport.Button")));
mainr.click();
WebElement vr=driver.findElement(By.xpath(prop.getProperty("HomePage.VReport")));
vr.click();

driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
reportStep("View Report Page is launched", "pass", false);

WebElement ProgramTasks=driver.findElement(By.xpath("//*[@id=\"esrEditToolForm.lineOrgSelection\"]"));
ProgramTasks.click();

Select dropdown=new Select(driver.findElement(By.id("esrEditToolForm.lineOrgSelection")));
dropdown.selectByVisibleText("57200 - Service Readiness");

WebElement childTask=driver.findElement(By.xpath("//*[@id=\"apa1\"]"));
childTask.click();


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

//PSR-MSR Report


public void psrLineMSR(String unitId,String flag,String kpi) {

WebElement mainr=driver.findElement(By.name(prop.getProperty("HomePage.ViewReport.Button")));
mainr.click();
WebElement vr=driver.findElement(By.xpath(prop.getProperty("HomePage.VReport")));
vr.click();

driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
reportStep("View Report Page is launched", "pass", false);

WebElement ProgramTasks=driver.findElement(By.xpath("//*[@id=\"esrEditToolForm.lineOrgSelection\"]"));
ProgramTasks.click();

Select dropdown=new Select(driver.findElement(By.id("esrEditToolForm.lineOrgSelection")));
dropdown.selectByVisibleText("57200 - Service Readiness");

WebElement childTask=driver.findElement(By.xpath("//*[@id=\"apa1\"]"));
childTask.click();


WebElement msrRadio=driver.findElement(By.xpath("//*[@id=\"radio_R4_RF_Milestone\"]"));
msrRadio.click(); 

WebElement msr=driver.findElement(By.id("esrEditToolForm.selectMilestone"));
msr.click();
	
Select milestone=new Select(driver.findElement(By.id("esrEditToolForm.selectMilestone")));
milestone.selectByVisibleText("PS - Program Start");

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

//WebElement excel=driver.findElement(By.xpath("//*[@id=\"radio_R5_OF_Xls\"]"));
// excel.click();

//WebElement html=driver.findElement(By.xpath("//*[@id=\"radio_R5_OF_Html\"]"));
//html.click();

try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


anyClick("Submit", By.xpath(prop.getProperty("Get.Psr.Report")));

driver.manage().timeouts().implicitlyWait(Default_Wait_4_Page, TimeUnit.SECONDS);
Thread.sleep(20000);

 
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
     String kkpi=kpi;
     System.out.println("uId: "+uID);
     System.out.println("kkpi: "+kkpi);
 			     	
     getSkill1(uID,flag,kkpi);
    


}
catch(Exception e){
e.printStackTrace();
}
}

public void getSkill1(String unitId,String flag,String kpi) throws ClassNotFoundException, InterruptedException {
String ClassName = prop.getProperty("Test.PSR.SQLSERVER.ClassName");
String ConnectionString = prop.getProperty("Test.PSR.SQLSERVER.Connection.String");
String UserName = prop.getProperty("Test.PSR.SQLSERVER.User.Name");
String Password = prop.getProperty("Test.PSR.SQLSERVER.Password");

ResultSet rs;
Connection conn;
String query = "exec dbo.showCurrentPSRReport ?,?,?";
try {        
Class.forName(ClassName);
conn = DriverManager.getConnection(ConnectionString,UserName,Password);
CallableStatement stmt = conn.prepareCall(query); 
stmt.setString(1,unitId);

stmt.setString(2,flag);

stmt.setString(3,kpi);

System.out.println("callable success");


rs = stmt.executeQuery();
System.out.println("Query success");
Thread.sleep(2000);
while (rs.next()) {
//System.out.println(String.format("%s - %s",rs.getString("PuDesc"),rs.getString("KPI"),rs.getString("KPIInstance"),rs.getString("H2"),rs.getString("H3"),rs.getString("H4"),rs.getString("H5"),rs.getString("V5"),rs.getString("H6"),rs.getString("V6")));


Area = rs.getString("Area");
KPI = rs.getString("KPI"); 
KPIInstance=rs.getString("KPIInstance");
H2=rs.getString("H2");
H3=rs.getString("H3");
H4=rs.getString("H4");
V5=rs.getString("V5");
H5=rs.getString("H5");
H6=rs.getString("H6");
V6=rs.getString("V6");
H7=rs.getString("H7");
System.out.println("DATABASE Area: "+Area);
System.out.println("DATABASE KPI: "+KPI);
System.out.println("DATABASE KPIInstance: "+KPIInstance);
System.out.println("DATABASE H2: "+H2);
System.out.println("DATABASE H3: "+H3);
System.out.println("DATABASE H4: "+H4);
System.out.println("DATABASE H5: "+H5);
//System.out.println("DATABASE V5: "+V5);
System.out.println("DATABASE H6: "+H6);
//System.out.println("DATABASE V6: "+V6);
System.out.println("DATABASE H7: "+H7);


}

}
catch (SQLException ex) {
System.out.println(ex.getMessage());
}
}
}
