package Queue;

public class QueueArray <T> {

    public int size;
    public int capacity = 0;
    public int front = 0;
    public int back = 0;
    public T[] queue;


    public QueueArray(int size) {
        this.size = size;
        this.queue = (T[]) new Object[size];
    }

    public QueueArray() {
        this.size = 10;
        this.queue = (T[]) new Object[10];
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    public boolean isFull() {
        return capacity == size;
    }

    public void add(T val) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        } else {
            queue[back] = val;
            back = (back + 1) % size;
            capacity++;
        }
    }

    public <T> T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }  else {
            T temp = (T) queue[front];
            front = (front + 1) % size;
            capacity--;
            return temp;
        }
    }

    public void peak() {
        System.out.println(queue[front]);
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            int head = front;
            int tail = back;
            if (head == tail) {
                System.out.println(queue[head]);
                head++;
            }
            while (head != tail) {
                System.out.println(queue[head]);
                head = (head + 1) % size;
            }
        }
    }
}
