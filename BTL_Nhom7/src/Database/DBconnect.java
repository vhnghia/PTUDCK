package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
	public static Connection con = null;
	private static DBconnect instance = new DBconnect();

	public static DBconnect getInstance() {
		return instance;
	}

	public static void connect() {
		try {
			String url = "jdbc:sqlserver://localhost:1433;databasename=QLKL";
			String user = "sa";
			String password = "reallyStrongPwd123";
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public static Connection getConnection() {
		connect();
		return con;
	}
}
