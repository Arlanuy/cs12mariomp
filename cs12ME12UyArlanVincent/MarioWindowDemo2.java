import javax.swing.*;

public class MarioWindowDemo2 {
	public static void main(String args[]) {
		MarioWindow w1 = new MarioWindow();
		Backdrop backdrop = new Backdrop();
		Clouds g = new Clouds();
		Ritz ritz = new Ritz();
      Marche marche = new Marche();
      Mario mario = new Mario();
		PrincessToad princess_toad = new PrincessToad();
		Toad toad = new Toad(princess_toad);
		Firework firework = new Firework(550, 100);
		Firework firework2 = new Firework(550,200);
		Firework firework3 = new Firework(550,250);
		Firework firework4 = new Firework(530, 100);
		Firework firework5 = new Firework(530,200);
		Firework firework6 = new Firework(530,250);
		Firework firework7 = new Firework(580, 100);
		Firework firework8 = new Firework(580,200);
		Firework firework9 = new Firework(580,250);
		w1.add(backdrop);
		w1.add(g);
		w1.add(ritz);
    w1.add(marche);
    w1.add(mario);
		w1.add(princess_toad);
		w1.add(toad);
		w1.add(firework);
		w1.add(firework2);
		w1.add(firework3);
		w1.add(firework4);
		w1.add(firework5);
		w1.add(firework6);
		w1.add(firework7);
		w1.add(firework8);
		w1.add(firework9);

		for (int i = 0; i < 50; i++) {
			Raindrops r = new Raindrops();
			w1.add(r);
		}

		w1.startGame();

	}
}
