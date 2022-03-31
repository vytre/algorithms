package org.pg4200.ex04;

public class FibonacciImp implements Fibonacci {

    @Override
    public int compute(int n) throws IllegalArgumentException {

        System.out.println(n);
        if (n < 0){
            throw new IllegalArgumentException();
        }

        if(n==0 || n==1){
            return n;
        }

        return compute(n-1) + compute(n-2);
    }
}
