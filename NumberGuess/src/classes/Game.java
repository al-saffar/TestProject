package classes;

public class Game {

	private String username;
	private int level;
	private int randomNumber;
	private int attempts;
	private int score;

	public Game(String username, int level, int randomNumber, int attempts,
			int score) {

		this.username = username;
		this.level = level;
		this.randomNumber = randomNumber;
		this.attempts = attempts;
		this.score = score;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(int randomNumber) {
		this.randomNumber = randomNumber;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
