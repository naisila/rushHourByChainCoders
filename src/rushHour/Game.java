package rushHour;

/**
 * __Game Panel of the game.
 * @author __Naisila
 * @version__18/11/2018
 */
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Game extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel rushhour;

	JLabel avatar;

	JLabel reset;

	JLabel instr;

	JLabel timer;

	JLabel secs;

	JLabel moves;

	JLabel level;

	JLabel puzzle;

	JLabel back;

	JLabel car1;

	JLabel car2;

	JLabel car3;

	JLabel car4;

	JLabel car5;

	JLabel mainCar;

	JLabel jam;

	JLabel exit;

	JLabel bg;

	GameGrid grid;

	JLabel go;

	JTextArea name;
	private FileManagementSystem fms;
	private User u;
	private int diff;
	private int puzz;
	private ArrayList<Car> cars;
	ArrayList<Integer> puzzleConf;
	private JButton expl;
	private JButton undo;
	private JLabel reward;

	/**
	 * Create the panel.
	 */
	public Game(FileManagementSystem fmsi, int diffic, int puzzNo) {
		fms = fmsi;
		diff = diffic;
		puzz = puzzNo;
		u = fms.getUserData();
		setBackground(new Color(255, 250, 205));
		setLayout(null);

		go = new JLabel("");
		go.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/congrats.png").getImage().getScaledInstance(230,
				100, Image.SCALE_DEFAULT)));
		go.setBounds(290, 80, 230, 100);
		go.setVisible(false);
		add(go);

		reward = new JLabel("Nice Job!");
		reward.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/dancing.gif").getImage().getScaledInstance(550,
				263, Image.SCALE_DEFAULT)));
		reward.setBounds(190, 180, 550, 263);
		add(reward);
		reward.setVisible(false);

		rushhour = new JLabel("");
		rushhour.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/rushHour.png").getImage()
				.getScaledInstance(250, 80, Image.SCALE_DEFAULT)));
		rushhour.setBounds(290, 5, 250, 80);
		add(rushhour);

		avatar = new JLabel("");
		avatar.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/" + fmsi.getUserData().getAvatar()).getImage()
				.getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		avatar.setBounds(630, 5, 100, 100);
		add(avatar);

		reset = new JLabel("");
		reset.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/reset.png").getImage().getScaledInstance(100, 60,
				Image.SCALE_DEFAULT)));
		reset.setBounds(65, 400, 100, 60);
		add(reset);
		reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				grid.reset();

			}
		});

		instr = new JLabel("");
		instr.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/goodLuck.png").getImage().getScaledInstance(260,
				75, Image.SCALE_DEFAULT)));
		instr.setBounds(1, 450, 260, 75);
		add(instr);

		undo = new JButton("UNDO");
		// level.setIcon(new ImageIcon(new
		// ImageIcon("src/rushHour/images/intermediateLevel.png").getImage()
		// .getScaledInstance(250, 55, Image.SCALE_DEFAULT)));
		undo.setBounds(60, 120, 100, 50);
		undo.setBackground(new Color(217, 102, 102));
		undo.setFont(new Font("Monospaced", Font.BOLD, 20));
		add(undo);
		undo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				grid.undo();
			}
		});

		expl = new JButton("EXPLODE");
		// puzzle.setIcon(new ImageIcon(new
		// ImageIcon("src/rushHour/images/puzzle2.png").getImage().getScaledInstance(170,
		// 80, Image.SCALE_DEFAULT)));
		expl.setBounds(50, 240, 120, 50);
		expl.setBackground(new Color(217, 102, 102));
		expl.setFont(new Font("Monospaced", Font.BOLD, 20));
		expl.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				grid.explode();
			}

		});
		add(expl);

		name = new JTextArea("MOVES: 0");
		name.setFont(new Font("Forte", Font.BOLD, 40));
		name.setForeground(Color.WHITE);
		name.setOpaque(false);
		name.setBounds(5, 330, 240, 55);
		name.setEditable(false);

		add(name);

		back = new JLabel("");
		back.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/back.png").getImage().getScaledInstance(120, 65,
				Image.SCALE_DEFAULT)));
		back.setBounds(0, 0, 156, 65);
		back.setHorizontalAlignment(SwingConstants.CENTER);
		add(back);

		// here we create and initialise the grid cars
		cars = fms.getPuzzleConfig(diff, puzz);
		puzzleConf = fms.getPuzzleStats(diff, puzz);

		String current = fms.getUserData().getCar();
		if (!current.equals("red car.png")) {
			if (current.equals("pink car.png"))
				cars.get(0).setUrl("src/rushHour/images/pPinkCar.png");
			else if (current.equals("purple car.png"))
				cars.get(0).setUrl("src/rushHour/images/pPurpleCar.png");
			else if (current.equals("white car.png"))
				cars.get(0).setUrl("src/rushHour/images/pWhiteCar.png");
			else if (current.equals("white car2.png"))
				cars.get(0).setUrl("src/rushHour/images/pWhiteCar2.png");
			else if (current.equals("yellow car.png"))
				cars.get(0).setUrl("src/rushHour/images/pYellowCar.png");
			else if (current.equals("black car.png"))
				cars.get(0).setUrl("src/rushHour/images/pBlackCar.png");
			else if (current.equals("blue car.png"))
				cars.get(0).setUrl("src/rushHour/images/pBlueCar.png");
			else
				cars.get(0).setUrl("src/rushHour/images/pGreenCar.png");
		}

		grid = new GameGrid(cars, puzzleConf.get(0));
		grid.setBounds(270, 110, 60 * puzzleConf.get(0), 60 * puzzleConf.get(0));
		add(grid);

		jam = new JLabel("");
		jam.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/jam.jpg").getImage()
				.getScaledInstance(60 * puzzleConf.get(0), 60 * puzzleConf.get(0), Image.SCALE_DEFAULT)));
		jam.setBounds(270, 110, 60 * puzzleConf.get(0), 60 * puzzleConf.get(0));
		add(jam);

		exit = new JLabel("");
		exit.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/exit.png").getImage().getScaledInstance(45, 60,
				Image.SCALE_DEFAULT)));
		exit.setBounds(620 + (puzzleConf.get(0) - 6) * 60, 228, 45, 60);
		add(exit);

		bg = new JLabel("");
		if (diff == 0)
			bg.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/labg.jpg").getImage().getScaledInstance(778,
					566, Image.SCALE_DEFAULT)));
		else if (diff == 1)
			bg.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/chinabg.jpg").getImage().getScaledInstance(778,
					566, Image.SCALE_DEFAULT)));
		else
			bg.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/parisbg.jpg").getImage().getScaledInstance(778,
					566, Image.SCALE_DEFAULT)));
		bg.setBounds(0, 0, 778, 566);
		add(bg);
	}

	public void setMLBack(MouseAdapter madpt) {
		back.addMouseListener(madpt);
	}

	public void setT(boolean v) {
		go.setVisible(v);
		reward.setVisible(v);
	}

	public void setM(int no) {
		name.setText("MOVES: " + no);
	}

	/**
	 * __Game Grid of the game.
	 * 
	 * @author __Fatbardh Feta @version__18/11/2018
	 */
	class GameGrid extends JPanel implements MouseMotionListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private ArrayList<Car> changedCars;
		private ArrayList<Car> initialCars;
		private ArrayList<Square> squares;
		private int gridSize;
		private boolean exploded;

		private Point drawPoint;

		private Car playersCar;
		private Car selectedCar;
		private Car leastSelectedCar;
		// puzzle components
		private boolean solved;
		private int movementNr;
		private int pointx;
		private int pointy;

		// the posible travel distance of the selected car
		private int backSquares = 0;
		private int frontSquares = 0;
		private int originalCarPositionX = 0;
		private int originalCarPositionY = 0;

		// stack implementation
		private Stack<ArrayList<Car>> movements;
		private Stack<Boolean> explodedStack;
		boolean poped;

		public GameGrid(ArrayList<Car> initialCars, int gridSize) {
			setOpaque(false);
			exploded = false;

			this.initialCars = initialCars;
			this.gridSize = gridSize;

			movements = new Stack<>();
			explodedStack = new Stack<>();

			changedCars = new ArrayList<>();
			for (int i = 0; i < initialCars.size(); i++) {
				Car temp = initialCars.get(i);
				changedCars.add(new Car(temp.getPosition().get(0), temp.getPosition().get(1), temp.getSize(),
						temp.getDirection(), temp.getUrl()));
			}

			playersCar = changedCars.get(0);

			squares = new ArrayList<>();

			for (int i = 0; i < gridSize; i++) {
				for (int m = 0; m < gridSize; m++) {
					Square square = new Square(m * playersCar.getLength(), i * playersCar.getLength());
					squares.add(square);
				}

			}

			// update the occupied squares
			for (int i = 0; i < changedCars.size(); i++)
				setOccupied(changedCars.get(i));

			// reset variables
			pushConfiguration();
			solved = false;

			movementNr = 0;
			pointx = 0;
			pointy = 0;

			backSquares = 0;
			frontSquares = 0;
			// set size of the panel
			this.setPreferredSize(new Dimension(playersCar.getLength() * gridSize, playersCar.getLength() * gridSize));
			repaint();

			addMouseMotionListener(this);

			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {

					drawPoint = new Point(e.getPoint());
					pointx = e.getX();
					pointy = e.getY();
					// gets the selected car
					for (int i = 0; i < changedCars.size(); i++) {
						if (changedCars.get(i).hasCoordinate(drawPoint.x, drawPoint.y)) {
							selectedCar = changedCars.get(i);
						}
					}
					if (selectedCar != null) {
						// updates the possible travel distances of the selected car
						getTravelDistance();
						// used to calculate movement nr
						originalCarPositionX = selectedCar.getPosition().get(0);
						originalCarPositionY = selectedCar.getPosition().get(1);
						removeOccupied(selectedCar);
					}
					repaint();
				}
			});

			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {

					drawPoint = new Point(e.getPoint());
					// updates the positions
					if (selectedCar != null) {

						selectedCar.normalisePosition(selectedCar.getPosition().get(0),
								selectedCar.getPosition().get(1), gridSize);
						setOccupied(selectedCar);

						// update movement nr
						if (originalCarPositionX != selectedCar.getPosition().get(0)
								|| originalCarPositionY != selectedCar.getPosition().get(1)) {
							movementNr++;
							pushConfiguration();
							poped = false;
						}

						if (changedCars.get(0).getPosition().get(0) == (gridSize - 2) * 60) {
							solved = true;
							if (Game.this.puzzleConf.get(1) == 0) {
								int stars = 0;
								if (Game.this.puzzleConf.get(4) >= movementNr)
									stars = 3;
								else if (Game.this.puzzleConf.get(4) + 3 >= movementNr)
									stars = 2;
								else if (Game.this.puzzleConf.get(4) + 6 >= movementNr)
									stars = 1;
								if (!Game.this.expl.isEnabled() && stars > 0)
									stars--;
								fms.updatePuzzleStats(Game.this.diff, Game.this.puzz, 1, stars, 0, movementNr);
								int coins = u.getCoins() + 1500 + (1000 * stars);
								fms.updateCoins(coins + "");
								int allStars = u.getStars() + stars;
								fms.updateStars(allStars + "");
							}
						}

						leastSelectedCar = selectedCar;

						System.out.println("solved = " + solved);
						System.out.println("movementNr = " + movementNr);
						repaint();

					}

					// reset selected car
					selectedCar = null;
					backSquares = 0;
					frontSquares = 0;
					for (int i = 0; i < changedCars.size(); i++)
						setOccupied(changedCars.get(i));

					// test/////////////////////////////
					for (int i = 0; i < gridSize * gridSize; i++) {
						System.out.print(squares.get(i).getOccupied() + " ");
						if (((i + 1) % gridSize) == 0)
							System.out.println();
					}
					System.out.println(exploded + " Exploded");
				}
			});

		}

		public void reset() {
			exploded = false;
			movementNr = 0;
			// Game.this.setM(movementNr);

			solved = false;
			movements = new Stack<>();
			explodedStack = new Stack<>();

			explodedStack.push(exploded);
			// Game.this.setT(solved);

			squares = new ArrayList<>();
			changedCars = new ArrayList<>();
			for (int i = 0; i < initialCars.size(); i++) {
				Car temp = initialCars.get(i);
				changedCars.add(new Car(temp.getPosition().get(0), temp.getPosition().get(1), temp.getSize(),
						temp.getDirection(), temp.getUrl()));
			}

			playersCar = changedCars.get(0);

			squares = new ArrayList<>();

			for (int i = 0; i < gridSize; i++) {
				for (int m = 0; m < gridSize; m++) {
					Square square = new Square(m * playersCar.getLength(), i * playersCar.getLength());
					squares.add(square);
				}

			}

			// update the occupied squares
			for (int i = 0; i < changedCars.size(); i++)
				setOccupied(changedCars.get(i));
			pushConfiguration();
			repaint();
			System.out.println(changedCars.get(0).getPosition().get(0));
		}

		private void pushConfiguration() {
			ArrayList<Car> carConfig = new ArrayList<>();

			if (changedCars != null) {
				for (int i = 0; i < changedCars.size(); i++) {
					Car temp = changedCars.get(i);
					carConfig.add(new Car(temp.getPosition().get(0), temp.getPosition().get(1), temp.getSize(),
							temp.getDirection(), temp.getUrl()));
				}

				poped = false;
				movements.push(carConfig);
				explodedStack.push(exploded);
			}

		}

		private void undo() {
			if (!movements.empty() && movements != null) {
				if (!poped) {
					movements.pop();
					explodedStack.pop();
					poped = true;
				}
				if (poped && movementNr > 0) {
					movementNr--;
					changedCars = movements.pop();
					playersCar = changedCars.get(0);
					exploded = explodedStack.pop();
					System.out.println("when setting : " + exploded);
					expl.setEnabled(!exploded);
				}

				squares = new ArrayList<>();

				for (int i = 0; i < gridSize; i++) {
					for (int m = 0; m < gridSize; m++) {
						Square square = new Square(m * playersCar.getLength(), i * playersCar.getLength());
						squares.add(square);
					}

				}

				for (int i = 0; i < changedCars.size(); i++)
					setOccupied(changedCars.get(i));

				repaint();
			} else {
				reset();
				pushConfiguration();
			}

		}

		private void explode() {

			if (leastSelectedCar != null && leastSelectedCar != playersCar) {

				if (!exploded) {
					this.exploded = true;
					expl.setEnabled(false);
				}

				changedCars.remove(leastSelectedCar);
				Clip clipNameClip;
				try {
					AudioInputStream clipNameAIS = AudioSystem
							.getAudioInputStream(getClass().getResourceAsStream("/rushHour/sound/explosion.wav"));

					clipNameClip = AudioSystem.getClip();
					clipNameClip.open(clipNameAIS);
					clipNameClip.setFramePosition(0);

					clipNameClip.start();
				} catch (Exception e1) {
					System.out.println("Failure to load sound");
				}

				movementNr++;
				leastSelectedCar = null;

				poped = true;

				pushConfiguration();

				squares = new ArrayList<>();

				for (int i = 0; i < gridSize; i++) {
					for (int m = 0; m < gridSize; m++) {
						Square square = new Square(m * playersCar.getLength(), i * playersCar.getLength());
						squares.add(square);
					}

				}

				for (int i = 0; i < changedCars.size(); i++)
					setOccupied(changedCars.get(i));

			}
			repaint();
		}

		private void getTravelDistance() {
			if (selectedCar != null) {
				// ArrayList<Integer> distances = new ArrayList<>();
				int carIndex = 0;
				int startIndex = 0;
				backSquares = 0;
				frontSquares = 0;

				for (int i = 0; i < gridSize * gridSize; i++) {
					if (squares.get(i).hasCoordinate(selectedCar.getPosition().get(0),
							selectedCar.getPosition().get(1))) {
						carIndex = i;
					}
				}
				startIndex = carIndex % gridSize;

				if (selectedCar.getDirection() == 0) {
					// horizontal car
					if (selectedCar.getSize() == 2) {
						// car with size 2
						int i = 1;
						while ((carIndex - i + 1) % gridSize != 0 && !squares.get(carIndex - i).getOccupied()) {
							backSquares++;
							i++;
						}
						// bc car is of size 2
						int j = 2;
						while ((carIndex + j) % gridSize != 0 && !squares.get(carIndex + j).getOccupied()) {
							frontSquares++;
							j++;
						}
					} else if (selectedCar.getSize() == 3) {
						// car with size 3
						int i = 1;
						while ((carIndex - i + 1) % gridSize != 0 && !squares.get(carIndex - i).getOccupied()) {
							backSquares++;
							i++;

						}
						// bc car is of size 2
						int j = 3;
						while ((carIndex + j) % gridSize != 0 && !squares.get(carIndex + j).getOccupied()) {
							frontSquares++;
							j++;
						}
					}

				} else if (selectedCar.getDirection() == 1) {
					// vertical car
					if (selectedCar.getSize() == 2) {
						// car with size 2
						int i = gridSize;
						while ((carIndex - i) >= 0 && !squares.get(carIndex - i).getOccupied()) {
							i += gridSize;
							backSquares++;
						}

						int j = gridSize * 2;
						while ((carIndex + j) < gridSize * gridSize && !squares.get(carIndex + j).getOccupied()) {
							frontSquares++;
							j += gridSize;

						}

					} else if (selectedCar.getSize() == 3) {
						// car with size 3
						int i = gridSize;
						while ((carIndex - i) >= 0 && !squares.get(carIndex - i).getOccupied()) {
							i += gridSize;
							backSquares++;
							System.out.println("1");
						}

						int j = gridSize * 3;
						while ((carIndex + j) < gridSize * gridSize && !squares.get(carIndex + j).getOccupied()) {
							frontSquares++;
							j += gridSize;
							System.out.println("2");
						}
					}
				}

				// right down are in frontSquares
				// left Up are in backSquares
				// returns possible distance to travel
				frontSquares = frontSquares * 60;
				backSquares = backSquares * 60;
				System.out.println(frontSquares + "  " + backSquares);
			}
		}

		private void updatePosition(int x, int y) {
			// it is important to remove the squares and then add them after the
			removeOccupied(selectedCar);
			System.out.println(" updateposition-----------------------------------------------");
			selectedCar.move(x, y, gridSize);
		}

		private void removeOccupied(Car car) {
			int x = car.getPosition().get(0);
			int y = car.getPosition().get(1);
			int index = 0;

			// set the first square to occupied
			for (int i = 0; i < gridSize * gridSize; i++) {
				if (squares.get(i).hasCoordinate(x, y)) {
					squares.get(i).setOccupied(false);
					index = i;
				}
			}
			// if the square is horizontal we update the next square in the array
			if (car.getDirection() == 0) {
				squares.get(index + 1).setOccupied(false);
				if (car.getSize() == 3) {
					// if the car has 3 squares we update the third one
					squares.get(index + 2).setOccupied(false);
				}
			}
			if (car.getDirection() == 1) {
				squares.get(index + gridSize).setOccupied(false);
				if (car.getSize() == 3)
					// if the car has 3 squares we update the third one
					squares.get(index + gridSize * 2).setOccupied(false);
			}

		}

		private void setOccupied(Car car) {
			int x = car.getPosition().get(0);
			int y = car.getPosition().get(1);
			int index = 0;

			// set the first square to occupied
			for (int i = 0; i < gridSize * gridSize; i++) {
				if (squares.get(i).hasCoordinate(x, y)) {
					squares.get(i).setOccupied(true);
					index = i;
				}
			}
			// if the square is horizontal we update the next square in the array
			if (car.getDirection() == 0) {
				squares.get(index + 1).setOccupied(true);
				if (car.getSize() == 3)
					// if the car has 3 squares we update the third one
					squares.get(index + 2).setOccupied(true);
			}
			if (car.getDirection() == 1) {
				squares.get(index + gridSize).setOccupied(true);
				if (car.getSize() == 3)
					// if the car has 3 squares we update the third one
					squares.get(index + gridSize * 2).setOccupied(true);
			}

		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();

			Game.this.setM(movementNr);
			Game.this.setT(solved);

			// drow the rectangles
			for (int i = 0; i < gridSize * gridSize; i++) {
				g2d.drawRect(squares.get(i).getX(), squares.get(i).getY(), playersCar.getLength(),
						playersCar.getLength());
			}

			// draws the changedCars
			for (int i = 0; i < changedCars.size(); i++) {
				try {
					g2d.drawImage(ImageIO.read(new File(changedCars.get(i).getUrl())),
							changedCars.get(i).getPosition().get(0), changedCars.get(i).getPosition().get(1), this);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			g2d.dispose();
		}

		public Car getPlayersCar() {
			return changedCars.get(0);
		}

		public int calculateStars() {
			// To DO
			return 2;
		}

		public int calculateCrowns() {
			// To Do
			return 2;
		}

		public int calculateCoins() {

			return 2;
		}

		public int getMovementNumber() {
			return movementNr;
		}

		public boolean isSolved() {
			return solved;
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			if (selectedCar != null) {
				if (selectedCar.getDirection() == 0) {
					// for horizontal changedCars

					if (e.getX() - pointx <= 0 && backSquares >= 0) {

						// left
						int temp = Math.max(selectedCar.getPosition().get(0) + e.getX() - pointx,
								selectedCar.getPosition().get(0) - backSquares);
						updatePosition(temp, selectedCar.getPosition().get(1));

						if (backSquares + e.getX() - pointx >= 0) {
							backSquares = backSquares + e.getX() - pointx;
							frontSquares = frontSquares + pointx - e.getX();
						} else {
							getTravelDistance();
						}

					} else if (pointx - e.getX() <= 0 && frontSquares >= 0) {
						// right
						int temp = Math.min(selectedCar.getPosition().get(0) + e.getX() - pointx,
								selectedCar.getPosition().get(0) + frontSquares);
						updatePosition(temp, selectedCar.getPosition().get(1));
						if (frontSquares - e.getX() + pointx >= 0) {
							backSquares = backSquares + e.getX() - pointx;
							frontSquares = frontSquares + pointx - e.getX();
						} else {
							getTravelDistance();
						}
					}

				} else if (selectedCar.getDirection() == 1) {
					// for vertical changedCars
					if (pointy - e.getY() >= 0 && backSquares >= 0) {
						// up
						int temp = Math.max(selectedCar.getPosition().get(1) + e.getY() - pointy,
								selectedCar.getPosition().get(1) - backSquares);
						updatePosition(selectedCar.getPosition().get(0), temp);

						System.out.println(backSquares + " " + frontSquares);

						if (backSquares + e.getY() - pointy >= 0) {
							backSquares = backSquares + e.getY() - pointy;
							frontSquares = frontSquares + pointy - e.getY();
						} else {
							getTravelDistance();
						}

					} else if (pointy - e.getY() <= 0 && frontSquares >= 0) {
						// down
						int temp = Math.min(selectedCar.getPosition().get(1) + e.getY() - pointy,
								selectedCar.getPosition().get(1) + frontSquares);
						updatePosition(selectedCar.getPosition().get(0), temp);

						if (frontSquares - e.getY() + pointy >= 0) {
							backSquares = backSquares + e.getY() - pointy;
							frontSquares = frontSquares + pointy - e.getY();
						} else {
							getTravelDistance();
						}

						System.out.println(backSquares + " " + frontSquares);

					}
				}
			}
			pointx = e.getX();
			pointy = e.getY();
			repaint();

		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
}