package org.pg4200.les02.queue;

public class MyRingArrayQueueBogdan<T> implements MyQueue<T>{

    int size;
    private int maxSize;
    private T[] contents;
    private int head;
    private int tail;

    public MyRingArrayQueueBogdan(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.head = -1;
        this.tail = -1;

        this.contents =  (T[]) new Object[maxSize];
    }

    public MyRingArrayQueueBogdan() {
        this(42);
    }

    @Override
    public void enqueue(T value) {

        // 1. Queue is Empty
        // 2. Adding to the end of my Array
        // 3. I've Reached the head, im at capacity
        if(head == tail && this.size == this.maxSize){
          reSize();
        }


        if(tail == -1){
            tail++;

            head = 0;
        }

        if (tail == contents.length-1 && this.size != this.maxSize){

        }

        contents[tail] = value;
        size++;
    }

    @Override
    public T dequeue() {
        // empty

        // end of array

        // general case

        T result = null;

        if(this.size == 0){
            throw new RuntimeException("RunTimeExection");
        }

        result = contents[head];
        size--;

        contents[head] = null;

        if(head == maxSize -1){
            head = 0;
        }else{
            head++;
        }

        if (size == 0){
            head = -1;
            tail = -1;
        }
        return result;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public int getMaxSize(){
        return maxSize;
    }

    private void reSize(){
        int newSize = this.maxSize*2;
        T[] newArray = (T[]) new Object[maxSize];

        if(head < tail) {
            for (int i = 0; i < maxSize - 1; i++) {
                newArray[i] = contents[i];
            }
        }else{
            for (int i = head; i < maxSize-1; i++) {
                newArray[i - head] = contents[i];
            }
            for (int i = head; i < maxSize-1; i++) {
                newArray[i + head] = contents[i];
            }
            head = 0;
            tail = maxSize - 1;


        }

        this.maxSize = newSize;
        this.contents = newArray;
    }

    private void altReSize(){
        int newSize = this.maxSize*2;
        T[] newArray = (T[]) new Object[maxSize];

        if(head < tail) {
            for (int i = 0; i < maxSize - 1; i++) {
                newArray[i] = contents[i];
            }
        }else{
            for (int i = head; i < maxSize-1; i++) {
                newArray[i] = contents[i];
            }
            for (int i = head; i < maxSize-1; i++) {
                newArray[i + maxSize] = contents[i];
            }
            head = 0;
            tail = maxSize - 1;
        }

        this.maxSize = newSize;
        this.contents = newArray;
    }

}
