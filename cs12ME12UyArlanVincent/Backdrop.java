import java.awt.*;
import java.awt.image.*;

public class Backdrop extends GameObject {
	int x =0, y = 0;
	BufferedImage img;
	BufferedImage i1, i2;
	String direction = "right";
	public Backdrop() {
		i1 = MarioWindow.getImage("loc1.png");
		i2 = MarioWindow.getImage("loc2.png");
		img = i2;
	}

	public void paint(Graphics2D g2d) {
		if (img != null) {
			g2d.drawImage(img,x,y,null);
			System.out.println("painted naman");
		} else {
			g2d.fillArc(x,y,10,10,0,360);
		}
	}

	public void run() {
		while(true) {
			MarioWindow.delay(100);
		}
	}
	public void keyPressed(String s) {
		System.out.println(s);
		if (s.equals("1")) {
			img = i1;
		} else if (s.equals("2")) {
			img = i2;
		}
	}
}
