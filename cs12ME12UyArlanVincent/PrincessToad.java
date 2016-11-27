import java.awt.*;
import java.awt.image.*;

public class PrincessToad extends GameObject {
	int x = 550, y = 0;
	BufferedImage img;
	BufferedImage i1;
	String direction = "neutral";
	public PrincessToad() {
		i1 = MarioWindow.getImage("Princess Toadstool.gif");
		img = i1;
	}

    public void paint(Graphics2D g2d) {
		if (img != null) {
			g2d.drawImage(img,x,y,null);
		} else {
			g2d.fillArc(x,y,10,10,0,360);
		}
	}

	public int[] getPosition() {
		int[] position = new int[2];
		position[0] = x;
		position[1] = y;
		return position;
	}

    public void run() {
		while(true) {
			/**
			if (direction.equals("right")) {
				System.out.println("Palagi na lang naman tumatakbo");
				x = x + 5;
				if (x > 1000) {
					x = 0;
				}

			} else if (direction.equals("left")) {
				x = x - 5;
				if (x < 0) {
					x = 1000;
				}
			} else if (direction.equals("down")) {
					System.out.println("Palagi na lang naman umuulan");
					y = y + 5;
					if (y > 500) {
						y = 250;
					}
			} else if (direction.equals("up")) {
					y = y - 5;
					if (y < 250) {
						y = 500;
					}
				}
				**/
			MarioWindow.delay(100);
		}
	}

	public void keyPressed(String key) {
		System.out.println(key + " whut ");
		if (key.equals("A")) {
			this.direction = "left";
			x = x - 5;
			if (x < 0) {
				x = 1000;
			}
		} else if (key.equals("D")) {
			this.direction = "right";
			x = x + 5;
			if (x > 1000) {
				x = 0;
			}
		}
		else if (key.equals("W")) {
			this.direction = "up";
			y = y - 5;
			if (y < 0) {
				y = 500;
			}
		} else if (key.equals("S")) {
			this.direction = "down";
			y = y + 5;
			if (y > 500) {
				y = 0;
			}
		}
		this.direction = "neutral";
	}
}
