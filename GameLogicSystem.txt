package cs12mariomp;
import java.util.*;

public class GameLogicSystem {
    static ZombieTasksLinkedQueue zombie_tasks_queue;
    static HeroTasksLinkedQueue hero_tasks_queue;
    static ZombiePila zombie_pila;
    static Hero main_hero;
    static HeroTask hero_recharge_task;
    static Zombie not_a_hero;
    public static void main (String[] arg) {
      hero_tasks_queue = new HeroTasksLinkedQueue();
      zombie_tasks_queue = new ZombieTasksLinkedQueue();
      zombie_pila = new ZombiePila();
      main_hero = new Hero("Mario");
      not_a_hero = new Zombie("Marcos");
      zombie_pila.enqueue(not_a_hero);
      HeroTask.setHero(main_hero);
      System.out.println("What would you like your hero or zombie to do? ");
      System.out.println("Hero: " + "\n" + "A. Move in a direction " + "\n" +
      "B. Shoot in the orientation you are facing " + "\n"  + "C. Charge gun " + "\n" + "X. Shoot a special recharge shot" + "\n" +
      "Y. Fire a close-range: molotov" + "\n" +
      "Zombie: " + "\n" + " D. Walk in a direction " + "\n" + "E. Bite attack on the hero " + "\n" +
       "F. Follow where hero is going " + "\n" + "G. Print the list of hero tasks" + "\n" +
       "H. Print the list of zombie tasks" + "\n" +
       "I. Print the queue names of the zombie in the pila");
       System.out.print("Enter the letter of the choice you want to execute: ");
       String input = "";
       while (!input.equalsIgnoreCase("K")) {
         input = takeStringAnswer();
         makeAChoice(input, hero_tasks_queue, zombie_tasks_queue);
         System.out.print("Enter the letter of the choice you want to execute: ");
       }
    }

    public static String takeStringAnswer() {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        return input;
    }

    public static int takeIntAnswer() {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        int num = Integer.parseInt(input);
        return num;
    }

    public static void makeAChoice(String input, HeroTasksLinkedQueue hero_tasks_queue, ZombieTasksLinkedQueue zombie_tasks_queue) {
        char magic = input.toUpperCase().charAt(0);
        String direction = "woe is me";
        switch (magic) {
        case 'A':
            System.out.print("To what direction would you like your hero to move: ");
            direction = takeStringAnswer();
            hero_tasks_queue.enqueue(new HeroTask("Move Hero " + direction));
            break;

        case 'B':
            System.out.print("To what direction would you like your hero to shoot: ");
            direction = takeStringAnswer();
            hero_tasks_queue.enqueue(new HeroTask("Hero Shoot " + direction));
            boolean sapul_sa_zombie = true;
            if (sapul_sa_zombie == true) {
                main_hero.shotAttack(not_a_hero);
                System.out.println("Mario's hp: " + main_hero.getHP() + " Marcos' hp: " + not_a_hero.getHP());
            }
            break;

        case 'C':
            System.out.print("As to how long would you like to recharge: ");
            int time = takeIntAnswer();
            hero_recharge_task = new HeroTask("Recharge", time);
            hero_tasks_queue.enqueue(hero_recharge_task);
            break;

        case 'X':
            System.out.print("To what direction would you like to use your super shot: ");
            direction = takeStringAnswer();
            HeroTask hero_super_shoot_task = new HeroTask("Hero Super Shoot " + direction);
            hero_tasks_queue.enqueue(hero_super_shoot_task);
            boolean sapul_super_sa_zombie = true;
            if (hero_recharge_task != null) {
                if (sapul_super_sa_zombie == true) {
                    main_hero.superShotAttack(not_a_hero, hero_recharge_task.blastAttack());
                    System.out.println("Mario's hp: " + main_hero.getHP() + " Marcos' hp: " + not_a_hero.getHP());
                }
            }
            break;

        case 'Y':
            System.out.print("To what direction would you like to use your molotov: ");
            direction = takeStringAnswer();
            hero_tasks_queue.enqueue(new HeroTask("Hero Fire " + direction));
            boolean sapul_super_fire_sa_zombie = true;
            if (sapul_super_fire_sa_zombie == true) {
                main_hero.superFireAttack(not_a_hero);
                System.out.println("Mario's hp: " + main_hero.getHP() + " Marcos' hp: " + not_a_hero.getHP());
            }
            break;


        case 'D':
            System.out.print("To what direction would you like your zombie to move: ");
            direction = takeStringAnswer();
            zombie_tasks_queue.enqueue(new ZombieTask("Move Zombie " + direction));
           break;

        case 'E':
            System.out.print("To what direction would you like your zombie to bite: ");
            direction = takeStringAnswer();
            zombie_tasks_queue.enqueue(new ZombieTask("Bite " + direction));
            boolean sapul_sa_hero = true;
            if (sapul_sa_hero == true) {
                not_a_hero.biteAttack(main_hero);
                System.out.println("Mario's hp: " + main_hero.getHP() + " Marcos' hp: " + not_a_hero.getHP());
            }
          break;

        case 'F':
            System.out.print("Where do we follow the hero: ");
            //int time = takeIntAnswer();
            zombie_tasks_queue.enqueue(new ZombieTask("WhereToFollowHero "));
            break;

        case 'G':
            System.out.println("The tasks left for hero are: ");
            hero_tasks_queue.printList();
            break;

        case 'H':
            System.out.println("The tasks left for zombie are: ");
            zombie_tasks_queue.printList();
            break;

        case 'I':
            System.out.println("The stats left for zombie are: ");
            zombie_pila.printList();
            break;
          /**
          case 'D':
            Task head_task = tasks_queue.peek();
            head_task.doTask();
            if (head_task.isDone()) {
                tasks_queue.dequeue();
                System.out.println(head_task + " done ");
            }
            break;
          case 'E':
            Task why_procrastinate = tasks_queue.dequeue();
            if (!why_procrastinate.description.equalsIgnoreCase("Null Task")) {
              tasks_queue.enqueue(why_procrastinate);
              System.out.println(why_procrastinate.description + " moved back to the line!");
            }
            break;
            */
        }
      }
}
