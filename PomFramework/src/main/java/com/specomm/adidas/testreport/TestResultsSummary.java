package com.specomm.adidas.testreport;


/**
 * <p> This class collects the test results summary, that needs to be
 * <br> published in the email after each test execution. 
 * </p>
 */
public class TestResultsSummary {
	
	static int reporterLogOutput_Row = 1;
	static int failedTestcasesDetails_Row = 1;

	private String content = "" + 
			"<html>" +
			"<head>" +
			"<title></title>"+
			"</head>"+
			"<body>"+
			"<p>"+
			"<span style='font-size:12px;'>"+
			"<span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>"+
			"<strong>Test Results Report</strong>"+
			"</span>"+
			"</span>"+
			"</p>";
	
	void build(){
		content = content + "</body>"+
		"</html>";
	}

	@Override
	public String toString() {
		return this.content;
	}

	/**
	 * <p> This class collects the execution results like 
	 * 		<ul>
	 * 			<li>Total number of test cases executed</li>
	 * 			<li>Number of test cases Passed</li>
	 * 			<li>Number of test cases Failed</li>
	 * 			<li>Number of test cases Skipped</li>
	 * 	    </ul>
	 * </p>
	 * 
	 * @author Sandeep H
	 */
	protected class TotalTestcasesSummary{
		String content = "";
		
		protected void setContent(int passed, int failed, int skipped, int  total){
			content =
					"<table border='1' cellpadding='0' cellspacing='0' height='90' style='width: 300px;' width='232'>"+
							"<tbody>"+
							"<tr>"+
							"<td>"+
							"<span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'><span style='color:#008000;'>Passed</span></span></span>"+
							"</td>"+
							"<td style='text-align: center;'>"+
							"<span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'><span style='color:#006400;'>" + passed + "</span></span></span>"+					
							"</td>"+
							"</tr>"+
							"<tr>"+
							"<td>"+
							"<span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'><span style='color:#ff0000;'>Failed</span></span></span>" +
							"</td>"+
							"<td style='text-align: center;'>"+
							"<span style='color:#ff0000;'><span style='font-size: 12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>" + failed + "</span></span></span>"+
							"</td>"+
							"</tr>"+
							"<tr>"+
							"<td>"+
							"<span style='color:#ff8c00;'><span style='font-size: 12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>Skipped</span></span></span>" +
							"</td>"+
							"<td style='text-align: center;'>"+
							"<span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'><span style='color:#ff8c00;'>" + skipped + "</span></span></span>" + 
							"</td>"+
							"</tr>"+
							"<tr>"+
							"<td>"+
							"<span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'><strong>Total Testcases</strong></span></span>" + 
							"</td>"+
							"<td style='text-align: center;'>"+
							"<strong><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>" + total  + "</span></span></strong>" + 
							"</td>"+
							"</tr>"+
							"</tbody>"+
							"</table>"+
							"<p>&nbsp;</p>";
		}

		void build(){
			TestResultsSummary.this.content = TestResultsSummary.this.content + content;
		}
	}

	/**
	 * <p> This class collects the execution results at suite level like 
	 * 		<ul>
	 * 			<li>Suite name</li>
	 * 			<li>Total number of test cases executed</li>
	 * 			<li>Number of test cases Passed</li>
	 * 			<li>Number of test cases Failed</li>
	 * 			<li>Number of test cases Skipped</li>
	 * 	    </ul>
	 * </p>
	 * 
	 * @author Sandeep H
	 */
	protected class TestsuitesSummary{
		String header = "<table border='1' cellpadding='0' cellspacing='0' style='width: 500px;'>"+
				"<tbody>"+
				"<tr>"+
				"<td><strong><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>Suite Name</span></span></strong></td>"+
				"<td><strong><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>Total Testcases</span></span></strong></td>"+
				"<td><strong><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>Passed</span></span></strong></td>"+
				"<td><strong><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>Failed</span></span></strong></td>"+
				"<td><strong><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>Skipped</span></span></strong></td>"+
				"</tr>";
		
		String footer = "</tbody>" +
				"</table>";
		
		String content = "";
		
		protected void setTestSuitesResultsSummary(String suitename, int totalTestcases, int passed, int failed, int skipped){
			content = content + 
					"<tr>"+
					"<td><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>" + suitename  + "</span></span></td>"+
					"<td><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>" + totalTestcases + "</span></span></td>"+
					"<td><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>" + passed + "</span></span></td>"+
					"<td><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>" + failed + "</span></span></td>"+
					"<td><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>" + skipped + "</span></span></td>"+
					"</tr>";
		}
		
		void build(){
			TestResultsSummary.this.content = TestResultsSummary.this.content + header + content + footer;  
		}
	}

	/**
	 * <p> This class collects the list of failed test cases  
	 * 	   details.	
	 * </p>
	 * @author Sandeep H
	 */
	protected class FailedTestcasesDetails{
		
		String header = "<p>"+
			"<span style='font-size:12px;'>"+
			"<span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>Following are the list of failed test cases, </span>"+
			"</span>"+
			"</p>"+
			"<table border='1' cellpadding='0' cellspacing='0' height='42' width='885'>"+
			"<tbody>"+ 
			"<tr>"+
			"<td><strong><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>S.No</span></span></strong></td>"+
			"<td><strong><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>Suite Name</span></span></strong></td>"+
			"<td><strong><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>Testcase name</span></span></strong></td>"+
			"<td><strong><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>Testcase Description</span></span></strong></td>"+
			"<td><strong><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>Fail Message</span></span></strong></td>"+
			"</tr>";
		
		String footer = "</tbody>"+
			"</table>"+
			"<p>&nbsp;</p>";
		
		String content = "";
		
		protected void setFailedTestcasesDetails(String suitename, String testmethodName, String testmethodDescription, String message){
			
			String tr = "<tr "  + (failedTestcasesDetails_Row%2 == 0? "style='background-color:#d3d3d3'" : "") + ">";
			
			content = content +
			//"<tr>"+
			tr +
			"<td><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>" + failedTestcasesDetails_Row + "</span></span></td>"+
			"<td><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>" + suitename + "</span></span></td>"+
			"<td><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>" + testmethodName + "</span></span></td>"+
			"<td><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>" + testmethodDescription + "</span></span></td>"+
			"<td><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>" + message + "</span></span></td>"+
			"</tr>";
			
			failedTestcasesDetails_Row++;
		}
		
		void build(){
			if(!content.trim().equals("")){
				TestResultsSummary.this.content = TestResultsSummary.this.content + header + content + footer;	
			}
		}
	}
	
	/**
	 * <p> This class collects the builds the Reporter log details in html format.</p>	
	 * 
	 * @author Sandeep H
	 */
	protected class ReporterLogOutput{
		
		String header = //"<p>&nbsp;</p>" + 
						"<p>" +
						"<table border='1' cellpadding='0' cellspacing='0' height='42' width='885'> " +
						"<thead>"+
						"<tr>"+
						"<th scope='col'>"+
						"<strong><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>S.No</span></span></strong></th>"+
						"<th scope='col'>"+
						"<strong><span style='font-size:12px;'><span style='font-family: lucida sans unicode,lucida grande,sans-serif;'>Reporter Log</span></span></strong></th>"+
						"</tr>"+
						"</thead>"+
						"<tbody>";
			
		String footer = "</tbody></table></p>";
		String content = "";
		
		public void setReporterLogOutput(String msg){
			
			String tr = "<tr "  + (reporterLogOutput_Row%2 == 0? "style='background-color:#d3d3d3'" : "") + ">";
			
			content = content + 
					  tr+	
					  "<td style='text-align: center;'>"+
					  "<span style='font-size:11px;'><span style='font-family: trebuchet ms,helvetica,sans-serif;'>" + reporterLogOutput_Row + "</span></span></td>"+
					  "<td>"+
					  "<span style='font-size:11px;'><span style='font-family: trebuchet ms,helvetica,sans-serif;'>" + msg + "</span></span></td>"+
					  "</tr>";	
			
			reporterLogOutput_Row++;
		}
		
		void build(){
			if(!content.trim().equals("")){
				TestResultsSummary.this.content = TestResultsSummary.this.content + header + content + footer;	
			}
		}
	}

}
