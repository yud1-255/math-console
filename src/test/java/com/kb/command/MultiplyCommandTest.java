package com.kb.command;

import com.kb.receiver.MathReceiver;
import com.kb.receiver.StandardMathReceiver;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class MultiplyCommandTest {

    MathReceiver standardMathReceiver;
    double[] positiveNumbers;
    double[] negativeNumbers;

    @Before
    public void setUp() {
        standardMathReceiver = new StandardMathReceiver();
        positiveNumbers = new double[] { 21, 32, 66, 123, 9 };
        negativeNumbers = new double[] { -1, -6, -91, -8, -102 };
    }

    @Test
    public void whenNotExecuted_returnNullCommandResult() {
        int posIdx = new Random().nextInt(positiveNumbers.length);
        int negIdx = new Random().nextInt(negativeNumbers.length);

        double param1 = positiveNumbers[posIdx];
        double param2 = negativeNumbers[negIdx];

        MultiplyCommand sut = new MultiplyCommand(standardMathReceiver, MultiplyCommand.createCommandRequest(param1, param2));
        CommandResult result = sut.getCommandResult();

        assertNull(result);
    }

    @Test
    public void whenExecuted_returnValidCommandResult() {

        double param1 = positiveNumbers[new Random().nextInt(positiveNumbers.length)];
        double param2 = negativeNumbers[new Random().nextInt(negativeNumbers.length)];

        MultiplyCommand sut = new MultiplyCommand(standardMathReceiver, MultiplyCommand.createCommandRequest(param1, param2));
        sut.execute();
        CommandResult result = sut.getCommandResult();

        double expected = param1 * param2;

        assertNotNull(result);
        assertTrue(result.getValue() instanceof  Double);
        assertEquals(expected, result.getValue());
    }

}