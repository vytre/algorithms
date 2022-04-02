package org.pg4200.les02.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyRingArrayQueueBogdanTest extends MyQueueTestTemplate{

    @Test
    public void constructorTest(){
        MyRingArrayQueueBogdan<String> test1 = new MyRingArrayQueueBogdan<>();
        MyRingArrayQueueBogdan<String> test2 = new MyRingArrayQueueBogdan<>(10);


        assertEquals(42,test1.getMaxSize());
        assertEquals(10,test2.getMaxSize());
    }

    @Test
    public void fancyConstructorTest(){
        for (int i = 0; i < 10; i++) {
            MyRingArrayQueueBogdan<String> test = new MyRingArrayQueueBogdan<>(i);

            assertEquals(i,test.getMaxSize());

        }
    }

    @Test
    public void testResize1(){
        MyRingArrayQueueBogdan<Integer> test = new MyRingArrayQueueBogdan<>(2);
        for (int i = 0; i < 13; i++) {
            test.enqueue(i);
        }

        assertEquals(16, test.getMaxSize());

    }



    @Override
    protected <T> MyQueue<T> getNewInstance(Class<T> klass) {
        return new MyRingArrayQueueBogdan<>();
    }
}
