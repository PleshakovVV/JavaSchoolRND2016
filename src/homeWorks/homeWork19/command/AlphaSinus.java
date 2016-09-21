package homeWorks.homeWork19.command;

/**
 * Created by Master on 14.09.2016.
 */
public class AlphaSinus implements Command{

    @Override
    public Double execute(Double... args) {
        if ((args != null) && (args.length >=2)) {
            return args[0] * Math.sin(args[1]);
        }
        throw new IllegalArgumentException("Argument is null or less than 2");
    }
}
