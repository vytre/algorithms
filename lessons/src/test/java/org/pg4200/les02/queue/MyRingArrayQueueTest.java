package org.pg4200.les02.queue;

public class MyRingArrayQueueTest extends MyQueueTestTemplate{
    @Override
    protected <T> MyQueue<T> getNewInstance(Class<T> klass) {
        return new MyRingArrayQueue<>();
    }
}
