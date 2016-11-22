import java.util.*;

class Hero {
    private int hp = 100;
    private int attack_strength = 10;
    private String name;
    private String movement_direction;
    private boolean is_dead = false;

    public Hero(String name) {
        this.name = name;
    }

    public void wasBitten(int damage) {
      this.hp -= damage;
    }


      public boolean isDeadHero()) {
        if (this.hp <= 0) {
          return true;
        }

        else {
          return false;
        }
      }


    public int getHP(){
      return hp;
    }

    public int shotAttack() {
      return attack_strength;
    }

    public String getName() {
      return name;
    }


  public void printMe() {
    System.out.println("Hero: " + getName() + " with hp " + getHP());
  }
}
