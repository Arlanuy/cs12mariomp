package cs12mariomp;
import java.util.*;

public class Zombie {
  private int hp = 100;
  private int bite_attack;
  private String name;
  private boolean is_dead = false;
  private ZombieGameThread zgt;

  public Zombie(String name) {
    this.name = name;
  }

  public Zombie(String name, ZombieGameThread zgt) {
    this.name = name;
    this.zgt = zgt;
    zgt.setZombie(this);
  }

  public ZombieGameThread getZGT() {
      return zgt;
  }

  public int getHP(){
    return hp;
  }

  public void biteAttack(Hero main_hero) {
    this.bite_attack = hp/10;
    main_hero.wasBitten(bite_attack);
    this.hp -= 10;
    if (hp <= 0) {
        is_dead = true;
    }
    System.out.println(main_hero.getName() + " was bitten and damaged by " + bite_attack + " hp ");
  }

  public String getName() {
    return name;
  }

  public void wasShot(int hp_dec) {
    this.hp -= hp_dec;
    if (hp <= 0) {
        is_dead = true;
    }
  }

  public void setOnFire() {
    this.hp -= 50;
    if (hp <= 0) {
        is_dead = true;
    }
  }

  public void decapitate() {
    this.hp = 0;
    is_dead = true;
  }

  public void setDeadUndead(boolean is_dead) {
      this.is_dead = is_dead;
  }

  public boolean isDeadUndead() {
      if (is_dead == true) {
          System.out.println(name + " is dead unfortunately");
      }
    return is_dead;
  }

  public void printMe() {
    System.out.println(getName() + " with hp " + getHP());
  }
}
