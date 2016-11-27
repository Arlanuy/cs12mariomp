import java.awt.*;
import java.awt.image.*;
public class Marche extends GameObject {
    int x = 1000, y = 320;
    BufferedImage img;
    BufferedImage i1, i2, i3,i4;
    String direction = "left";
    public Marche() {
        i1 = MarioWindow.getImage("Marche2 (SE).gif");
        i2 = MarioWindow.getImage("Marche1 - Glance.gif");
        i3 = MarioWindow.getImage("Marche1 - Wounded.gif");
        i4 = MarioWindow.getImage("Marche1 - Hit.gif");
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
				if (x > 600) {
					x = 0;
				}
			} else if (direction.equals("left")) {
				x = x - 7;
				if (x <= 600) {
					x = 1000;
                    img = i1;
				}
			}
			if (img == i1) {
				img = i2;
			} else if (img == i2) {
				img = i3;
			} else if (img == i3) {
				img = i4;
			} else if (img == i4) {
				img = i2;
			}

			MarioWindow.delay(100);
		}
	}
}
