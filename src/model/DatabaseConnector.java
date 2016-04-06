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
	private InetAddress addr;

	public DatabaseConnector()
	{
		nodeInfoList = new ArrayList<NodeInfo>();
		
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Put the SQL Connector infos into the ArrayList for easy access
		fillNodeInfo();
		
		String dbname = "animal"; 
		String connurl;
				
		for(int i = 0; i < 3; i++)
		{
			if(nodeInfoList.get(i).getIpAdd() == addr.toString())
			{
				connurl = "jdbc:mysql://" + nodeInfoList.get(i).getIpAdd() 
						+ ":" + nodeInfoList.get(i).getPortNum() 
						+ "/" + dbname;
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					connection = (Connection) DriverManager.getConnection(connurl, nodeInfoList.get(i).getUser(), nodeInfoList.get(i).getPassword());
					//System.out.println("It works!");
				} 
				catch (Exception e)
				{
					e.printStackTrace();
					System.err.println("Exception: " + e.getMessage());
				} 
			}
		}
		
		/*String connurl = "jdbc:mysql://localhost:3306/" + dbname;
		String username = "root";
		String password = "joshansar";		// change password */
		
		/*try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = (Connection) DriverManager.getConnection(connurl, username, password);
			//System.out.println("It works!");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println("Exception: " + e.getMessage());
		} */
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
	
	public void fillNodeInfo()
	{
		nodeInfoList.add(new NodeInfo("", "", "", 0)); // Node1 - MASTER
		nodeInfoList.add(new NodeInfo("", "", "", 0)); // Node2 - SLAVE
		nodeInfoList.add(new NodeInfo("", "", "", 0)); // Node3 - SLAVE
	}
	
}
