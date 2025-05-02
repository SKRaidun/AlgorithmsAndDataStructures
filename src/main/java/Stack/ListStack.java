package Stack;


public class ListStack {

    Node top = null;

    public void add(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            throw new IllegalStateException();
        } else {
            Node newNode = top;
            int result = newNode.info;
            top = newNode.next;
            return result;
        }
    }

    public void print() {
        Node newNode = top;

        if (top != null) {
            while (newNode.next != null) {
                System.out.println(newNode.info);
                newNode = newNode.next;
            }
            System.out.println(newNode.info);
        }
    }
}
