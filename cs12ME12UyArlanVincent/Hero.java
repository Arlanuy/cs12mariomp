import java.awt.*;
import java.awt.image.*;
public class Hero extends GameObject {
	int x; int y; Color c; String direction;
	BufferedImage img;
	public Hero() {   // this is a constructor
		this.x = 150; // called when object is created
		this.y = 300; // i.e. Hero h = new **Hero()**;
		this.c = Color.YELLOW; // used for initialization
		this.direction = "right";
		this.img = MarioWindow.getImage("r1.gif");
	}
	// what does the hero look like?
	public void paint(Graphics2D g) {
		g.setColor(this.c);
		//g.fillArc(x,y,30,30,0,360);
		g.drawImage(this.img, x, y, null);
	}

	// what does your hero do?
	public void run() {
		while(true) {

			if (this.direction.equals("right")) {
				x = x + 5;
				if (x > 1200) {  x = 0; }
			}

			if (this.direction.equals("left")) {
				x = x - 5;
				if (x < 0) { x = 1200; }
			}

			MarioWindow.delay(200);
		}
	}

	// a key was pressed! how does your hero react?
	public void keyPressed(String key) {
		System.out.println(key + " whut ");
		if (key.equals("1")) {
			this.c = Color.RED;
		} else if (key.equals("2")){
			this.c = Color.GREEN;
		} else if (key.equals("3")) {
			this.c = Color.YELLOW;
		} else if (key.equals("A")) {
			this.direction = "left";
			this.img = MarioWindow.getImage("l1.gif");
		} else if (key.equals("D")) {
			this.direction = "right";
			x = x + 5;
			if (x > 1200) {  x = 0; }
			this.img = MarioWindow.getImage("r1.gif");
		}
	}
}
