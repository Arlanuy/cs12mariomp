import java.awt.*;
import java.awt.image.*;

public class MyGameObject extends GameObject {
	int x = 50, y = 320;
	BufferedImage img;
	BufferedImage i1, i2, i3,i4,i5,i6;
	String direction = "right";
	public MyGameObject() {
		
		i1 = MarioWindow.getImage("r1.gif");
		i2 = MarioWindow.getImage("r2.gif");
		i3 = MarioWindow.getImage("r3.gif");
		img = i1;
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
				x = x - 1;
				if (x < 0) {
					x = 600;
				}
			}
			if (img == i1) {
				img = i2;
			} else if (img == i2) {
				img = i3;				
			} else if (img == i3) {
				img = i1;
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