import java.awt.*;
import java.awt.image.*;

public class Mario extends GameObject {
	int x = 150, y = 400;
	BufferedImage img;
	BufferedImage r1, r2, r3, l1,l2;
	String direction = "right";
	public Mario() {

		r1 = MarioWindow.getImage("r1.gif");
		r2 = MarioWindow.getImage("r2.gif");
		r3 = MarioWindow.getImage("r3.gif");
		l1 = MarioWindow.getImage("l1.gif");
		l2 = MarioWindow.getImage("l2.gif");
		img = r1;
	}

    public void paint(Graphics2D g2d) {
		if (img != null) {
			g2d.drawImage(img,x,y,null);
		} else {
			g2d.fillArc(x,y,10,10,0,360);
		}
	}

    public void run() {
		while(true) {
				if (direction.equals("right")) {
					x = x + 7;
					if (x > 1000) {
						x = 150;
					}
					if (img == r1) {
						img = r2;
					} else if (img == r2) {
						img = r3;
					} else if (img == r3) {
						img = r1;
					}
				} else if (direction.equals("left")) {
					x = x - 5;
					if (x < 0) {
						x = 1000;
					}
					if (img == l1) {
						img = l2;
					} else if (img == l2) {
						img = l1;
					}
				}
			MarioWindow.delay(100);
		}
	}
}
