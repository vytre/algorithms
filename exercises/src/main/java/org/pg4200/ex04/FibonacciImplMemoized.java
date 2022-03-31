package org.pg4200.ex04;

public class FibonacciImplMemoized implements Fibonacci{

    private final Integer[] cache = new Integer[100];

    @Override
    public int compute(int n) throws IllegalArgumentException {
        if(n < 0){
            throw new IllegalArgumentException("Negative input: " + n);
        }

        if(n==0 || n==1){
            return n;
        }

        if(n < cache.length && cache[n] != null){
            return cache[n];
        }

        int f = compute(n-2) + compute(n-1);

        if(n < cache.length){
            cache[n] = f;
        }

        return f;
    }
}
