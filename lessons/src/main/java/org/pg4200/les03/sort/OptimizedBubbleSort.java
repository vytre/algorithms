package org.pg4200.les03.sort;

import java.util.Comparator;

public class OptimizedBubbleSort {

    public <T> int sort(T[] array, Comparator<T> comparator, boolean optimized){

        if(array == null){
            return 0;
        }

        int counter = 0;

        boolean swapped = true;

        int lastSwap = array.length-1;

        while (swapped){
            swapped = false;

            int limit = array.length-1;

            if(optimized){
                limit = lastSwap;
            }

            for (int i = 0; i < limit; i++) {
                int j = i+1;

                counter++;

                if(comparator.compare(array[i],array[j]) >0){
                    T tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;

                    swapped = true;
                    lastSwap = i;
                }

            }

        }

        return counter;
    }

}
