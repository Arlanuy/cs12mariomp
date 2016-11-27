import java.awt.*;
import java.awt.image.*;
public class Ritz extends GameObject {
    int x = 150, y = 320;
    BufferedImage img;
    BufferedImage i1, i2, i3,i4,i5,i6;
    String direction = "right";
    public Ritz() {
        i1 = MarioWindow.getImage("Ritz1 (SE).gif");
        i2 = MarioWindow.getImage("Ritz1 - Down.gif");
        i3 = MarioWindow.getImage("Ritz1 - Wounded.gif");
        i4 = MarioWindow.getImage("Ritz1 - Wave.gif");
        i5 = MarioWindow.getImage("Ritz1 - Victory.gif");
        i6 = MarioWindow.getImage("Ritz1 - Hit.gif");
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
				x = x + 7;
				if (x >= 550) {
					x = 150;
				}
			} else if (direction.equals("left")) {
				x = x - 7;
				if (x < 0) {
					x = 600;
				}
			}
			if (img == i1) {
				img = i2;
			} else if (img == i2) {
				img = i3;
			} else if (img == i3) {
				img = i4;
			}

            if (img == i4) {
				img = i5;
			} else if (img == i5) {
				img = i6;
			} else if (img == i6) {
				img = i1;
			}

			MarioWindow.delay(180);
		}
	}
}
