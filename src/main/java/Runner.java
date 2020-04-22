import com.kb.command.CommandResult;
import com.kb.command.FibonacciCommand;
import com.kb.command.FindPrimeCommand;
import com.kb.command.SumCommand;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] argv) {
//        System.out.println("Hello World!");
//
//        SumCommand sumCommand = new SumCommand(2, 3);
//
//        sumCommand.execute();
//        CommandResult result = sumCommand.getCommandResult();
//
        FibonacciCommand fibonacciCommand = new FibonacciCommand(7);
        fibonacciCommand.execute();
        CommandResult result = fibonacciCommand.getCommandResult();

        if (result.getValue() instanceof int[]) {
            for (int num : (int[])result.getValue()) {
                System.out.print(num + " ");
            }
        }

        System.out.println(result.getValue());

//        FindPrimeCommand findPrimeCommand = new FindPrimeCommand(8);
//        findPrimeCommand.execute();
    }
}
