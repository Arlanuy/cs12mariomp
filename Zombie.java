import java.util.*;

class Zombie {
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

  public int biteAttack() {
    this.bite_attack = hp/2;
    this.hp -= 10;
    return bite_attack;
  }

  public String getName() {
    return name;
  }

  public void eatPeople(int count) {
    this.hp += (count*10);
  }

  public void walk(int km) {
    this.hp -= km;
  }

  public void run(int km) {
    this.hp -= (10 * km);
  }

  public void wasShot() {
    this.hp -= 20;
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
    System.out.println("Zombie " + getName() + " with hp " + getHP());
  }
}
