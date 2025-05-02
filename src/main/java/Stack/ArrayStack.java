package Stack;

public class ArrayStack {

    int info;
    int size = 0;
    int top = 0;
    int[] stack;

    public ArrayStack() {
        this.size = size;
        this.stack = new int[size];
    }

    public void add(int info) {
        if (top == size) {
            System.out.println("Stack is full");
        } else {
            stack[top] = info;
            top += 1;
        }
    }

    public int pop() throws RuntimeException {
        if (top == 0) {
            System.out.println("Stack is empty");
            throw new RuntimeException();
        } else {
            top -= 1;
            return stack[top];
        }
    }

    public void print() {
        for (int i = 0; i < top; i++) {
            System.out.println(stack[i]);
        }
    }
}
