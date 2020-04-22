package com.kb.command;

public class FibonacciCommand implements Command {
    private int n;
    private CommandResult result;

    public FibonacciCommand(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid argument: should be positive integer");
        }

        this.n = n;
    }

    private int[] findFibonacci(int n) {
        /* implementation note: we can use recursive calls, but using memoization with array is simpler */

        int[] fib = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                fib[i] = 0;
            } else if (i == 1) {
                fib[i] = 1;
            } else {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }

        return fib;
    }

    @Override
    public void execute() {
        this.result = new CommandResult(findFibonacci(n));
    }

    @Override
    public CommandResult getCommandResult() {
        return result;
    }

}
