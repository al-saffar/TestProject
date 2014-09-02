package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DatabaseCon {

	public static Connection connect;

	public static void openConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl = "jdbc:mysql://localhost/DatabaseNameHere?"
					+ "user=root&password=&autoReconnect=true";
			connect = DriverManager.getConnection(connectionUrl);
			System.out.println("++++++++++Connection established!++++++++++");

		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.toString());
		} catch (ClassNotFoundException cE) {
			System.out.println("Class Not Found Exception: " + cE.toString());
		}

	}

	public static PreparedStatement getStatement(String sql) {

		PreparedStatement result = null;
		try {
			result = connect.prepareStatement(sql);
		} catch (SQLException ex) {
			Logger.getLogger(DatabaseCon.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		return result;
	}

}
