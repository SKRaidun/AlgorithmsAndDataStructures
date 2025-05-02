package AVLTree;

public class Node {
    int key;
    Info info;
    int balance;
    Node left;
    Node right;
    Node parent;

    public Node(int key, int num1, int num2, String str) {
        this.key = key;
        this.info = new Info(num1, num2, str);
    }

}
