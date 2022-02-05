package org.pg4200.ex01;

public class ArrayUtilsImp implements ArrayUtils{


    @Override
    public int min(int[] array) throws IllegalArgumentException {
            checkForIllegalArguments(array);

            int minValue = array[0];
            for (int i = 0; i < array.length; i++) {
                if (array[i] < minValue) {
                    minValue = array[i];
                }
            }
            return minValue;
    }


    @Override
    public int max(int[] array) throws IllegalArgumentException {

            checkForIllegalArguments(array);
            int maxValue = array[0];
            for (int i = 0; i < array.length; i++) {
                if (array[i] > maxValue){
                    maxValue = array[i];
                }
            }
            return maxValue;
    }

    @Override
    public double mean(int[] array) throws IllegalArgumentException {
            checkForIllegalArguments(array);
            int totalValue = 0;
            int meanValue = 0;
            for (int i = 0; i < array.length; i++) {
                totalValue += array[i];
            }
            meanValue = totalValue/ array.length;
            return meanValue;
    }


    private void checkForIllegalArguments(int[] array) {
        if(array == null||array.length == 0){
            throw new IllegalArgumentException("Bug");
        }
    }
}
