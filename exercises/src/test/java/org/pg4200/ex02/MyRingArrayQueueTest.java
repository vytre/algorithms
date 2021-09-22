package org.pg4200.ex02;

import org.pg4200.les02.queue.MyQueue;
import org.pg4200.les02.queue.MyQueueTestTemplate;

public class MyRingArrayQueueTest extends MyQueueTestTemplate {
    @Override
    protected <T> MyQueue<T> getNewInstance(Class<T> klass) {
        return new MyRingArrayQueue<T>();
    }
}
