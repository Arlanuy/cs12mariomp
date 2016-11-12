import javax.swing.*;

public class MarioWindowDemo2 {
	public static void main(String args[]) {
		MarioWindow w1 = new MarioWindow();
		Clouds g = new Clouds();
		MyGameObject g2 = new MyGameObject();
		w1.add(g);			
		w1.add(g2);
		
		for (int i = 0; i < 50; i++) {
			Raindrops r = new Raindrops();
			w1.add(r);
		}		
		
		w1.startGame();
		
	}
}