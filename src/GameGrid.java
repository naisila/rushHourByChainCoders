import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.Destination;
import javax.swing.*;
import javax.swing.JPanel;

public class GameGrid extends JPanel {
	private ArrayList<Car> cars;
	private ArrayList<Square> squares;

	private BufferedImage image;
	private Point drawPoint;

	private Car playersCar;
	private Car selectedCar;

	public GameGrid() {

		cars = new ArrayList<>();
		squares = new ArrayList<>();

		playersCar = new Car(0, 120, 2, 0, "C:\\Users\\Fatbardh\\eclipse-workspace\\CS319.1.0\\src\\players-car.png");
		cars.add(playersCar);
		cars.add(new Car(0, 0, 2, 0, "C:\\Users\\Fatbardh\\eclipse-workspace\\CS319.1.0\\src\\horizontal2x1.png"));
		cars.add(new Car(120, 180, 3, 0, "C:\\Users\\Fatbardh\\eclipse-workspace\\CS319.1.0\\src\\horizontal3x1.png"));
		cars.add(new Car(0, 180, 2, 1, "C:\\Users\\Fatbardh\\eclipse-workspace\\CS319.1.0\\src\\vertical2x1.png"));
		cars.add(new Car(120, 0, 3, 1, "C:\\Users\\Fatbardh\\eclipse-workspace\\CS319.1.0\\src\\vertical3x1.png"));

		for (int i = 0; i < 6; i++) {
			for (int m = 0; m < 6; m++) {
				Square square = new Square(m * playersCar.getLength(), i * playersCar.getLength());
				squares.add(square);
			}

		}

		// update the occupied squares
		for (int i = 0; i < cars.size(); i++)
			setOccupied(cars.get(i));

		// set size of the panel
		this.setPreferredSize(new Dimension(playersCar.getLength() * 6, playersCar.getLength() * 6));

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				drawPoint = new Point(e.getPoint());
				// gets the selected car
				System.out.println(drawPoint.x + "  " + drawPoint.y);
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
		repaint();
		
		
	}

	private void updatePositions() {
		for (int i = 0; i < 36; i++) {
			if (selectedCar != null)
				if (squares.get(i).hasCoordinate(drawPoint.x, drawPoint.y)) {
					// it is important to remove the occupied squares and then add them after the
					removeOccupied(selectedCar);
					System.out.println(hasPath(selectedCar, i));
					if (hasPath(selectedCar, i)) {
						// car is moved
						selectedCar.move(squares.get(i).getX(), squares.get(i).getY());
					}
					// reset the car to occupied
					setOccupied(selectedCar);
				}
		}
		for (int i = 0; i < squares.size(); i++) {
			if (i % 6 == 0)
				System.out.println();
			System.out.print(squares.get(i).getOccupied() + " ");
		}

		for (int i = 0; i < squares.size(); i++) {
			if (i % 6 == 0)
				System.out.println();
			System.out.print(i + " ");
		}

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
		//if car is horizontal
		if (car.getDirection() == 0) {
			int distanceToTravel = destIndex - index;
			//ceck if destination is free
			for (int m = 0; m < carParts.size(); m++) {
				if (squares.get(carParts.get(m) + distanceToTravel).getOccupied())
					return false;
			}
			//check if there is a car in the path
			if (distanceToTravel > 0) {
				for (int start = carParts.get(0) + car.getSize();  destIndex > start; start++) {
					if (squares.get(start).getOccupied())
						return false;
				}
			} else if (distanceToTravel < 0){
				for (int start = carParts.get(0);  destIndex < start ; start--) {
					if (squares.get(start).getOccupied())
						return false;
				}
			}
		}
		
		//if car is vertical
		if (car.getDirection() == 1) {
			int distanceToTravel = destIndex - index;
			//check if destination is free
			for (int m = 0; m < carParts.size(); m++) {
				if (squares.get(carParts.get(m) + distanceToTravel).getOccupied())
					return false;
			}
			//check if there is a car in the path
			if (distanceToTravel > 0) {
				for (int start = carParts.get(0) + (car.getSize() -1)*6 ; start < destIndex; start+=6) {
					if (squares.get(start).getOccupied())
						return false;
				}
			} else if (distanceToTravel < 0){
				for (int start = index;  destIndex < start ; start-=6) {
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

		if (drawPoint != null) {

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
		}
		g2d.dispose();
	}

}
