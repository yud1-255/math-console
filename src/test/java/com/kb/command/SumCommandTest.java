package com.kb.command;

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

        SumCommand sut = new SumCommand(param1, param2);
        CommandResult result = sut.getCommandResult();

        assertNull(result);
    }

    @Test
    public void whenExecuted_returnValidCommandResult() {
        double param1 = positiveNumbers[0], param2 = negativeNumbers[2];
        double expected = param1 + param2;

        SumCommand sut = new SumCommand(param1, param2);
        sut.execute();
        CommandResult result = sut.getCommandResult();

        assertNotNull(result);
        assertTrue(result.getValue() instanceof  Double);
        assertEquals(expected, result.getValue());
    }

    @Test
    public void whenSameNumbers_returnTwoTimesOfInput() {
        double param1 = positiveNumbers[0], param2 = positiveNumbers[0];
        double expected = param1 * 2;

        SumCommand sut = new SumCommand(param1, param2);
        sut.execute();
        CommandResult result = sut.getCommandResult();

        assertNotNull(result);
        assertTrue(result.getValue() instanceof  Double);
        assertEquals(expected, result.getValue());
    }

}