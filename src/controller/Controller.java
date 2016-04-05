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
}
