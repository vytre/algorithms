package org.pg4200.les01.arraylist;

public class MyArrayListInteger {
    private int[] data;
    private int size;

    public MyArrayListInteger() {
        this(10);
    }

    public MyArrayListInteger(int size) {
        data = new int[size];
    }

    public Integer get(int index) {
        if(index < 0 || index >= size){ // Hvis Index er - (negativ) eller hvis index er større eller lik "størrelsen" på arraye.
            //some input validation     Altså, vi kan ikke kalle på index pos 10 i en array med 10 elementer (0-9)
            return null;
        }
        return data[index];
    }

    public void add(int number){
        data[size] = number;
        size++;
    }

    public int size(){
        return size;
    }
}
