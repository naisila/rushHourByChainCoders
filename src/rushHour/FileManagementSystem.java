package rushHour;

/**
 * __File Management System of the game.
 * @author __Masna
 * @version__18/11/2018
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.Scanner;

public class FileManagementSystem {

	// private InputStream i;
	// private BufferedReader r;

	// constructor
	public FileManagementSystem() {
//		setUserData("Masna Ahmed", "img.png", "0", "0", "0", "red car.png");
//		getUserData();
//		updateName("Talha Zeeshan");
//		updateAvatar("img2.png");
//		updateCoins("230000");
//		updateStars("28");
//		updateCrowns("7");
//		updateCar("yellow car.png");
//		getUserData();
//		Iterator<Car> itr = getPuzzleConfig(0,9).iterator();
//		while (itr.hasNext())
//		{
//			Car car = itr.next();
//			System.out.println(car.getDirection() + " " + car.getSize() + " " + car.getUrl());
//		}
//		System.out.println();
//		updatePuzzleStats(0, 9, 1, 3, 2, 20);
//		Iterator<Car> itr2 = getPuzzleConfig(0,9).iterator();
//		while (itr2.hasNext())
//		{
//			Car car = itr2.next();
//			System.out.println(car.getDirection() + " " + car.getSize() + " " + car.getUrl());
//		}
		// System.out.println(userFileExists());

//		getUserSettings();
//		updateMouseSense(3);
//		updateVolume(6);
//		updateThemeMusic("Till I Collapse");
//		updateGameTheme("parking.jpg");
//		getUserSettings();

//		unlockCar("pink car.png");
//		System.out.println(isUnlocked("pink car.png"));
//		getPuzzleConfig(0, 0);
		// getPuzzleConfig(0, 1);
		// getPuzzleConfig(0, 2);
		// getPuzzleConfig(0, 3);
		// getPuzzleConfig(0, 4);
	}

	public void setUserData(String name, String avatar, String coins, String stars, String crowns, String currentCar) {
		File userFile = new File("src/files/user.txt");
		try {
			if (userFile.createNewFile()) {
				System.out.println("user.txt File Created in src/files directory");
				FileWriter writer = new FileWriter(userFile);
				writer.write("Name: " + name + ";\r\n" + "Avatar: " + avatar + ";\r\n" + "Coins: " + coins + ";\r\n"
						+ "Stars: " + stars + ";\r\n" + "Crowns: " + crowns + ";\r\n" + "Car: " + currentCar + ";");
				writer.close();
			} else
				System.out.println("File user.txt already exists in src/files directory");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean userFileExists() {
		File file = new File("src/files/user.txt");
		if (file.exists()) {
			return true;
		}
		return false;
	}

	public User getUserData() {
		File userFile = new File("src/files/user.txt");
		String name = "", avatar = "", coinsS = "", crownsS = "", starsS = "", currentCarS = "";
		User user = new User();

		try {
			Scanner scan = new Scanner(userFile);

			name = scan.nextLine();
			name = name.substring(name.indexOf(" ") + 1, name.indexOf(';'));
			user.setName(name);

			avatar = scan.nextLine();
			avatar = avatar.substring(avatar.indexOf(" ") + 1, avatar.indexOf(';'));
			user.setAvatar(avatar);

			coinsS = scan.nextLine();
			coinsS = coinsS.substring(coinsS.indexOf(" ") + 1, coinsS.indexOf(';'));
			user.setCoins(Integer.valueOf(coinsS));

			starsS = scan.nextLine();
			starsS = starsS.substring(starsS.indexOf(" ") + 1, starsS.indexOf(';'));
			user.setStars(Integer.valueOf(starsS));

			crownsS = scan.nextLine();
			crownsS = crownsS.substring(crownsS.indexOf(" ") + 1, crownsS.indexOf(';'));
			user.setCrowns(Integer.valueOf(crownsS));

			currentCarS = scan.nextLine();
			currentCarS = currentCarS.substring(currentCarS.indexOf(" ") + 1, currentCarS.indexOf(';'));
			user.setCar(currentCarS);

			// System.out.println(user.toString());
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		return user;
	}

	public void updateName(String newName) {
		File temp = new File("src/files/temp.txt");
		File user = new File("src/files/user.txt");
		try {
			temp.createNewFile();
			Scanner scan = new Scanner(user);
			scan.nextLine(); // old name line

			FileWriter writer = new FileWriter(temp);
			writer.write("Name: " + newName + ";");

			while (scan.hasNextLine()) {
				writer.write("\r\n" + scan.nextLine());
			}

			writer.close();
			scan.close();

			user.delete();
			temp.renameTo(new File("src/files/user.txt"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateAvatar(String newAvatar) {

		File temp = new File("src/files/temp.txt");
		File user = new File("src/files/user.txt");
		try {
			temp.createNewFile();
			Scanner scan = new Scanner(user);

			FileWriter writer = new FileWriter(temp);
			writer.write(scan.nextLine()); // copy name
			writer.write("\r\nAvatar: " + newAvatar + ";");
			scan.nextLine(); // remove the older avatar

			while (scan.hasNextLine()) {
				writer.write("\r\n" + scan.nextLine());
			}

			writer.close();
			scan.close();

			user.delete();
			temp.renameTo(new File("src/files/user.txt"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateCoins(String newCoins) {

		File temp = new File("src/files/temp.txt");
		File user = new File("src/files/user.txt");
		try {
			temp.createNewFile();
			Scanner scan = new Scanner(user);

			FileWriter writer = new FileWriter(temp);
			writer.write(scan.nextLine()); // copy name
			writer.write("\r\n" + scan.nextLine()); // copy avatar

			writer.write("\r\nCoins: " + newCoins + ";");
			scan.nextLine(); // remove the older coins number

			while (scan.hasNextLine()) {
				writer.write("\r\n" + scan.nextLine());
			}

			writer.close();
			scan.close();

			user.delete();
			temp.renameTo(new File("src/files/user.txt"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateStars(String newStars) {
		File temp = new File("src/files/temp.txt");
		File user = new File("src/files/user.txt");
		try {
			temp.createNewFile();
			Scanner scan = new Scanner(user);

			FileWriter writer = new FileWriter(temp);
			writer.write(scan.nextLine()); // copy name
			writer.write("\r\n" + scan.nextLine()); // copy avatar
			writer.write("\r\n" + scan.nextLine()); // copy coins

			writer.write("\r\nStars: " + newStars + ";");
			scan.nextLine(); // remove the older stars number

			while (scan.hasNextLine()) {
				writer.write("\r\n" + scan.nextLine());
			}

			writer.close();
			scan.close();

			user.delete();
			temp.renameTo(new File("src/files/user.txt"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateCrowns(String newCrowns) {
		File temp = new File("src/files/temp.txt");
		File user = new File("src/files/user.txt");
		try {
			temp.createNewFile();
			Scanner scan = new Scanner(user);

			FileWriter writer = new FileWriter(temp);
			writer.write(scan.nextLine()); // copy name
			writer.write("\r\n" + scan.nextLine()); // copy avatar
			writer.write("\r\n" + scan.nextLine()); // copy coins
			writer.write("\r\n" + scan.nextLine()); // copy stars

			writer.write("\r\nCrowns: " + newCrowns + ";");
			scan.nextLine();
			writer.write("\r\n" + scan.nextLine()); // copy car

			writer.close();
			scan.close();

			user.delete();
			temp.renameTo(new File("src/files/user.txt"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateCar(String newCar) {
		File temp = new File("src/files/temp.txt");
		File user = new File("src/files/user.txt");
		try {
			temp.createNewFile();
			Scanner scan = new Scanner(user);

			FileWriter writer = new FileWriter(temp);
			writer.write(scan.nextLine()); // copy name
			writer.write("\r\n" + scan.nextLine()); // copy avatar
			writer.write("\r\n" + scan.nextLine()); // copy coins
			writer.write("\r\n" + scan.nextLine()); // copy stars
			writer.write("\r\n" + scan.nextLine()); // copy crowns
			writer.write("\r\nCar: " + newCar + ";");

			writer.close();
			scan.close();

			user.delete();
			temp.renameTo(new File("src/files/user.txt"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Integer> getPuzzleStats(int puzzleDifficulty, int puzzleNumber) {
		File currentPuzzle = new File("src/files/puzzle" + puzzleDifficulty + puzzleNumber + ".txt");
		ArrayList<Integer> stats = new ArrayList<>();

		try {
			Scanner scan = new Scanner(currentPuzzle);

			String gridSizeString = scan.nextLine();
			int gridSize = gridSizeString.charAt(gridSizeString.indexOf(':') + 1) - 48;
			// System.out.println(gridSize);

			String solvedString = scan.nextLine();
			int solved = solvedString.charAt(solvedString.indexOf(':') + 1) - 48;
			// System.out.println(solved);

			String starsString = scan.nextLine();
			int stars = starsString.charAt(starsString.indexOf(':') + 1) - 48;
			// System.out.println(stars);

			String crownsString = scan.nextLine();
			int crowns = crownsString.charAt(crownsString.indexOf(':') + 1) - 48;
			// System.out.println(crowns);

			String minMovesString = scan.nextLine();
			int minMoves = Integer
					.valueOf(minMovesString.substring(minMovesString.indexOf(':') + 1, minMovesString.indexOf(';')));
			// System.out.println(minMoves);

			String movesString = scan.nextLine();
			int moves = Integer.valueOf(movesString.substring(movesString.indexOf(':') + 1, movesString.indexOf(';')));
			// System.out.println(moves);

			scan.close();

			stats.add(gridSize);
			stats.add(solved);
			stats.add(stars);
			stats.add(crowns);
			stats.add(minMoves);
			stats.add(moves);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
		}
		return stats;
	}

	public ArrayList<Car> getPuzzleConfig(int puzzleDifficulty, int puzzleNumber) {
		File currentPuzzle = new File("src/files/puzzle" + puzzleDifficulty + puzzleNumber + ".txt");
		ArrayList<Car> cars = new ArrayList<>();

		try {

			Scanner scan = new Scanner(currentPuzzle);

			for (int i = 1; i <= 6; i++) {
				scan.nextLine();
			} // to skip the lines related to the puzzle's statistics

			while (scan.hasNextLine()) {
				String currentCarString = scan.nextLine();
				// System.out.println(currentCarString);

				if (!currentCarString.equals("")) {
					int x = Integer.valueOf(currentCarString.substring(currentCarString.indexOf('(') + 1,
							currentCarString.indexOf(',')));
					int y = Integer.valueOf(currentCarString.substring(currentCarString.indexOf(',') + 1,
							currentCarString.indexOf(')')));
					int carSize = currentCarString.charAt(currentCarString.indexOf(')') + 2) - 48;
					int carOrientation = currentCarString.charAt(currentCarString.indexOf(')') + 4) - 48;
					String url = currentCarString.substring(currentCarString.indexOf(')') + 6,
							currentCarString.indexOf(';'));

					// System.out.println(x + " " + y + " " + carSize + " " + carOrientation + " " +
					// url);
					Car newCar = new Car(x, y, carSize, carOrientation, url);
					cars.add(newCar);
				}
			}
			scan.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cars;
	}

	public void updatePuzzleStats(int puzzleDifficulty, int puzzleNumber, int solved, int stars, int crowns,
			int moves) {
		File temp = new File("temp.txt");
		File currentPuzzle = new File("src/files/puzzle" + puzzleDifficulty + puzzleNumber + ".txt");

		try {
			Scanner scan = new Scanner(currentPuzzle);
			FileWriter writer = new FileWriter(temp);

			writer.write(scan.nextLine());
			writer.write("\r\nSolved:" + solved + ";");
			scan.nextLine();
			writer.write("\r\nStars:" + stars + ";");
			scan.nextLine();
			writer.write("\r\nCrowns:" + crowns + ";\r\n");
			scan.nextLine();
			writer.write(scan.nextLine());
			writer.write("\r\nMoves:" + moves + ";");
			scan.nextLine();

			while (scan.hasNextLine()) {
				writer.write("\r\n" + scan.nextLine());
			}

			writer.close();
			scan.close();

			currentPuzzle.delete();
			temp.renameTo(new File("src/files/puzzle" + puzzleDifficulty + puzzleNumber + ".txt"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Settings getUserSettings() {
		File settingsFile = new File("src/files/settings.txt");
		Settings settings = new Settings();

		try {
			Scanner scan = new Scanner(settingsFile);

			String mouseSenseString = scan.nextLine();
			int mouseSense = Integer.valueOf(
					mouseSenseString.substring(mouseSenseString.indexOf(':') + 1, mouseSenseString.indexOf(';')));

			String volumeString = scan.nextLine();
			int volume = Integer
					.valueOf(volumeString.substring(volumeString.indexOf(':') + 1, volumeString.indexOf(';')));

			String tmString = scan.nextLine();
			String tm = tmString.substring(tmString.indexOf(':') + 1, tmString.indexOf(';'));

			String gtString = scan.nextLine();
			String gt = gtString.substring(gtString.indexOf(':') + 1, gtString.indexOf(';'));

			System.out.println(mouseSense + " " + volume + " " + tm + " " + gt);

			scan.close();

			settings.setMouseSense(mouseSense);
			settings.setVolume(volume);
			settings.setThemeMusic(tm);
			settings.setGameTheme(gt);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return settings;
	}

	public void updateMouseSense(int newSense) {
		File currentSettings = new File("src/files/settings.txt");
		File temp = new File("src/files/temp.txt");

		try {
			Scanner scan = new Scanner(currentSettings);

			FileWriter writer = new FileWriter(temp);

			writer.write("MouseSense:" + newSense + ";");
			scan.nextLine(); // skipping the new line

			while (scan.hasNextLine()) {
				writer.write("\r\n" + scan.nextLine());
			}

			writer.close();
			scan.close();

			currentSettings.delete();
			temp.renameTo(new File("src/files/settings.txt"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateVolume(int newVolume) {
		File currentSettings = new File("src/files/settings.txt");
		File temp = new File("src/files/temp.txt");

		try {
			Scanner scan = new Scanner(currentSettings);

			FileWriter writer = new FileWriter(temp);

			writer.write(scan.nextLine());

			writer.write("\r\nVolume:" + newVolume + ";");
			scan.nextLine(); // skipping previous volume setting

			while (scan.hasNextLine()) {
				writer.write("\r\n" + scan.nextLine());
			}

			writer.close();
			scan.close();

			currentSettings.delete();
			temp.renameTo(new File("src/files/settings.txt"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateThemeMusic(String newThemeMusic) {
		File currentSettings = new File("src/files/settings.txt");
		File temp = new File("src/files/temp.txt");

		try {
			Scanner scan = new Scanner(currentSettings);

			FileWriter writer = new FileWriter(temp);

			writer.write(scan.nextLine());
			writer.write("\r\n" + scan.nextLine());

			writer.write("\r\nThemeMusic:" + newThemeMusic + ";");
			scan.nextLine(); // skipping previous music setting

			while (scan.hasNextLine()) {
				writer.write("\r\n" + scan.nextLine());
			}

			writer.close();
			scan.close();

			currentSettings.delete();
			temp.renameTo(new File("src/files/settings.txt"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateGameTheme(String newGameTheme) {
		File currentSettings = new File("src/files/settings.txt");
		File temp = new File("src/files/temp.txt");

		try {
			Scanner scan = new Scanner(currentSettings);

			FileWriter writer = new FileWriter(temp);

			writer.write(scan.nextLine());
			writer.write("\r\n" + scan.nextLine());
			writer.write("\r\n" + scan.nextLine());

			writer.write("\r\nGameTheme:" + newGameTheme + ";");

			writer.close();
			scan.close();

			currentSettings.delete();
			temp.renameTo(new File("src/files/settings.txt"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void unlockCar(String carToUnlock) {
		File lockedCars = new File("src/files/locked.txt");
		File unlockedCars = new File("src/files/unlocked.txt");

		try {
			Scanner scan = new Scanner(lockedCars);
			FileWriter writer = new FileWriter(unlockedCars, true);
			String carString = "src/rushHour/images/" + carToUnlock + ";";

			while (scan.hasNextLine()) {
				String currentCar = scan.nextLine();
				if (carString.equals(currentCar)) {
					writer.write("\r\n" + currentCar);
					break;
				}
			}
			writer.close();
			scan.close();
			removeFromLocked(carToUnlock);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void removeFromLocked(String nowUnlocked) {
		File lockedCars = new File("src/files/locked.txt");
		File temp = new File("src/files/temp.txt");
		String carString = "src/rushHour/images/" + nowUnlocked + ";";

		try {
			Scanner scan = new Scanner(lockedCars);
			FileWriter writer = new FileWriter(temp);

			while (scan.hasNextLine()) {
				String currentCar = scan.nextLine();
				if (!currentCar.equals(carString)) {
					writer.write(currentCar + "\r\n");
				}
			}
			writer.close();
			scan.close();
			lockedCars.delete();
			temp.renameTo(new File("src/files/locked.txt"));
			if (!(temp.length() == 0))
				filterBlankLine("src/files/locked.txt");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void filterBlankLine(String fileName) {
		File file = new File(fileName);
		File temp = new File("src/files/temp.txt");

		try {
			Scanner scan = new Scanner(file);
			FileWriter writer = new FileWriter(temp);

			writer.write(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				if (!line.equals("")) {
					writer.write("\r\n" + line);
				}
			}
			writer.close();
			scan.close();
			file.delete();
			temp.renameTo(new File(fileName));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isUnlocked(String carName) {
		File unlocked = new File("src/files/unlocked.txt");
		String carURL = "src/rushHour/images/" + carName + ";";
		boolean found = false;

		try {
			Scanner scan = new Scanner(unlocked);

			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				if (line.equals(carURL))
					found = true;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
		}
		return found;
	}
}
