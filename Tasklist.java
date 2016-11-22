import java.util.*;

class Tasklist {
  public static void makeAChoice(String input, LinkedQueue tasks_queue) {
      char magic = input.toUpperCase().charAt(0);
      switch (magic) {
        case 'A':
          tasks_queue.enqueue(new Task("Nap", 1));
          break;
        case 'B':
          tasks_queue.enqueue(new Task("Eat", 1));
          break;
        case 'C':
          tasks_queue.enqueue(new Task("Wash dishes", 2));
          break;
        case 'D':
          tasks_queue.enqueue(new Task("Internet", 3));
          break;
        case 'E':
          tasks_queue.enqueue(new Task("Study", 4));
          break;
        case 'F':
          tasks_queue.enqueue(new Task("Play games", 4));
          break;
        case 'G':
          tasks_queue.enqueue(new Task("Sleep", 8));
          break;
        case 'H':
          tasks_queue.printList();
          break;
        case 'I':
          Task head_task = tasks_queue.peek();
          head_task.doTask();
          if (head_task.isDone()) {
              tasks_queue.dequeue();
              System.out.println(head_task + " done "); 
          }
          break;
        case 'J':
          Task why_procrastinate = tasks_queue.dequeue();
          if (!why_procrastinate.description.equalsIgnoreCase("Null Task")) {
            tasks_queue.enqueue(why_procrastinate);
            System.out.println(why_procrastinate.description + " moved back to the line!");
          }
          break;
      }
    }
  public static void main (String[] arg) {
    LinkedQueue tasks_queue = new LinkedQueue();
    Scanner in = new Scanner(System.in);
    System.out.println("What would you like to do?");
    System.out.println("A. Nap for 1 hour " + "\n" +
    "B. Eat for 1 hour " + "\n"  + "C. Wash dishes for 2 hours " + "\n" +
    "D. Internet for 3 hours " + "\n" +
     "E. Study for 4 hours " + "\n" + "F. Play games for 4 hours " + "\n" +
     "G. Sleep for 8 hours " + "\n" + "H. Print Tasklist " + "\n" +
     "I. Do a Task for 1 hour " + "\n" + "J. Procrastinate " + "\n" +
     "K. Quit");
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
}
