package db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {

	private Connection con;
	
	private static DBConnector instance = new DBConnector();
	
	private DBConnector() {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.url, DBConfig.user, DBConfig.password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static DBConnector getInstance() {
		return instance;
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public void close(PreparedStatement ps, ResultSet rs) {
			try {
				if( ps != null)	ps.close();
				if( rs != null) rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
