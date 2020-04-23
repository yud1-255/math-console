package com.kb.command;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

public class FibonacciCommandTest {

    Map<Integer, Integer> fibonacciMap = new HashMap<>();

    @Before
    public void setUp() {
        fibonacciMap.put(37, 14930352);
        fibonacciMap.put(40, 63245986);
        fibonacciMap.put(7, 8);

    }

    @Test
    public void whenNotExecuted_returnNullCommandResult() {
        int param = 5;


        FibonacciCommand sut = new FibonacciCommand(
                FibonacciCommand.createCommandRequest(param)
        );

        CommandResult result = sut.getCommandResult();

        assertNull(result);
    }

    @Test
    public void whenValidInput_returnValidArrays() {
        int param = 9;
        FibonacciCommand sut = new FibonacciCommand(FibonacciCommand.createCommandRequest(param));
        sut.execute();
        CommandResult result = sut.getCommandResult();

        int[] arrayResult = (int[])result.getValue();

        assertEquals(param, arrayResult.length);
        assertEquals(arrayResult[param - 1], arrayResult[param - 2] + arrayResult[param - 3]);

    }

    @Test
    public void whenMultipleCases_returnValidLastElement() {
        for (int key : fibonacciMap.keySet()) {
            FibonacciCommand sut = new FibonacciCommand(
                    FibonacciCommand.createCommandRequest(key)
            );
            sut.execute();

            CommandResult result = sut.getCommandResult();
            int[] arrayResult = (int[])result.getValue();

            assertEquals((int)fibonacciMap.get(key), arrayResult[arrayResult.length - 1]);

        }
    }



    @Test(expected = IllegalArgumentException.class)
    public void whenNegative_throwIllegalArgumentException() {
        int param = -1;

        FibonacciCommand sut = new FibonacciCommand(new FibonacciCommandRequest(param));
        sut.execute();
        CommandResult result = sut.getCommandResult();

        assertNull(result);
    }
}