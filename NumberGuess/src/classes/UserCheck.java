package classes;

import classes.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserCheck {

	HashMap<String, String> userTable;

	public UserCheck() {
		userTable = new HashMap<String, String>();

		init2();

	}

	public void addUser(String name, String code) {
		if (!userTable.containsKey(name)) {
			userTable.put(name, code);
		} else {
			System.out.println("User: " + name + " exists in DB");
		}

	}

	public Boolean userExists(String name, String code) {
		Boolean found = false;
		if (userTable.containsKey(name)) {
			if (code.equals(userTable.get(name))) {
				found = true;
			}

		}
		return found;

	}

	
	public void init2() {
		database.DatabaseCon.openConnection();

		List<User> sus = Data.getUsers();

		for (User su : sus) {
			addUser(su.getUsername(), su.getPassword());

		}

	}
}
