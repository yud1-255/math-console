package com.kb.command;

import com.kb.receiver.MathReceiver;
import com.kb.receiver.StandardMathReceiver;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

public class FibonacciCommandTest {

    MathReceiver standardMathReceiver;
    @Before
    public void setUp() {
        standardMathReceiver = new StandardMathReceiver();
    }

    @Test
    public void whenNotExecuted_returnNullCommandResult() {
        int param = 5;

        FibonacciCommand sut = new FibonacciCommand(
                standardMathReceiver,
                FibonacciCommand.createCommandRequest(param)
        );

        CommandResult result = sut.getCommandResult();

        assertNull(result);
    }

    @Test
    public void whenExecuted_returnValidCommandResult() {
        int param = 5;

        FibonacciCommand sut = new FibonacciCommand(
                standardMathReceiver,
                FibonacciCommand.createCommandRequest(param)
        );

        sut.execute();
        CommandResult result = sut.getCommandResult();
        int[] arr = (int[])result.getValue();

        assertNotNull(result);
        assertEquals(param, arr.length);
        assertEquals(3, arr[arr.length - 1]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNegative_throwIllegalArgumentException() {
        int param = -1;

        FibonacciCommand sut = new FibonacciCommand(standardMathReceiver, new FibonacciCommandRequest(param));
        sut.execute();
        CommandResult result = sut.getCommandResult();

        assertNull(result);
    }
}