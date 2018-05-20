package bbs.db;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

	public static Connection getConnection()  {
		String Driver = "com.mysql.jdbc.Driver";

		String URL = "jdbc:mysql://localhost:3306/bbs"+"?characterEncoding=utf8&useSSL=true";

		String USER = "root";

		String PASSWORD = "root";

		Connection conn = null;
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement ps) {
		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
