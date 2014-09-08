package controller;

public class UserController {

	public static ArrayList<User> getUser(String username) {
		return mapper.SQLMapper.selectUser(username);
	}

	public static void<User> insertUser(user) {
		mapper.SQLMapper.insertNewUser(user);
	}

}
