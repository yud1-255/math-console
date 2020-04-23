package com.kb.command;

import com.kb.receiver.MathReceiver;

public class FibonacciCommand implements Command {
    private int n;
    MathReceiver receiver;
    private CommandResult result;

    public FibonacciCommand(MathReceiver receiver, FibonacciCommandRequest commandRequest) {
        this.receiver = receiver;
        this.n = commandRequest.getN();
    }

    private FibonacciCommand() { }

    @Override
    public void execute() {
        this.result = new CommandResult(receiver.findFibonacci(n));
    }

    @Override
    public CommandResult getCommandResult() {
        return result;
    }

    public static FibonacciCommandRequest createCommandRequest(int n) {
        return new FibonacciCommandRequest(n);
    }

}

class FibonacciCommandRequest {
    private int n;

    public FibonacciCommandRequest(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid argument: should be positive integer");
        }

        this.n = n;
    }

    public int getN() {
        return n;
    }
}
