package model;

import java.util.HashMap;

public class NodeInfo {
	
	String ipAdd, user, password;
	int portNum;
	
	public NodeInfo(String ip, String user, String pass, int port)
	{
		this.ipAdd = ip;
		this.user = user;
		this.password = pass;
		this.portNum = port;
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
	
}
