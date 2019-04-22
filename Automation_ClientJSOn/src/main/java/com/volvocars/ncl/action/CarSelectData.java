package com.volvocars.ncl.action;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author tmohamed
 *
 */
public class CarSelectData {
	 
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
	   //static final String DB_URL = "jdbc:sqlserver://gotsvw2253.got.volvocars.net\\KEXT_T_IN1:1433;databaseName=NCL_T_DB";
	   static final String DB_URL = "jdbc:sqlserver://gotsvw2253.got.volvocars.net;databaseName=NCL_T_Automation_DB";

	   //  Database credentials
	   static final String USER = "KEXT_APP_ACCT_TEST";
	   static final String PASS = "CwJkv6iv";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName(JDBC_DRIVER);

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();

	      String sql = "SELECT * FROM CARS";
	      ResultSet rs = stmt.executeQuery(sql);
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	    	  //long id  = rs.getLong("Id");
	         // String jsonData = rs.getString("JsonData");

	         //Display values
	         //System.out.print("ID ---> " + id);
	         //System.out.print("jsonData ---> " + jsonData);
	         
	        /* int fyon  = rs.getInt("hidden_Package_No");
	         System.out.print("fyon ---> " + fyon+"\n");
	         String fcode  = rs.getString("feature_Code");
	         System.out.print("fcode ---> " + fcode+"\n");*/
	         
	         String type  = rs.getString("Fyon");
	         System.out.print("type ---> " + type+"\n");
	         
	        
	      }
	      rs.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}//end main
}
