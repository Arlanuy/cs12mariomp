package cs12mariomp;
class  HeroTasksLinkedQueue extends TasksLinkedQueue{
    void printList() {
        int count_num = 1;
        for (NodeTask rover = head;  rover != null; rover = rover.next) {
            System.out.println(count_num + ": " + rover.task.description);
            Task task = rover.task;
            String[] split = (((HeroTask)task).description).split("\\s+");
            if (split[0].equals("Recharge") && (((HeroTask)task).rechargetime != 0)) {
                System.out.println(" ( " + ((HeroTask)task).rechargetime + " second/s recharged)");
            }

            count_num++;
        }
        System.out.println();
    }
}
