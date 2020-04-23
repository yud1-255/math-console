package com.kb.receiver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StandardMathReceiver implements MathReceiver {
    private List<Integer> confirmedPrimes = new ArrayList<>();

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

    private List<Integer> generatePrimes(int n) {
        if (confirmedPrimes.size() == 0) {
            confirmedPrimes.add(2);
            confirmedPrimes.add(3);
        }

        while (confirmedPrimes.size() < n) {
            int nextPrime = findNextPrime(confirmedPrimes.get(confirmedPrimes.size() - 1));
            confirmedPrimes.add(nextPrime);

        }

        return confirmedPrimes;

    }

    private int findNextPrime(int lastPrime) {
        int primeCandidate = lastPrime + 2; //start from odd numbers
        while (!isPrime(primeCandidate)) {
            primeCandidate = primeCandidate + 2;

        }

        return primeCandidate;
    }

    private boolean isPrime(int n) {
        /* implementation note: store primes in list, then check if divisible by stored list */

        if (confirmedPrimes.contains(n))
            return true;

        double upperBound = Math.ceil(Math.sqrt(n));

        for (int num : confirmedPrimes) {
            if (num > upperBound) {
                break;
            }

            if (n % num == 0) {
                return false;
            }
        }

        return true;

    }

    @Override
    public int[] findPrimes(int n) {
        this.confirmedPrimes = generatePrimes(n);

        int[] intArray = new int[confirmedPrimes.size()];
        Iterator<Integer> itr = confirmedPrimes.iterator();

        for (int i = 0; i < intArray.length; i++) {
            intArray[i]  = itr.next();
        }

        return intArray;

    }


}
