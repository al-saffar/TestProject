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
		} catch (Exception ex) {
			Logger.getLogger(SQLmapper.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}
	
	public static boolean isThisUsernameTaken(String username)
	{
		try {
			DatabaseCon.openConnection();
			
			String queryCheck = "SELECT count(*) FROM `okul_guess_users` WHERE `username` = ?";
			PreparedStatement query = DatabaseCon.getStatement(queryCheck);
			query.setString(1, username);
			
			ResultSet result = query.executeQuery();
			
			if(result.next()) {
			    final int count = result.getInt(1);
			    if(count > 0)
			    {
			    	DatabaseCon.closeConnection();
			    	return true;
			    }
			    else
			    {
			    	DatabaseCon.closeConnection();
			    	return false;
			    }
			}
			else
			{
				DatabaseCon.closeConnection();
				return true;
			}
		} catch (Exception ex) {
			Logger.getLogger(SQLmapper.class.getName()).log(Level.SEVERE, null, ex);
			return true;
		}
	}
	
	public static Score[] gethighscore()
	{
		Score[] scores = new Score[1];
		
		try {
			DatabaseCon.openConnection();
			
			String sqlStr = "SELECT `username`,`score` FROM `okul_guess_users` ORDER BY score DESC LIMIT 10";
			PreparedStatement query = DatabaseCon.getStatement(sqlStr);
			
			ResultSet result = query.executeQuery();
			
			while(result.next())
			{
				System.out.println("bef"+scores.length);
				
				Score score = new Score(result.getString("username"), result.getInt("score"));
				
				System.out.println("af"+scores.length);
				
				scores[scores.length-1] = score;
				
				System.out.println(score.getUsername());
				
				if(scores.length > 0)
				{
					scores = Arrays.copyOf(scores, scores.length+1);
				}
			}
			
			scores = Arrays.copyOf(scores, scores.length-1);
			
			DatabaseCon.closeConnection();
		} catch (Exception ex) {
			Logger.getLogger(SQLmapper.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return scores;
	}
}
