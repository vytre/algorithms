package org.pg4200.ex04;

public class FibonacciImplTest extends FibonacciTestTemplate{
    @Override
    protected Fibonacci getInstance() {
        return new FibonacciImpl();
    }
}
