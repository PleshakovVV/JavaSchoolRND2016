package homeWorks.homeWork19.command;

/**
 * Created by Master on 14.09.2016.
 */
public class Sinus implements Command {

    @Override
    public Double execute(Double... args) {
        if ((args != null) && args.length > 0) {
            return Math.sin(args[0]);
        }
        throw new IllegalArgumentException("Argument is null");
    }
}
