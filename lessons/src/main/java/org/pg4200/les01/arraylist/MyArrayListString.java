package org.pg4200.les01.arraylist;

import org.pg4200.les01.MyListString;

/**
 * Created by arcuri82 on 14-Aug-17.
 */
public class MyArrayListString implements MyListString {

    /**
     * Here we use an array to backup the data we insert in the container.
     */
    private String[] data;

    /**
     * The "size" of the container is not going to be necessarily equal to the length
     * of the "data" array.
     */
    private int size = 0;

    public MyArrayListString(){
        //call the other constructor with "10" as default max size.
        this(10);
    }

    public MyArrayListString(int maxSize){
        data = new String[maxSize];
    }

    @Override
    public String get(int index) {
        if(index < 0 || index >= size){ // Hvis Index er - (negativ) eller hvis index er større eller lik "størrelsen" på arraye.
            //some input validation     Altså, vi kan ikke kalle på index pos 10 i en array med 10 elementer (0-9)
            return null;
        }
        return data[index];
    }

    @Override
    public void add(String value) {
        data[size] = value;
        size++;
    }

    @Override
    public int size() {
        return size;
    }
}
