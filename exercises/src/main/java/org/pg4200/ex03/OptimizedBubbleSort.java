package org.pg4200.ex03;

import java.util.Comparator;

public class OptimizedBubbleSort {

    public <T> int sort(T[] array, Comparator<T> comparator, boolean optimized){

        if(array.length <= 1){
            return 0;
        }

        int timesCalled = 0;

        boolean ordered = false;
        // useful for the optimized version, unused otherwise
        int lastSwap = array.length - 1;

        while(!ordered) {
            // it's not ordered. so order it.

            ordered = true; // assume it is, until we find a counter example
            int limit = array.length - 1;
            if(optimized){
                limit = lastSwap;
            }

            for (int i = 0; i < limit; i++ ){
                if(comparator.compare(array[i], array[i+1]) > 0){
                    ordered = false;

                    T aux = array[i];
                    array[i] = array[i+1];
                    array[i+1] = aux;

                    lastSwap = i;
                }
                // My mistake: the point is to count how many times "compare" was called, so always increment
                timesCalled++;
            }
        }

        return timesCalled;
    }
}


