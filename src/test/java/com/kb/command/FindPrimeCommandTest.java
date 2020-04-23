package com.kb.command;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FindPrimeCommandTest {

    @Test
    public void whenNEqualsThree_returnThreeSortedPrimes() {
        FindPrimeCommand sut = new FindPrimeCommand(
                FindPrimeCommand.createCommandRequest(3)
        );
        sut.execute();

        int[] actual = (int[])sut.getCommandResult().getValue();

        assertArrayEquals(new int[] {2, 3, 5}, actual);

    }

    @Test
    public void whenMultipleCases_returnValidLastElement() {
        Map<Integer,Integer> primeMap = new HashMap<>();

        primeMap.put(4, 7);
        primeMap.put(32, 131);
        primeMap.put(11, 31);

        for (int key : primeMap.keySet()) {
            FindPrimeCommand sut = new FindPrimeCommand(FindPrimeCommand.createCommandRequest(key));

            sut.execute();
            CommandResult result = sut.getCommandResult();
            int[] arr = (int[])result.getValue();

            assertNotNull(result);
            assertEquals(key, arr.length);
            assertEquals((int)primeMap.get(key), arr[arr.length - 1]);
        }

    }

    @Test
    public void whenLargeNumbers_returnValidLastElement() {
        Map<Integer,Integer> primeMap = new HashMap<>();

        primeMap.put(962, 7577);
        primeMap.put(860, 6673);
        primeMap.put(1000, 7919);

        for (int key : primeMap.keySet()) {
            FindPrimeCommand sut = new FindPrimeCommand(FindPrimeCommand.createCommandRequest(key));

            sut.execute();
            CommandResult result = sut.getCommandResult();
            int[] arr = (int[])result.getValue();

            assertNotNull(result);
            assertEquals(key, arr.length);
            assertEquals((int)primeMap.get(key), arr[arr.length - 1]);
        }

    }
}