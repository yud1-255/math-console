package com.kb.command;

public interface Command<T> {
    void execute();
    CommandResult<T> getCommandResult();
}