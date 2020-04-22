package com.kb.operator;

import com.kb.command.Command;

import java.util.List;

public interface CommandOperator {
    void addCommand();
    void removeCommand();

    void executeCommand();
    void executeAll();
}
