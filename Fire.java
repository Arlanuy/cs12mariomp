package cs12mariomp;
import java.awt.*;
import java.awt.image.*;
import java.io.InputStream;

public class Fire extends GameObject {
    int x, y;
    BufferedImage img;
    BufferedImage i1;
    InputStream picture_input_stream;
    boolean appear = false;
    String direction;
    HeroGameThread hgt;
    //GameObject to_follow =
    public Fire(HeroGameThread hgt) {
        picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/fire.png");
		img = MarioWindow.getImage(picture_input_stream);
        this.hgt = hgt;
        this.x = hgt.getX();
        this.y = hgt.getY();
        hgt.setFire(this);
	}

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paint(Graphics2D g2d) {
		if (img != null && appear == true) {
			g2d.drawImage(img,x,y,150,120,null);
		} else if (appear == true){
			g2d.fillArc(x,y,10,10,0,360);
		}
	}

    public void run() {
		while(true) {
            if (appear == true) {
                MarioWindow.delay(200);
                appear = false;
            }
            MarioWindow.delay(100);
		}
	}

	public void keyPressed(String key) {
	    if (key.equals("F")) {
            if (hgt.getToWhereFacing().equals("left")) {
                x = x - 100;
            }

            else {
                x = x + 150;
            }
            MarioWindow.delay(20);
            appear = true;
        }
	}
}
