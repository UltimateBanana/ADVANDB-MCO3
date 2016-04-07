package model;

import java.util.HashMap;

public class NodeInfo {
	
	String ipAdd, user, password, dbType;
	int portNum;
	
	public NodeInfo(String ip, String user, String pass, int port, String dbType)
	{
		this.ipAdd = ip;
		this.user = user;
		this.password = pass;
		this.portNum = port;
		this.dbType = dbType;
	}

// GETTERS
	public String getIpAdd() {
		return ipAdd;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public int getPortNum() {
		return portNum;
	}

	public String getDbType() {
		return dbType;
	}


	// SETTERS
	public void setIpAdd(String ipAdd) {
		this.ipAdd = ipAdd;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPortNum(int portNum) {
		this.portNum = portNum;
	}
	
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
}
