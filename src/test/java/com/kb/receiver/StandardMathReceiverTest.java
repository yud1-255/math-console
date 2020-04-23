package com.kb.receiver;

import com.kb.command.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

public class StandardMathReceiverTest {

    double[] positiveNumbers;
    double[] negativeNumbers;

    Map<Integer, Integer> fibonacciMap = new HashMap<>();

    @Before
    public void setUp() {
        positiveNumbers = new double[] { 21, 32, 66, 123, 9 };
        negativeNumbers = new double[] { -1, -6, -91, -8, -102 };

        fibonacciMap.put(37, 14930352);
        fibonacciMap.put(40, 63245986);
        fibonacciMap.put(7, 8);
    }


    @Test
    public void sum_whenExecuted_returnValidCommandResult() {
        double param1 = positiveNumbers[0], param2 = negativeNumbers[2];
        double expected = param1 + param2;

        StandardMathReceiver sut = new StandardMathReceiver();
        double actual = sut.sum(param1, param2);

        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void sum_whenSameNumbers_returnTwoTimesOfInput() {
        double param1 = positiveNumbers[0], param2 = positiveNumbers[0];
        double expected = param1 * 2;

        StandardMathReceiver sut = new StandardMathReceiver();
        double actual = sut.sum(param1, param2);

        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void multiply_whenPositiveAndPositive_returnPositiveCommandResult() {

        double param1 = positiveNumbers[new Random().nextInt(positiveNumbers.length)];
        double param2 = positiveNumbers[new Random().nextInt(positiveNumbers.length)];

        StandardMathReceiver sut = new StandardMathReceiver();
        double actual = sut.multiply(param1, param2);

        assertTrue(actual > 0);
    }

    @Test
    public void multiply_whenPositiveAndNegative_returnNegativeCommandResult() {

        double param1 = positiveNumbers[new Random().nextInt(positiveNumbers.length)];
        double param2 = negativeNumbers[new Random().nextInt(negativeNumbers.length)];

        StandardMathReceiver sut = new StandardMathReceiver();
        double actual = sut.multiply(param1, param2);

        assertTrue(actual < 0);
    }

    @Test
    public void multiply_whenZero_returnZeroCommandResult() {
        double param1 = 0;
        double param2 = new Random().nextDouble();

        StandardMathReceiver sut = new StandardMathReceiver();
        double actual = sut.multiply(param1, param2);

        assertEquals(0, actual, 1e-8);

    }

    @Test
    public void fibonacci_whenValidInput_returnValidArrays() {
        int param = 9;

        StandardMathReceiver sut = new StandardMathReceiver();

        int[] arrayResult = sut.findFibonacci(param);

        assertEquals(param, arrayResult.length);
        assertEquals(arrayResult[param - 1], arrayResult[param - 2] + arrayResult[param - 3]);

    }

    @Test
    public void fibonacci_whenMultipleCases_returnValidLastElement() {
        for (int key : fibonacciMap.keySet()) {
            StandardMathReceiver sut = new StandardMathReceiver();
            int[] arrayResult = sut.findFibonacci(key);

            assertEquals((int)fibonacciMap.get(key), arrayResult[arrayResult.length - 1]);

        }
    }


    @Test
    public void findPrimes_whenNEqualsThree_returnThreeSortedPrimes() {
        StandardMathReceiver sut = new StandardMathReceiver();
        int[] actual = sut.findPrimes(3);

        assertArrayEquals(new int[] {2, 3, 5}, actual);

    }

    @Test
    public void findPrimes_whenMultipleCases_returnValidLastElement() {
        Map<Integer,Integer> primeMap = new HashMap<>();

        primeMap.put(4, 7);
        primeMap.put(32, 131);
        primeMap.put(11, 31);

        for (int key : primeMap.keySet()) {
            StandardMathReceiver sut = new StandardMathReceiver();
            int[] arr = sut.findPrimes(key);

            assertEquals(key, arr.length);
            assertEquals((int)primeMap.get(key), arr[arr.length - 1]);
        }

    }

    @Test
    public void findPrimes_whenLargeNumbers_returnValidLastElement() {
        Map<Integer,Integer> primeMap = new HashMap<>();

        primeMap.put(962, 7577);
        primeMap.put(860, 6673);
        primeMap.put(1000, 7919);

        for (int key : primeMap.keySet()) {
            StandardMathReceiver sut = new StandardMathReceiver();
            int[] arr = sut.findPrimes(key);

            assertEquals(key, arr.length);
            assertEquals((int)primeMap.get(key), arr[arr.length - 1]);
        }

    }
}
