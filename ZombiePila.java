package cs12mariomp;
class  ZombiePila {
    NodeZombie head, tail;

    public ZombiePila() {
      //this doesn't affect the program because
      //uninitialized reference objects are automatically
      //set to null
        init();
    }

    public Zombie peek() {
      if (checkEmpty() == true) {
        try {
          NullPointerException e = new NullPointerException();
          throw e;
        }

        catch (NullPointerException e) {
          e.printError();
        }
        return new Zombie("Null Zombie");
      }

      else {
        Zombie result = head.zombie;
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

    void enqueue(Zombie zombie) {
        NodeZombie bago = new NodeZombie(zombie);
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
        Zombie result = peek();

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
      for (NodeZombie rover = head;  rover != null; rover = rover.next) {
          count_num++;
      }
      return count_num;
    }

    void printList() {
        int count_num = 1;
        for (NodeZombie rover = head;  rover != null; rover = rover.next) {
            System.out.print("#" + count_num + " ");
            rover.zombie.printMe();
            count_num++;
        }
        System.out.println();
    }
}
