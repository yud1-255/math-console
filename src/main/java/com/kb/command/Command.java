package com.kb.command;

public interface Command {
    void execute();
    CommandResult getCommandResult();
}