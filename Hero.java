package cs12mariomp;
import java.util.*;

public class Hero {
    private int hp = 100;
    private int attack_strength = 10;
    private String name;
    private String movement_direction;
    private boolean is_dead = false;
    private HeroGameThread hgt;

    public Hero(String name, HeroGameThread hgt) {
        this.name = name;
        this.hgt = hgt;
        hgt.setHero(this);
    }

    public void wasBitten(int damage) {
      this.hp -= damage;
    }

      public boolean isDeadHero() {
        if (this.hp <= 0) {
          return true;
        }

        else {
          return false;
        }
      }

     public void setHP(int hp) {
         this.hp = hp;
     }

    public int getHP(){
      return hp;
    }

    public void shotAttack(Zombie zombie)  {
        zombie.wasShot(attack_strength);
        System.out.println(zombie.getName() + " was shot and damaged by " + attack_strength + " hp ");
    }

    public void superShotAttack(Zombie zombie, int damage)  {
        zombie.wasShot(damage);
        System.out.println(zombie.getName() + " was shot and damaged by " + damage + " hp ");
    }

    public void superFireAttack(Zombie zombie)  {
        zombie.setOnFire();
        System.out.println(zombie.getName() + " was shot and damaged by " +" 50 hp ");
    }

    public String getName() {
      return name;
    }


  public void printMe() {
    System.out.println("Hero: " + getName() + " with hp " + getHP());
  }
}
