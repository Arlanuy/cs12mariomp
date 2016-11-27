import java.awt.*;
import java.awt.image.*;

public class Raindrops extends GameObject {
	int x = 700, y = 320;
	int rate = 1;
	Color c = Color.BLUE;
	BufferedImage img;
	BufferedImage i1, i2, i3;
	public Raindrops() {
		x = (int)(Math.random()*1100);
		y = (int)(Math.random()*480);
	}

	public void paint(Graphics2D g2d) {
		g2d.setColor(c);
		g2d.fillArc(x,y,10,10,0,360);

	}

	public void run() {
		while(true) {
			y = y + 5;
			if (y > 480) {
				y = 0;
				x = (int)(Math.random()*900);
			}
			MarioWindow.delay(20);
		}
	}
	public void keyPressed(String s) {
		System.out.println(s);
		if (s.equals("Space")) {
			c = Color.RED;
		}
	}

	public void keyReleased(String s) {
		System.out.println(s);
		if (s.equals("Space")) {
			c = Color.BLUE;
		}
	}
}
