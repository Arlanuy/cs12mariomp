import java.util.*;


class  ZombieQueueDemo {
    public static void makeAChoice(String input, ZombieQueue zombie_queue) {
      char magic = input.toUpperCase().charAt(0);
      Zombie head_zombie;
      switch (magic) {
        case 'A':
          zombie_queue.enqueue(new Zombie());
          System.out.println("Zombie " + zombie_queue.count() + " added ");
          break;
        case 'B':
          zombie_queue.printList();
          break;
        case 'C':
          if (zombie_queue.count() == 0) {
            System.out.println("Error: No head zombie");
          }
          else {
            head_zombie = zombie_queue.getHeadZombie();
            if (head_zombie != null) {
              head_zombie.increaseHP(10);
            }
          }
          break;
        case 'D':
          head_zombie = zombie_queue.getHeadZombie();

          if (head_zombie != null) {
            head_zombie.wasShot();
            if (head_zombie.hp <= 0) {
              zombie_queue.dequeue();
            }
          }
          break;
        case 'E':
          head_zombie = zombie_queue.getHeadZombie();
          if (head_zombie != null) {
            head_zombie.setOnFire();
            if (head_zombie.hp <= 0) {
              zombie_queue.dequeue();
            }
          }
          break;
        case 'F':
          head_zombie = zombie_queue.getHeadZombie();
          if (head_zombie.hp == 0) {
            System.out.println("Null zombie");
          }

          else {
            head_zombie.decapitate();
            zombie_queue.dequeue();
          }
          break;
      }
    }
    public static void main (String[] args) {
      ZombieQueue zombie_queue = new ZombieQueue();

      Scanner in = new Scanner(System.in);
      System.out.println("What would you like to do?");
      System.out.println("A. Add a Zombie to the Line" + "\n" +
      "B. Print Zombie to the Line " + "\n"
      + "C. Feed Head Zombie " + "\n" + "D. Shoot Head Zombie " + "\n"
      + "E. Burn Head Zombie " + "\n" + "F. Decapitate Head Zombie " + "\n" + "G. Quit");
      System.out.print("Enter the letter of the choice you want to execute: ");
      String input = in.next();
      while (!input.equalsIgnoreCase("G")) {
        makeAChoice(input, zombie_queue);
        System.out.print("Enter the letter of the choice you want to execute: ");
        input = in.next();
      }
    }
}
