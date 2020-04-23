package com.kb.command;

import com.kb.receiver.MathReceiver;
import com.kb.receiver.StandardMathReceiver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SumCommandTest {
    double[] positiveNumbers;
    double[] negativeNumbers;

    @Before
    public void setUp() {
        positiveNumbers = new double[] { 21, 32, 66, 123, 9 };
        negativeNumbers = new double[] { -1, -6, -91, -8, -102 };
    }

    @Test
    public void whenNotExecuted_returnNullCommandResult() {
        double param1 = positiveNumbers[3], param2 = positiveNumbers[1];
        MathReceiver standardMathReceiver = new StandardMathReceiver();

        SumCommand sut = new SumCommand(
                standardMathReceiver,
                SumCommand.createCommandRequest(param1, param2)
        );

        CommandResult result = sut.getCommandResult();

        assertNull(result);
    }

    @Test
    public void whenExecuted_returnValidCommandResult() {
        double param1 = positiveNumbers[3], param2 = positiveNumbers[1];
        MathReceiver standardMathReceiver = new StandardMathReceiver();

        SumCommand sut = new SumCommand(
                standardMathReceiver,
                SumCommand.createCommandRequest(param1, param2)
        );
        sut.execute();

        CommandResult result = sut.getCommandResult();

        assertNotNull(result);
        assertEquals(param1 + param2, (double)result.getValue(), 1e-8);
    }

}