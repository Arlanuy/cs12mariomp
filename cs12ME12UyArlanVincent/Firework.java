import java.awt.*;
import java.awt.image.*;

public class Firework extends GameObject {
    int x, y;
    BufferedImage img;
    BufferedImage i1;
    boolean appear = false;
    String direction;
    //GameObject to_follow =
    public Firework(int x, int y) {
		i1 = MarioWindow.getImage("Firework2.gif");
		img = i1;
        this.x = x;
        this.y = y;
	}

    public void paint(Graphics2D g2d) {
		if (img != null && appear == true) {
			g2d.drawImage(img,x,y,null);
		} else if (appear == true){
			g2d.fillArc(x,y,10,10,0,360);
		}
	}

    public void run() {
		while(true) {
            if (appear == true) {
                MarioWindow.delay(500);
                appear = false;
            }
			MarioWindow.delay(100);
		}
	}


	public void keyPressed(String key) {
		System.out.println(key + " love ");
		if (key.equals("A")) {
			this.direction = "left";
			x = x - 5;
		} else if (key.equals("D")) {
			this.direction = "right";
			x = x + 5;
		}
		else if (key.equals("W")) {
			this.direction = "up";
			y = y - 5;
		} else if (key.equals("S")) {
			this.direction = "down";
			y = y + 5;
		}

        else if (key.equals("F")) {
            appear = true;
        }
	}
}
