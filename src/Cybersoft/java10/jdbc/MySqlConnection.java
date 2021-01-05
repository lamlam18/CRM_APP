package Cybersoft.java10.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	private static String url		="jdbc:mysql://localhost:6606/jdbc";
	private static String username	="admin";
	private static String password	="root";
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			System.out.println("Lỗi không đọc được driver jdbc");
		} catch (SQLException exc) {
			System.out.println("Không kết nối được database");
		}
		return null;
		
	}

}
