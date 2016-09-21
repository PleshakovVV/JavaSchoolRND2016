package homeWorks.homeWork14;

/**
 * Created by Master on 30.08.2016.
 */
public class Task implements Runnable {

    private Sinusable sinusable;
    private final double arg;

    public Task(double arg, Sinusable sinusable) {
        this.arg = arg;
        this.sinusable = sinusable;
    }

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sinusable.getSin(arg));
    }
}
