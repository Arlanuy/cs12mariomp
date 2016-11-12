public class Task {
  String description;
  int timeleft;

  public Task (String description, int timeleft) {
    if (this.timeleft > 0) {
      this.timeleft += timeleft;
    }

    else {
      this.description = description;
      this.timeleft = timeleft;
    }

  }

  public void doTask() {
    timeleft -= 1;
  }

  public boolean isDone() {
    return (timeleft <= 0) ? true : false;
  }

  public String toString() {
    return description;
  }
}
