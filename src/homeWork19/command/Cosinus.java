package homeWork19.command;

/**
 * Created by Master on 14.09.2016.
 */
public class Cosinus implements Command {

    @Override
    public Double execute(Double... args) {
        if ((args != null) && args.length > 0) {
            return Math.cos(args[0]);
        }
        throw new IllegalArgumentException("Argument is null");
    }
}
