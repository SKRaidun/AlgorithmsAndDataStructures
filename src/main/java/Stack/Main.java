package Stack;

public class Main {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        //ListStack stack = new ListStack();

        stack.add("o");
        stack.add("q");
        stack.add(5);

        stack.print();
        stack.pop();
        stack.pop();
        //stack.pop();
        stack.print();
    }
}
