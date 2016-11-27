import java.util.*;

class ZombieDemo {
  public static void main (String[] args) {
        Zombie cloud = new Zombie("cloud");
        System.out.println("It is very " + cloud.isDeadUndead() + " that cloud is dead");
        System.out.println("Before activities ");
        cloud.printMe();
        System.out.println("Inflicted " + cloud.biteAttack() + " on another"); //100 - 10 = 90;
        cloud.walk(10); //90 - 10 = 80
        System.out.println("Walked 10 km");
        cloud.run(2); //80 - (10 * 2) = 60
        System.out.println("Ran 2 km");
        cloud.eatPeople(2);
        System.out.println("Eated 2 people");// 60 + 20 = 80
        System.out.println("After activities ");
        cloud.printMe();
        cloud.wasShot();
        System.out.println("Was shot"); // 80 - 20 = 60
        cloud.setOnFire();
        System.out.println("Was set on fire"); // 60 - 50 = 10
        System.out.println("After activities ");
        cloud.printMe();
        cloud.decapitate();
        System.out.println("After decapitating ");
        cloud.printMe();
        System.out.println("It is very " + cloud.isDeadUndead() + " that cloud is dead");
    }
}
