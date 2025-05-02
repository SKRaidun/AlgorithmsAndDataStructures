package Queue;

import LinkedList.LinkedList;

public class QueueLinkedList {

    int size;

    LinkedList linkedList = new LinkedList();

    public QueueLinkedList(int size) {
        this.size = size;
    }

    public boolean isFull() {
        return linkedList.length == size;
    }

    public boolean isEmpty() {
        return linkedList.length == 0;
    }

    public void add(int val) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else if (linkedList.length == 0) {
            linkedList.addFirst(val);
        } else {
            linkedList.addLast(val);
        }
    }

    public int pop() {
        if (isEmpty()) {
            return 0;
        } else {
            return linkedList.remove(1);
        }
    }

    public void print() {
        linkedList.print();
    }

    public int peek() {
        System.out.println(linkedList.printFirst());
        return linkedList.printFirst();
    }
}
