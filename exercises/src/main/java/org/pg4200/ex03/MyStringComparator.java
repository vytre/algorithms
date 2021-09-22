package org.pg4200.ex03;

import java.util.Comparator;

public class MyStringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }

    @Override
    public boolean equals(Object obj) {
        return this.equals(obj);
    }

    public boolean isSorted(String[] array){
        boolean sorted = true;
        for(int i = 0; i < array.length - 1; i++){
            if (compare(array[i], array[i+1]) > 0){
                sorted = false;
            }
        }
        return sorted;
    }

}
