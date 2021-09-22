package org.pg4200.ex03;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class OptimizedBubbleSortTest {

    @Test
    public void testCustomInput(){
        String[] customInput = {"c", "b", "a", "d", "e", "f"};

        OptimizedBubbleSort sorter = new OptimizedBubbleSort();
        MyStringComparator stringComparator = new MyStringComparator();
        int runs = sorter.sort(customInput, stringComparator, false);

        assertTrue(stringComparator.isSorted(customInput));
        assertTrue(runs == 15);
        assertTrue(customInput[0] == "a");
        assertTrue(customInput[1] == "b");
        assertTrue(customInput[2] == "c");
        assertTrue(customInput[3] == "d");
        assertTrue(customInput[4] == "e");
        assertTrue(customInput[5] == "f");

    }

    @Test
    public void isSorted(){
        String[] sortedInput = {"a", "c", "e", "g", "l", "m", "p"};

        OptimizedBubbleSort sorter = new OptimizedBubbleSort();
        MyStringComparator comparator = new MyStringComparator();
        int runs = sorter.sort(sortedInput, comparator, false);

        assertTrue(comparator.isSorted(sortedInput));

        assertTrue(runs == sortedInput.length - 1);
        assertTrue(sortedInput[0] == "a");
        assertTrue(sortedInput[1] == "c");
        assertTrue(sortedInput[2] == "e");
        assertTrue(sortedInput[3] == "g");
        assertTrue(sortedInput[4] == "l");
        assertTrue(sortedInput[5] == "m");
        assertTrue(sortedInput[6] == "p");
    }

    @Test
    public void almostSortedExample(){

        String[] sortedInput = {"a", "c", "e", "g", "l", "z" , "m", "p"};

        OptimizedBubbleSort sorter = new OptimizedBubbleSort();
        MyStringComparator comparator = new MyStringComparator();
        int runs = sorter.sort(sortedInput, comparator, false);

        assertEquals(14, runs);
        assertSame("a", sortedInput[0]);
        assertTrue(sortedInput[1] == "c");
        assertTrue(sortedInput[2] == "e");
        assertTrue(sortedInput[3] == "g");
        assertTrue(sortedInput[4] == "l");
        assertTrue(sortedInput[5] == "m");
        assertTrue(sortedInput[6] == "p");
        assertTrue(sortedInput[7] == "z");

    }

    @Test
    public void almostSortedExampleOptimized(){

        String[] sortedInput = {"a", "c", "e", "g", "l", "z" , "m", "p"};

        OptimizedBubbleSort sorter = new OptimizedBubbleSort();
        MyStringComparator comparator = new MyStringComparator();
        int runs = sorter.sort(sortedInput, comparator, true);


        // The "optimized" version optimized away 1 method call :)
        assertEquals(13, runs);
        assertSame("a", sortedInput[0]);
        assertTrue(sortedInput[1] == "c");
        assertTrue(sortedInput[2] == "e");
        assertTrue(sortedInput[3] == "g");
        assertTrue(sortedInput[4] == "l");
        assertTrue(sortedInput[5] == "m");
        assertTrue(sortedInput[6] == "p");
        assertTrue(sortedInput[7] == "z");

    }

    @Test
    public void testEmpty(){

        String[] input = {};
        OptimizedBubbleSort sorter = new OptimizedBubbleSort();
        MyStringComparator comparator = new MyStringComparator();
        int runs = sorter.sort(input, comparator, false);

        assertEquals(0, runs);

    }

    @Test
    public void testSingleElement(){

        String[] input = {"a"};
        OptimizedBubbleSort sorter = new OptimizedBubbleSort();
        MyStringComparator comparator = new MyStringComparator();
        int runs = sorter.sort(input, comparator, false);

        assertEquals(0, runs);

    }

    @Test
    public void testWorstCase(){
        String[] worst = {"f", "e", "d", "c", "b", "a"};
        OptimizedBubbleSort sorter = new OptimizedBubbleSort();
        MyStringComparator comparator = new MyStringComparator();
        int runs = sorter.sort(worst, comparator, false);

        // check that the array contains the same elements, in the correct order
        assertTrue(worst[0] == "a");
        assertTrue(worst[1] == "b");
        assertTrue(worst[2] == "c");
        assertTrue(worst[3] == "d");
        assertTrue(worst[4] == "e");
        assertTrue(worst[5] == "f");

        assertEquals(30, runs);
    }

    @Test
    public void testWorstCaseOptimized(){
        String[] worst = {"f", "e", "d", "c", "b", "a"};
        OptimizedBubbleSort sorter = new OptimizedBubbleSort();
        MyStringComparator comparator = new MyStringComparator();
        int runs = sorter.sort(worst, comparator, true);

        // check that the array contains the same elements, in the correct order
        assertTrue(worst[0] == "a");
        assertTrue(worst[1] == "b");
        assertTrue(worst[2] == "c");
        assertTrue(worst[3] == "d");
        assertTrue(worst[4] == "e");
        assertTrue(worst[5] == "f");

        assertEquals(15, runs);
    }

    @Test
    public void testGameUserComparator(){
        GameUser[] users = new GameUser[6];
        users[0] = new GameUser("a", 1);
        users[1] = new GameUser("b", 2);
        users[2] = new GameUser("c", 3);
        users[3] = new GameUser("z", 42);
        users[4] = new GameUser("e", 42);
        users[5] = new GameUser("w", 42);

        OptimizedBubbleSort sort = new OptimizedBubbleSort();
        GameUserComparator comparator = new GameUserComparator();

        int runs = sort.sort(users, comparator, true);

        assertEquals(42, users[3].getPoints());
        assertEquals(42, users[4].getPoints());
        assertEquals(42, users[5].getPoints());

        assertEquals("e", users[3].getUserId());
        assertEquals("w", users[4].getUserId());
        assertEquals("z", users[5].getUserId());


    }


}

