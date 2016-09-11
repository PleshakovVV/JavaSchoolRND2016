package homeWork18.proxy.example1;

/**
 * Created by Master on 11.09.2016.
 */
public class Function implements Evaluatable {

    @Override
    public double evaluate(double arg1, double arg2) {
        return arg1 * Math.sin(arg2 * Math.PI / 4) + arg2 * Math.cos(arg1 * Math.PI / 6);
    }
}
