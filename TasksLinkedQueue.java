package cs12mariomp;
abstract class  TasksLinkedQueue {
    NodeTask head, tail;
    public TasksLinkedQueue() {
      //this doesn't affect the program because
      //uninitialized reference objects are automatically
      //set to null
        init();
    }

    public Task peek() {
      if (checkEmpty() == true) {
        try {
          NullPointerException e = new NullPointerException();
          throw e;
        }

        catch (NullPointerException e) {
          e.printError();
        }
        Task null_task = new Task();
        null_task.setDescription("Null Task");
        return null_task;
      }

      else {
        Task result = head.task;
        return result;
      }

    }

    void init() {
        head = null;
        tail = null;
    }

    boolean checkEmpty() {
        return (head == null) ? true : false;
    }

    void enqueue(Task task) {
        NodeTask bago = new NodeTask(task);
        if (checkEmpty() ==true) {
            head = bago;
            tail = bago;
        }

        else {
            bago.task = task;
            tail.next = bago;
            tail = bago;
        }
    }

    Task dequeue() {
        Task result = peek();

        if (head != tail) {
            head = head.next;
            System.out.println("Passed through this first method");
        }

        else {
            head = null;
            tail = null;
            System.out.println("Passed through this else method");
        }
        return result;
    }

    int count() {
      int count_num = 0;
      for (NodeTask rover = head;  rover != null; rover = rover.next) {
          count_num++;
      }
      return count_num;
    }

    abstract void printList();


}
