package org.pg4200.ex01;

public class ArrayUtilsImp implements ArrayUtils{

    private int[] data;
    private int size;

    public ArrayUtilsImp() {
        this(10);
    }

    public ArrayUtilsImp(int size) {
        data = new int[size];
    }

    @Override
    public int min(int[] array) throws IllegalArgumentException {
        try {
            int minValue = array[0];
            for (int i = 0; i < array.length; i++) {
                if (array[i] < minValue) {
                    minValue = array[i];
                }
            }
            return minValue;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public int max(int[] array) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public double mean(int[] array) throws IllegalArgumentException {
        try {

        }catch (Exception e){

        }
        return 0;
    }
}
