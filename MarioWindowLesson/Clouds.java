// please place in MyGameObject.java
import java.awt.*;
import java.awt.image.*;

public class Clouds extends GameObject {
	int x = 600, y = 50;
	String direction = "right";
	BufferedImage img;
	BufferedImage i1;
	public Clouds() {
		img = MarioWindow.getImage("cloud3.gif");
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
				if (x > 600) {
					x = 0;					
				}
			} else if (direction.equals("left")) {
				x = x - 5;
				if (x < 0) {
					x = 600;
				}
			}
			MarioWindow.delay(100);
		}
	}
	
	public void keyPressed(String s) {
		System.out.println(s);
		if (s.equals("Left")) {
			direction = "left";
		} else if (s.equals("Right")) {
			direction = "right";
		}
	}

}