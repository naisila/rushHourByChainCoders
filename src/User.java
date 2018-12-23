package rushHour;

public class User {
	private String name;
	private String avatar;
	private int coins;
	private int stars;
	private int crowns;

	public User() {
		setName("");
		setAvatar("");
		setCoins(0);
		setStars(0);
		setCrowns(0);
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

	@Override
	public String toString() {
		String str = "Name is " + this.name + "\n" + "Avatar is " + this.avatar + "\n" + "Coins are " + this.coins
				+ "\n" + "Stars are " + this.stars + "\n" + "Crowns are " + this.crowns;
		return str;
	}

}
