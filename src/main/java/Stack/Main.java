package Stack;

public class Main {
    public static void main(String[] args) {
        //ArrayStack stack = new ArrayStack(3);
        ListStack stack = new ListStack();

        stack.add(1);
        stack.add(5);
        stack.add(9);

        stack.print();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
//
        stack.print();
    }
}
