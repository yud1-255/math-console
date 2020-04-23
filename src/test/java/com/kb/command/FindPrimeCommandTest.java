package com.kb.command;

import com.kb.receiver.MathReceiver;
import com.kb.receiver.StandardMathReceiver;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FindPrimeCommandTest {
    @Test
    public void whenNotExecuted_returnNullCommandResult() {
        int param = 3;
        MathReceiver standardMathReceiver = new StandardMathReceiver();

        FindPrimeCommand sut = new FindPrimeCommand(
                standardMathReceiver,
                FindPrimeCommand.createCommandRequest(param)
        );

        CommandResult result = sut.getCommandResult();

        assertNull(result);
    }

    @Test
    public void whenExecuted_returnValidCommandResult() {
        int param = 4;
        MathReceiver standardMathReceiver = new StandardMathReceiver();

        FindPrimeCommand sut = new FindPrimeCommand(
                standardMathReceiver,
                FindPrimeCommand.createCommandRequest(param)
        );
        sut.execute();

        CommandResult result = sut.getCommandResult();
        int[] arr = (int[])result.getValue();

        assertNotNull(result);
        assertEquals(param, arr.length);
        assertEquals(7, arr[arr.length - 1]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNegative_throwIllegalArgumentException() {
        MathReceiver standardMathReceiver = new StandardMathReceiver();
        int param = -1;

        FindPrimeCommand sut = new FindPrimeCommand(
                standardMathReceiver,
                FindPrimeCommand.createCommandRequest(param));
        sut.execute();
        CommandResult result = sut.getCommandResult();

        assertNull(result);
    }
}