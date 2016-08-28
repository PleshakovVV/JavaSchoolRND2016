package homeWork14;

/**
 * Created by Master on 31.07.2016.
 */
public class AppStart {
    public static void main(String[] args) {
        Sinusable cachedSin = ProxyUtils.makeCached(new SinusableImpl());
        cachedSin.getSin(5D);
        cachedSin.getSin(5D);
        cachedSin.getSin(4D);
        Cosinusable cosinusable = (Cosinusable)cachedSin;
        cosinusable.getCos(3D);
    }
}