package cs12mariomp;
public class HeroTask extends Task {
  static Hero main_hero;
  static int rechargetime = 0;

    public HeroTask (String description, int rechargetime) {
        if (this.rechargetime > 0) {
          this.rechargetime += rechargetime;
        }

        else {
          this.description = description;
          this.rechargetime = rechargetime;
        }
    }

    public HeroTask (String description) {
        this.description = description;
    }

    public static void setHero(Hero hero) {
        main_hero = hero;
    }

  public int blastAttack() {
    int to_be_returned = rechargetime * 10;
    rechargetime = 0;
    return to_be_returned;
  }

  public boolean isDoneRecharging() {
    return (rechargetime <= 0) ? true : false;
  }

  public String toString() {
    return description;
  }
}
