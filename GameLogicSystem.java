import java.util.*;

public class GameLogicSystem {


    public static void main (String[] arg) {
      LinkedQueue tasks_queue = new LinkedQueue();
      Scanner in = new Scanner(System.in);
      Hero main_hero = new Hero("Arlan");
      System.out.println("What would you like your hero or zombie to do? ");
      System.out.println("A. Move in a direction " + "\n" +
      "B. Shoot in the orientation you are facing " + "\n"  + "C. Charge gun ");
       System.out.print("Enter the letter of the choice you want to execute: ");
        String input = in.next();
        while (!input.equalsIgnoreCase("K")) {
          makeAChoice(input, tasks_queue);
          System.out.print("Enter the letter of the choice you want to execute: ");
          input = in.next();
        }

        System.out.println("The tasks left are: ");
        tasks_queue.printList();
    }

    public static void makeAChoice(String input, LinkedQueue tasks_queue) {
        char magic = input.toUpperCase().charAt(0);
        switch (magic) {
          case 'A':
            System.out.println("To what direction would you kike to moeve")
            tasks_queue.enqueue(new Task("Nap", 1));
            break;
          case 'B':
            tasks_queue.enqueue(new Task("Eat", 1));
            break;
          case 'C':
            tasks_queue.enqueue(new Task("Wash dishes", 2));
            break;
          case 'D':
            tasks_queue.printList();
            break;
          case 'E':
            Task head_task = tasks_queue.peek();
            head_task.doTask();
            if (head_task.isDone()) {
                tasks_queue.dequeue();
                System.out.println(head_task + " done ");
            }
            break;
          case 'F':
            Task why_procrastinate = tasks_queue.dequeue();
            if (!why_procrastinate.description.equalsIgnoreCase("Null Task")) {
              tasks_queue.enqueue(why_procrastinate);
              System.out.println(why_procrastinate.description + " moved back to the line!");
            }
            break;
        }
      }
}
