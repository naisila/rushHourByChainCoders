package rushHour;

/**
 * __User class of the game, related to file management system
 * 
 * @author __Masna @version__18/11/2018
 */

public class User {
	private String name;
	private String avatar;
	private int coins;
	private int stars;
	private int crowns;
	private String car;

	public User() {
		setName("");
		setAvatar("");
		setCoins(0);
		setStars(0);
		setCrowns(0);
		setCar("");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getCrowns() {
		return crowns;
	}

	public void setCrowns(int crowns) {
		this.crowns = crowns;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	@Override
	public String toString() {
		String str = "Name is " + this.name + "\n" + "Avatar is " + this.avatar + "\n" + "Coins are " + this.coins
				+ "\n" + "Stars are " + this.stars + "\n" + "Crowns are " + this.crowns + "\n" + "Car is " + this.car;
		return str;
	}

}
