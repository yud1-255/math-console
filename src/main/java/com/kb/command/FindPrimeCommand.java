package com.kb.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FindPrimeCommand implements Command {
    private int n;
    private CommandResult result;

    private List<Integer> confirmedPrimes = new ArrayList<>();

    public FindPrimeCommand(FindPrimeCommandRequest commandRequest) {
        this.n = commandRequest.getN();
    }

    private FindPrimeCommand() { }

    private List<Integer> findPrimes(int n) {
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
    public void execute() {
        this.confirmedPrimes = findPrimes(this.n);

        int[] intArray = new int[confirmedPrimes.size()];
        Iterator<Integer> itr = confirmedPrimes.iterator();

        for (int i = 0; i < intArray.length; i++) {
            intArray[i]  = itr.next();
        }

        this.result = new CommandResult(intArray);
    }

    @Override
    public CommandResult getCommandResult() {
        return result;
    }

    public static FindPrimeCommandRequest createCommandRequest(int n) {
        return new FindPrimeCommandRequest(n);
    }
}

class FindPrimeCommandRequest {
    private int n;

    public FindPrimeCommandRequest(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid argument: should be positive integer");
        }

        this.n = n;
    }

    public int getN() {
        return n;
    }
}
