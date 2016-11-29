package cs12mariomp;
public class Point {
	int x;
	int y;

	public Point() {
		this.x = 0; this.y = 0;
	}

	public Point(int x, int y) {
		this.x = x; this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	/**
	public int distanceTo(Point another) {
		return Math.sqrt( Math.pow((this.x - another.x),2)
			+ Math.pow((this.y - another.y),2));
	}

	public int distanceTo(int x, int y) {
		return Math.sqrt( Math.pow((this.x - x),2)
			+ Math.pow((this.y - y),2));
	}

	public Point midPoint(Point another) {
		Point bago = new Point();
		bago.x = (this.x + another.x)/2;
		bago.y = (this.y + another.y)/2;
		return bago;
	}*/

	public void sayHello() {
		System.out.println("(" + this.x + "," + this.y + ")");
	}
}
