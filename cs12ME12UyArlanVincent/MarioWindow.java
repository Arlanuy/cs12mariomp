/*
	MarioWindow2.java is a nice program that allows you to create
	graphical threaded applications without having to learn specifics
	about java awt and java swing. I made this so you guys
	can concentrate on working on threads rather than graphics.

	To use simply make GameObjects and add() them to MarioWindow.
	See the (commented out) main method.

	v.1.1 - Just a basic hack
	v.1.2 - Learned double buffering! http://www.gamedev.net/page/resources/_/reference/programming/languages/java/java-games-active-rendering-r2418
*/


import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.Vector;
import javax.swing.*;
import java.util.*;
import javax.imageio.*;
import java.io.*;

/*
* CHANGES:
* Added keyboardfocusmanager to prevent unresponsiveness of keypresses after mouse click inside the window
* removed interface keylistener
* wired keyboard focus manager to functions from the keylistener interface
 */
public class MarioWindow extends JFrame {
	Vector<GameObject> gameobjects = new Vector<GameObject>();
	public static int WIDTH = 800;
	public static int HEIGHT = 600;
	public static final int REFRESH_RATE = 20;

	boolean fpsFlag = true;

	Canvas canvas;
	BufferStrategy buffer;
	GraphicsEnvironment ge;
	GraphicsDevice gd;
	GraphicsConfiguration gc;

	BufferedImage bi;

    MarioWindow() {
		this.setTitle("MarioWindow");
        this.setLocation(0,0);
		this.setIgnoreRepaint(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//this.addKeyListener(this);

		canvas = new Canvas();
		canvas.setIgnoreRepaint(true);
		canvas.setSize(1216,704);

		this.add(canvas);
		this.pack();
		this.setVisible(true);

		// using back buffering
		canvas.createBufferStrategy(2);
		buffer = canvas.getBufferStrategy();

		// getting the graphics configuration
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gd = ge.getDefaultScreenDevice();
		gc = gd.getDefaultConfiguration();

		// creating the back buffer
		bi = gc.createCompatibleImage(1216,704);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher( new KeyEventDispatcher() {
			public boolean dispatchKeyEvent(KeyEvent e) {
				if (e.getID() == KeyEvent.KEY_PRESSED) {
					keyPressed(e);
				} else if (e.getID() == KeyEvent.KEY_RELEASED) {
					keyReleased(e);
				}
				return false;
			}
		});
    }

	public void showFPS(boolean fpsFlag) {
		this.fpsFlag = fpsFlag;
	}

	public void draw() {
		Random rand = new Random();
		Graphics graphics = null;
		Graphics2D g2d = null;
		Color background = Color.BLACK;

		// Variables for counting frames per seconds
		int fps = 0;
		int frames = 0;
		long totalTime = 0;
		long curTime = System.currentTimeMillis();
		long lastTime = curTime;

		while(true) {
			try {

				// count Frames per second...
				lastTime = curTime;
				curTime = System.currentTimeMillis();
				totalTime += curTime - lastTime;
				if( totalTime > 1000 ) {
					totalTime -= 1000;
					fps = frames;
					frames = 0;
				}
				++frames;

				// clear back buffer
				g2d = bi.createGraphics();
				g2d.setColor(background);
				g2d.fillRect(0,0,1216,704);

				// display frames per second...
				if (fpsFlag) {
					g2d.setFont( new Font( "Courier New", Font.PLAIN, 12 ) );
					g2d.setColor( Color.GREEN );
					g2d.drawString( String.format( "FPS: %s", fps ), 20, 20 );
				}

				// draw stuff
				for (GameObject go : gameobjects) {
					go.paint(g2d);
				}

				// placing the back buffer in front
				graphics = buffer.getDrawGraphics();
				graphics.drawImage(bi,0,0,null);
				if (!buffer.contentsLost()) {
					buffer.show();
				}
				Thread.yield();
			} finally {
				if (graphics != null) {
					graphics.dispose();
				}
				if (g2d != null) {
					g2d.dispose();
				}

			}
		}
	}

    public synchronized void add(GameObject go) {
        gameobjects.add(go);
    }


    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        String key = KeyEvent.getKeyText(e.getKeyCode());
        for (GameObject go : gameobjects) {
            go.keyPressed(key);
        }
    }

    public void keyReleased(KeyEvent e) {
        String key = KeyEvent.getKeyText(e.getKeyCode());
        for (GameObject go : gameobjects) {
            go.keyReleased(key);
        }
    }



    public void startGame() {
        System.out.println("MarioWindow: Starting all game objects...");
        for (GameObject go : gameobjects) {
			Thread t = new Thread(go);
            t.start();
        }
        System.out.println("MarioWindow: Starting game...");
        this.draw();
    }

	public static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) { }
    }

	public static BufferedImage getImage(String filename) {
		try {
			File fp = new File(filename);
			BufferedImage img = ImageIO.read(fp);
			return img;
		} catch (Exception e) {
			System.out.println("Unable to read file!");
			return null;
		}
	}

//	public static void main(String args[]) {
//		MarioWindow2 w1 = new MarioWindow2();
//		for (int i = 0; i < 50; i++) {
//			MyGameObject2 g2 = new MyGameObject2();
//			w1.add(g2);
//		}
//		w1.startGame();
//
//	}
}
