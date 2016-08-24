package homeWork13.task1;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

/**
 * Created by Master on 24.08.2016.
 */
public class Task<T> {

    private final Callable<? extends T> callable;
    private T result;
    private RuntimeException e;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() throws Exception{
        if (e != null) {
            System.out.println("Exception from cache.");
            throw e;
        }
        if (result == null) {
            synchronized (callable) {
                if (result == null) {
                    try {
                        result = callable.call();
                        System.out.println("Return new result.");
                        return result;
                    }
                    catch (Exception e) {
                        RuntimeException runtimeException = new RuntimeException(e);
                        this.e = runtimeException;
                        throw e;
                    }
                }
                else {
                    if (e != null) {
                        System.out.println("New exception throwing.");
                        throw e;
                    }
                }
            }
        }
        System.out.println("Result from cache.");
        return result;
    }
}
