package com.kb.command;

public class CommandResult {
    private Object value;
    public CommandResult(Object value) {
        this.value = value;
    }
    public Object getValue() {
        return this.value;
    }
}