package com.volvo.mfg.agv.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.volvo.automation.commonutilities.ExcelUtils;
import com.volvo.mfg.StepDefinition.DriverSuite;

public class MASWEB_Other_Functionalities extends DriverSuite {

	// Excel class object to access the function
		ExcelUtils excelUtils = new ExcelUtils();
		public HashMap<String, String> tdrow;
	
	
	public void ReportsTab() throws InterruptedException {
		
		String sheetName = "MASWEB_Other_Functionalities";
		// retrieve data from MasWeb_Page
		// Load Test Data File
		tdrow = excelUtils.testCaseRetrieve(refTestDataName, sheetName);
		
		//selecting a value from dropdown to display
		//selectDropDownValue("Dropdown", By.xpath(prop.getProperty("Masweb_Home.ReportsInMasweb.DropDown")),"25");
	
		anyClick("Dropdown button", By.xpath(prop.getProperty("Masweb_Home.ReportsInMasweb.DropDown")));
		anyClick("Dropdown value", By.xpath(prop.getProperty("Masweb_Home.ReportsInMasweb.DropDown.Value")));
		anyClick("Display button",By.xpath(prop.getProperty("Masweb_Home.ReportsInMasweb.Display_Button")));
		if(verifyElementExist("Reports Tab Table for selected option", By.xpath(prop.getProperty("Masweb_Home.Reports.Table")))==true) {
			verifyElementExist("Export to excel option", By.xpath(prop.getProperty("Masweb_Home.Reports.ExcelExport.Button")));
			anyClick("Export to excel button", By.xpath(prop.getProperty("Masweb_Home.Reports.ExcelExport.Button")));
			reportStep("Reports Table displayed for selected option with export to excel button ", "pass", true);
		}
		//navigating to reports create and edit tab
		anyClick("Reports Tab", By.xpath(prop.getProperty("Masweb_Home.Reports.Menu")));
		anyClick("Reports Tab edit and create tab", By.xpath(prop.getProperty("Masweb_Home.Reports.CreateAndEdit")));
		
		//clicking on edit button
		anyClick("Edit button", By.xpath(prop.getProperty("Masweb_Home.Reports.Edit.Button")));
		reportStep("Edit button is clicked successfully", "pass", true);
		anyClick("Return button", By.xpath(prop.getProperty("Masweb_Home.Reports.Return.Button")));
		reportStep("Return button is clicked successfully", "pass", true);
		anyClick("Create button is clicked successfully", By.xpath(prop.getProperty("Masweb_Home.Reports.Create.Button")));
		sendKeys("Report Name text box", By.xpath(prop.getProperty("Masweb_Home.Reports.ReportName")), "Test");
		anyClick("Save button", By.xpath(prop.getProperty("Masweb_Home.Reports.Save.Button")));
		//have to give values and save
		
		// new table
		String tableHeaderRow = prop.getProperty("Admin_ShowClose.Search.Table") + "/thead/tr";
		String tableObject = prop.getProperty("Masweb_Home.Reports.Table") + "/tbody/tr";
		List<WebElement> rows = driver.findElements(By.xpath(tableObject));
		int colEDIT = htmlTableColumnNamePosition("Edit", tableHeaderRow);
		int colReportName = htmlTableColumnNamePosition("Report name", tableHeaderRow);
		int row_count = rows.size();

		for (int i = 0; i <= row_count; i++) {
			int rowInc = i + 1;
			String strTableData = prop.getProperty("Admin_ShowClose.Search.Table") + "/tbody/tr[" + rowInc + "]/td";
			List<WebElement> tableData = driver.findElements(By.xpath(strTableData));
			String strReportName = tableData.get(colReportName).getText();
			System.out.println("strReportName: "+strReportName);
			if(strReportName.equalsIgnoreCase("Test")==true) {
			tableData.get(colEDIT).click();
			anyClick("Remove button",By.xpath(prop.getProperty("Masweb_Home.Reports.Remove.Button")));
			// handling the Alert
			isAlertPresent("ok");
			break;

			}
			
			reportStep("TaskID need to be closed: " + strReportName, "Pass", true);
		}
		
		
				
		
	}
	
	
}
