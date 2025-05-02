package Stack;

public class Main {
    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>(3);
        //ListStack stack = new ListStack();

        stack.add("o");
        stack.add("q");
        stack.add("p");

        stack.print();
        stack.pop();
        stack.pop();
        //stack.pop();
        stack.print();
    }
}
