package com.volvo.psr.test;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.volvo.psr.common.utils.CommonWrapperMethods;
import com.volvo.psr.pagecomponents.LoginPage;
import com.volvo.psr.pagecomponents.MsrReport;
import com.volvo.psr.pagecomponents.PsrLineOrg;
import com.volvo.psr.pagecomponents.RiskReport;
import com.volvo.psr.pagecomponents.SaveTestProReport;
import com.volvo.psr.pagecomponents.ViewReport;


	public class TestSavedTestProReports extends TestBase {
	
	LoginPage loginPage;	
	SaveTestProReport saveTestProReport;
	ViewReport viewReport;
	RiskReport riskReport;
	MsrReport msrReport;
	PsrLineOrg psrLine;
	CommonWrapperMethods commonWrapperMethods;

	
	 @Test(dataProvider="TestDataProvider")
	 
	 public void testProReport(LinkedHashMap<String,String>testData) throws IOException, InterruptedException, ClassNotFoundException
	 {	 
		   loginPage=new LoginPage(driver);
		   loginPage.loginPage(testData.get("UserName"),testData.get("Password"));
		   saveTestProReport=new SaveTestProReport(driver);
		   viewReport=new ViewReport(driver);
		   riskReport=new RiskReport(driver);
		   msrReport=new MsrReport(driver);
		   psrLine=new PsrLineOrg(driver);
		
		  //saveTestProReport.PersonalReportProgramtask();
		  // saveTestProReport.PersonalReportLineOrg();
		  // saveTestProReport.ProgramTasksLineOrg();
		  // saveTestProReport.Subscriptiondaily();
		  // saveTestProReport.Subscriptionweekly();
		  // saveTestProReport.standardLibrary();
		  // saveTestProReport.generateSavedReport(testData.get("UnitId"),testData.get("Flag"),testData.get("KPI"));
		  // saveTestProReport.validatePDFReport();
		   
		   
		  // viewReport.ViewReportProgramtask(testData.get("UnitId"),testData.get("Flag"),testData.get("KPI"));
		   //viewReport.validatePDFReport();
		//   viewReport.psrDropdown(testData.get("UnitId"),testData.get("Flag"),testData.get("KPI"));
		  // viewReport.validatePDFReport();
		   //viewReport.htmlProgramtask();
		  // viewReport.psrMSR(testData.get("UnitId"),testData.get("Flag"),testData.get("KPI"));
		  // viewReport.validatePDFReport();
		   
		   // riskReport.ristRep(testData.get("UnitId"));
		   // riskReport.validatePDFReport();
		  // riskReport.ristRepDropDown(testData.get("UnitId"));
		  // riskReport.validatePDFReport();
		  // riskReport.htmlRisk();
		     //riskReport.riskMsr(testData.get("UnitId"));
			// riskReport.validatePDFReport();
		   
		 msrReport.msrRep(testData.get("UnitId"),testData.get("milestoneAbrr"),"####");
		 msrReport.validatePDFReport();
			  // msrReport.msrRepDropDown(testData.get("UnitId"));
			  // msrReport.validatePDFReport();
			 // msrReport.htmlMsr();
			 
			 //Line-Org
//			 psrLine.PsrLineTask(testData.get("UnitId"),testData.get("Flag"),testData.get("KPI"));
//			 psrLine.validatePDFReport();
			// psrLine.psrLineDropdown(testData.get("UnitId"),testData.get("Flag"),testData.get("KPI"));
			// psrLine.validatePDFReport();
			// psrLine.htmlLineProgramtask();
			// psrLine.psrLineMSR(testData.get("UnitId"),testData.get("Flag"),testData.get("KPI"));
			// psrLine.validatePDFReport();
		   
	 }
}