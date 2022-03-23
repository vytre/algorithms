package org.pg4200.ex03;

public class SortCheckerImp implements SortChecker{
    @Override
    public <T extends Comparable<T>> boolean isSortedCopy(T[] original, T[] sorted) {

        if(original == null ||sorted == null){ // En Array = null
            return false;
        }

        if(original.length != sorted.length){ // Ulik lengde
            return false;
        }

        boolean swapped = true;

        while (swapped){
            swapped = false;
            for (int i = 0; i < original.length-1; i++) {
                int j = i+1;

                if(original[i].compareTo(original[j])>0){ // Sorterer de høyt til lavt med bouble sort.
                    T tmp = original[i];
                    original[i] = original[j];
                    original[j] = tmp;

                    swapped =true;
                }
            }
        }
        for (int i = 0; i < original.length; i++) { // Sjekker om Orginalt sortert == sorted[]
            if(original[i] != sorted[i]){
                return false;
            }
        }
        return false;
    }
}
