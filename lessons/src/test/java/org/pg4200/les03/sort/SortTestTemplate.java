package org.pg4200.les03.sort;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pg4200.les03.sort.MySort;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Created by arcuri82 on 21-Aug-17.
 */
public abstract class SortTestTemplate {

    protected abstract MySort getInstance();

    protected MySort sorter;

    @BeforeEach
    public void init(){
        sorter = getInstance();
    }

    @Test
    public void testNull(){
        //should not throw an exception
        sorter.sort(null);
    }

    @Test
    public void testEmpty(){
        //should not throw an exception
        sorter.sort(new String[]{});
    }

    @Test
    public void testOne(){

        String[] array = {"a"};

        sorter.sort(array);

        assertEquals("a", array[0]);
    }

    @Test
    public void testAlreadySorted(){

        String[] array = {"A", "B", "C", "D"};

        sorter.sort(array);

        assertEquals("A", array[0]);
        assertEquals("B", array[1]);
        assertEquals("C", array[2]);
        assertEquals("D", array[3]);
    }


    @Test
    public void testInverted(){

        String[] array = {"c", "b", "a","d"};

        sorter.sort(array);

        assertEquals("a", array[0]);
        assertEquals("b", array[1]);
        assertEquals("c", array[2]);
        assertEquals("d", array[3]);

    }


    @Test
    public void testBase(){

        String[] array = {"d", "a", "c", "b"};

        sorter.sort(array);

        assertEquals("a", array[0]);
        assertEquals("b", array[1]);
        assertEquals("c", array[2]);
        assertEquals("d", array[3]);
    }


    @Test
    public void testRandom() {

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            System.out.println("------------------------------"+i+"---------------------");

            Integer[] array = new Integer[10];
            for (int j = 0; j < array.length; j++) {
                array[j] = random.nextInt(20);
            }

            sorter.sort(array);

            /*
                Regardless of the input array (which could be random)
                there are still properties that we can check, and that
                are independent of the input, like [j] <= [j+1].
             */
            for (int j = 0; j < array.length - 1; j++) {
                assertTrue(array[j] <= array[j + 1], Arrays.toString(array));
            }

            /*
                Is the above check enough to determine if an array is
                sorted???

                What if an implementation of "sorter.sort" just sets all
                the values in the array to 0 ???
             */
        }
    }

    @Test
    public void testVegard() {

        Random random = new Random();


        Integer[] array = new Integer[4];
        for (int j = 0; j < array.length; j++) {
            array[j] = random.nextInt(10);
        }

        sorter.sort(array);

    /*
    Regardless of the input array (which could be random)
    there are still properties that we can check, and that
    are independent of the input, like [j] <= [j+1].
    */
        for (int j = 0; j < array.length - 1; j++) {
            assertTrue(array[j] <= array[j + 1], Arrays.toString(array));
        }

     /*
    Is the above check enough to determine if an array is
    sorted???
    What if an implementation of "sorter.sort" just sets all
    the values in the array to 0 ???
    */
    }

    @Test
    public void testVegard2() {

        Integer[] array = new Integer[4];
        array[0] = 1;
        array[1] = 7;
        array[2] = 0;
        array[3] = 9;




        sorter.sort(array);

    /*
    Regardless of the input array (which could be random)
    there are still properties that we can check, and that
    are independent of the input, like [j] <= [j+1].
    */
        for (int j = 0; j < array.length - 1; j++) {
            assertTrue(array[j] <= array[j + 1], Arrays.toString(array));
        }

     /*
    Is the above check enough to determine if an array is
    sorted???
    What if an implementation of "sorter.sort" just sets all
    the values in the array to 0 ???
    */
    }

    @Test
    public void testBase2(){

        String[] array = {"d", "a", "e" ,"f" ,"c" , "g", "b"};

        sorter.sort(array);

        assertEquals("a", array[0]);
        assertEquals("b", array[1]);
        assertEquals("c", array[2]);
        assertEquals("d", array[3]);
        assertEquals("e", array[4]);
        assertEquals("f", array[5]);
        assertEquals("g", array[6]);
    }
}
