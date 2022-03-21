package org.pg4200.les03.sort;

// WARNING: this is one of the 12 classes you need to study and know by heart


import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort implements MySort {

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {

        if (array == null) {
            return;
        }

        ArrayList<T> myList = new ArrayList<>();
        for (T s:
             array) {
            myList.add(s);
        }
        System.out.println( "Starten av lista " +myList + "\n");


        /*
            We start from 1 (2nd element), as an array of length 0
            or 1 is sorted by definition
         */
        for(int i=1; i<array.length; i++){
            System.out.println();
            System.out.println("i: "+i+"\n");
            /*
                At each step, the elements before "i" are sorted,
                but "i" itself might be of lower value.
                In such latter case, the value at "i" need to be inserted
                in the right order between the previous ones.
                This is done by comparing two elements at a time,
                from right to left, until the element is greater than
                what is on its left-side, ie no more swapping is necessary.
             */
            for(int k=i-1; k>=0; k--){
                System.out.println("k: " + k);
                System.out.println("k+1: "+(k+1));
                System.out.println("MyArray " + Arrays.toString(array));
                System.out.print("Checking: "+array[k] +"[" + k +"]" + " with "+ array[k+1]+"[" + (k+1) +"]" );
                System.out.println();
                if (array[k].compareTo(array[k+1]) > 0) {
                    T tmp = array[k+1];
                    array[k+1] = array[k];
                    array[k] = tmp;
                    System.out.println("Swapped");
                    System.out.println("New Array " + Arrays.toString(array)+"\n");
                } else {
                    System.out.println("Ingen Swapped \nbreak");
                    break;
                }
            }
        }
    }
}
