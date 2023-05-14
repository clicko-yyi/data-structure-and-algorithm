package offer.queue;

public class Stack {
    int[] array;
    int top;
    int size;

    public void push(int x){
        if (isFull()) {
            return;
        }
        array[top++] = x;
    }

    public int pop(){
        if (isEmpty()) {
            return -1;
        }
        int t = array[top--];
        return t;
    }

    public boolean isFull(){
        return top == size;
    }

    public boolean isEmpty(){
        return top == 0;
    }
}
