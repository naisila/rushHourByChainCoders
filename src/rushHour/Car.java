package src.rushHour;

/**
 * __Car class of the game.
 * @author __Fatbardh
 * @version__18/11/2018
 */
import java.util.ArrayList;

public class Car {

	private Square sq1;
	private Square sq2;
	private Square sq3;
	private int size;
	private int direction;
	private int x, y;
	private int sideLength = 60;
	private String url;

	public Car(int x, int y, int size, int direction, String url) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.direction = direction;
		this.url = url;

		if (direction == 0) {
			sq1 = new Square(x, y);
			sq2 = new Square(x + sideLength, y);

		} else if (direction == 1) {

			sq1 = new Square(x, y);
			sq2 = new Square(x, y + sideLength);
		}

		// if the car has size 3 than we add a third square depending on the car
		// direction
		if (size == 3) {
			if (direction == 0) {
				sq3 = new Square(x + sideLength * 2, y);
			} else if (direction == 1) {
				sq3 = new Square(x, y + sideLength * 2);
			}
		}
	}

	public void move(int x, int y, int gridsize) {

		if (gridsize > 3) {
			if (direction == 0) {
				if (y >= this.y && y < this.y + sideLength && y >= 0 && x >= 0)
					if ((x <= (gridsize - 2) * 60 && size == 2)
							|| ((x <= (gridsize - 3) * 60 && size == 3)) && y >= 0 && x >= 0)
						updatePosition(x, this.y);
			} else if (direction == 1) {
				if (x >= this.x && x < this.x + sideLength && y >= 0 && x >= 0)
					if ((y <= (gridsize - 2) * 60 && size == 2)
							|| ((y <= (gridsize - 3) * 60 && size == 3)) && y >= 0 && x >= 0)
						updatePosition(this.x, y);
			}

		}

	}

	public void normalisePosition(int x, int y, int gridsize) {
		if (y % 60 == 0)
			if ((x % 60) < 30)
				this.move(x - (x % 60), y, gridsize);
			else
				this.move(x + 60 - (x % 60), y, gridsize);

		if (x % 60 == 0)
			if (y % 60 < 30)
				this.move(x, y - (y % 60), gridsize);
			else
				this.move(x, y + 60 - (y % 60), gridsize);
	}

	private void updatePosition(int x, int y) {
		this.x = x;
		this.y = y;

		if (direction == 0) {
			sq1.setX(x);
			sq2.setX(x + sideLength);
			sq1.setY(y);
			sq2.setY(y);

		} else if (direction == 1) {
			sq1.setX(x);
			sq2.setX(x);
			sq1.setY(y);
			sq2.setY(y + sideLength);
		}

		// if the car has size 3 than we add a third square depending on the car
		// direction
		if (size == 3) {
			if (direction == 0) {
				sq3.setX(x + sideLength * 2);
				sq3.setY(y);
			} else if (direction == 1) {
				sq3.setX(x);
				sq3.setY(y + sideLength * 2);
			}
		}

	}

	public ArrayList<Integer> getPosition() {
		ArrayList<Integer> arl = new ArrayList<Integer>();
		arl.add(x);
		arl.add(y);
		return arl;
	}

	public int getSize() {
		return size;
	}

	public int getDirection() {
		return direction;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String carUrl) {
		url = carUrl;
	}

	public boolean hasCoordinate(int x, int y) {
		if (sq1.hasCoordinate(x, y) || sq2.hasCoordinate(x, y))
			return true;
		if (size == 3)
			if (sq3.hasCoordinate(x, y))
				return true;
		return false;

	}

	public int getLength() {
		return this.sideLength;
	}

}