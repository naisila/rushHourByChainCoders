package src.rushHour;

/**
 * __Settings class of the game, related to fms.
 * 
 * @author __Masna
 * @version__ 20/11/2018
 */

public class Settings {
	private int mouseSense;
	private int volume;
	private String themeMusic;
	private String gameTheme;

	public Settings() {
		this.mouseSense = 0;
		this.volume = 0;
		this.themeMusic = "";
		this.gameTheme = "";
	}

	public int getMouseSense() {
		return mouseSense;
	}

	public void setMouseSense(int mouseSense) {
		this.mouseSense = mouseSense;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getThemeMusic() {
		return themeMusic;
	}

	public void setThemeMusic(String themeMusic) {
		this.themeMusic = themeMusic;
	}

	public String getGameTheme() {
		return gameTheme;
	}

	public void setGameTheme(String gameTheme) {
		this.gameTheme = gameTheme;
	}
}
