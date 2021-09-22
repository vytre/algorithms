package org.pg4200.ex04;

import org.pg4200.ex04.Fibonacci;

public class FibonacciImpl implements Fibonacci{

    private int[] mem = new int[200];

    @Override
    public int compute(int n) throws IllegalArgumentException {

        if(n < 0) throw new IllegalArgumentException("Fibonacci for negative numbers?");
        if(n == 0) return 0;
        if(n == 1){
            return 1;
        }

        if(mem[n] != 0){
            return mem[n];
        }
        else{
            mem[n] = compute(n-2) + compute(n-1);
            return mem[n];
        }
    }
}
