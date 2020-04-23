package com.kb.command;

public class MultiplyCommand implements Command {
    private double x, y;
    private CommandResult result;

    public MultiplyCommand(MultiplyCommandRequest commandRequest) {
        this.x = commandRequest.getX();
        this.y = commandRequest.getY();
    }

    @Override
    public void execute() {
        this.result = new CommandResult(x * y);
    }

    @Override
    public CommandResult getCommandResult() {
        return this.result;
    }

    public static MultiplyCommandRequest createCommandRequest(double x, double y) {
        return new MultiplyCommandRequest(x, y);
    }
}

class MultiplyCommandRequest {
    private double x, y;

    public MultiplyCommandRequest(double x, double y) {
        this.x = x;
        this.y = y;

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
