package cs12mariomp;
class ZombieFactory extends GameObject {
    ZombiePila q;
    ZombieGameThread[] zombies_horde;
    int count = 0;

    public ZombieFactory (ZombieGameThread[] zombies_horde, ZombiePila q) {
        this.q = q;
        this.zombies_horde = zombies_horde;
    }

    public void run() {
        while (count < 10) {
            String name = zombies_horde[count].getName();
            Zombie zombie = new Zombie(name, zombies_horde[count]);
            this.q.enqueue(zombie);
            int randomYLocation = 150 + (int)(Math.random() * 1000);
            zombie.getZGT().setPointLocation(new Point(2000, randomYLocation));
            zombie.getZGT().setAppear(true);
            count++;
            int randomDelay = 3000 + (int)(Math.random() * 10000);
            MarioWindow.delay(randomDelay);
        }
    }
}
