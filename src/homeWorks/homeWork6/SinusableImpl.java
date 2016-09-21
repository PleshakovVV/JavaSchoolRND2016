package homeWorks.homeWork6;

/**
 * Created by Master on 31.07.2016.
 */
public class SinusableImpl implements Sinusable, Cosinusable {
    @Override
    public double getSin(Double arg) {
        return Math.sin(arg);
    }

    @Override
    public Double getCos(Double arg) {
        return Math.cos(arg);
    }
}
