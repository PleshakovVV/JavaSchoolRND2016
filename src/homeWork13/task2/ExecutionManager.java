package homeWork13.task2;

/**
 * Created by Master on 24.08.2016.
 */
public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}
