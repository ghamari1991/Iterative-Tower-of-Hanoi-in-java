
public class MyStack {

    private int[] stack;
    int top = -1;

    public MyStack(int Size) {
        stack = new int[Size];
    }

    public void push(int a) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        stack[++top] = a;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return stack.length == top - 1;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return stack[top];
    }

}
