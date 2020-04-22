package com.kb.operator;

import com.kb.command.Command;
import com.kb.command.CommandResult;

import java.util.List;

public interface CommandOperator {
    void addCommand(Command command);
    void removeCommand();

    List<Command> getCommands();

    CommandResult executeCommand();
    List<CommandResult> executeAll();
}
