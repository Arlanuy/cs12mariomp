class  ZombieQueue {
    Node head, tail;

    public ZombieQueue() {
      //this doesn't affect the program because
      //uninitialized reference objects are automatically
      //set to null
        init();
    }

    Zombie getHeadZombie() {
      Zombie head_zombie = peek();
      return head.zombie;
    }

    public Zombie peek() {
      if (head == null) {
        try {
          NullPointerException e = new NullPointerException();
          throw e;
        }

        catch (NullPointerException e) {
          e.printError();
        }
      }

      else {
        Zombie result = head.zombie;
        return result;
      }
      return new Zombie(0);
    }

    void init() {
        head = null;
        tail = null;
    }

    boolean checkEmpty() {
        return (head == null) ? true : false;
    }

    void enqueue(Zombie zombie) {
        Node bago = new Node(zombie);
        if (checkEmpty() ==true) {
            head = bago;
            tail = bago;
        }

        else {
            bago.zombie = zombie;
            tail.next = bago;
            tail = bago;
        }
    }

    Zombie dequeue() {
        Zombie result;
        if (head != null) {
            result = head.zombie;
            System.out.println("Result at first is " + result);
        }

        else {
          try {
              NullPointerException e = new NullPointerException();
              throw e;
            }

            catch (NullPointerException e) {
              e.printError();
            }
            return null;
        }

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
        System.out.println(count() + " zombies in the line ");
        int count_num = 1;
        for (Node rover = head;  rover != null; rover = rover.next) {
            System.out.println(count_num + ": " + rover.zombie);
            count_num++;
        }
        System.out.println();
    }
}
