package com.kb.command;

import com.kb.receiver.MathReceiver;

public class SumCommand implements Command {
    private double x, y;
    private MathReceiver receiver;
    private CommandResult result;

    public SumCommand(MathReceiver receiver, SumCommandRequest commandRequest) {
        this.receiver = receiver;
        this.x = commandRequest.getX();
        this.y = commandRequest.getY();
    }

    private SumCommand() { }

    @Override
    public void execute() {
        this.result = new CommandResult(receiver.sum(this.x, this.y));
    }

    @Override
    public CommandResult getCommandResult() {
        return result;
    }

    public static SumCommandRequest createCommandRequest(double x, double y) {
        return new SumCommandRequest(x, y);
    }

}

class SumCommandRequest {
    private double x;
    private double y;

    SumCommandRequest(double x, double y) {
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
