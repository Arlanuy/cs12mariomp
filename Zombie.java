package cs12mariomp;
import java.util.*;

public class Zombie {
  private int hp = 100;
  private int bite_attack;
  private String name;
  private boolean is_dead = false;

  public Zombie(String name) {
    this.name = name;
  }

  public int getHP(){
    return hp;
  }

  public void setHP(int hp) {
      this.hp = hp;
  }

  public void biteAttack(Hero main_hero) {
    this.bite_attack = hp/10;
    main_hero.wasBitten(bite_attack);
    this.hp -= 10;
    System.out.println(main_hero.getName() + " was bitten and damaged by " + bite_attack + " hp ");
  }

  public String getName() {
    return name;
  }

  public void wasShot(int hp_dec) {
    this.hp -= hp_dec;
  }

  public void setOnFire() {
    this.hp -= 50;
  }

  public void decapitate() {
    this.hp = 0;
  }

  public boolean isDeadUndead() {
    if (this.hp <= 0) {
      return true;
    }

    else {
      return false;
    }
  }

  public void printMe() {
    System.out.println(getName() + " with hp " + getHP());
  }
}
