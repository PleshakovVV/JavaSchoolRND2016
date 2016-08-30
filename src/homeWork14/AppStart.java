package homeWork14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Master on 31.07.2016.
 */
public class AppStart {
    public static void main(String[] args) {
        Sinusable cachedSin = ProxyUtils.makeCached(new SinusableImpl());
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 20; i++) {
            executorService.submit(new Task(i/10D, cachedSin));
        }
        Cosinusable cosinusable = (Cosinusable)cachedSin;
        cosinusable.getCos(3D);
    }
}