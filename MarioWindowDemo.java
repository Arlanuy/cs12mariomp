package cs12mariomp;
public class MarioWindowDemo {
	static MarioWindow w1;
	static ZombiePila zombie_pila;
    static Hero main_hero;
    static HeroTask hero_recharge_task;
    static Zombie not_a_hero;

	public static void main (String[] arg) {
	    zombie_pila = new ZombiePila();
		w1 = new MarioWindow();
		HeroGameThread h = new HeroGameThread("Mario");
		main_hero = new Hero("Mario", h);
		ZombieGameThread zgt = new ZombieGameThread("Marcos");
		not_a_hero = new Zombie("Marcos", zgt);
		zombie_pila.enqueue(not_a_hero);
		Fire fire = new Fire(h);
		SimpleBulletSkillThread sb_skill = new SimpleBulletSkillThread(zombie_pila, main_hero);
		SimpleBullet simple_bullet = new SimpleBullet(h, sb_skill);
		w1.add(sb_skill);
		w1.add(zgt);
		w1.add(fire);
		w1.add(h);
		w1.add(simple_bullet);
		w1.startGame();
	}
}
