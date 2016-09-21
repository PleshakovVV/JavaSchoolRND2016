package homeWorks.homeWork18.proxy.example1;

/**
 * Created by Master on 11.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        Evaluatable evaluatable = new SynchronizedProxy();
        System.out.println(evaluatable.evaluate(6,4));
    }
}
