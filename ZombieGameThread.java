package cs12mariomp;
import java.awt.*;
import java.awt.image.*;
import java.io.InputStream;
public class ZombieGameThread extends GameObject {
	int x; int y; Color c; String direction;
	BufferedImage img;
	InputStream picture_input_stream;
	public ZombieGameThread() {   // this is a constructor
		this.x = 1800; // called when object is created
		this.y = 300; // i.e. Hero h = new **Hero()**;
		this.c = Color.YELLOW; // used for initialization
		this.direction = "left";
		picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/zombieleft.png");
		img = MarioWindow.getImage(picture_input_stream);
	}

	// what does the hero look like?
	public void paint(Graphics2D g) {
		g.setColor(this.c);
		//g.fillArc(x,y,30,30,0,360);
		g.drawImage(this.img, x, y, 150, 120, null);
	}

	// what does your hero do?
	public void run() {
		while(true) {
			if (this.direction.equals("right")) {
				x = x + 10;
			}

			if (this.direction.equals("left")) {
				x = x - 10;
			}

			MarioWindow.delay(200);
		}
	}
}
