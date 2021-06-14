package db.util;

public interface DBConfig {
	public String driver = "oracle.jdbc.driver.OracleDriver";
	public String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public String user = "SERVER_USER";
	public String password = "1111";
}
