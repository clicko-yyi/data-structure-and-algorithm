package offer.queue;

public class Queue {

    int[] array;
    int size;
    int front;
    int end;
    int nitems;

    public Queue(int size) {
        array = new int[size];
        this.size = size;
        int front = 0;
        int end = 0;
        int nitems = 0;
    }

    public void enQueue(int x) {
        if(isFull()){
            return;
        }
        front = (front + 1) % size;
        array[front] = x;
        nitems++;
    }

    public void deQueue(int x){
        if (isEmpty()) {
            return;
        }
        end = (end + 1) % size;
        array[end] = 0;
        nitems--;
    }

    public boolean isFull(){
        return nitems == size;
    }

    public boolean isEmpty(){
        return nitems == 0;
    }

}
