import com.kb.command.*;
import com.kb.operator.MathOperator;

import java.util.List;

public class Runner {
    public static void main(String[] argv) {
        System.out.println("Hello World!");

        //SumCommand sumCommand = new SumCommand(2, 3);
        SumCommand sumCommand = new SumCommand(
                SumCommand.createCommandRequest(2, 3)
        );

        FibonacciCommand fibonacciCommand = new FibonacciCommand(
                FibonacciCommand.createCommandRequest(7)
        );

        MathOperator ops = new MathOperator();
        ops.addCommand(sumCommand);
        ops.addCommand(fibonacciCommand);

        List<CommandResult> results = ops.executeAll();

        for (CommandResult result : results) {
            if (result.getValue() instanceof Double) {
                System.out.println(result.getValue());
            } else if (result.getValue() instanceof int[]) {
                for (int num : (int[])result.getValue()) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }

    }
}
