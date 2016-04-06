package model;
import com.mysql.jdbc.Connection;

public class CustomConnector{
	private Connection conn;
	private String ip;
	
	public CustomConnector(Connection conn, String ip) {
		this.conn = conn;
		this.ip = ip;
	}

	public Connection getConn() {
		return conn;
	}

	public String getIp() {
		return ip;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}
