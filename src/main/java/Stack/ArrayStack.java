package Stack;

public class ArrayStack <T> {

    private T info;
    private int size = 0;
    int top = 0;
    private T[] stack;

    public ArrayStack(int n) {
        this.size = n;
        this.stack = (T[]) new Object[n];
    }

    public void add(T info) {
        if (top == size) {
            System.out.println("Stack is full");
        } else {
            stack[top] = info;
            top += 1;
        }
    }

    public T pop() throws RuntimeException {
        if (top == 0) {
            System.out.println("Stack is empty");
            throw new RuntimeException();
        } else {
            top -= 1;
            return stack[top];
        }
    }

    public void print() {
        if (top == 0) {
            System.out.println("Stack is empty");
            throw new RuntimeException();
        } else {
            for (int i = top - 1; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }
}
