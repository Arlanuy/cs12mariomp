import java.awt.*;

public class SimpleGameObject extends GameObject {
	int x = 50, y = 10;
	Color c = Color.BLUE;
	public SimpleGameObject() {
	}
	
	/* What does the object look like? */
	public void paint(Graphics2D g2d) {
		g2d.setColor(c);
		g2d.fillArc(x,y,50,50,0,360);
	}
	
	/* what movements does the object do? */
	public void run() {
		while(true) {
			y = y + 5;
			if (y > 600) {
				y = 0;
			}
			MarioWindow.delay(100);
		}
	}
	
	/* what does the object do when you press something? */
	public void keyPressed(String s) {
		System.out.println(s);
		if (s.equals("Space")) {
			c = Color.RED;
		}
	}
	
	/* what does the object do when you stop pressing something? */
	public void keyReleased(String s) {
		if (s.equals("Space")) {
			c = Color.BLUE;
		}
	}

}