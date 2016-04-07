package model;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

public class DatabaseConnector {

	private Connection connection;
	private static DatabaseConnector dbConn;
	private ArrayList<NodeInfo> nodeInfoList;
	private String dbname, connurl;

	public DatabaseConnector()
	{
		nodeInfoList = new ArrayList<NodeInfo>();
		
		
		// Put the SQL Connector infos into the ArrayList for easy access
		fillNodeInfo();
		
		dbname = "animal"; 
				
		for(int i = 0; i < 1; i++)
		{
			System.out.println("In for loop");
			System.out.println(nodeInfoList.get(i).getIpAdd());

			System.out.println("in IF");
			
			connurl = "jdbc:mysql://" + nodeInfoList.get(i).getIpAdd() 
					+ ":" + nodeInfoList.get(i).getPortNum() 
					+ "/" + dbname;
			System.out.println(connurl);
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				connection = (Connection) DriverManager.getConnection(connurl, nodeInfoList.get(i).getUser(), nodeInfoList.get(i).getPassword());
				System.out.println("It works!");
			} 
			catch (Exception e)
			{
				e.printStackTrace();
				System.err.println("Exception: " + e.getMessage());
			} 
		}
		
		/*String dbname = "animal";
		String connurl = "jdbc:mysql://localhost:3306/" + dbname;
		String username = "root";
		String password = "joshansar";		// change password 
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = (Connection) DriverManager.getConnection(connurl, username, password);
			System.out.println("It works!");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println("Exception: " + e.getMessage());
		} */
	}
	
	public void changeConnection(int id)
	{
		System.out.println(nodeInfoList.get(id).getIpAdd());
		
		connurl = "jdbc:mysql://" + nodeInfoList.get(id).getIpAdd() 
				+ ":" + nodeInfoList.get(id).getPortNum() 
				+ "/" + dbname;
		System.out.println(connurl);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = (Connection) DriverManager.getConnection(connurl, nodeInfoList.get(id).getUser(), nodeInfoList.get(id).getPassword());
			System.out.println("It works!");
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
			System.out.println("With instance");
		}
		return dbConn;
	}
	
	public void fillNodeInfo()
	{
		nodeInfoList.add(new NodeInfo("localhost", "root", "joshansar", 3306, "home")); 
		nodeInfoList.add(new NodeInfo("10.100.206.96", "replicator", "root", 3309, "db_hpq_central"));// Node1 - MASTER
		nodeInfoList.add(new NodeInfo("10.100.206.242", "replicator", "root", 3306, "db_hpq_palawan")); // Node2 - SLAVE
		nodeInfoList.add(new NodeInfo("10.100.216.202", "replicator", "root", 3311, "db_hpq_marinduque")); // Node3 - SLAVE
	}
	
}
