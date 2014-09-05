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
		if (firstname.matches("[a-zA-Z]{1,20}")) { // bogstav fra "a til z og mellem 3 og 10 i længden.
			this.firstname = firstname;
			return true;
		} else {
			return false;
		}
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
