class Zombie {
  int hp;
  public Zombie() {
    hp = 100;
  }

  public Zombie (int hp) {
    this.hp = hp;
  }

  void increaseHP(int added_hp) {
    hp += added_hp;
  }

  boolean wasShot() {
    hp -= 20;
    return (hp <= 0) ? true : false;
  }

  boolean setOnFire() {
    hp -= 50;
    return (hp <= 0) ? true : false;
  }

  void decapitate() {
    hp = 0;
  }

  public String toString() {
    return hp + "";
  }

}
