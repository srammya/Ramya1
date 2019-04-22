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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import com.volvo.psr.common.utils.CommonWrapperMethods;



public class SaveTestProReport extends CommonWrapperMethods {
	
	protected WebDriver driver;
	static String directory;
	static String PuDesc,KPI,KPIInstance,H2,H3,H4,H5,V5,H6,V6,pdfData;
	
	public void PersonalReportProgramtask() {
		WebElement psr=driver.findElement(By.xpath(prop.getProperty("HomePage.PSReport")));
		WebElement cr=driver.findElement(By.xpath(prop.getProperty("HomePage.CReport")));
		//WebElement sr=driver.findElement(By.xpath(prop.getProperty("HomePage.SReport")));
	    anyClick("Submit", By.name(prop.getProperty("HomePage.ViewReport.Button")));
        //anyClick("Submit", By.name(prop.getProperty("PersonalReport.CreateReport.Button")));
		
		
		Actions action =new Actions(driver);
		
		action.moveToElement(psr).perform();
		action.moveToElement(cr).perform();
		//action.moveToElement(sr).perform();
		cr.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		reportStep("Create Personal Page is launched", "pass", false);
		//reportStep("saved Report Page is launched", "pass", false);
		
		List <WebElement> pCheckBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(pCheckBox.size());
		for(int i=0; i <pCheckBox.size() ; i++ ){
			WebElement cb =pCheckBox.get(i);
			 String value =  cb.getAttribute("value");
	
			 if (value.equals("77486") || value.equals("80232")){
				 
				 cb.click();
				 
				  try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 //driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS) ;
				 System.out.println("Value:" + value);
				 reportStep("ProgramTask is Checked", "pass", false);
				 
				// break;
			 }
			 
			 }
		
		WebElement kpiButton=driver.findElement(By.xpath(prop.getProperty("PersonalReport.ChooseKpi")));
		kpiButton.click();
		WebElement kpiHeader=driver.findElement(By.xpath(prop.getProperty("PersonalReport.KpiHeader")));
		kpiHeader.click();
		WebElement kpiArea=driver.findElement(By.xpath(prop.getProperty("PersonalReport.KpiArea")));
		kpiArea.click();
		WebElement kpiInstance1=driver.findElement(By.xpath(prop.getProperty("PersonalReport.KpiInstance1")));
		kpiInstance1.click();
		WebElement kpiInstance2=driver.findElement(By.xpath(prop.getProperty("PersonalReport.KpiInstance2")));
		kpiInstance2.click();
		WebElement continue1=driver.findElement(By.xpath(prop.getProperty("PersonalReport.ContinueButton")));
		continue1.click();
		WebElement reportName=driver.findElement(By.xpath(prop.getProperty("PersonalReport.ReportName")));
		reportName.sendKeys("FirstReport_18_3");
		WebElement saveButton=driver.findElement(By.xpath(prop.getProperty("PersonalReport.SaveButton")));
		saveButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reportStep("ProgramTask report created successfully", "pass", false);
		
		/*WebElement back=driver.findElement(By.xpath(prop.getProperty("PersonalReport.Back")));
		back.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		 
		//uncheck
	/*	List <WebElement> tCheckBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int j=0; j <tCheckBox.size() ; j++ ){
			WebElement cb =tCheckBox.get(j);
			 String value1 =  cb.getAttribute("value");
	
			 if (value1.equals("77486") || value1.equals("80232")){
				 
				 cb.click();
				 
				  try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 //driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS) ;
				 System.out.println("Value:" + value1);
				 reportStep("ProgramTask is Unchecked", "pass", false);
				 
				// break;
			 }
		} */
	}
		//Line Org
		
	public void PersonalReportLineOrg() {
		/*WebElement psr=driver.findElement(By.xpath(prop.getProperty("HomePage.PSReport")));
		WebElement cr=driver.findElement(By.xpath(prop.getProperty("HomePage.CReport")));
		//WebElement sr=driver.findElement(By.xpath(prop.getProperty("HomePage.SReport")));
	    anyClick("Submit", By.name(prop.getProperty("HomePage.ViewReport.Button")));
        //anyClick("Submit", By.name(prop.getProperty("PersonalReport.CreateReport.Button")));
		
		
		Actions action =new Actions(driver);
		
		action.moveToElement(psr).perform();
		action.moveToElement(cr).perform();
		//action.moveToElement(sr).perform();
		cr.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		reportStep("Create Personal Page is launched", "pass", false);
		//reportStep("saved Report Page is launched", "pass", false);*/
		WebElement reportmenu=driver.findElement(By.xpath(prop.getProperty("PersonalReport.ReportMenu")));
	    reportmenu.click();
	    WebElement personalReportMenu=driver.findElement(By.xpath(prop.getProperty("PersonalReport.PersonalReportMenu")));
	    personalReportMenu.click();
	    WebElement createReportMenu=driver.findElement(By.xpath(prop.getProperty("PersonalReport.CreateReportMenu")));
	    createReportMenu.click();
		List <WebElement> lCheckBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int k=0; k < lCheckBox.size() ; k++ ){
			WebElement cb =lCheckBox.get(k);
			 String value1 =  cb.getAttribute("value");
	
			 if (value1.equals("178") || value1.equals("70")){
				 
				 cb.click();
				 
				  try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 //driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS) ;
				 System.out.println("Value:" + value1);
				 reportStep("LineOrg is Checked", "pass", false);
				 
				// break;
			 }
		}
		
		WebElement submit=driver.findElement(By.xpath(prop.getProperty("PersonalReport.SubmitTask")));
		submit.click();
		
		WebElement taskselect=driver.findElement(By.xpath("//*[@id=\"apa1\"]"));
		taskselect.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement kpiButton1=driver.findElement(By.xpath("//*[@id=\"kpiButton\"]"));
		kpiButton1.click();
		WebElement kpiHeader1=driver.findElement(By.xpath(prop.getProperty("PersonalReport.KpiHeader")));
		kpiHeader1.click();
		WebElement kpiArea1=driver.findElement(By.xpath(prop.getProperty("PersonalReport.KpiArea")));
		kpiArea1.click();
		WebElement kpiInstance3=driver.findElement(By.xpath(prop.getProperty("PersonalReport.KpiInstance1")));
		kpiInstance3.click();
		WebElement kpiInstance4=driver.findElement(By.xpath(prop.getProperty("PersonalReport.KpiInstance2")));
		kpiInstance4.click();
		WebElement continue2=driver.findElement(By.xpath(prop.getProperty("PersonalReport.ContinueButton")));
		continue2.click();
		WebElement reportName1=driver.findElement(By.xpath(prop.getProperty("PersonalReport.ReportName")));
		reportName1.sendKeys("FirstLineOrg");
		WebElement saveButton1=driver.findElement(By.xpath(prop.getProperty("PersonalReport.SaveButton")));
		saveButton1.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reportStep("LineOrg report created successfully", "pass", false);

		/*List <WebElement> orCheckBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int l=0; l <orCheckBox.size() ; l++ ){
			WebElement cb =orCheckBox.get(l);
			 String value1 =  cb.getAttribute("value");
	
			 if (value1.equals("178") || value1.equals("70")){
				 
				 cb.click();
				 
				  try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 //driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS) ;
				 System.out.println("Value:" + value1);
				 reportStep("LineOrg is Unchecked", "pass", false);
				 
				// break;
			 }
		} */
		
	}
		//Validate Program task and line org selection
	
	public void ProgramTasksLineOrg() {
		/*WebElement psr=driver.findElement(By.xpath(prop.getProperty("HomePage.PSReport")));
		WebElement cr=driver.findElement(By.xpath(prop.getProperty("HomePage.CReport")));
		//WebElement sr=driver.findElement(By.xpath(prop.getProperty("HomePage.SReport")));
	    anyClick("Submit", By.name(prop.getProperty("HomePage.ViewReport.Button")));
        //anyClick("Submit", By.name(prop.getProperty("PersonalReport.CreateReport.Button")));
		
		
		Actions action =new Actions(driver);
		
		action.moveToElement(psr).perform();
		action.moveToElement(cr).perform();
		//action.moveToElement(sr).perform();
		cr.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		//reportStep("Create Personal Page is launched", "pass", false);
		reportStep("saved Report Page is launched", "pass", false);*/
		
        WebElement reportmenu=driver.findElement(By.xpath(prop.getProperty("PersonalReport.ReportMenu")));
		reportmenu.click();
		WebElement personalReportMenu=driver.findElement(By.xpath(prop.getProperty("PersonalReport.PersonalReportMenu")));
	    personalReportMenu.click();
	    WebElement createReportMenu=driver.findElement(By.xpath(prop.getProperty("PersonalReport.CreateReportMenu")));
	    createReportMenu.click();
		
		List <WebElement> plCheckBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int m=0; m < plCheckBox.size() ; m++ ){
			WebElement cb =plCheckBox.get(m);
			 String value1 =  cb.getAttribute("value");
	
			 if (value1.equals("77486") || value1.equals("178")){
				 
				 cb.click();
				 
				  try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 //driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS) ;
				 System.out.println("Value:" + value1);
				 reportStep("programTask and LineOrg is Checked", "pass", false);
				 
				// break;
			 }
		}
		WebElement submit1=driver.findElement(By.xpath(prop.getProperty("PersonalReport.SubmitTask")));
		submit1.click();
		reportStep("Error Message Displayed", "pass", false);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	} 

	
	public void Subscriptiondaily() {
		
		//WebElement homemenu=driver.findElement(By.xpath(prop.getProperty("HomePage.Menu")));
		//homemenu.click();
		WebElement psr=driver.findElement(By.xpath(prop.getProperty("HomePage.PSReport")));
	    WebElement sr=driver.findElement(By.xpath(prop.getProperty("HomePage.SReport")));
	    anyClick("Submit", By.name(prop.getProperty("HomePage.ViewReport.Button")));
        //anyClick("Submit", By.name(prop.getProperty("PersonalReport.CreateReport.Button")));
		
		
		Actions action =new Actions(driver);
		
		action.moveToElement(psr).perform();
		action.moveToElement(sr).perform();
		sr.click();
		reportStep("saved Report Page is launched", "pass", false);
		
		// Daily Report
		
		
		WebElement subscrp=driver.findElement(By.xpath("//*[@id=\"subscribeButton_159\"]"));
		subscrp.click();
		 
		/*WebElement occRange=driver.findElement(By.xpath("//*[@id=\"one\"]/p/input"));
		occRange.sendKeys("1");*/
		//WebElement enddate=driver.findElement(By.xpath("//*[@id=\"maxDate2\"]"));
		//enddate.click();
		
		WebElement startDate=driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/form/div/fieldset[2]/div/div[1]/a/img"));
		startDate.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	      Set<String>swinid=driver.getWindowHandles();

	       Iterator<String> sit=swinid.iterator();

	       String smainWindow=sit.next();

	       System.out.println("mainWindow: "+smainWindow);

	       String sWindow=sit.next();

	       System.out.println("sWindow: "+sWindow);

	       driver.switchTo().window(sWindow);
	       
	       driver.manage().window().maximize();
	       
	       WebElement pickStartDate=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[6]/span/a"));
	       pickStartDate.click();
	       
	       try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
	       

	       driver.switchTo().window(smainWindow);
	       
	       try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	   
	     
	    
	 		
		
		//EndDate select
	   WebElement selectEndDate=driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/form/div/fieldset[2]/div/div[2]/p[2]/a/img"));
	   selectEndDate.click();
       // Date Picker 
		//anyClick("LifeCycle Date click", By.xpath(prop.getProperty("LifeCycle_Date.Click")));

	       try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	      Set<String>winid=driver.getWindowHandles();

	       Iterator<String> it=winid.iterator();

	       String mainWindow=it.next();

	       System.out.println("mainWindow: "+mainWindow);

	       String Window=it.next();

	       System.out.println("cWindow: "+Window);

	       driver.switchTo().window(Window);
	       
	       driver.manage().window().maximize();
	       
	       WebElement pickEndDate=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/span/a"));
	       pickEndDate.click();
	       
	       try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
	       

	       driver.switchTo().window(mainWindow);
	       try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	   
	       WebElement save=driver.findElement(By.xpath(prop.getProperty("Subscription.Save")));
	 		 save.click();
	    
	 		
	       
	    reportStep("Daily Report Done", "pass", false);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
		
		// Weekly Report
		public void Subscriptionweekly() {
			
			WebElement psr=driver.findElement(By.xpath(prop.getProperty("HomePage.PSReport")));
		    WebElement sr=driver.findElement(By.xpath(prop.getProperty("HomePage.SReport")));
		    anyClick("Submit", By.name(prop.getProperty("HomePage.ViewReport.Button")));
	        //anyClick("Submit", By.name(prop.getProperty("PersonalReport.CreateReport.Button")));
			
			
			Actions action =new Actions(driver);
			
			action.moveToElement(psr).perform();
			action.moveToElement(sr).perform();
			sr.click();
			reportStep("saved Report Page is launched", "pass", false);
			
			WebElement subscrp=driver.findElement(By.xpath("//*[@id=\"subscribeButton_158\"]"));
			subscrp.click();
			
			
			
			WebElement radioBtn = driver.findElement(By.id("weekly"));
			radioBtn.click();
		    WebElement selectSun=driver.findElement(By.xpath("//*[@id=\"two\"]/p[2]/span[7]/input"));
		    selectSun.click();
		    
		    WebElement selectWeeklyStartDate=driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/form/div/fieldset[2]/div/div[1]/a/img"));
		    selectWeeklyStartDate.click();
		       // Date Picker 
				//anyClick("LifeCycle Date click", By.xpath(prop.getProperty("LifeCycle_Date.Click")));

			       try {
					Thread.sleep(2000);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

			      Set<String>winid=driver.getWindowHandles();

			       Iterator<String> wsit=winid.iterator();

			       String mainWindow=wsit.next();

			       System.out.println("mainWindow: "+mainWindow);

			       String Window=wsit.next();

			       System.out.println("Window: "+Window);

			       driver.switchTo().window(Window);
			       
			       driver.manage().window().maximize();
			       
			       WebElement pickWeeklyStartDate=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[6]/span/a"));
			       pickWeeklyStartDate.click();
			       
			       try {
						Thread.sleep(5000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
			       

			       driver.switchTo().window(mainWindow);
			       try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			   //Weekly End Date
			       
			       WebElement selectWeeklyEndDate=driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/form/div/fieldset[2]/div/div[2]/p[2]/a/img"));
				   selectWeeklyEndDate.click();
				       // Date Picker 
						//anyClick("LifeCycle Date click", By.xpath(prop.getProperty("LifeCycle_Date.Click")));

					       try {
							Thread.sleep(2000);
						} catch (InterruptedException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}

					      Set<String>wewinid=driver.getWindowHandles();

					       Iterator<String> weit=wewinid.iterator();

					       String emainWindow=weit.next();

					       System.out.println("mainWindow: "+mainWindow);

					       String wWindow=weit.next();

					       System.out.println("Window: "+wWindow);

					       driver.switchTo().window(wWindow);
					       
					       driver.manage().window().maximize();
					       
					       WebElement pickWeeklyEndndDate=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/span/a"));
					       pickWeeklyEndndDate.click();
					       
					       try {
								Thread.sleep(5000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
					       

					       driver.switchTo().window(mainWindow);
					       try {
								Thread.sleep(4000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
		
		 reportStep("Weekly Report Done", "pass", false);
		 
		 WebElement save1=driver.findElement(By.xpath(prop.getProperty("Subscription.Save")));
		 save1.click();
		}

		//Monthly Report
public void Subscriptionmonthly() {
			
			WebElement psr=driver.findElement(By.xpath(prop.getProperty("HomePage.PSReport")));
		    WebElement sr=driver.findElement(By.xpath(prop.getProperty("HomePage.SReport")));
		    anyClick("Submit", By.name(prop.getProperty("HomePage.ViewReport.Button")));
	        //anyClick("Submit", By.name(prop.getProperty("PersonalReport.CreateReport.Button")));
			
			
			Actions action =new Actions(driver);
			
			action.moveToElement(psr).perform();
			action.moveToElement(sr).perform();
			sr.click();
			reportStep("saved Report Page is launched", "pass", false);
			
			WebElement subscrp=driver.findElement(By.xpath("//*[@id=\"subscribeButton_158\"]"));
			subscrp.click();
			
			
			
			WebElement radioBtn = driver.findElement(By.id("monthly"));
			radioBtn.click();
			
			WebElement dayDrop = driver.findElement(By.xpath("//*[@id=\"three\"]/p[2]/select[1]"));
			dayDrop.click();
			
		    WebElement selectSun=driver.findElement(By.xpath("//*[@id=\"two\"]/p[2]/span[7]/input"));
		    selectSun.click();
		    
		    WebElement selectWeeklyStartDate=driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/form/div/fieldset[2]/div/div[1]/a/img"));
		    selectWeeklyStartDate.click();
		       // Date Picker 
				//anyClick("LifeCycle Date click", By.xpath(prop.getProperty("LifeCycle_Date.Click")));

			       try {
					Thread.sleep(2000);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

			      Set<String>winid=driver.getWindowHandles();

			       Iterator<String> wsit=winid.iterator();

			       String mainWindow=wsit.next();

			       System.out.println("mainWindow: "+mainWindow);

			       String Window=wsit.next();

			       System.out.println("Window: "+Window);

			       driver.switchTo().window(Window);
			       
			       driver.manage().window().maximize();
			       
			       WebElement pickWeeklyStartDate=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[6]/span/a"));
			       pickWeeklyStartDate.click();
			       
			       try {
						Thread.sleep(5000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
			       

			       driver.switchTo().window(mainWindow);
			       try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			   //Weekly End Date
			       
			       WebElement selectWeeklyEndDate=driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/form/div/fieldset[2]/div/div[2]/p[2]/a/img"));
				   selectWeeklyEndDate.click();
				       // Date Picker 
						//anyClick("LifeCycle Date click", By.xpath(prop.getProperty("LifeCycle_Date.Click")));

					       try {
							Thread.sleep(2000);
						} catch (InterruptedException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}

					      Set<String>wewinid=driver.getWindowHandles();

					       Iterator<String> weit=wewinid.iterator();

					       String emainWindow=weit.next();

					       System.out.println("mainWindow: "+mainWindow);

					       String wWindow=weit.next();

					       System.out.println("Window: "+wWindow);

					       driver.switchTo().window(wWindow);
					       
					       driver.manage().window().maximize();
					       
					       WebElement pickWeeklyEndndDate=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/span/a"));
					       pickWeeklyEndndDate.click();
					       
					       try {
								Thread.sleep(5000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
					       

					       driver.switchTo().window(mainWindow);
					       try {
								Thread.sleep(4000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
		
		 reportStep("Weekly Report Done", "pass", false);
		 
		 WebElement save1=driver.findElement(By.xpath(prop.getProperty("Subscription.Save")));
		 save1.click();
		}
	public void standardLibrary() {
		
		//WebElement homemenu=driver.findElement(By.xpath(prop.getProperty("HomePage.Menu")));
		//homemenu.click();
		WebElement admin=driver.findElement(By.xpath(prop.getProperty("Administration.Menu")));
	    WebElement stdl=driver.findElement(By.xpath(prop.getProperty("Administration.StandradLibrary")));
	    //anyClick("Submit", By.name(prop.getProperty("HomePage.ViewReport.Button")));
        //anyClick("Submit", By.name(prop.getProperty("PersonalReport.CreateReport.Button")));
		
		
	/*	Actions action =new Actions(driver);
		action.moveToElement(admin).perform();
		action.moveToElement(stdl).perform();*/
		admin.click();
		stdl.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		WebElement stdnew=driver.findElement(By.xpath(prop.getProperty("StandardLibrary.New")));
		stdnew.click();
		
		
		WebElement kpiHeader1=driver.findElement(By.xpath(prop.getProperty("PersonalReport.KpiHeader")));
		kpiHeader1.click();
		WebElement kpiArea1=driver.findElement(By.xpath(prop.getProperty("PersonalReport.KpiArea")));
		kpiArea1.click();
		WebElement kpiInstance5=driver.findElement(By.name(prop.getProperty("Standard.Kpiinstance1")));
		kpiInstance5.click();
		WebElement kpiInstance6=driver.findElement(By.name(prop.getProperty("Standard.Kpiinstance2")));
		kpiInstance6.click(); 
		 
		WebElement stdreportName=driver.findElement(By.id("personalReportName"));
		stdreportName.sendKeys("NewLib_3");
		WebElement stdSave=driver.findElement(By.id("saveButton"));
		stdSave.click();
		reportStep("Library Created Successfully", "pass", false);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		WebElement reportmenu=driver.findElement(By.xpath(prop.getProperty("PersonalReport.ReportMenu")));
	    reportmenu.click();
	    WebElement personalReportMenu=driver.findElement(By.xpath(prop.getProperty("PersonalReport.PersonalReportMenu")));
	    personalReportMenu.click();
	    WebElement createReportMenu=driver.findElement(By.xpath(prop.getProperty("PersonalReport.CreateReportMenu")));
	    createReportMenu.click();
	    
	    List <WebElement> pCheckBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(pCheckBox.size());
		for(int i=0; i <pCheckBox.size() ; i++ ){
			WebElement cb =pCheckBox.get(i);
			 String value =  cb.getAttribute("value");
	
			 if (value.equals("77486") || value.equals("80232")){
				 
				 cb.click();
				 
				  try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 //driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS) ;
				 System.out.println("Value:" + value);
				 reportStep("ProgramTask is Checked", "pass", false);
				 
				// break;
			 }
			 
			 }
		
		WebElement kpiButton=driver.findElement(By.xpath(prop.getProperty("PersonalReport.ChooseKpi")));
		kpiButton.click();
		
		WebElement stdLibButton=driver.findElement(By.xpath(prop.getProperty("Standard.Button")));
		stdLibButton.click();
		WebElement selectButton=driver.findElement(By.xpath(prop.getProperty("Select.Library")));
		selectButton.click();
		
		WebElement reportName=driver.findElement(By.xpath(prop.getProperty("PersonalReport.ReportName")));
		reportName.sendKeys("StdLibReport_3");
		WebElement saveButton=driver.findElement(By.xpath(prop.getProperty("PersonalReport.SaveButton")));
		saveButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reportStep("ProgramTask report created successfully", "pass", false);
		
	}

	
	public SaveTestProReport(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	 	}
	 
	
	

	public void generateSavedReport(String unitId,String flag,String kpi){
		
		//WebElement homemenu=driver.findElement(By.xpath(prop.getProperty("HomePage.Menu")));
		//homemenu.click();
		WebElement mainr=driver.findElement(By.name(prop.getProperty("HomePage.ViewReport.Button")));
		mainr.click();
		WebElement psr=driver.findElement(By.xpath(prop.getProperty("HomePage.PSReport")));
	    WebElement sr=driver.findElement(By.xpath(prop.getProperty("HomePage.SReport")));
	    
Actions action =new Actions(driver);
		
		action.moveToElement(psr).perform();
		action.moveToElement(sr).perform();
		sr.click();
		reportStep("saved Report Page is launched", "pass", false);
		
	
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
			
			
			anyClick("Submit", By.xpath(prop.getProperty("Get.Test.Pro.Report")));
			
			Thread.sleep(7000);
		     
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
	
	public static void getSkills(String unitId,String flag,String kpi) throws ClassNotFoundException, InterruptedException {
		String ClassName = prop.getProperty("Test.PSR.SQLSERVER.ClassName");
		String ConnectionString = prop.getProperty("Test.PSR.SQLSERVER.Connection.String");
		String UserName = prop.getProperty("Test.PSR.SQLSERVER.User.Name");
		String Password = prop.getProperty("Test.PSR.SQLSERVER.Password");

		ResultSet rs;
		Connection conn;
		String query = "exec dbo.showCurrentPSRStdPersonalReport ?,?,?";
try {        
		Class.forName(ClassName);
		conn = DriverManager.getConnection(ConnectionString,UserName,Password);
		CallableStatement stmt = conn.prepareCall(query); 
        	stmt.setString(1, unitId);
        	
        	stmt.setString(2, flag);
        
    		stmt.setString(3,kpi);
            
        	System.out.println("callable success");
   

    rs = stmt.executeQuery();
	System.out.println("Query success");
	Thread.sleep(2000);
    while (rs.next()) {
      // System.out.println(String.format("%s - %s",rs.getString("PuDesc"),rs.getString("KPI"),rs.getString("KPIInstance"),rs.getString("H2"),rs.getString("H3"),rs.getString("H4"),rs.getString("H5"),rs.getString("V5"),rs.getString("H6"),rs.getString("V6")));
        
      
       PuDesc = rs.getString("PuDesc");
       KPI = rs.getString("KPI"); 
       KPIInstance=rs.getString("KPIInstance");
       H2=rs.getString("H2");
       H3=rs.getString("H3");
       H4=rs.getString("H4");
        V5=rs.getString("V5");
       H6=rs.getString("H6");
      V6=rs.getString("V6");
        System.out.println("DATABASE PuDesc: "+PuDesc);
        System.out.println("DATABASE KPI: "+KPI);
        System.out.println("DATABASE KPIInstance: "+KPIInstance);
        System.out.println("DATABASE H2: "+H2);
        System.out.println("DATABASE H3: "+H3);
        System.out.println("DATABASE H4: "+H4);
        //System.out.println("DATABASE H5: "+H5);
        //System.out.println("DATABASE V5: "+V5);
        System.out.println("DATABASE H6: "+H6);
        //System.out.println("DATABASE V6: "+V6);
        
      
    }

}
		catch (SQLException ex) {
    System.out.println(ex.getMessage());
}
}

	public void validatePDFReport() {
		
		if(pdfData.contains(PuDesc)) {
			System.out.println("PuDesc found");
			reportStep("PUDesc data found in PDF " + PuDesc + " - Completed", "pass", false);
		}
		
		else {
			System.out.println("PuDesc NOT found");
			reportStep("PUDesc data NOT found in PDF " + PuDesc + " - Completed", "fail", false);
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
		
		else /* {
			System.out.println("H5 NOT found");
			reportStep("H5 data NOT found in PDF " + H5 + " - Completed", "fail", false);
		}
		
				
		if(pdfData.contains(V5)) {
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
						
		
	}

	
}
