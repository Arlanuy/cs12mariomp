class  LinkedQueue {
    Node head, tail;

    public LinkedQueue() {
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
        return new Task("Null Task", 0);
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
        Node bago = new Node(task);
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
      for (Node rover = head;  rover != null; rover = rover.next) {
          count_num++;
      }
      return count_num;
    }

    void printList() {
        int count_num = 1;
        for (Node rover = head;  rover != null; rover = rover.next) {
            System.out.println(count_num + ": " + rover.task.description + "( " + rover.task.timeleft + " hour/s left)");
            count_num++;
        }
        System.out.println();
    }
}
