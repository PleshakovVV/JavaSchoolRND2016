package homeWork19.command;

/**
 * Created by Master on 14.09.2016.
 */
public class Evaluator {
    private final Command command;

    public Evaluator(Command command) {
        this.command = command;
    }

    public Double evaluate(Double... args) {
        return command.execute(args);
    }
}
