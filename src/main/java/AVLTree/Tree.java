package AVLTree;

import Stack.ArrayStack;

public class Tree {

    Node root = null;


    public void left_rotate(Node x) {
        Node y = x.right;
        Node parent = x.parent;

        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }

        y.parent = parent;

        if (parent == null) {
            root = y;
        } else {
            if (x == parent.left) {
                parent.left = y;
            } else {
                parent.right = y;
            }
        }

        y.left = x;
        x.parent = y;

    }

    public void right_rotate(Node x) {
        Node y = x.left;
        Node parent = x.parent;

        x.left = y.right;

        if (y.right != null) {
            y.right.parent = x;
        }

        y.parent = parent;

        if (parent == null) {
            root = y;
        } else {
            if (x == parent.left) {
                parent.left = y;
            } else {
                parent.right = y;
            }
        }

        y.right = x;
        x.parent = y;
    }

    public void TreeBalance(Node x) {
        Node parent = x.parent;
        try {
            if (parent.balance == 1) {
                if (x.left != null) {
                    if (x.left.balance == 1 || x.left.balance == -1) {
                        right_rotate(x);
                    }
                }
                left_rotate(parent);
            } else if (parent.balance == -1) {
                if (x.left.balance == 1 || x.left.balance == -1) {
                    left_rotate(x);
                }
                right_rotate(parent);
            }
        } catch (NullPointerException _) {}
        correction(x);
    }

    public void correction(Node x) {
        Node parent = x.parent;

        while (parent != null && parent.balance == 0) {
            if (x == parent.left) {
                parent.balance--;
            } else {
                parent.balance++;
            }
            x = parent;
            parent = x.parent;
        }

        if (parent == null) {
            return;
        }
        if ((x == parent.left && parent.balance == 1) ||( x == parent.right && parent.balance == -1)) {
            parent.balance = 0;
            return;
        }
        TreeBalance(x);
    }

    public void insert(Node node) {
        if (root == null) {
            root = node;
            return;
        }

        Node ptr = root;
        Node par = null;
        while (ptr != null) {
            par = ptr;
            if (node.key < ptr.key) {
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }

        if (node.key < par.key) {
            par.left = node;
        } else {
            par.right = node;
        }
        node.parent = par;
        correction(node);
    }

    public void printTree(Node node, int lvl) {
        int i = lvl;
        if (node != null) {
            printTree(node.right, lvl + 1);
            while (i > 0) {
                System.out.print("                ");
                i -= 1;
            }
            System.out.println(node.key);
            printTree(node.left, lvl + 1);
        }
    }
}
