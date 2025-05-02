package Queue;

public class Main {

    public static void main(String[] args) {

        //QueueArray<String> queue = new QueueArray<>(3);
        QueueLinkedList queueLinkedList = new QueueLinkedList(3);

//        queue.add("A");
//        queue.add("B");
//        queue.add("C");
//        queue.print();
//        System.out.println("--------------------------");
//        queue.pop();
//        queue.print();
//        System.out.println("--------------------------");
//        queue.add("O");
//        queue.print();
//        System.out.println("--------------------------");
//        queue.pop();
//        queue.print();
//        System.out.println("--------------------------");
//        queue.pop();
//        queue.print();
//        System.out.println("--------------------------");
//        queue.add("P");
//        queue.print();
//        System.out.println("--------------------------");
//        queue.add("Q");
//        queue.print();
//        System.out.println("--------------------------");
//        queue.pop();
//        queue.print();
//        System.out.println("--------------------------");

        queueLinkedList.add(1);
        queueLinkedList.add(2);
        queueLinkedList.add(3);

        queueLinkedList.print();

        System.out.println("--------------------------");

        queueLinkedList.pop();
        int l = (int) queueLinkedList.peek();
        System.out.println("--------------------------");
        queueLinkedList.print();

    }
}
