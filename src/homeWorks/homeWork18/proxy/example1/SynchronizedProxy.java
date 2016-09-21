package homeWorks.homeWork18.proxy.example1;

/**
 * Created by Master on 11.09.2016.
 */
public class SynchronizedProxy implements Evaluatable {
    private Evaluatable evaluatable;

    @Override
    public synchronized double evaluate(double arg1, double arg2) {
        if (evaluatable == null) {
            evaluatable = new Function();
        }

        return evaluatable.evaluate(arg1, arg2);
    }
}
