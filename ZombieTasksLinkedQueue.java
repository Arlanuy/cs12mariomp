package cs12mariomp;
class  ZombieTasksLinkedQueue extends TasksLinkedQueue{
    void printList() {
        int count_num = 1;
        for (NodeTask rover = head;  rover != null; rover = rover.next) {
            Task task = rover.task;
            System.out.println(count_num + ": " + rover.task.description); // + " ( " + ((ZombieTask)task).bitepower + " bite power)");
            count_num++;
        }
        System.out.println();
    }
}
