package model;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DatabaseConnector {

	private Connection connection;
	private static DatabaseConnector dbConn;
	
	public DatabaseConnector()
	{
		// TODO: change the dbname to the palawan + marinduque db
		String dbname = "testing"; 
		String connurl = "jdbc:mysql://localhost:3306/" + dbname;
		String username = "root";
		String password = "joshansar";		// change password
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = (Connection) DriverManager.getConnection(connurl, username, password);
			//System.out.println("It works!");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println("Exception: " + e.getMessage());
		} 
	}
	
	public Connection getConnection()
	{
		return connection;
	}
	
	public static DatabaseConnector getInstance()
	{
		// If dbConn doesn't exist yet, make one
		// Else return the existing DatabaseConnector
		if(dbConn == null)
		{
			dbConn = new DatabaseConnector();
		}
		return dbConn;
	}
}
