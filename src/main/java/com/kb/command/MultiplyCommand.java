package com.kb.command;

public class MultiplyCommand implements Command {
    private double x, y;
    private CommandResult result;

    public MultiplyCommand(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        this.result = new CommandResult(x * y);
    }

    @Override
    public CommandResult getCommandResult() {
        return this.result;
    }
}
