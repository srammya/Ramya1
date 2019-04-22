package com.volvo.mfg.StepDefinition;

import java.io.FileInputStream;

import java.io.InputStream;

import java.util.HashMap;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import com.volvo.automation.commonutilities.DB_Connectivity;
import com.volvo.automation.commonutilities.ExcelUtils;
import com.volvo.mfg.agv.pages.AGV_MachineIDScan;
import com.volvo.mfg.agv.pages.AGV_RackChanger;
import com.volvo.mfg.agv.pages.Admin_Page;
import com.volvo.mfg.agv.pages.Agv_Emulator;
import com.volvo.mfg.agv.pages.BlueBox;
import com.volvo.mfg.agv.pages.LDJIT;
import com.volvo.mfg.agv.pages.LoginPage;
import com.volvo.mfg.agv.pages.MASWEB_Other_Functionalities;
import com.volvo.mfg.agv.pages.MasWeb_Home;
//import com.volvo.mfg.agv.pages.Multiple_Tugger;
import com.volvo.mfg.agv.pages.Production_ControlCodes;
import com.volvo.mfg.agv.pages.Sekadm;
import com.volvo.mfg.agv.pages.V60_Page;
import com.volvo.mfg.agv.pages.V90_Pages;
import com.volvo.mfg.agv.pages.Vclas_Assignment;
import com.volvo.mfg.agv.pages.Vclas_TestCases;
import com.volvo.mfg.agv.pages.Vclas_tasks;

public class DriverSuite extends BaseTest {

	// Excel class object to access the function
	protected static ExcelUtils excelUtils = new ExcelUtils();
	HashMap<String, String> tdrow;
	// CommonWrapperMethods cwm = new CommonWrapperMethods();

	@Test(description = "ADMIN Pages End-to-End flow")
	@Parameters({ "TestName" })
	public void ADMIN_SCANNEDGOODS(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);

			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_Admin_ScannedGoods();

			// Scanned goods
			Admin_Page ap = new Admin_Page();
			ap.ScannedGoods_Display();
			ap.Deletion_Verification();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	// priya
	@Test(description = "Admin End-to-End flow")
	@Parameters({ "TestName" })
	public void CONTROL_PARAMETER(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);

			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_Admin_ControlParameters();

			// adminpages_controlparameter
			Admin_Page ap = new Admin_Page();
			ap.ControlParameters_Create();
			// flow with random number

			ap.ControlParameters_CreateNew("Save");
			ap.ControlParameters_CreateNew("Return");
			ap.ControlParameters_Display();
			ap.ControlParameters_Edit("Save");
			ap.ControlParameters_Display();
			ap.ControlParameters_Edit("Remove");
			ap.ControlParameters_Clear();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}

	}

	@Test(description = "Admin End-to-End flow")
	@Parameters({ "TestName" })
	public void TEST_PRINTER(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);

			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_Admin_TestPrinter();

			// Adminpage_testprinter
			Admin_Page ap = new Admin_Page();
			ap.TestPrinter_Add();
			ap.TestPrinter_Remove();
			ap.TestPrinter_Print();
			ap.TestPrinter_Clear();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}

	}

	@Test(description = "ADMIN Pages End-to-End flow")
	@Parameters({ "TestName" })
	public void ADMIN_MANAGEALARMS(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);

			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_Admin_Manage_ManageAlarms();

			// Manage Alarms
			Admin_Page ap = new Admin_Page();
			ap.Managealarms("Display");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "ADMIN Pages End-to-End flow")
	@Parameters({ "TestName" })
	public void ADMIN_MANAGEALARMIDS(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);

			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_Admin_Manage_ManageAlarmids();

			// Manage AlarmIDs
			Admin_Page ap = new Admin_Page();
			ap.Managealarmsids_Create();
			ap.Managealarmsids_Remove();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "Admin End-to-End flow")
	@Parameters({ "TestName" })
	public void ADMIN_SHOWTASK(String TestName) {
		try {
			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);

			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_Admin_ShowClose();
			// SHOWCLOSE PAGE
			Admin_Page ap = new Admin_Page();
			// Return
			ap.ShowClose_Tasks_display();
			ap.ShowClose_Edit_Return();
			ap.ShowClose_Tasks_clear();
			// Close Task
			ap.ShowClose_Tasks_display();
			ap.ShowClose_Edit_Close_Task();
			ap.CloseTask_Verification();

		} catch (Exception e) {
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "Admin End-to-End flow")
	@Parameters({ "TestName" })
	public void BLUEBOX(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);

			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_Bluebox_Best();

			// BlueBox Page

			BlueBox bb = new BlueBox();

			bb.blueboxBest();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}

	}

	@Test(description = "V60 End-to-End flow")
	@Parameters({ "TestName" })
	public void V60_NormalStation(String TestName) {
		try {
			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);

			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_V60_ScanRFID_NormalStation();
			// V60 Page
			V60_Page vp = new V60_Page();
			// Return
			vp.V60_NormalStation_Display();

		} catch (Exception e) {
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "V60 End-to-End flow")
	@Parameters({ "TestName" })
	public void V60_RepairStation(String TestName) {
		try {
			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);

			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_V60_ScanRFID_RepairStation();
			// V60 Page
			V60_Page vp = new V60_Page();
			// Return
			vp.V60_RepairStation_Display();

		} catch (Exception e) {
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "V90 End-to-End flow")
	@Parameters({ "TestName" })
	public void V90_DELIVERV90TASKS(String TestName) {
		try {
			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);

			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_V90_DeliverV90Tasks();
			// V90 PAGE
			V90_Pages vp = new V90_Pages();
			// Return
			vp.DeliverV90Tasks_Deliver();
			mwHome.Navigate_V90_V90PackagingNote();
			// vp.V90PackagingNote_Display();

		} catch (Exception e) {
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "Admin End-to-End flow")
	@Parameters({ "TestName" })
	public void SIMULATOR(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);

			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_Admin_Simulator_Assembly_Line();

			Admin_Page adp = new Admin_Page();

			adp.Simulator_Assemblyline_Click(3);

			/*
			 * Vclas_Assignment va=new Vclas_Assignment();
			 * 
			 * va.clickk();
			 */ // to check threshold

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(description = "Tugger End-to-End flow")
	@Parameters({ "TestName" })
	public void TUGGER(String TestName) {
		try {

			// Tugger Flow
			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);
			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_Vclas_CreateNewRack();
			// Sekadm Page
			Sekadm sp = new Sekadm();
			// pre requisite

			sp.Prerequiste_tugger();
			sp.sekadmCreate();
			sp.checkOrderSequence();
			// Vclas_task
			mwHome.Navigate_Vclas_Task();
			Vclas_tasks vt = new Vclas_tasks();
			vt.Vclas_getRacksTaskId();

			// Vclas_Login_app
			lp.LogintoVclas(TestName);
			// Load Test Data File
			tdrow = excelUtils.testCaseRetrieve(refTestDataName, "Vclas_Assignments");
			String stRoomValue = tdrow.get("Select_Work_Area_Room");
			tdrow.clear();
			// Select Rooms - Tugger
			Vclas_Assignment vclasAgn = new Vclas_Assignment();
			vclasAgn.Vclas_Assignment_Navigate();
			vclasAgn.Vclas_Assignment_SelectWorkArea("Room", stRoomValue.split(",")[0]);
			vclasAgn.Vclas_Tugger_Shortage_Assignment_Flow("Tugger");
			// Verify the Inactive tasks
			mwHome.Navigate_Vclas_Task();
			vt.Vclas_VerifyTaskEvents_Inactive("");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}

	}

	@Test(description = "Tugger End-to-End flow")
	@Parameters({ "TestName" })
	public void TUGGER_ASSIGNMENT_DELIVERY(String TestName) {
		try {

			// Tugger Flow
			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);
			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_Vclas_CreateNewRack();
			// Sekadm Page
			Sekadm sp = new Sekadm();
			// pre requisite

			sp.Prerequiste_tugger();
			sp.sekadmCreate();
			// sp.checkOrderSequence();
			// Vclas_task
			mwHome.Navigate_Vclas_Task();
			Vclas_tasks vt = new Vclas_tasks();
			vt.Vclas_getRacksTaskId();

			// Vclas_Login_app
			lp.LogintoVclas(TestName);
			// Load Test Data File
			tdrow = excelUtils.testCaseRetrieve(refTestDataName, "Vclas_Assignments");
			String stRoomValue = tdrow.get("Select_Work_Area_Room");
			tdrow.clear();
			// Select Rooms - Tugger
			Vclas_Assignment vclasAgn = new Vclas_Assignment();
			vclasAgn.Vclas_Assignment_Navigate();
			vclasAgn.Vclas_Assignment_SelectWorkArea("Room", stRoomValue.split(",")[0]);
			vclasAgn.Vclas_Tugger_Assignment_Delivery("Tugger");
			// Verify the Inactive tasks
			// mwHome.Navigate_Vclas_Task();
			// vt.Vclas_VerifyTaskEvents_Inactive("");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}

	}

	@Test(description = "JISJIT Tugger End-to-End flow")
	@Parameters({ "TestName" })
	public void JISJIT_TUGGER(String TestName) {
		try {

			// JISJIT Tugger Flow

			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);
			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_Vclas_CreateNewRack();
			// Sekadm Page
			Sekadm sp = new Sekadm();
			sp.Prerequiste_JISJIT_Tugger();
			sp.sekadmCreate();
			// Vclas_task
			mwHome.Navigate_Vclas_Task();
			Vclas_tasks vt = new Vclas_tasks();
			vt.Vclas_getRacksTaskId();

			// Vclas_Login_app

			lp.LogintoVclas(TestName);
			// Load Test Data File
			tdrow = excelUtils.testCaseRetrieve(refTestDataName, "Vclas_Assignments");
			String stRoomValue = tdrow.get("Select_Work_Area_Room");
			tdrow.clear();

			// Select Rooms - Tugger
			Vclas_Assignment vclasAgn = new Vclas_Assignment();
			vclasAgn.Vclas_Assignment_Navigate();
			vclasAgn.Vclas_Assignment_SelectWorkArea("Room", stRoomValue);
			vclasAgn.Vclas_Tugger_Shortage_Assignment_Flow("JISJIT");

			mwHome.Navigate_Vclas_Task();
			vt.Vclas_VerifyTaskEvents_Inactive("");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "JISJIT Tugger End-to-End flow")
	@Parameters({ "TestName" })
	public void JISJIT_TUGGER_DUMMY_ASN(String TestName) {
		try {

			// JISJIT Tugger Flow

			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);
			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_Vclas_CreateNewRack();
			// Sekadm Page
			Sekadm sp = new Sekadm();
			sp.Prerequiste_JISJIT_Tugger();
			sp.Data_Deletion_JISJIT_Tugger();
			sp.sekadmCreate();
			// Vclas_task
			Vclas_tasks vt = new Vclas_tasks();
			vt.Navigate_Vclas_Task();
			vt.Vclas_getRacksTaskId();

			// Vclas_Login_app

			lp.LogintoVclas(TestName);
			// Load Test Data File
			tdrow = excelUtils.testCaseRetrieve(refTestDataName, "Vclas_Assignments");
			String stRoomValue = tdrow.get("Select_Work_Area_Room");
			tdrow.clear();

			// Select Rooms - Tugger
			Vclas_Assignment vclasAgn = new Vclas_Assignment();
			vclasAgn.Vclas_Assignment_Navigate();
			vclasAgn.Vclas_Assignment_SelectWorkArea("Room", stRoomValue);
			vclasAgn.Vclas_Tugger_Shortage_Assignment_Flow("JISJIT");

			vt.Vclas_VerifyTaskEvents_Inactive("");

			sp.Data_Insertion_JISJIT_Tugger();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "LDJIT Trailer End-to-End flow")
	@Parameters({ "TestName" })
	public void LDJIT_TRAILER(String TestName) {
		try {

			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);
			// Navigation to LDJIT-> Yard zone maintenance
			LDJIT obj = new LDJIT();
			obj.navigateLdjit();
			// Parking the trailer
			obj.ldjitTrailersInfoPark();
			// Bringing full trailer
			obj.navigateLdjit();
			obj.createTrailerAssignments("full");
			obj.navigateLdjit();
			obj.verifyFullTrailer("full");
			Vclas_tasks vt = new Vclas_tasks();
			vt.Navigate_Vclas_Task();
			vt.Vclas_Search_Partno();
			// Verification in vclas tasks- ACK
			obj.verifyTrailerAck();

			// Vclas_Login_app
			lp.LogintoVclas(TestName);

			// Load Test Data File
			tdrow = excelUtils.testCaseRetrieve(refTestDataName, "Vclas_Assignments");
			String stRoomValue = tdrow.get("Select_Work_Area_Room");
			tdrow.clear();

			// Select Rooms - Tugger
			Vclas_Assignment vclasAgn = new Vclas_Assignment();
			vclasAgn.Vclas_Assignment_Navigate();
			vclasAgn.Vclas_Assignment_SelectWorkArea("Room", stRoomValue);
			// Delivery of trailer from assignment list
			obj.trailerFlowDelivery("Full");

			// Update trailer as empty
			obj.updateLDJITTrailerEmpty();
			obj.navigateLdjit();
			obj.createTrailerAssignments("empty");

			vt.Navigate_Vclas_Task();
			vt.Vclas_Search_Partno();
			obj.verifyTrailerAck();
			// driver.switchTo().window(browser[2]);
			// deliver empty trailer
			obj.trailerFlowDelivery("Empty");
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_Vclas_Task();
			vt.Agv_Vclas_VerifyTaskEvents_Inactive("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "JISJIT Tugger End-to-End flow")
	@Parameters({ "TestName" })
	public void JISJIT_TUGGER_GR(String TestName) {
		try {

			// JISJIT Tugger Flow

			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);
			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_Vclas_CreateNewRack();
			// Sekadm Page
			Sekadm sp = new Sekadm();
			sp.Prerequiste_JISJIT_Tugger();
			sp.sekadmCreate();

			// Vclas_task
			mwHome.Navigate_Vclas_Task();
			Vclas_tasks vt = new Vclas_tasks();
			vt.Vclas_getRacksTaskId();

			// Vclas_Login_app

			lp.LogintoVclas(TestName);
			// Load Test Data File
			tdrow = excelUtils.testCaseRetrieve(refTestDataName, "Vclas_Assignments");
			String stRoomValue = tdrow.get("Select_Work_Area_Room");
			tdrow.clear();

			// Select Rooms - Tugger
			Vclas_Assignment vclasAgn = new Vclas_Assignment();
			vclasAgn.Vclas_Assignment_Navigate();
			vclasAgn.Vclas_Assignment_SelectWorkArea("Room", stRoomValue);
			vclasAgn.Vclas_Tugger_Shortage_Assignment_Flow("JISJIT");

			mwHome.Navigate_Vclas_Task();
			vt.Vclas_VerifyTaskEvents_Inactive("");

			LDJIT obj = new LDJIT();
			obj.navigateLdjit();
			// Parking the trailer
			obj.ldjitTrailersInfoPark();
			// Bringing full trailer
			obj.navigateLdjit();
			obj.createTrailerAssignments("full");
			obj.navigateLdjit();
			obj.verifyFullTrailer("full");

			vt.Navigate_Vclas_Task();
			vt.Vclas_Search_Partno();
			// Verification in vclas tasks- ACK
			obj.verifyTrailerAck();
			driver.switchTo().window(browser[2]);

			// Load Test Data File
			tdrow = excelUtils.testCaseRetrieve(refTestDataName, "Vclas_Assignments");
			stRoomValue = tdrow.get("Select_Work_Area_Room");
			tdrow.clear();

			// Select Rooms - Tugger

			vclasAgn.Vclas_Assignment_Navigate();
			vclasAgn.Vclas_Assignment_SelectWorkArea("Room", stRoomValue);
			// Delivery of trailer from assignment list
			obj.trailerFlowDelivery("Full");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "LDJIT Trailer End-to-End flow")
	@Parameters({ "TestName" })
	public void LDJIT_TRAILER_GR_DbINSERTION(String TestName) {
		try {

			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);
			// Navigation to LDJIT-> Yard zone maintenance
			LDJIT obj = new LDJIT();
			obj.navigateLdjit();
			// Parking the trailer
			obj.ldjitTrailersInfoPark();
			// Bringing full trailer
			obj.navigateLdjit();
			obj.createTrailerAssignments("full");
			obj.DB_DataInsertion_AfterGR();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	/*
	 * @Test(description = "Multiple Tugger")
	 * 
	 * @Parameters({ "TestName" }) public void MULTIPLE_TUGGER(String TestName)
	 * throws InterruptedException {
	 * 
	 * InputStream inputFile = null;
	 * 
	 * XSSFWorkbook testWorkBook = null; DataFormatter formatter = new
	 * DataFormatter(); int rowsCount = 0; int FlowColumn = 0; String sheetName =
	 * "Multiple_Tugger";
	 * 
	 * try {
	 * 
	 * inputFile = new FileInputStream(Test_Sheet_Path); testWorkBook = new
	 * XSSFWorkbook(inputFile);
	 * 
	 * Sheet testSheet = testWorkBook.getSheet(sheetName); // new ExcelUtils eu =
	 * new ExcelUtils(); int testCaseExecute = eu.getColumnNumber(testSheet,
	 * "To_Be_Executed");
	 * 
	 * FlowColumn = excelUtils.getColumnNumber(testSheet, "Flow");
	 * 
	 * if (FlowColumn == -1) {
	 * System.err.println("Flow column not exist, Check the Data Sheet: " +
	 * Test_Sheet_Path); reportStep("Flowcolumn not exist, Check the Data Sheet: " +
	 * Test_Sheet_Path, "FAIL", false);
	 * 
	 * }
	 * 
	 * // Login page LoginPage lp = new LoginPage(); lp.LogintoPage(TestName);
	 * 
	 * // Multiple Tugger Row Count rowsCount = testSheet.getLastRowNum();
	 * 
	 * int seqNamePos = excelUtils.getColumnNumber(testSheet, "Flow"); int rackPos =
	 * excelUtils.getColumnNumber(testSheet, "1st_Rack_Size"); int startSeqPos =
	 * excelUtils.getColumnNumber(testSheet, "Start_Sequence");
	 * 
	 * // updating the excel values
	 * 
	 * for (int i = 1; i <= 15; i++) { Row row = testSheet.getRow(i); Cell
	 * testCellExecute = row.getCell(testCaseExecute);
	 * 
	 * Cell sequenceName = null;
	 * 
	 * if (testCellExecute.getStringCellValue().equalsIgnoreCase("Y")) {
	 * sequenceName = row.getCell(seqNamePos); System.out.println("seq is " +
	 * sequenceName); excelUtils.excelUpdateValue("vclas_sekadm", "Sequence",
	 * refTestDataName, sequenceName.getStringCellValue());
	 * 
	 * 
	 * 
	 * if (i == 1) { // Updating the excel fields for the first time only Cell
	 * rackValue = row.getCell(rackPos); Cell startSeq = row.getCell(startSeqPos);
	 * 
	 * excelUtils.excelUpdateValue("Vclas_Assignments", "Line_movement",
	 * refTestDataName, formatter.formatCellValue(rackValue));
	 * excelUtils.excelUpdateValue("vclas_sekadm", "Racksnr", refTestDataName,
	 * startSeq.getStringCellValue());
	 * 
	 * }
	 * 
	 * // updating the excel values
	 * 
	 * Multiple_Tugger ml = new Multiple_Tugger(); ml.MultipleRacksCreation(); //
	 * Vclas_task MasWeb_Home mwHome = new MasWeb_Home();
	 * 
	 * mwHome.Navigate_Vclas_Task(); Vclas_tasks vt = new Vclas_tasks();
	 * vt.Vclas_getRacksTaskId();
	 * 
	 * // Vclas Login if (i == 1) { // Vclas_Login_app lp.LogintoVclas(TestName); }
	 * // Load Test Data File tdrow = excelUtils.testCaseRetrieve(refTestDataName,
	 * "Vclas_Assignments"); String stRoomValue =
	 * tdrow.get("Select_Work_Area_Room");
	 * 
	 * tdrow.clear();
	 * 
	 * // Select Rooms - Tugger Vclas_Assignment vclasAgn = new Vclas_Assignment();
	 * 
	 * if (i == 1) { vclasAgn.Vclas_Assignment_Navigate();
	 * vclasAgn.Vclas_Assignment_SelectWorkArea("Room", stRoomValue); }
	 * ml.Multiple_Tugger_Flow();
	 * 
	 * }
	 * 
	 * }
	 * 
	 * } catch (Exception e) { e.printStackTrace();
	 * System.err.println("Error in Test Data Sheet access - Exception");
	 * 
	 * }
	 * 
	 * }
	 */

	@Test(description = "Production End-to-End flow")
	@Parameters({ "TestName" })
	public void Production_Controlcodes(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);

			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			Production_ControlCodes pc = new Production_ControlCodes();

			// navigate to Control Codes menu
			mwHome.Navigate_Production_Control_Codes();
			// Create
			pc.Production_ControlCodes_Display();
			pc.Production_Controlcodes_Remove();
			pc.Production_ControlCodes_Create();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "Production End-to-End flow")
	@Parameters({ "TestName" })
	public void Production_Plockan(String TestName) {
		try {
			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);
			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			Production_ControlCodes pc = new Production_ControlCodes();
			// navigate to plockan menu
			mwHome.Navigate_Production_Plockan();
			pc.Production_Plockan_Display_Edit();
			pc.Production_Plockan_Change_NewPlockan();
			pc.Production_Plockan_Display_Edit();
			pc.Production_Plockan_Remove();
			pc.Production_Plockan_Create();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "Production End-to-End flow")
	@Parameters({ "TestName" })
	public void Production_Consumption(String TestName) {
		try {
			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);
			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			Production_ControlCodes pc = new Production_ControlCodes();
			// navigate to consumption menu
			mwHome.Navigate_Production_Consumption();
			pc.Production_Consumption_Display();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "Production End-to-End flow")
	@Parameters({ "TestName" })
	public void Production_LocationCode(String TestName) {
		try {
			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);
			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			Production_ControlCodes pc = new Production_ControlCodes();
			// navigate to location codes menu
			mwHome.Navigate_Production_LocationCodes();

			pc.Production_LocationCode_Display();
			pc.Production_LocationCodes_Remove();
			pc.Production_LocationCode_Create();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "RACK Changer End-to-End flow")
	@Parameters({ "TestName" })
	public void AGV_ASSIGNMENTLIST_DELIVERY(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();
			lp.Agv_LogintoMasweb(TestName);

			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();

			mwHome.Navigate_AGV_RackChanger();

			// RacKChanger Page
			AGV_RackChanger agvRack = new AGV_RackChanger();
			agvRack.MachineID_Search();
			String strFID = agvRack.MachineID_Pick("A");
			mwHome.Navigate_AGV_MachineIDScan();

			// Machine Scan ID page
			AGV_MachineIDScan agvMach = new AGV_MachineIDScan();
			agvMach.MachineID_Scan_Submit(strFID);
			mwHome.Agv_Navigate_Vclas_Task();

			// Vclas task Page
			Vclas_tasks vclasTask = new Vclas_tasks();
			vclasTask.Vclas_Task_Search();
			vclasTask.Vclas_getAGVTask();

			reportStep(
					" Verification of possibility of creating AGV orders for a Active AGV machine ID completed #B Test Case ID:2884 #C",
					"Pass", false);
			reportStep(
					" Verification of possibility of creating AGV orders for a Active AGV machine ID  completed #B Test Case ID:2884  #C",
					"info", false);

			// Vclas Application Login
			lp.Agv_LogintoVclas(TestName);

			// Vclas Home Page
			Vclas_Assignment vclasAgn = new Vclas_Assignment();
			// vclasAgn.Nodes_Conveyor_Data_Pickup();
			vclasAgn.Agv_Vclas_Assignment_Navigate();

			// Submitting the Flow
			vclasAgn.Vclas_Agv_Flow();
			Agv_launchUrl(URL, "");
			mwHome.Agv_Navigate_Vclas_Task();
			vclasTask.Agv_Vclas_VerifyTaskEvents_Inactive("Utfört samt avslutat");
			reportStep("Status:'Done as well as completed' is verified successfully ", "pass", false);
			reportStep(
					"Verification of status from Vclas tasks screen for these Delivery completed AGV Racks #B TestCase ID:2886 #C completed",
					"Pass", false);
			reportStep(
					"Verification of status from Vclas tasks screen for these Delivery completed AGV Racks #B TestCase ID:2886 #C completed",
					"info", false);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "RACK Changer End-to-End flow")
	@Parameters({ "TestName" })
	public void AGV_RACKCHANGER_INVALID_INPUT(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();
			lp.Agv_LogintoMasweb(TestName);

			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_AGV_RackChanger();

			// RacKChanger Page
			AGV_RackChanger agvRack = new AGV_RackChanger();
			agvRack.Agv_Invalid_Input_Validation();
			reportStep(
					" Verification of  functionality of Rack changer screen which will display  all the configured  AGV machine ids is completed"
							+ "#B Test Case ID:2881 #C",
					"Pass", false);
			reportStep(
					"Verification of functionality of Rack changer screen which will display  all the configured  AGV machine ids is completed"
							+ "#B Test Case ID:2881  #C",
					"info", false);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "AGV Shortage delivery End-to-End flow")
	@Parameters({ "TestName" })
	public void AGV_SHORTAGE_DELIVERY(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();
			lp.Agv_LogintoMasweb(TestName);

			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_AGV_RackChanger();

			// RacKChanger Page
			AGV_RackChanger agvRack = new AGV_RackChanger();
			agvRack.MachineID_Search();
			String strFID = agvRack.MachineID_Pick("A");
			mwHome.Navigate_AGV_MachineIDScan();

			// Machine Scan ID page
			AGV_MachineIDScan agvMach = new AGV_MachineIDScan();
			agvMach.MachineID_Scan_Submit(strFID);
			mwHome.Agv_Navigate_Vclas_Task();

			// Vclas task Page
			Vclas_tasks vclasTask = new Vclas_tasks();
			vclasTask.Vclas_Task_Search();
			vclasTask.Vclas_getAGVTask();

			// Vclas Application Login
			lp.Agv_LogintoVclas(TestName);

			// Vclas Home Page
			Vclas_Assignment vclasAgn = new Vclas_Assignment();
			vclasAgn.Agv_Vclas_Assignment_Navigate();

			// Submitting the Flow
			vclasAgn.Vclas_Agv_Shortage_Screen_Delivery();
			Agv_launchUrl(URL, "");
			mwHome.Agv_Navigate_Vclas_Task();
			vclasTask.Agv_Vclas_VerifyTaskEvents_Inactive("Allt utfört samtidigt");
			reportStep("Status:'Everything done simultaneously' is verified successfully ", "pass", false);
			reportStep(
					"Verification of functionality of Delivering a AGVFKOLL and AGVEKOLL from Shortage screen #B TestCase ID:2887 #C",
					"info", false);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "AGV Inprogress delivery End-to-End flow")
	@Parameters({ "TestName" })
	public void AGV_INPROGRESS_DELIVERY(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();
			lp.Agv_LogintoMasweb(TestName);

			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_AGV_RackChanger();

			// RacKChanger Page
			AGV_RackChanger agvRack = new AGV_RackChanger();
			agvRack.MachineID_Search();
			String strFID = agvRack.MachineID_Pick("A");
			mwHome.Navigate_AGV_MachineIDScan();

			// Machine Scan ID page
			AGV_MachineIDScan agvMach = new AGV_MachineIDScan();
			agvMach.MachineID_Scan_Submit(strFID);
			mwHome.Agv_Navigate_Vclas_Task();

			// Vclas task Page
			Vclas_tasks vclasTask = new Vclas_tasks();
			vclasTask.Vclas_Task_Search();
			vclasTask.Vclas_getAGVTask();

			// Vclas Application Login
			lp.Agv_LogintoVclas(TestName);

			// Vclas Home Page
			Vclas_Assignment vclasAgn = new Vclas_Assignment();
			vclasAgn.Agv_Vclas_Assignment_Navigate();

			// Submitting the Flow
			vclasAgn.Vclas_Inprogress_Delivery();

			Agv_launchUrl(URL, "");
			mwHome.Agv_Navigate_Vclas_Task();
			vclasTask.Agv_Vclas_VerifyTaskEvents_Inactive("Allt utfört samtidigt");
			reportStep("Status:'Everything done simultaneously' is verified successfully ", "pass", false);
			reportStep(
					"Verification of functionality of Delivering a AGVFKOLL and AGVEKOLL from Shortage screen when those are in inprogress #B TestCase ID:2888 #C",
					"info", false);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "AGV Inactive order creation End-to-End flow")
	@Parameters({ "TestName" })
	public void AGV_Inactive_Order_Creation(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();
			lp.Agv_LogintoMasweb(TestName);

			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_AGV_RackChanger();

			// RacKChanger Page
			AGV_RackChanger agvRack = new AGV_RackChanger();
			agvRack.MachineID_Search();
			String strFID = agvRack.MachineID_Pick("I");
			mwHome.Navigate_AGV_MachineIDScan();

			// Machine Scan ID page
			AGV_MachineIDScan agvMach = new AGV_MachineIDScan();
			agvMach.MachineID_Scan_Submit(strFID);
			mwHome.Agv_Navigate_Vclas_Task();

			// Vclas task Page
			Vclas_tasks vclasTask = new Vclas_tasks();
			vclasTask.Vclas_Task_Search();
			vclasTask.Vclas_getAGVTask_Inactive_MID();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}

	}

	@Test(description = "AGV Reserve order creation End-to-End flow")
	@Parameters({ "TestName" })
	public void AGV_Reserve_Order_Creation(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();
			lp.Agv_LogintoMasweb(TestName);

			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_AGV_RackChanger();

			// RacKChanger Page
			AGV_RackChanger agvRack = new AGV_RackChanger();
			agvRack.MachineID_Search();
			String strFID = agvRack.MachineID_Pick("R");
			mwHome.Navigate_AGV_MachineIDScan();

			// Machine Scan ID page
			AGV_MachineIDScan agvMach = new AGV_MachineIDScan();
			agvMach.MachineID_Scan_Submit(strFID);
			mwHome.Agv_Navigate_Vclas_Task();

			// Vclas task Page
			Vclas_tasks vclasTask = new Vclas_tasks();
			vclasTask.Vclas_Task_Search();
			vclasTask.Vclas_getAGVTask();
			agvRack.ReserveID_TaskCreation_Verification();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}

	}

	@Test(description = "AGV Picking multiple assignments delivery End-to-End flow")
	@Parameters({ "TestName" })
	public void AGV_Picking_Multiple_Assignments_delivery(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();
			lp.Agv_LogintoMasweb(TestName);

			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			Agv_Emulator agvEmulator = new Agv_Emulator();
			// agvEmulator.Agv_Picking_Multiple_Assignments();

			// Vclas Application Login
			lp.Agv_LogintoVclas(TestName);

			// Vclas Home Page
			Vclas_Assignment vclasAgn = new Vclas_Assignment();
			// vclasAgn.Nodes_Conveyor_Data_Pickup();
			vclasAgn.Agv_Vclas_Assignment_Navigate();
			// agvEmulator.Vclas_Picking_Multiple_Assignments();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}

	}

	@Test(description = "RACK Changer End-to-End flow")
	@Parameters({ "TestName" })
	public void AGV_PlanningStatus_AL_DELIVERY(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();
			lp.Agv_LogintoMasweb(TestName);

			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();

			mwHome.Navigate_AGV_RackChanger();

			// RacKChanger Page
			AGV_RackChanger agvRack = new AGV_RackChanger();
			agvRack.MachineID_Search();
			String strFID = agvRack.MachineID_Pick("A");
			mwHome.Navigate_AGV_MachineIDScan();

			// Machine Scan ID page
			AGV_MachineIDScan agvMach = new AGV_MachineIDScan();
			agvMach.MachineID_Scan_Submit(strFID);
			mwHome.Agv_Navigate_Vclas_Task();

			// Vclas task Page
			Vclas_tasks vclasTask = new Vclas_tasks();
			vclasTask.Vclas_Task_Search();
			vclasTask.Vclas_getAGVTask();

			reportStep(
					" Verification of possibility of creating AGV orders for a Active AGV machine ID completed #B Test Case ID:2884 #C",
					"Pass", false);
			reportStep(
					" Verification of possibility of creating AGV orders for a Active AGV machine ID  completed #B Test Case ID:2884  #C",
					"info", false);

			// Vclas Application Login
			lp.Agv_LogintoVclas(TestName);

			// Vclas Home Page
			Agv_Emulator Agv_Emu = new Agv_Emulator();
			Vclas_Assignment vclasAgn = new Vclas_Assignment();
			// vclasAgn.Nodes_Conveyor_Data_Pickup();
			vclasAgn.Agv_Vclas_Assignment_Navigate();

			// Submitting the Flow
			Agv_Emu.AGV_PlanningStatus_delivery();
			/*
			 * Agv_launchUrl(URL, ""); mwHome.Agv_Navigate_Vclas_Task();
			 * vclasTask.Agv_Vclas_VerifyTaskEvents_Inactive("Utfört samt avslutat");
			 * reportStep("Status:'Done as well as completed' is verified successfully ",
			 * "pass", false);
			 * reportStep("Verification of status from Vclas tasks screen for these Delivery completed AGV Racks #B TestCase ID:2886 #C completed"
			 * , "Pass", false);
			 * reportStep("Verification of status from Vclas tasks screen for these Delivery completed AGV Racks #B TestCase ID:2886 #C completed"
			 * , "info", false);
			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "Vclas NodesType screenfunctional verificaton")
	@Parameters({ "TestName" })
	public void Vclas_NodesType(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();

			// Vclas Application Login
			lp.Agv_LogintoVclas(TestName);
			Vclas_TestCases VclasTC = new Vclas_TestCases();

			// Vclas Home Page
			VclasTC.Nodes_TypesScreen();
			reportStep("#B Verified the functionality of Node Types Screen TestCase ID:2908 #C", "pass", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);

		}
	}

	@Test(description = "Vclas Transport section screen functional verirification")
	@Parameters({ "TestName" })
	public void Vclas_TransportSection(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();

			// Vclas Application Login
			lp.Agv_LogintoVclas(TestName);
			Vclas_TestCases VclasTC = new Vclas_TestCases();

			// Vclas Home Page
			VclasTC.Vclas_TransportSectionScreen();
			reportStep("#B Verified the functionality of Transport Sections Screen TestCase ID:2909 #C", "pass", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "Vclas ReleaseNotes Information verification")
	@Parameters({ "TestName" })
	public void Vclas_ReleaseNotes(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();

			// Vclas Application Login
			lp.Agv_LogintoVclas(TestName);
			Vclas_TestCases VclasTC = new Vclas_TestCases();

			// Vclas Home Page
			VclasTC.ReleaseNotesScreen();
			reportStep("#B Verified the functionality of Release Notes Screen TestCase ID:2918 #C", "pass", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "Vclas Move button verification")
	@Parameters({ "TestName" })
	public void Vclas_Nodes_MovebuttonVerify(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();

			// Vclas Application Login
			lp.Agv_LogintoVclas(TestName);
			Vclas_TestCases VclasTC = new Vclas_TestCases();

			// Vclas Home Page
			VclasTC.Nodes_MoveButton();
			reportStep(
					"#B Verified the newly added paramater Use Move button for all types of nodes TestCase ID:3467 #C",
					"pass", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}
	}

	@Test(description = "Vclas Administration tab Nodes functionality End-to-End flow")
	@Parameters({ "TestName" })
	public void Vclas_Adminstration_Tab_Nodes_Functionality(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();

			// Vclas Application Login
			lp.Agv_LogintoVclas(TestName);

			// Vclas Administration tab
			Vclas_TestCases VclasTC = new Vclas_TestCases();
			VclasTC.Administration_Nodes_Tab();

			reportStep("#B Verified the functionality of Node Screen TestCase ID:3461 #C", "Pass", false);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}

	}

	@Test(description = "Vclas Administration tab rooms functionality End-to-End flow")
	@Parameters({ "TestName" })
	public void Vclas_Adminstration_Tab_Rooms_Functionality(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();

			// Vclas Application Login
			lp.Agv_LogintoVclas(TestName);

			// Vclas Administration tab
			Vclas_TestCases VclasTC = new Vclas_TestCases();
			VclasTC.Administration_Rooms_Tab();

			reportStep(
					"#B Verified the functionality of Rooms screen to create Rooms for all flows TestCase ID:2910 #C",
					"Pass", false);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}

	}

	@Test(description = "Vclas Administration tab Parts functionality End-to-End flow")
	@Parameters({ "TestName" })
	public void Vclas_Adminstration_Tab_Parts_Functionality(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();

			// Vclas Application Login
			lp.Agv_LogintoVclas(TestName);

			// Vclas Administration tab
			Vclas_TestCases VclasTC = new Vclas_TestCases();
			VclasTC.Administration_Parts_Tab();

			reportStep("#B Verified the functionality of Parts screen TestCase ID:2911 #C", "Pass", false);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}

	}

	@Test(description = "Vclas Administration tab TAT functionality End-to-End flow")
	@Parameters({ "TestName" })
	public void Vclas_Adminstration_Tab_TAT_Functionality(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();

			// Vclas Application Login
			lp.Agv_LogintoVclas(TestName);

			// Vclas Administration tab
			Vclas_TestCases VclasTC = new Vclas_TestCases();
			VclasTC.Administration_TAT_Tab();

			reportStep("#B Verified the functionality of TAT screen TestCase ID:2913 #C", "Pass", false);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}

	}

	@Test(description = "Vclas_Adminstration_Tab_DB_Constant_Functionality End-to-End flow")
	@Parameters({ "TestName" })
	public void Vclas_Adminstration_Tab_DB_Constant_Functionality(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();

			// Vclas Application Login
			lp.Agv_LogintoVclas(TestName);

			// Vclas Administration tab
			Vclas_TestCases VclasTC = new Vclas_TestCases();
			VclasTC.Administration_DB_Constant_Admin_Screen_Tab();

			reportStep("#B Verified the functionality of DB Constant Admin screen TestCase ID:2914 #C", "Pass", false);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}

	}

	@Test(description = "Vclas_Adminstration_Tab_DB_Constant_Functionality End-to-End flow")
	@Parameters({ "TestName" })
	public void Vclas_Assignments_Functionality(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();

			// Vclas Application Login
			lp.Agv_LogintoVclas(TestName);

			// Vclas Administration tab
			Vclas_TestCases VclasTC = new Vclas_TestCases();
			VclasTC.AssignmentsTab();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}

	}

	@Test(description = "Vclas_Adminstration_Tab User Functionality End-to-End flow")
	@Parameters({ "TestName" })
	public void Vclas_Adminstration_Tab_User_Functionality(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();

			// Vclas Application Login
			lp.Agv_LogintoVclas(TestName);

			// Vclas Administration tab
			Vclas_TestCases VclasTC = new Vclas_TestCases();
			VclasTC.Administration_User_Tab();

			reportStep("#B Verified the functionality of User screen TestCase ID:2912 #C", "Pass", false);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}

	}

	@Test(description = "Vclas_Adminstration_Tab Health Check Functionality End-to-End flow")
	@Parameters({ "TestName" })
	public void Vclas_Adminstration_Tab_Health_Check_Functionality(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();

			// Vclas Application Login
			lp.Agv_LogintoVclas(TestName);

			// Vclas Administration tab
			Vclas_TestCases VclasTC = new Vclas_TestCases();
			VclasTC.Administration_Health_Check_Tab();

			reportStep("#B Verified the functionality of Health Check screen TestCase ID:2915 #C", "Pass", false);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}

	}

	@Test(description = "Tugger End-to-End flow")
	@Parameters({ "TestName" })
	public void TUGGER_SHORTAGE_DELIVERY(String TestName) {
		try {

			// Tugger Flow
			// Login page
			LoginPage lp = new LoginPage();
			lp.LogintoPage(TestName);
			// MasWeb page
			MasWeb_Home mwHome = new MasWeb_Home();
			mwHome.Navigate_Vclas_CreateNewRack();
			// Sekadm Page
			Sekadm sp = new Sekadm();
			// pre requisite

			sp.Prerequiste_tugger();
			sp.sekadmCreate();
			// sp.checkOrderSequence();
			// Vclas_task
			mwHome.Navigate_Vclas_Task();
			Vclas_tasks vt = new Vclas_tasks();
			vt.Vclas_getRacksTaskId();

			// Vclas_Login_app
			lp.LogintoVclas(TestName);
			// Load Test Data File
			tdrow = excelUtils.testCaseRetrieve(refTestDataName, "Vclas_Assignments");
			String stRoomValue = tdrow.get("Select_Work_Area_Room");
			tdrow.clear();
			// Select Rooms - Tugger
			Vclas_Assignment vclasAgn = new Vclas_Assignment();
			vclasAgn.Vclas_Assignment_Navigate();
			vclasAgn.Vclas_Assignment_SelectWorkArea("Room", stRoomValue.split(",")[0]);
			vclasAgn.Vclas_Tugger_Shortage_Delivery("Tugger");
			// Verify the Inactive tasks
			// mwHome.Navigate_Vclas_Task();
			// vt.Vclas_VerifyTaskEvents_Inactive("");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}

	}

	@Test(description = "Masweb Reports Tab functionality")
	@Parameters({ "TestName" })
	public void ReportsTabFunctionality(String TestName) {
		try {

			// Login page
			LoginPage lp = new LoginPage();
			MasWeb_Home MHome = new MasWeb_Home();
			MASWEB_Other_Functionalities otherFunc = new MASWEB_Other_Functionalities();
			lp.Agv_LogintoMasweb(TestName);
			MHome.Navigate_Reports_ReportsInMasweb();
			otherFunc.ReportsTab();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("@Method " + Scenario_Name + " exception to be handled", "Pass", true);
		}

	}

}
