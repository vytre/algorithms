package org.pg4200.ex04;

public class FibonacciImplMemoizedTest extends FibonacciTestTemplate{
    @Override
    protected Fibonacci getInstance() {
        return new FibonacciImplMemoized();
    }
}
