package homeWorks.homeWork13.task2;

/**
 * Created by Master on 24.08.2016.
 */
public interface Context {
    int getComplitedTaskCount();
    int getFailedTaskCount();
    int getInterruptedTaskCount();
    void interrupt();
    boolean isFinished();
}
