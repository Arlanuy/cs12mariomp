package zombietrip;
import java.util.*;

class ZombieDemo {
  public static void main (String[] args) {
    Zombie cloud = new Zombie(100);
    Zombie[] zombies = new Zombie[8];
    zombies[0] = cloud;
    System.out.println("Zombie 0 with " + cloud.getHP());
    for (int i = 1; i < 8; i++) {
      zombies[i] = zombies[i - 1].split();
      System.out.println("Zombie " + i + " has hp "
      + zombies[i].getHP()  + " which is very "
      + zombies[i].isDeadUndead()
      + " that he is an undead");
    }
    System.out.println("Before zombie 0 has health " + zombies[0].getHP() + " and zombie 1 has health " + zombies[1].getHP());
    zombies[0].eatZombie(zombies[1]);
    System.out.println("Zombie 0 with hp " +
    zombies[0].getHP() + " have eaten zombie 1 with hp "
     + zombies[1].getHP() + " which is very "
     + zombies[1].isDeadUndead()
     + " that he is an undead");
  }
}
