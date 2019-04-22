package com.volvocars.ncl.bo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author tmohamed
 *
 */
public class JdbcSQLServerConnection {
	 
    public static void main(String[] args) {
 
        Connection conn = null;
 
        try {
 
            //String dbURL = "jdbc:sqlserver://gotsvw2253.got.volvocars.net:1433//NCL_T_DB";
            String dbURL = "jdbc:sqlserver://gotsvw2253.got.volvocars.net\\KEXT_T_IN1:1433;" + "databaseName=NCL_T_Automation_DB"; 
            String user = "KEXT_APP_ACCT_TEST";
            String pass = "CwJkv6iv";
            conn = DriverManager.getConnection(dbURL, user, pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
                ResultSet schemas = dm.getSchemas();
                while (schemas.next()) {
                  String tableSchema = schemas.getString(1);    // "TABLE_SCHEM"
                  System.out.println("tableSchema:"+tableSchema);
                  String tableCatalog = schemas.getString(2); //"TABLE_CATALOG"
                  System.out.println("tableCatalog:"+tableCatalog);
                }

            }
 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
