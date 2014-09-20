package mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import classes.*;
import database.DatabaseCon;

public class SQLmapper {

	public static boolean saveUser(User user) {
		try {
			DatabaseCon.openConnection();

			String queryCheck = "SELECT count(*) FROM `okul_guess_users` WHERE `username` = ?";
			PreparedStatement query = DatabaseCon.getStatement(queryCheck);
			query.setString(1, user.getUsername());

			ResultSet result = query.executeQuery();

			if (result.next()) {
				final int count = result.getInt(1);
				if (count > 0) {
					DatabaseCon.closeConnection();
					System.out.println("username is taken!");
					return false;
				}
			}

			String sqlStr = "INSERT INTO `okul_guess_users`(`firstname`, `lastname`, `username`, `score`) VALUES (?,?,?,?)";
			query = DatabaseCon.getStatement(sqlStr);

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
		} catch (Exception ex) {
			Logger.getLogger(SQLmapper.class.getName()).log(Level.SEVERE, null,
					ex);
			return false;
		}
	}

	public static boolean isThisUsernameTaken(String username) {
		try {
			DatabaseCon.openConnection();

			String queryCheck = "SELECT count(*) FROM `okul_guess_users` WHERE `username` = ?";
			PreparedStatement query = DatabaseCon.getStatement(queryCheck);
			query.setString(1, username);

			ResultSet result = query.executeQuery();

			if (result.next()) {
				final int count = result.getInt(1);
				if (count > 0) {
					DatabaseCon.closeConnection();
					return true;
				} else {
					DatabaseCon.closeConnection();
					return false;
				}
			} else {
				DatabaseCon.closeConnection();
				return true;
			}
		} catch (Exception ex) {
			Logger.getLogger(SQLmapper.class.getName()).log(Level.SEVERE, null,
					ex);
			return true;
		}
	}

	public static int loginAndGetID(String username, String pass) {
		try {
			DatabaseCon.openConnection();

			String queryCheck = "SELECT `userID` FROM `okul_guess_users` WHERE `username` = ?";
			PreparedStatement query = DatabaseCon.getStatement(queryCheck);
			query.setString(1, username);

			ResultSet result = query.executeQuery();

			if (result.next()) {
				final int id = result.getInt("userID");
				if (id != -1) {
					queryCheck = "SELECT count(*) FROM `okul_guess_passwords` WHERE `userID` = ? AND `value` = ?";
					query = DatabaseCon.getStatement(queryCheck);
					query.setInt(1, id);
					query.setString(2, pass);
					result = query.executeQuery();

					if (result.next()) {
						final int count = result.getInt(1);
						if (count > 0) {
							DatabaseCon.closeConnection();
							return id;
						} else {
							DatabaseCon.closeConnection();
							return -1;
						}
					}
				} else {
					DatabaseCon.closeConnection();
					return -1;
				}
			} else {
				DatabaseCon.closeConnection();
				return -1;
			}
		} catch (Exception ex) {
			Logger.getLogger(SQLmapper.class.getName()).log(Level.SEVERE, null,
					ex);
			return -1;
		}
		return -1;
	}

	public static String getUsername(int userID) {
		String username = "";

		try {
			DatabaseCon.openConnection();

			String sqlStr = "SELECT `username` FROM `okul_guess_users` WHERE `userID` = ?";
			PreparedStatement query = DatabaseCon.getStatement(sqlStr);
			query.setInt(1, userID);

			ResultSet result = query.executeQuery();

			if (result.next()) {
				username = result.getString("username");

			}

			DatabaseCon.closeConnection();
		} catch (Exception ex) {
			Logger.getLogger(SQLmapper.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		return username;
	}

	public static Score[] gethighscore() {
		Score[] scores = new Score[1];

		try {
			DatabaseCon.openConnection();

			String sqlStr = "SELECT `username`,`score` FROM `okul_guess_users` ORDER BY score DESC LIMIT 10";
			PreparedStatement query = DatabaseCon.getStatement(sqlStr);

			ResultSet result = query.executeQuery();

			while (result.next()) {
				System.out.println("bef" + scores.length);

				Score score = new Score(result.getString("username"),
						result.getInt("score"));

				System.out.println("af" + scores.length);

				scores[scores.length - 1] = score;

				System.out.println(score.getUsername());

				if (scores.length > 0) {
					scores = Arrays.copyOf(scores, scores.length + 1);
				}
			}

			scores = Arrays.copyOf(scores, scores.length - 1);

			DatabaseCon.closeConnection();
		} catch (Exception ex) {
			Logger.getLogger(SQLmapper.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		return scores;
	}
	
	public static User getUserInfo(int id)
	{
		User user = new User();
		
		try {
			DatabaseCon.openConnection();

			String sqlStr = "SELECT `firstname`,`lastname`,`username` FROM `okul_guess_users` Where userID = ?";
			PreparedStatement query = DatabaseCon.getStatement(sqlStr);
			query.setInt(1, id);
			ResultSet result = query.executeQuery();

			while (result.next()) {

				user.setFirstname(result.getString("firstname"));
				user.setLastname(result.getString("lastname"));
				user.setUsername(result.getString("username"));
			}

			DatabaseCon.closeConnection();
			
		} catch (Exception ex) {
			Logger.getLogger(SQLmapper.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		
		return user;
	}

	public static int getCurrentScoreByUser(String username) {
		int score = -1;

		try {
			DatabaseCon.openConnection();

			String sqlStr = "SELECT `username`,`score` FROM `okul_guess_users` Where username = ?";
			PreparedStatement query = DatabaseCon.getStatement(sqlStr);
			query.setString(1, username);
			ResultSet result = query.executeQuery();

			while (result.next()) {

				score = result.getInt("score");

			}
			System.out.println("score "+score);

			DatabaseCon.closeConnection();
			
		} catch (Exception ex) {
			Logger.getLogger(SQLmapper.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		return score;
	}
	
	
	public static boolean updateScore(int score, String username) {
		try {
			DatabaseCon.openConnection();

			
			String sqlStr = "UPDATE `okul_guess_users` SET `score` = ? WHERE `username` = ?";
			PreparedStatement query = DatabaseCon.getStatement(sqlStr);
			
			query.setInt(1, score);
			query.setString(2,username);

			query.executeUpdate();
			DatabaseCon.closeConnection();
			return true;
		} catch (Exception ex) {
			Logger.getLogger(SQLmapper.class.getName()).log(Level.SEVERE, null,
					ex);
			return false;
		}
	}
	
	public static boolean updateUser(int id, User user)
	{
		try {
			DatabaseCon.openConnection();

			String sqlStr = "UPDATE `okul_guess_users` SET `firstname` = ?, `lastname` = ? WHERE `userID` = ?";
			PreparedStatement query = DatabaseCon.getStatement(sqlStr);
			
			query.setString(1, user.getFirstname());
			query.setString(2,user.getLastname());
			query.setInt(3, id);

			query.executeUpdate();
			
			if(!user.getPassword().isEmpty())
			{
				sqlStr = "UPDATE `okul_guess_passwords` SET `value` = ? WHERE `userID` = ?";
				query = DatabaseCon.getStatement(sqlStr);
				
				query.setString(1, user.getPassword());
				query.setInt(2, id);

				query.executeUpdate();
			}
			
			DatabaseCon.closeConnection();
			return true;
		} catch (Exception ex) {
			Logger.getLogger(SQLmapper.class.getName()).log(Level.SEVERE, null,
					ex);
			return false;
		}
	}

	public static boolean deleteUser(int id)
	{
		try {
			DatabaseCon.openConnection();

			String sqlStr = "DELETE FROM `okul_guess_passwords` WHERE `userID` = ?";
			PreparedStatement query = DatabaseCon.getStatement(sqlStr);
			query.setInt(1, id);

			query.executeUpdate();
			
			sqlStr = "DELETE FROM `okul_guess_users` WHERE `userID` = ?";
			query = DatabaseCon.getStatement(sqlStr);
			query.setInt(1, id);

			query.executeUpdate();
			
			DatabaseCon.closeConnection();
			System.out.println("User Deleted: "+ id);
			return true;
		} catch (Exception ex) {
			Logger.getLogger(SQLmapper.class.getName()).log(Level.SEVERE, null,
					ex);
			return false;
		}
	}
}
