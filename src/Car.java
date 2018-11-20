import java.util.ArrayList;

public class Car{

	private Square sq1;
	private Square sq2;
	private Square sq3;
	private int size;
	private int direction;
	private int x,y;
	private int sideLength = 60;
	private String url;
	
	public Car(int x, int y, int size, int direction, String url) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.direction = direction;
		this.url = url;
		
		if(direction == 0) {
			sq1 = new Square(x, y);
			sq2 = new Square(x + sideLength, y);
			
		} else if(direction == 1){
			
			sq1 = new Square(x, y);
			sq2 = new Square(x, y + sideLength);
		}
		
		//if the car has size 3 than we add a third square depending on the car direction
		if( size ==3) {
			if(direction == 0) {
				sq3 = new Square(x + sideLength*2, y);
			} else if(direction == 1){
				sq3 = new Square(x, y + sideLength*2);
			}
		}
	}
	
	
	public void move( int x, int y) {
		if(direction == 0) {
			if(y >= this.y && y < this.y + sideLength)
				if(( x<= 240 && size == 2) || ( ( x<= 180 && size == 3)))
					updatePosition( x, y);
		}else if(direction == 1) {
			if( x >= this.x && x < this.x + sideLength )
				if(( y<= 240 && size == 2) || ( ( y<= 180 && size == 3)))
					updatePosition( x, y);
		}
	}
	
	private void updatePosition( int x, int y) {
		this.x = x;
		this.y = y;
		
		if(direction == 0) {
			sq1.setX(x);
			sq2.setX(x + sideLength);
			sq1.setY(y);
			sq2.setY(y);
			
		} else if(direction == 1){
			sq1.setX(x);
			sq2.setX(x);
			sq1.setY(y);
			sq2.setY(y + sideLength);
		}
		
		//if the car has size 3 than we add a third square depending on the car direction
		if( size ==3 ) {
			if(direction == 0) {
				sq3.setX(x + sideLength*2);
				sq3.setY(y);
			} else if(direction == 1){
				sq3.setX(x);
				sq3.setY(y + sideLength*2);
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
	
	public boolean hasCoordinate(int x, int y) {
			if( sq1.hasCoordinate(x, y) || sq2.hasCoordinate(x, y))
				return true;
			if(size == 3)
				if(sq3.hasCoordinate(x, y))
					return true;
			return false;
		
	}


	public int getLength() {
		return this.sideLength;
	}
	
}
