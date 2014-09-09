package classes;

public class User {

	private String firstname;
	private String lastname;
	private String username;
	private String password;

	public User() {

	}

	public User(String firstname, String lastname, String username,
			String password) {

		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public boolean setFirstname(String firstname) {
		if (firstname.matches("[a-zA-Z]{2,20}")) { // bogstav fra "a til z og mellem 3 og 10 i længden.
			this.firstname = firstname;
			return true;
		} else {
			return false;
		}
	}

	public String getLastname() {
		return lastname;
	}

	public boolean setLastname(String lastname) {
		if (lastname.matches("[a-zA-Z]{2,20}")) { // bogstav fra "a til z og mellem 3 og 10 i længden.
			this.lastname = lastname;
			return true;
		} else {
			return false;
		}
	}

	public String getUsername() {
		return username;
	}

	public boolean setUsername(String username) {
		if (username.matches("[a-zA-Z]{2,20}")) { // bogstav fra "a til z og mellem 2 og 20 i længden.
			this.username = username;
			return true;
		} else {
			return false;
		}
	}

	public String getPassword() {
		return password;
	}

	public boolean setPassword(String password) {
		if (password.matches("[a-zA-Z0-9]{6,20}")) { // bogstav fra "a til z eller fra 0 til 9 og mellem 3 og 10 i længden.
			this.password = password;
			return true;
		} else {
			return false;
		}
	}

}
