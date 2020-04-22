package com.kb.operator;

import com.kb.command.Command;
import com.kb.command.CommandResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MathOperator implements CommandOperator {
    private List<Command> commands = new ArrayList<>();

    @Override
    public void addCommand(Command command) {
        commands.add(command);
    }

    @Override
    public void removeCommand() {
        if (commands.size() > 0) {
            commands.remove(commands.size() - 1);
        }
    }

    @Override
    public List<Command> getCommands() {
        return Collections.unmodifiableList(this.commands);
    }

    @Override
    public CommandResult executeCommand() {

        if (commands.size() > 0) {
            Command commandToExecute  = commands.get(0);
            commandToExecute.execute();

            CommandResult commandResult = commandToExecute.getCommandResult();

            commands.remove(commandToExecute);

            return commandResult;
        }

        return null;
    }

    @Override
    public List<CommandResult> executeAll() {
        Iterator<Command> itr = commands.iterator();
        List<CommandResult> commandResults = new ArrayList<>();

        while (itr.hasNext()) {
            Command c = itr.next();
            c.execute();

            commandResults.add(c.getCommandResult());
        }

        commands.clear();

        return commandResults;
    }
}
