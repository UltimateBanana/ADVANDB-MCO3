package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {
	
	private DatabaseConnector connection;
	private double queryTime;
	
	public DatabaseManager()
	{
		connection = DatabaseConnector.getInstance();
	}
	
	// gets the input query and returns the result set; input is from the text area
	public ResultSet getData(String sql)
	{
		PreparedStatement ps;
		
		try
		{
			System.out.println("Query:\n" + sql + "\n");
			
			ps = connection.getConnection().prepareStatement(sql);
			
			double start = System.currentTimeMillis();
			ResultSet rs = ps.executeQuery();
			double end = System.currentTimeMillis();
			
			// execution time of the query
			queryTime = end - start;
			
			return rs;
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			System.out.println("DatabaseManager :: catch");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public double getQueryTime()
	{
		return queryTime;
	}
}
