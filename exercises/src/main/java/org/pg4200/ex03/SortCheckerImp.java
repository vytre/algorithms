package org.pg4200.ex03;

import java.util.Arrays;

public class SortCheckerImp implements SortChecker{
    @Override
    public <T extends Comparable<T>> boolean isSortedCopy(T[] original, T[] sorted) {

        if (original == null && sorted == null) { // Litt rart i testene, men disse "isSorted" når begge er null...
            return true;
        }

        if (original == null || sorted == null) {
            return false;
        }

       if(sorted.length == 0 || original.length == 0){ // Hvis en eller begge er tom array
           return true;
       }

       if(original.length != sorted.length){ // Ulik lengde
           return false;
       }

       if(original.length == 1 && sorted.length == 1){ // Lengden er 1 og de er lik aka IsSorted...
           if(original[0] == sorted[0]){
               return true;
           }
       }


       boolean swapped = true;

        while (swapped){ // Sorterer bare original, hvis like sorted == så er sorted en kopi av Orginal
            swapped = false;
            for (int i = 0; i < original.length-1; i++) {
                int j = i+1;

                if(original[j] == null){
                    return false;
                }

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
                System.out.println(Arrays.toString(original));
                return false;
            }
        }
        return true;
    }
}
