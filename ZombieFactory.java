package cs12mariomp;
class ZombieFactory extends GameObject {
    ZombiePila q;
    int count = 1;

    public ZombieFactory (ZombiePila q) {
        this.q = q;
    }

    public void run() {
        while (true) {
            String zombie_name = "Zombie # " + count;
            this.q.enqueue(new Zombie(zombie_name));
            int randomNum = 2 + (int)(Math.random() * 10);
            count++;
            MarioWindow.delay(randomNum);
        }
    }
}
