package com.kb.command;

public class SumCommand implements Command {
    private double x, y;
    private CommandResult result;

    public SumCommand(SumCommandRequest commandRequest) {
        this.x = commandRequest.getX();
        this.y = commandRequest.getY();
    }

    @Override
    public void execute() {
        this.result = new CommandResult(x + y);
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
