package com.kb.command;

public class SumCommand implements Command {
    private double x, y;
    private CommandResult result;

    public SumCommand(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        this.result = new CommandResult(x + y);
    }

    @Override
    public CommandResult getCommandResult() {
        return result;
    }

}
