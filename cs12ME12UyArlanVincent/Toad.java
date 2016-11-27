import java.awt.*;
import java.awt.image.*;

public class Toad extends GameObject {
    int x = 600, y = 0;
    BufferedImage img;
    BufferedImage i1;
    GameObject to_follow;
    public Toad(GameObject to_follow) {
		i1 = MarioWindow.getImage("Toad.gif");
		img = i1;
        this.to_follow = to_follow;
	}

    public void paint(Graphics2D g2d) {
		if (img != null) {
			g2d.drawImage(img,x,y,null);
		} else {
			g2d.fillArc(x,y,10,10,0,360);
		}
	}

    public void followGameObjectPosition() {
		int[] followed_position = ((PrincessToad)to_follow).getPosition();
        x = followed_position[0] - 0;
        y = followed_position[1] - 70;
	}

    public void run() {
		while(true) {
			followGameObjectPosition();
			MarioWindow.delay(200);
		}
	}
}
