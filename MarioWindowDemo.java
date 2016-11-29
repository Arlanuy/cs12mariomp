package cs12mariomp;
public class MarioWindowDemo {
	static ZombiePila zombie_pila;
	static MarioWindow w1;
    static Hero main_hero;
    static HeroTask hero_recharge_task;
	static ZombieFactory zombie_factory;

	public static void main (String[] arg) {
		ZombiePila zombie_pila = new ZombiePila();
		w1 = new MarioWindow();
		HeroGameThread h = new HeroGameThread("Mario", zombie_pila);
		main_hero = new Hero("Mario", h);
		Fire fire = new Fire(h);
		SimpleBulletSkillThread sb_skill = new SimpleBulletSkillThread(zombie_pila, main_hero);
		SimpleBullet simple_bullet = new SimpleBullet(h, sb_skill);
		LQVGO lqvgo = new LQVGO(zombie_pila);
		w1.add(sb_skill);
		w1.add(lqvgo);
		ZombieGameThread[] zombies_horde = new ZombieGameThread[10];
		for (int i = 1; i <= 10; i++) {
			String zombie_name = "Zombie # " + i;
			ZombieGameThread zgt = new 	ZombieGameThread(zombie_name);
			zombies_horde[i - 1] = zgt;
			w1.add(zgt);
		}
		zombie_factory = new ZombieFactory(zombies_horde, zombie_pila);
		w1.add(zombie_factory);
		w1.add(fire);
		w1.add(h);
		w1.add(simple_bullet);
		w1.startGame();
	}
}
