package com.kb.command;

import com.kb.receiver.MathReceiver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FindPrimeCommand implements Command {
    private int n;
    private MathReceiver receiver;
    private CommandResult result;

    private List<Integer> confirmedPrimes = new ArrayList<>();

    public FindPrimeCommand(MathReceiver receiver, FindPrimeCommandRequest commandRequest) {
        this.receiver = receiver;
        this.n = commandRequest.getN();
    }

    private FindPrimeCommand() { }

    @Override
    public void execute() {
        int[] intArray = receiver.findPrimes(this.n);
        this.result = new CommandResult(intArray);
    }

    @Override
    public CommandResult getCommandResult() {
        return result;
    }

    public static FindPrimeCommandRequest createCommandRequest(int n) {
        return new FindPrimeCommandRequest(n);
    }
}

class FindPrimeCommandRequest {
    private int n;

    public FindPrimeCommandRequest(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid argument: should be positive integer");
        }

        this.n = n;
    }

    public int getN() {
        return n;
    }
}
