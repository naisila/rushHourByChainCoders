package rushHour;

/**
 * __Game Panel of the game.
 * @author __Naisila
 * @version__18/11/2018
 */
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

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

	JLabel name;

	/**
	 * Create the panel.
	 */
	public Game() {
		setBackground(new Color(255, 250, 205));
		setLayout(null);

		rushhour = new JLabel("");
		rushhour.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/rushHour.png").getImage()
				.getScaledInstance(250, 80, Image.SCALE_DEFAULT)));
		rushhour.setBounds(290, 5, 250, 80);
		add(rushhour);

		avatar = new JLabel("");
		avatar.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/Avatar.png").getImage().getScaledInstance(100,
				100, Image.SCALE_DEFAULT)));
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
		instr.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/instructions.png").getImage()
				.getScaledInstance(200, 75, Image.SCALE_DEFAULT)));
		instr.setBounds(20, 450, 200, 75);
		add(instr);

//		timer = new JLabel("");
//		timer.setIcon(new ImageIcon(
//				new ImageIcon("src/rushHour/images/timer.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
//		timer.setBounds(10, 196, 88, 94);
//		add(timer);

//		secs = new JLabel("");
//		secs.setIcon(new ImageIcon(
//				new ImageIcon("src/rushHour/images/secs.png").getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT)));
//		secs.setBounds(65, 225, 139, 40);
//		add(secs);

//		moves = new JLabel("");
//		moves.setIcon(new ImageIcon(
//				new ImageIcon("src/rushHour/images/moves.png").getImage().getScaledInstance(130, 50, Image.SCALE_DEFAULT)));
//		moves.setBounds(21, 174, 143, 40);
//		add(moves);

		level = new JLabel("");
		level.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/intermediateLevel.png").getImage()
				.getScaledInstance(250, 55, Image.SCALE_DEFAULT)));
		level.setBounds(7, 100, 250, 55);
		add(level);

		puzzle = new JLabel("");
		puzzle.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/puzzle2.png").getImage().getScaledInstance(170,
				80, Image.SCALE_DEFAULT)));
		puzzle.setBounds(30, 230, 170, 80);
		add(puzzle);

		name = new JLabel("MOVES: 0");
		name.setFont(new Font("Forte", Font.BOLD, 40));
		name.setForeground(Color.BLUE);
		name.setBackground(Color.BLUE);
		name.setBounds(5, 330, 240, 35);
		add(name);

		go = new JLabel("");
		go.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/congrats.png").getImage().getScaledInstance(230,
				100, Image.SCALE_DEFAULT)));
		go.setBounds(10, 150, 230, 100);
		go.setVisible(false);
		add(go);

		back = new JLabel("");
		back.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/back.png").getImage().getScaledInstance(150, 80,
				Image.SCALE_DEFAULT)));
		back.setBounds(3, 3, 150, 80);
		add(back);

		grid = new GameGrid();
		grid.setBounds(270, 110, 360, 360);
		add(grid);

		jam = new JLabel("");
		jam.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/jam.jpg").getImage().getScaledInstance(360, 360,
				Image.SCALE_DEFAULT)));
		jam.setBounds(270, 110, 360, 360);
		add(jam);

		exit = new JLabel("");
		exit.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/exit.png").getImage().getScaledInstance(45, 60,
				Image.SCALE_DEFAULT)));
		exit.setBounds(620, 228, 45, 60);
		add(exit);

		bg = new JLabel("");
		bg.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/bg.jpg").getImage().getScaledInstance(778, 566,
				Image.SCALE_DEFAULT)));
		bg.setBounds(0, 0, 778, 566);
		add(bg);
	}

	public void setMLBack(MouseAdapter madpt) {
		back.addMouseListener(madpt);
	}

	public void setT(boolean v) {
		go.setVisible(v);
	}

	public void setM(int no) {
		name.setText("MOVES: " + no);
	}

	/**
	 * __Game Grid of the game.
	 * 
	 * @author __Fatbardh 
	 * @version__18/11/2018
	 */
	class GameGrid extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private ArrayList<Car> cars;
		private ArrayList<Square> squares;

		private Point drawPoint;

		private Car playersCar;
		private Car selectedCar;
		// puzzle components
		private boolean solved = false;
		private int movementNr;

		public GameGrid() {

			this.reset();
			setOpaque(false);
			// set size of the panel
			this.setPreferredSize(new Dimension(playersCar.getLength() * 6, playersCar.getLength() * 6));
			repaint();
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					drawPoint = new Point(e.getPoint());
					// gets the selected car
					for (int i = 0; i < cars.size(); i++) {
						if (cars.get(i).hasCoordinate(drawPoint.x, drawPoint.y)) {
							selectedCar = cars.get(i);
						}
					}
					repaint();
				}
			});

			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					drawPoint = new Point(e.getPoint());
					// updates the positions
					updatePositions();
					repaint();
				}
			});

		}

		public void reset() {
			Game.this.setT(false);
			Game.this.setM(0);
			solved = false;
			movementNr = 0;
			cars = new ArrayList<>();
			squares = new ArrayList<>();

			playersCar = new Car(0, 120, 2, 0, "src/rushHour/images/players-car.png");
			cars.add(playersCar);
			cars.add(new Car(0, 0, 2, 0, "src/rushHour/images/horizontal2x1.png"));
			cars.add(new Car(120, 180, 3, 0, "src/rushHour/images/horizontal3x1.png"));
			cars.add(new Car(0, 180, 2, 1, "src/rushHour/images/vertical2x1.png"));
			cars.add(new Car(120, 0, 3, 1, "src/rushHour/images/vertical3x1.png"));

			for (int i = 0; i < 6; i++) {
				for (int m = 0; m < 6; m++) {
					Square square = new Square(m * playersCar.getLength(), i * playersCar.getLength());
					squares.add(square);
					square.setOccupied(false);
				}

			}

			// update the occupied squares
			for (int i = 0; i < cars.size(); i++)
				setOccupied(cars.get(i));
			repaint();
			System.out.println(isSolved());
		}

		private void updatePositions() {
			for (int i = 0; i < 36; i++) {
				if (selectedCar != null)
					if (squares.get(i).hasCoordinate(drawPoint.x, drawPoint.y)) {
						// it is important to remove the occupied squares and then add them after the
						removeOccupied(selectedCar);
						if (hasPath(selectedCar, i)) {
							// car is moved
							if (!isInHead(selectedCar, drawPoint.x, drawPoint.y)) {
								movementNr++;
							}
							System.out.println(movementNr);
							selectedCar.move(squares.get(i).getX(), squares.get(i).getY());
							// if the players car is moved to the
							if (cars.get(0).getPosition().get(0) == 240 && cars.get(0).getPosition().get(1) == 120)
								solved = true;
							System.out.println(solved);
						}
						// reset the car to occupied
						setOccupied(selectedCar);
					}
			}
		}

		private boolean isInHead(Car car, int x, int y) {
			Square headSquare = new Square(car.getPosition().get(0), car.getPosition().get(1));

			return headSquare.hasCoordinate(x, y);
		}

		private boolean hasPath(Car car, int destIndex) {
			// first we get all the squares that the selected car contains
			ArrayList<Integer> carParts = new ArrayList<>();
			int index = 0;
			for (int i = 0; i < 36; i++) {
				if (squares.get(i).hasCoordinate(car.getPosition().get(0), car.getPosition().get(1))) {
					index = i;

				}
			}
			carParts.add(index);

			if (car.getDirection() == 0) {
				carParts.add(index + 1);
				if (car.getSize() == 3) {
					// if the car has 3 squares we update the third one
					carParts.add(index + 2);
				}
			}
			if (car.getDirection() == 1) {
				carParts.add(index + 6);
				if (car.getSize() == 3) {
					// if the car has 3 squares we update the third one
					carParts.add(index + 12);
				}
			}

			// check if there is an obstacle in the path
			// if car is horizontal
			if (car.getDirection() == 0) {
				int distanceToTravel = destIndex - index;
				// ceck if destination is free
				for (int m = 0; m < carParts.size(); m++) {
					if (squares.get(carParts.get(m) + distanceToTravel).getOccupied())
						return false;
				}
				// check if there is a car in the path
				if (distanceToTravel > 0) {
					for (int start = carParts.get(0) + car.getSize(); destIndex > start; start++) {
						if (squares.get(start).getOccupied())
							return false;
					}
				} else if (distanceToTravel < 0) {
					for (int start = carParts.get(0); destIndex < start; start--) {
						if (squares.get(start).getOccupied())
							return false;
					}
				}
			}

			// if car is vertical
			if (car.getDirection() == 1) {
				int distanceToTravel = destIndex - index;
				// check if destination is free
				for (int m = 0; m < carParts.size(); m++) {
					if (squares.get(carParts.get(m) + distanceToTravel).getOccupied())
						return false;
				}
				// check if there is a car in the path
				if (distanceToTravel > 0) {
					for (int start = carParts.get(0) + (car.getSize() - 1) * 6; start < destIndex; start += 6) {
						if (squares.get(start).getOccupied())
							return false;
					}
				} else if (distanceToTravel < 0) {
					for (int start = index; destIndex < start; start -= 6) {
						if (squares.get(start).getOccupied())
							return false;
					}
				}
			}

			return true;

		}

		private void removeOccupied(Car car) {
			int x = car.getPosition().get(0);
			int y = car.getPosition().get(1);
			int index = 0;

			// set the first square to occupied
			for (int i = 0; i < 36; i++) {
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
				squares.get(index + 6).setOccupied(false);
				if (car.getSize() == 3)
					// if the car has 3 squares we update the third one
					squares.get(index + 12).setOccupied(false);
			}

		}

		private void setOccupied(Car car) {
			int x = car.getPosition().get(0);
			int y = car.getPosition().get(1);
			int index = 0;

			// set the first square to occupied
			for (int i = 0; i < 36; i++) {
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
				squares.get(index + 6).setOccupied(true);
				if (car.getSize() == 3)
					// if the car has 3 squares we update the third one
					squares.get(index + 12).setOccupied(true);
			}

		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			// drow the rectangles
			for (int i = 0; i < 36; i++) {
				g2d.drawRect(squares.get(i).getX(), squares.get(i).getY(), playersCar.getLength(),
						playersCar.getLength());
			}

			// draws the cars
			for (int i = 0; i < cars.size(); i++) {
				try {
					g2d.drawImage(ImageIO.read(new File(cars.get(i).getUrl())), cars.get(i).getPosition().get(0),
							cars.get(i).getPosition().get(1), this);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			if (GameGrid.this.isSolved())
				Game.this.setT(true);
			Game.this.setM(GameGrid.this.getMovementNumber());
			g2d.dispose();
		}

		public Car getPlayersCar() {
			return cars.get(0);
		}

		public int calculateStars() {

			return 2;
		}

		public int calculateCrowns() {

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
	}
}
