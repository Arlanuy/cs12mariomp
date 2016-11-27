package cs12mariomp;
public class MarioWindowDemo {
	public static void main(String args[]) {
		MarioWindow w1 = new MarioWindow();
		//HeroGameThread h = new HeroGameThread();
		ZombieGameThread zgt = new ZombieGameThread();
		w1.add(zgt);
		w1.startGame();
	}
}
