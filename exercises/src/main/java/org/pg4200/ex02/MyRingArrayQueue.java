package org.pg4200.ex02;

import org.pg4200.les02.queue.MyQueue;

public class MyRingArrayQueue<T> implements MyQueue<T> {

    Object[] data;
    int tail = -1;
    int head = -1;
    int size = 0;

    public MyRingArrayQueue(){
        data = new Object[42];
    }

    public MyRingArrayQueue(int capacity){
        data = new Object[capacity];
    }

    @Override
    public void enqueue(T value) {
        if(size < data.length){
            if (tail < data.length - 1) {
                data[tail++] = value;
            }
            else if(head != 0){
                // tail is at end, but head is not 0 (and we know there should still be space)
                tail = 0;
                data[tail] = value;
            }
        }
        else{
            // full. replace inner array
            Object[] newArr = new Object[2 * data.length];

        }

        // Add at tail if there is room (size < capacity)

        //else replace data object

    }



    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
