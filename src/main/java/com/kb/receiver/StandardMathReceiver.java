package com.kb.receiver;

public class StandardMathReceiver implements MathReceiver {
    @Override
    public double sum(double x, double y) {
        return x + y;
    }

    @Override
    public double multiply(double x, double y) {
        return x * y;
    }

    @Override
    public int[] findFibonacci(int n) {
        /* implementation note: we can use recursive calls, but using memoization with array is simpler */

        int[] fib = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                fib[i] = 0;
            } else if (i == 1) {
                fib[i] = 1;
            } else {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }

        return fib;
    }

    @Override
    public int[] findPrime(int n) {
        return new int[0];
    }
}
