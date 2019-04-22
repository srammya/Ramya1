package com.volvo.automation.commonutilities;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

//POI Headers
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils extends CommonWrapperMethods {
	
	HashMap<String, String> testData = null;
	InputStream testFile = null;
	OutputStream outFile = null;
	XSSFWorkbook testWorkBook = null;
	DataFormatter formatter = new DataFormatter();
	
	public HashMap<String, String> testCaseRetrieve(String testCaseID, String sheetName)
	{
		
		
		try {
			
			testFile = new FileInputStream(Test_Sheet_Path);
			testWorkBook = new XSSFWorkbook(testFile);
			Sheet testSheet = testWorkBook.getSheet(sheetName);
			
			int testCaseColumn = getColumnNumber(testSheet, "Scenario_ID");
			int testCaseExecute = getColumnNumber(testSheet, "To_Be_Executed");
			
			if (testCaseColumn == -1)
			{
				System.err.println("Scenario_ID column not exist, Check the Data Sheet: "+ Test_Sheet_Path);
				reportStep("Scenario_ID column not exist, Check the Data Sheet: "+ Test_Sheet_Path, "FAIL", false);
				
			}
			
			int rowsCount = testSheet.getLastRowNum();
			
			for (int i = 1; i <= rowsCount; i ++)
			{
				//Navigate each row
				Row row = testSheet.getRow(i);
				Row rowHeader = testSheet.getRow(0);
				//Get the Test Case Id value
				Cell testCellValue = row.getCell(testCaseColumn);
				Cell testCellExecute = row.getCell(testCaseExecute);
				//Verify the test Id
				if (formatter.formatCellValue(testCellValue).equalsIgnoreCase(testCaseID) && testCellExecute.getStringCellValue().equalsIgnoreCase("Y"))
				{
					int colsCount = row.getLastCellNum();
					testData = new HashMap<String, String>();
					for (int j = 0; j < colsCount; j ++)
					{
						Cell cellHeader = rowHeader.getCell(j);
						Cell cellValue = row.getCell(j);
						testData.put(cellHeader.getStringCellValue(), formatter.formatCellValue(cellValue));
					}
					testData.entrySet();
					
					return testData;
				}
			}
			
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println("Error in Test Data Sheet access - Exception");


		}
		finally 
		{
			try 
			{
				testFile.close();
				testWorkBook.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return testData;	
	}
	
	private int getColumnNumber(Sheet getSheetName, String colName) {
		// TODO Auto-generated method stub
		Row row = getSheetName.getRow(0);
		
		int colCounts = row.getLastCellNum();
		
		for (int i=0; i< colCounts; i ++)
		{
			Cell cell = row.getCell(i);
			if (cell.getStringCellValue().equalsIgnoreCase(colName))
			{
				return i;
			}
		}
		return -1;
	}
	
	
	//Write the data in the cell
	public boolean excelUpdateValue(String sheetName, String colName, String ScenarioName, String strValue) {
		boolean bReturn = false;
		
		try {
				
				testFile = new FileInputStream(Test_Sheet_Path);
				//outFile = new FileOutputStream(Test_Sheet_Path);
				testWorkBook = new XSSFWorkbook(testFile);
				Sheet testSheet = testWorkBook.getSheet(sheetName);
				
				int testCaseColumn = getColumnNumber(testSheet, "Scenario_ID");
				int columnEdit = getColumnNumber(testSheet, colName);
				
				if (testCaseColumn == -1 || columnEdit == -1) 
				{
					return bReturn;
				}
				//Get the Row Count
				int rowsCount = testSheet.getLastRowNum();
				
				for (int i = 1; i <= rowsCount; i ++)
				{
					//Navigate each row
					Row row = testSheet.getRow(i);
					//Get the Test Case Id value
					Cell testCellValue = row.getCell(testCaseColumn);
					//Verify the Scenario Name
					if(formatter.formatCellValue(testCellValue).equalsIgnoreCase(ScenarioName))
					{
						Cell cell = row.createCell(columnEdit);
						cell.setCellValue(strValue);
						bReturn = true;
						System.out.println();
						break;
					}
					
				}
				outFile = new FileOutputStream(Test_Sheet_Path);
				testWorkBook.write(outFile);
				outFile.flush();
				outFile.close();
					
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				testWorkBook.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
				
	return bReturn;
	}
	
	
	public long takeSnap(){
		return 0;
	}

	
}
