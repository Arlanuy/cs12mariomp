package cs12mariomp;
public class MarioWindowDemo {
	static MarioWindow w1;
	public static void main(String args[]) {
		w1 = new MarioWindow();
		HeroGameThread h = new HeroGameThread();
		ZombieGameThread zgt = new ZombieGameThread();
		Fire fire = new Fire(h);
		SimpleBullet simple_bullet = new SimpleBullet(h);
		w1.add(h);
		w1.add(zgt);
		w1.add(fire);
		w1.add(simple_bullet);
		w1.startGame();
	}
}
