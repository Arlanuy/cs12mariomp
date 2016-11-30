package cs12mariomp;
import java.awt.*;
import java.awt.image.*;
import java.io.InputStream;
public class ZombieGameThread extends GameObject {
	private int x;
	private int y;
	private Color c;
	private String direction;
	private BufferedImage img;
	private InputStream picture_input_stream;
	private Zombie zombie;
	private String name;
	private boolean appear = false;
	public ZombieGameThread(String name) {   // this is a constructor
		this.c = Color.YELLOW; // used for initialization
		this.direction = "left";
		picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/zombieleft.png");
		img = MarioWindow.getImage(picture_input_stream);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAppear(boolean appear) {
		this.appear = appear;
	}

	public void setPointLocation(Point p) {
		x = p.getX();
		y = p.getY();
	}

	public Point getPointCM() {
		return new Point(x + 60, y + 75);
	}

	public Zombie getZombie() {
		return zombie;
	}

	// what does the hero look like?
	public void paint(Graphics2D g) {
		g.setColor(this.c);
		//g.fillArc(x,y,30,30,0,360);
		if (appear == true) {
			 g.drawImage(this.img, x, y, 150, 120, null);
		}
	}

	public void setZombie(Zombie zombie) {
		this.zombie = zombie;
	}

	// what does your hero do?
	public void run() {
		while(true) {
			if(zombie != null && zombie.isDeadUndead() == true) {
				picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/broken_head_zombie_left.png");
				MarioWindow.delay(500);
				img = MarioWindow.getImage(picture_input_stream);
				picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/kneeling_zombie_left.png");
				MarioWindow.delay(500);
				img = MarioWindow.getImage(picture_input_stream);
				picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/almost_down_zombie_left.png");
				MarioWindow.delay(500);
				img = MarioWindow.getImage(picture_input_stream);
				MarioWindow.delay(500);
				appear = false;
			}
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
