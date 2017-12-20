package com.demo.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
private static Connection con=null;
public static void setMySqlDbConnection() throws SQLException, ClassNotFoundException 
{
	try
	{
		Class.forName(TestConfig.mysqldriver).newInstance();
		con=DriverManager.getConnection(TestConfig.mysqlurl, TestConfig.mysqluserName, TestConfig.mysqlpassword);
		if(!con.isClosed())
			System.out.println("Succefully connected to MYSQL Server");
	}
	catch(Exception e)
	{
		System.out.println("Cannot connect to database server"+ e);
	}
	
}
public static List<String> getmysqlquery(String query) throws SQLException
{
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(query);
	List<String> values=new ArrayList<String>();
	while(rs.next()){
		values.add(rs.getString(1));
	}
	return values;
}

}
