package src.rushHour;

/**
 * __Square class of the game.
 * 
 * @author __Fatbardh @version__18/11/2018
 */
public class Square {
	final private int SIZE = 60;

	private int x;
	private int y;
	private boolean occupied;

	public Square(int x, int y) {
		this.x = x;
		this.y = y;
		this.occupied = false;
	}

	public int getSize() {
		return SIZE;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean getOccupied() {
		return this.occupied;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setOccupied(boolean b) {
		this.occupied = b;
	}

	public Boolean hasCoordinate(int x, int y) {
		// check if the coordinate fits in the x direction
		if ((x < this.x + SIZE) && (x >= this.x))
			// check if the coordinate fits in y direction
			if ((y >= this.y) && (y < this.y + SIZE))
				return true;
		return false;
	}
}
