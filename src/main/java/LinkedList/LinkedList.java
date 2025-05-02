package LinkedList;

public class LinkedList <T> {

    public Node first;
    public int length;
    public LinkedList() {
        first = null;
        length = 0;
    }

    public void addFirst(T val) {

        Node newNode = new Node(val);

        if (first == null) {
            first = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        length += 1;
    }

    public void addLast(T val) {
        Node temp = first;
        while (temp.next != null) {
            temp = temp.next;
            }
        temp.next = new Node(val);
        length += 1;
        }

    public void add(T val, int n) {
        Node newNode = new Node(val);
        if (n == 0) {
            addFirst(val);
        } else if (n == length) {
            addLast(val);
        } else {
            int k = 0;
            Node temp = first;
            while (temp.next != null) {
                if (k == n - 1) {
                    Node next = temp.next;
                    newNode.next = next;
                    temp.next = newNode;
                    length++;
                }
                temp = temp.next;
                k += 1;
            }
        }
    }

    public void print() {

        if (first == null) {
            System.out.println("List is empty");
        } else {
            Node temp = first;
            if (temp.next == null) {
                System.out.println(temp.getVal());
            } else {
                while (temp.next != null) {
                    System.out.println(temp.getVal());
                    temp = temp.next;
                }
                System.out.println(temp.getVal());
            }
        }
    }

    public <T> T remove(int n) {
        T node = null;
        if (n == 1) {
            node = (T) first.getVal();
            first = first.next;
            length--;
            return node;
        } else {
            Node temp = first;
            Node next = temp.next;
            int k = 1;
            while (temp.next != null) {
                if (n == length & k == n - 1) {
                    node = (T) temp.getVal();
                    temp.next = null;
                    length--;
                    return node;
                } else if (k == n - 1) {
                    node = (T) temp.getVal();
                    temp.next = next.next;
                    length--;
                    return node;
                }
                temp=temp.next;
                k += 1;
            }
        }

        return node;
    }

    public void reverse() {
        if (length != 1) {
            Node temp = first;
            while(temp.next != null) {
                first.next = temp.next;
                temp.next = first;
                first = temp;
                temp = temp.next;
            }

        }
    }

    public <T> T printFirst() {
        return (T) first.getVal();
    }

//    public void search(int n) {
//        if (first == null) {
//            System.out.println("List is empty");
//        }
//        Node temp = first;
//        int k = 0;
//        while (temp.next != null) {
//            if (k == n) {
//                System.out.println(temp.val);
//            } else {
//                k += 1;
//                temp = temp.next;
//            }
//            if (temp.next == null) {
//                System.out.println(temp.val);
//            }
//        }
//    }
}
