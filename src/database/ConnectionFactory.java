package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFactory {
	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://sl-us-south-1-portal.1.dblayer.com:16020/compose","admin","JEDQPLUZIBFNDZZG");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void closeConnection(Connection conn,
									Statement stmt,
									ResultSet rs) {
		close(conn, stmt, rs);
	}
	
	public static void closeConnection(Connection conn,
										Statement stmt) {
		close(conn, stmt, null);
	}
	
	public static void closeConnection(Connection conn) {
		close(conn, null, null);
	}
	
	private static void close(Connection conn,
								Statement stmt,
								ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
