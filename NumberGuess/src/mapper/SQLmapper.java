package mapper;

import java.sql.PreparedStatement;

import classes.User;
import database.DatabaseCon;

public class SQLmapper {
	
	public static boolean saveUser(User user)
	{
		try {
			DatabaseCon.openConnection();
			
			String sqlStr = "INSERT INTO `okul_guess_users`(`firstname`, `lastname`, `username`, `score`) VALUES (?,?,?,?)";
			PreparedStatement query = DatabaseCon.getStatement(sqlStr);
			
			query.setString(1, user.getFirstname());
			query.setString(2, user.getLastname());
			query.setString(3, user.getUsername());
			query.setInt(4, 0);
			
			query.executeUpdate();
			
			sqlStr = "INSERT INTO `okul_guess_passwords`(`userID`, `value`) VALUES ((SELECT `userID` FROM `okul_guess_users` WHERE `username` = ?),?);";
			
			query.clearParameters();
			
			query = DatabaseCon.getStatement(sqlStr);
			
			query.setString(1, user.getUsername());
			query.setString(2, user.getPassword());
			
			query.executeUpdate();
			
			DatabaseCon.closeConnection();
			return true;
		} catch (Exception e) {
			System.out.println("error: " +e);
			return false;
		}
	}
}
