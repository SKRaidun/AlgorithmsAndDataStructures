package Queue;

public class Main {

    public static void main(String[] args) {

        QueueArray queue = new QueueArray(3);
        //QueueLinkedList queueLinkedList = new QueueLinkedList(3);

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.print();
        queue.pop();
        queue.print();
        System.out.println("--------------------------");
        queue.add(9);
        queue.print();
        System.out.println("--------------------------");
        queue.pop();
        queue.print();
        System.out.println("--------------------------");
        queue.pop();
        queue.print();
        System.out.println("--------------------------");
        queue.add(1);
        queue.print();
        System.out.println("--------------------------");
        queue.add(3);
        queue.print();
        System.out.println("--------------------------");
        queue.pop();
        queue.print();
        System.out.println("--------------------------");

//        queueLinkedList.add(1);
//        queueLinkedList.add(2);
//        queueLinkedList.add(3);
//
//        queueLinkedList.print();
//
//        System.out.println("--------------------------");
//
//        queueLinkedList.pop();
//        int l = queueLinkedList.peek();
//        queueLinkedList.print();

    }
}
