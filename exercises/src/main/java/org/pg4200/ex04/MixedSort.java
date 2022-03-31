package org.pg4200.ex04;

import org.pg4200.les03.sort.MySort;

public class MixedSort implements MySort {


    private final int bubbleLimit;

    public MixedSort(int bubbleLimit) {
        this.bubbleLimit = bubbleLimit;
    }


    @Override
    public <T extends Comparable<T>> void sort(T[] array) {

        if (array == null) {
            return;
        }

        T[] buffer = (T[]) new Comparable[array.length];

        mergesort(0, array.length - 1, array, buffer);
    }

    private <T extends Comparable<T>> void mergesort(int low, int high, T[] array, T[] buffer) {

        if(high - low < bubbleLimit){
            bubbleSort(low, high,array);
            return;
        }


        if (low < high) {

            int middle = low + (high - low) / 2;

            mergesort(low, middle, array, buffer);

            mergesort(middle + 1, high, array, buffer);

            merge(low, middle, high, array, buffer);
        }
    }

    private <T extends Comparable<T>> void merge(int low, int middle, int high, T[] array, T[] buffer) {

        for (int i = low; i <= high; i++) {
            buffer[i] = array[i];
        }

        //index over the left half, before middle
        int i = low;

        //index over the right half, after middle
        int j = middle + 1;

        for (int k = low; k <= high; k++) {
            if (i > middle) {
                //done with left half, just copy over the right
                array[k] = buffer[j++];
            } else if (j > high) {
                //done with right half, just copy over the left
                array[k] = buffer[i++];
            } else if (buffer[j].compareTo(buffer[i]) < 0) {
                array[k] = buffer[j++];
            } else {
                array[k] = buffer[i++];
            }
        }
    }

    private <T extends Comparable<T>> void bubbleSort(int low, int high, T[] array) {


        boolean swapped = true;
        int lastSwap = high;

        while (swapped) {

            swapped = false;
            int limit = lastSwap;

            for (int i = low; i < limit; i++) {
                int j = i + 1;


                if (array[i].compareTo(array[j]) > 0) {
                    T tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;

                    swapped = true;
                    lastSwap = i;
                }
            }
        }
    }

}
