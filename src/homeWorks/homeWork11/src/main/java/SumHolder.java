/**
 * Created by Master on 16.08.2016.
 */
public class SumHolder {
    private volatile int sum = 0;

    public SumHolder(int startSum) {
        this.sum = startSum;
    }

    public SumHolder() {
    }

    public void add(int value) {
        synchronized (this) {
            this.sum += value;
        }
    }

    public int getSum() {
        return sum;
    }
}
