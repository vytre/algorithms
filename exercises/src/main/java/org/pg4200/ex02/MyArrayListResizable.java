package org.pg4200.ex02;

import org.pg4200.les02.list.MyArrayList;

public class MyArrayListResizable<T> extends MyArrayList<T> {

    @Override
    public void add(int index, T value){
        //what if index > data.length - Ex A
        if(index >= data.length){
            // double the size of the array
            Object[] newArray = new Object[2 * data.length];
            //copy data to new array
            for (int i = 0; i < data.length; i++){
                newArray[i] = data[i];
            }
            this.data = newArray;
        }
        super.add(index, value);
    }
}
