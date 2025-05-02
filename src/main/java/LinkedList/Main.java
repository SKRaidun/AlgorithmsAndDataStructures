package LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> ll = new LinkedList<Integer>();

        ll.addFirst(10);
        ll.addLast(15);
        ll.addFirst(11);
        ll.add(25, 2);
        ll.add(90, 1);

        ll.print();

        System.out.println("--------------------");

        ll.remove(5);

        ll.print();


    }
}
