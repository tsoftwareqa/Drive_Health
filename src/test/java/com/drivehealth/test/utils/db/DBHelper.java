package com.drivehealth.test.utils.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;


public class DBHelper {
	
	private static Logger logger = Logger.getLogger(DBHelper.class.getName());

    public static Connection getOracleConnection(String ip, String port, String dbName, String userName, String password) throws Exception {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String strConnection = "jdbc:oracle:thin:@" + ip +":"+ port +":"+ dbName;
            return DriverManager.getConnection(strConnection, userName, password);
        } catch (Exception e){
            throw new Exception("Unable create connection");
        }
    }

    public static ResultSet getResultSet(Connection connection, String query) throws Exception {

    	ResultSet resultSet = null;

    	try {
        	Statement statement  = connection.createStatement();
        	resultSet =  statement.executeQuery(query);
        } catch (Exception e) {
            throw new Exception("DataBase error while executing the query"+ e.getMessage());
        }
        return resultSet; 
    }
    
    public static String getSingleValue(Connection connection, String query) {

    	String result = null; 
    	
    	try {
    		ResultSet resultSet = getResultSet(connection, query);
			
			if (resultSet != null) {
		        while (resultSet.next()) {
		        	result = resultSet.getString(1); 
		        }
			}
			
		} catch (Exception e) {
			logger.severe("Unable to fetch result for query : "+query);
		}
    	return result; 
    }

    public static void fireCommitQuery(Connection connection, String query) throws Exception {
        try {
        	Statement statement = connection.createStatement();
        	statement.executeQuery(query);
            connection.commit();
            connection.close();
        } catch (Exception e) {
            connection.commit();
            connection.close();
            throw new Exception("DataBase error while executing the query"
                    + e.getMessage());
        } 
    }
}
