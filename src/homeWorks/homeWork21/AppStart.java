package homeWorks.homeWork21;

/**
 * Created by Master on 21.09.2016.
 */
public class AppStart {
    public static void main(String[] args) {
        String URL = "jdbc:h2:tcp://localhost/~/test;USER=sa;password=";

        Fibonachiable fibonachi = new FibonachiableImpl();
        Fibonachiable cachedFibonachi = new CachedFibonachiableProxy(fibonachi, URL);

        System.out.println(cachedFibonachi.count(6));
        System.out.println(cachedFibonachi.count(7));
        System.out.println(cachedFibonachi.count(8));
        System.out.println(cachedFibonachi.count(12));
    }
}
