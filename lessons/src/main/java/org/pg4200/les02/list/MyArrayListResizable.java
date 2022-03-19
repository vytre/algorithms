package org.pg4200.les02.list;

public class MyArrayListResizable<T> extends MyArrayList<T> {

    // Først må vi hente Object Array og størrelse
    public MyArrayListResizable(){
        super();
    }

    public MyArrayListResizable(int capacity) {
        super(capacity);
    }

    @Override
    public void add(int index, T value) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }


        if (size < data.length) {
            for (int j = size - 1; j >= index; j--) {
                data[j + 1] = data[j];
            }
            data[index] = value;
            size++;
            System.out.println("size: "  +size);
            System.out.println("DataLenghth: "  +data.length);
        }else {
            Object[] tmp = new Object[data.length * 2];

            for(int i=0; i< data.length; i++){
                tmp[i] = data[i];
            }
            data = tmp;
        }
    }
}
