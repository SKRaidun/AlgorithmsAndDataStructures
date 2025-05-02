package AVLTree;

public class Main {
    public static void main(String[] args) {

        Tree tree = new Tree();

        Node node1 = new Node(10, 2, 5, "popa");

        tree.insert(node1);

        Node node2 = new Node(9, 2, 5, "popa");
        Node node3 = new Node(15, 2, 5, "popa");
        Node node4 = new Node(25, 2, 5, "popa");
        Node node5 = new Node(35, 2, 5, "popa");
        Node node6 = new Node(40, 2, 5, "popa");

        tree.insert(node2);
        tree.insert(node3);
        tree.insert(node4);
        tree.insert(node5);
        tree.insert(node6);


        System.out.println(tree.root.left.left.left.left.key);
    }
}
