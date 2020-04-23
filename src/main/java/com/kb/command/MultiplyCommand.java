package com.kb.command;

import com.kb.receiver.MathReceiver;

public class MultiplyCommand implements Command {
    private double x, y;
    private MathReceiver receiver;
    private CommandResult result;

    public MultiplyCommand(MathReceiver receiver, MultiplyCommandRequest commandRequest) {
        this.receiver = receiver;
        this.x = commandRequest.getX();
        this.y = commandRequest.getY();
    }

    private MultiplyCommand() { }

    @Override
    public void execute() {
        this.result = new CommandResult(receiver.multiply(this.x, this.y));
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
