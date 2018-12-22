
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
import java.awt.event.MouseMotionListener;
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

		// here we create and initialise the grid cars
		ArrayList<Car> cars = new ArrayList<>();

		cars
				.add(new Car(0, 120, 2, 0, "src/rushHour/images/players-car.png"));
		cars
				.add(new Car(0, 0, 2, 0,"src/rushHour/images/horizontal2x1.png"));
		cars.add(
				new Car(120, 180, 3, 0, "src/rushHour/images/horizontal3x1.png"));
		cars
				.add(new Car(0, 180, 2, 1,"src/rushHour/images/vertical2x1.png"));
		cars
				.add(new Car(120, 0, 3, 1, "src/rushHour/images/vertical3x1.png"	));

		grid = new GameGrid(cars, 6);
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

		private Point drawPoint;

		private Car playersCar;
		private Car selectedCar;
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

		public GameGrid(ArrayList<Car> initialCars, int gridSize) {

			this.initialCars = initialCars;
			this.gridSize = gridSize;

			changedCars = new ArrayList<>();
			for (int i = 0; i < initialCars.size(); i++) {
				Car temp = initialCars.get(i);
				changedCars.add(new Car(temp.getPosition().get(0)
						,temp.getPosition().get(1)
						,temp.getSize()
						,temp.getDirection(),
						temp.getUrl()));
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
					// updates the possible travel distances of the selected car
					getTravelDistance();
					// used to calculate movement nr
					originalCarPositionX = selectedCar.getPosition().get(0);
					originalCarPositionY = selectedCar.getPosition().get(1);
					removeOccupied(selectedCar);

					repaint();
				}
			});

			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {

					drawPoint = new Point(e.getPoint());
					// updates the positions
					if (selectedCar != null) {
						selectedCar.normalisePosition(selectedCar.getPosition().get(0), selectedCar.getPosition().get(1) , gridSize);
						setOccupied(selectedCar);
						repaint();

						// test Index///////////////////////////
						int index = 0;
						for (int i = 0; i < gridSize*gridSize; i++) {
							if (squares.get(i).hasCoordinate(selectedCar.getPosition().get(0),
									selectedCar.getPosition().get(1))) {
								index = i;
								System.out.println("index1 = " + index);
							}
						}
						
						// update movement nr
						if (originalCarPositionX != selectedCar.getPosition().get(0)
								|| originalCarPositionY != selectedCar.getPosition().get(1)) {
							movementNr++;
							
						}
						
						if( changedCars.get(0).getPosition().get(0) == (gridSize-2)*60) {
							solved = true;
						}
						
						System.out.println("solved = " + solved);
						System.out.println("movementNr = " + movementNr);
						Game.this.setM(movementNr);
						Game.this.setT(solved);
						
					}

					// reset selected car
					selectedCar = null;
					backSquares = 0;
					frontSquares = 0;
					for (int i = 0; i < changedCars.size(); i++)
						setOccupied(changedCars.get(i));
					// test/////////////////////////////
					for (int i = 0; i < gridSize*gridSize; i++) {
						System.out.print(squares.get(i).getOccupied() + " ");
						if (((i + 1) % gridSize) == 0)
							System.out.println();
					}

				}
			});

		}

		public void reset() {
			movementNr = 0;
			//Game.this.setM(movementNr);
			
			solved = false;
			//Game.this.setT(solved);
			
			squares = new ArrayList<>();
			changedCars = new ArrayList<>();
			for (int i = 0; i < initialCars.size(); i++) {
				Car temp = initialCars.get(i);
				changedCars.add(new Car(temp.getPosition().get(0)
						,temp.getPosition().get(1)
						,temp.getSize()
						,temp.getDirection(),
						temp.getUrl()));
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
			repaint();
			System.out.println( changedCars.get(0).getPosition().get(0));
		}

		private void getTravelDistance() {
			// ArrayList<Integer> distances = new ArrayList<>();
			int carIndex = 0;
			int startIndex = 0;
			backSquares = 0;
			frontSquares = 0;

			for (int i = 0; i < gridSize*gridSize; i++) {
				if (squares.get(i).hasCoordinate(selectedCar.getPosition().get(0), selectedCar.getPosition().get(1))) {
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

					int j = gridSize*2;
					while ((carIndex + j) < gridSize*gridSize && !squares.get(carIndex + j).getOccupied()) {
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

					int j = gridSize*3;
					while ((carIndex + j) < gridSize*gridSize && !squares.get(carIndex + j).getOccupied()) {
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
			for (int i = 0; i < gridSize*gridSize; i++) {
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
					squares.get(index + gridSize*2).setOccupied(false);
			}

		}

		private void setOccupied(Car car) {
			int x = car.getPosition().get(0);
			int y = car.getPosition().get(1);
			int index = 0;

			// set the first square to occupied
			for (int i = 0; i < gridSize*gridSize; i++) {
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
					squares.get(index + gridSize*2).setOccupied(true);
			}

		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			// drow the rectangles
			for (int i = 0; i < gridSize*gridSize; i++) {
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
