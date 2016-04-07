package controller;

import java.sql.ResultSet;

import model.DatabaseManager;

public class Controller {

	private DatabaseManager databaseManager;
	
	public Controller()
	{
		databaseManager = new DatabaseManager();
	}
	
	public ResultSet getData(String sql)
	{
		return databaseManager.getData(sql);
	}
	
	public double getQueryTime()
	{
		return databaseManager.getQueryTime();
	}
	
	public void changeConnection(String dbType)
	{
		int id = 0;
		
		if(dbType.equals("central"))
		{
			id = 0;
			System.out.println("central");
		}
		else if(dbType.equals("palawan"))
		{
			id = 1;
			System.out.println("palawan");
		}
		else if(dbType.equals("marinduque"))
		{
			id = 2;
			System.out.println("marinduque");
		}
		
		databaseManager.changeConnection(id);
	}
}
