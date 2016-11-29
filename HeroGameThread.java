package cs12mariomp;
import java.awt.*;
import java.awt.image.*;
import java.io.InputStream;
public class HeroGameThread extends GameObject {
	int x; int y; Color c; String direction,to_where_facing;
	BufferedImage img;
    InputStream picture_input_stream;
    Fire fire;
    int recharge_count = 0;
    ZombiePila zombie_pila;
    Hero hero;
    String name;
    SimpleBullet simple_bullet;
	public HeroGameThread(String name) {   // this is a constructor
		this.x = 150; // called when object is created
		this.y = 300; // i.e. Hero h = new **Hero()**;
		this.c = Color.YELLOW; // used for initialization
		this.direction = "right";
        to_where_facing = "right";
        picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange0.png");
		img = MarioWindow.getImage(picture_input_stream);
        this.name = name;
	}

    public void setSimpleBullet(SimpleBullet simple_bullet) {
        this.simple_bullet = simple_bullet;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }

    public String getDirection() {
        return direction;
    }

    public String getToWhereFacing() {
        return to_where_facing;
    }

    public ZombiePila getZombiePila() {
        return zombie_pila;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setFire(Fire fire) {
        this.fire = fire;
    }



	// what does the hero look like?
	public void paint(Graphics2D g) {
		g.setColor(this.c);
		//g.fillArc(x,y,30,30,0,360);
		g.drawImage(this.img, x, y, null);
	}

	// what does your hero do?
	public void run() {
		while(true) {
			MarioWindow.delay(200);
		}
	}

	// a key was pressed! how does your hero react?
	public void keyPressed(String key) {
		if (key.equals("A")) {
			this.direction = "left";
			x = x - 12;
            picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strangeleft0.png");
    		img = MarioWindow.getImage(picture_input_stream);
            to_where_facing = "left";
		} else if (key.equals("D")) {
			this.direction = "right";
			x = x + 12;
            picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange0.png");
    		img = MarioWindow.getImage(picture_input_stream);
            to_where_facing = "right";
        }
        else if (key.equals("W")) {
			this.direction = "down";
			y = y - 12;
		} else if (key.equals("S")) {
			this.direction = "right";
			y = y + 12;
		}

        else  {
            if (to_where_facing == "right") {
                if (key.equals("F")) {
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_fire_attack1.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_fire_attack2.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange0.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                    fire.setX(x);
                    fire.setY(y);
                } else if (key.equals("R")) {
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange1.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange0.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                }
                else if (key.equals("C")) {
                    this.direction = "down";
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_recharge.png");
                    MarioWindow.delay(500);
                    img = MarioWindow.getImage(picture_input_stream);
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange0.png");
                    MarioWindow.delay(500);
                    img = MarioWindow.getImage(picture_input_stream);
                    recharge_count++;
                } else if (key.equals("G")) {
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange1.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_super1.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_super2.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_super3.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange1.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange0.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                    recharge_count = 0;
                }
            } else {
                if (key.equals("F")) {
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_fire_attack1left.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_fire_attackleft2.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strangeleft0.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                    fire.setX(x);
                    fire.setY(y);
                } else if (key.equals("R")) {
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strangeleft1.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strangeleft0.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);

                }
                else if (key.equals("C")) {
                    this.direction = "down";
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_rechargeleft.png");
                    MarioWindow.delay(500);
                    img = MarioWindow.getImage(picture_input_stream);
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strangeleft0.png");
                    MarioWindow.delay(500);
                    img = MarioWindow.getImage(picture_input_stream);
                    recharge_count++;
                } else if (key.equals("G")) {
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strangeleft1.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_super1left.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_superleft2.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strange_super3left.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strangeleft1.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                    picture_input_stream = getClass().getResourceAsStream("/cs12mariomp/pictures/dr_strangeleft0.png");
                    MarioWindow.delay(250);
                    img = MarioWindow.getImage(picture_input_stream);
                    recharge_count = 0;
                }
            }
        }

	}
}
