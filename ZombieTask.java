package cs12mariomp;
public class ZombieTask extends Task {
  int bitepower;


    public ZombieTask (String description) {
      this.description = description;
    }

    public ZombieTask (String description, int bitepower) {
        if (this.bitepower > 0) {
          this.bitepower += bitepower;
        }

        else {
          this.description = description;
          this.bitepower = bitepower;
        }
    }


  public int biteAttack() {
    return bitepower;
  }

  public boolean isDone() {
    return (bitepower <= 0) ? true : false;
  }
}
