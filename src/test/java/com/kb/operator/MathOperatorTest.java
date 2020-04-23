package com.kb.operator;

import com.kb.command.CommandResult;
import com.kb.command.MultiplyCommand;
import com.kb.command.SumCommand;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MathOperatorTest {

    @Test
    public void whenZeroCommandAdded_returnOneCommandList() {
        MathOperator mathOperator = new MathOperator();
        SumCommand sumCommand = new SumCommand(SumCommand.createCommandRequest(3, 4));

        mathOperator.addCommand(sumCommand);

        assertEquals(1, mathOperator.getCommands().size());
    }

    @Test
    public void whenExistingCommandsRemoved_returnWithRemovedLastCommand() {
        MathOperator mathOperator = new MathOperator();
        SumCommand sumCommand = new SumCommand(SumCommand.createCommandRequest(4, 1));
        MultiplyCommand multiplyCommand = new MultiplyCommand(MultiplyCommand.createCommandRequest(2, 3));

        mathOperator.addCommand(sumCommand);
        mathOperator.addCommand(multiplyCommand);

        mathOperator.removeCommand();

        assertEquals(1, mathOperator.getCommands().size());
        assertTrue(mathOperator.getCommands().get(0) instanceof SumCommand);

    }

    @Test
    public void whenZeroCommand_returnNullCommandResult() {
        MathOperator mathOperator = new MathOperator();
        CommandResult commandResult = mathOperator.executeCommand();

        assertNull(commandResult);
    }

    @Test
    public void whenCommandExists_returnValidCommandResult() {
        MathOperator mathOperator = new MathOperator();
        SumCommand sumCommand = new SumCommand(SumCommand.createCommandRequest(-3, 6));
        mathOperator.addCommand(sumCommand);

        CommandResult commandResult = mathOperator.executeCommand();

        assertEquals(3.0, (double)commandResult.getValue(), 1e-8);
    }

    @Test
    public void whenCommandExists_returnSameNumberOfCommandResults() {
        MathOperator mathOperator = new MathOperator();
        SumCommand sumCommand = new SumCommand(SumCommand.createCommandRequest(1, 8));
        MultiplyCommand multiplyCommand = new MultiplyCommand(MultiplyCommand.createCommandRequest(2, 7));

        mathOperator.addCommand(sumCommand);
        mathOperator.addCommand(multiplyCommand);

        List<CommandResult> results = mathOperator.executeAll();
        assertEquals(2, results.size());
    }
}