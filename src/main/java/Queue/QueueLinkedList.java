package Queue;

import LinkedList.LinkedList;

public class QueueLinkedList <T> {

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

    public void add(T val) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else if (linkedList.length == 0) {
            linkedList.addFirst(val);
        } else {
            linkedList.addLast(val);
        }
    }

    public <T> T pop() {
        if (isEmpty()) {
            return null;
        } else {
            return (T) linkedList.remove(1);
        }
    }

    public void print() {
        linkedList.print();
    }

    public <T> T peek() {
        System.out.println(linkedList.printFirst());
        return (T) linkedList.printFirst();
    }
}
