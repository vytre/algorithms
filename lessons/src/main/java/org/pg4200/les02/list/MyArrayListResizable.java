package org.pg4200.les02.list;

public class MyArrayListResizable<T> extends MyArrayList<T> {
    @Override
    public void add(int index, T value) {
        if(index < 0 || index > size){
            //note that here "size" is a valid index
            throw new IndexOutOfBoundsException();
        }
        System.out.println(size);
        if (size() < data.length) {
            for (int j = size - 1; j >= index; j--) {
                data[j + 1] = data[j];
            }
            data[index] = value;
            size++;
        }else {
            Object[] tmp = new Object[data.length * 2];

            int size = size();
            for(int i=0; i<size; i++){
                tmp[i] = data[i];
            }
            data = tmp;
        }
    }
}
