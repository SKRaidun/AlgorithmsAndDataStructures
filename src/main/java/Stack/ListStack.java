package Stack;


public class ListStack <T>{

    private Node top = null;

    public void add(T value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public <T> T pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            throw new IllegalStateException();
        } else {
            Node newNode = top;
            T result = (T) newNode.getInfo();
            top = newNode.next;
            return result;
        }
    }

    public void print() {
        Node newNode = top;

        if (top != null) {
            while (newNode.next != null) {
                System.out.println(newNode.getInfo());
                newNode = newNode.next;
            }
            System.out.println(newNode.getInfo());
        }
    }
}
