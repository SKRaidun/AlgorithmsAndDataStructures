package Stack;

public class Node <T> {

    private T info;
    public Node next = null;

    public Node(T info) {
        this.info = info;
    }

    public <T> T getInfo() {
        return (T) info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
