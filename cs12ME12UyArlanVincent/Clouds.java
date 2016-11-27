// please place in MyGameObject.java
import java.awt.*;
import java.awt.image.*;

public class Clouds extends GameObject {
	int x = 600, y = 50;
	String direction = "right";
	BufferedImage img;
	BufferedImage i1;
	public Clouds() {
		img = MarioWindow.getImage("Cloud3.gif");
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
				x = x + 5;
				if (x > 1000) {
					x = 0;
				}
			} else if (direction.equals("left")) {
				x = x - 5;
				if (x < 0) {
					x = 1000;
				}
			}
			MarioWindow.delay(100);
		}
	}

}
