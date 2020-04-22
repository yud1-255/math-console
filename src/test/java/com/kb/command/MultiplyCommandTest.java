package com.kb.command;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class MultiplyCommandTest {
    double[] positiveNumbers;
    double[] negativeNumbers;

    @Before
    public void setUp() {
        positiveNumbers = new double[] { 21, 32, 66, 123, 9 };
        negativeNumbers = new double[] { -1, -6, -91, -8, -102 };
    }

    @Test
    public void whenNotExecuted_returnNullCommandResult() {
        int posIdx = new Random().nextInt(positiveNumbers.length);
        int negIdx = new Random().nextInt(negativeNumbers.length);

        double param1 = positiveNumbers[posIdx];
        double param2 = negativeNumbers[negIdx];

        MultiplyCommand sut = new MultiplyCommand(param1, param2);
        CommandResult result = sut.getCommandResult();

        assertNull(result);
    }

    @Test
    public void whenExecuted_returnValidCommandResult() {

        double param1 = positiveNumbers[new Random().nextInt(positiveNumbers.length)];
        double param2 = negativeNumbers[new Random().nextInt(negativeNumbers.length)];

        MultiplyCommand sut = new MultiplyCommand(param1, param2);
        sut.execute();
        CommandResult result = sut.getCommandResult();

        double expected = param1 * param2;

        assertNotNull(result);
        assertTrue(result.getValue() instanceof  Double);
        assertEquals(expected, result.getValue());
    }

    @Test
    public void whenPositiveAndPositive_returnPositiveCommandResult() {

        double param1 = positiveNumbers[new Random().nextInt(positiveNumbers.length)];
        double param2 = positiveNumbers[new Random().nextInt(positiveNumbers.length)];

        MultiplyCommand sut = new MultiplyCommand(param1, param2);
        sut.execute();
        CommandResult result = sut.getCommandResult();

        assertNotNull(result);
        assertTrue((double)result.getValue() > 0);
    }

    @Test
    public void whenPositiveAndNegative_returnNegativeCommandResult() {

        double param1 = positiveNumbers[new Random().nextInt(positiveNumbers.length)];
        double param2 = negativeNumbers[new Random().nextInt(negativeNumbers.length)];

        MultiplyCommand sut = new MultiplyCommand(param1, param2);
        sut.execute();
        CommandResult result = sut.getCommandResult();

        assertNotNull(result);
        assertTrue((double)result.getValue() < 0);
    }

    @Test
    public void whenZero_returnZeroCommandResult() {
        double param1 = 0;
        double param2 = new Random().nextDouble();

        MultiplyCommand sut = new MultiplyCommand(param1, param2);
        sut.execute();
        CommandResult result = sut.getCommandResult();

        assertNotNull(result);
        assertEquals(0, (double)result.getValue(), 1e-8);

    }
}