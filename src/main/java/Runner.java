import com.kb.command.*;
import com.kb.operator.MathOperator;
import com.kb.receiver.StandardMathReceiver;

import java.util.List;

public class Runner {
    public static void main(String[] argv) {
        System.out.println("Hello World!");
        System.out.println();

        StandardMathReceiver standardMathReceiver = new StandardMathReceiver();

        System.out.println("Created SumCommand: (x = 2, y = 3)");
        SumCommand sumCommand = new SumCommand(
                standardMathReceiver,
                SumCommand.createCommandRequest(2, 3)
        );

        System.out.println("Created MultiplyCommand: (x = 5, y = 3)");
        MultiplyCommand multiplyCommand = new MultiplyCommand(
                standardMathReceiver,
                MultiplyCommand.createCommandRequest(5, 3)
        );

        System.out.println("Created FibonacciCommand: (n = 7)");
        FibonacciCommand fibonacciCommand = new FibonacciCommand(
                standardMathReceiver,
                FibonacciCommand.createCommandRequest(7)
        );

        System.out.println("Created PrimeCommand: (n = 5)");
        FindPrimeCommand findPrimeCommand = new FindPrimeCommand(
                new StandardMathReceiver(),
                FindPrimeCommand.createCommandRequest(5)
        );

        MathOperator ops = new MathOperator();
        ops.addCommand(sumCommand);
        ops.addCommand(multiplyCommand);
        ops.addCommand(fibonacciCommand);
        ops.addCommand(findPrimeCommand);

        System.out.println();

        CommandResult result = ops.executeCommand();
        System.out.println("SumCommand result: " + result.getValue());

        result = ops.executeCommand();
        System.out.println("MultiplyCommand result: " + result.getValue());

        result = ops.executeCommand();
        System.out.print("FibonacciCommand result: [");
        for (int num : (int[])result.getValue()) {
            System.out.print(num + " ");
        }
        System.out.print("]\n");

        result = ops.executeCommand();
        System.out.print("FindPrimeCommand result: [");
        for (int num : (int[])result.getValue()) {
            System.out.print(num + " ");
        }
        System.out.print("]\n");

    }
}
