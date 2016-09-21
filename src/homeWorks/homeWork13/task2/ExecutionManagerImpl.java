package homeWorks.homeWork13.task2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Master on 24.08.2016.
 */
public class ExecutionManagerImpl implements ExecutionManager {

    private final Queue<Runnable> tasks = new LinkedList<>();
    private int numberOfTasks;
    Thread[] threads = new Thread[Runtime.getRuntime().availableProcessors()];
    private final CounterWrapper counterWrapper = new CounterWrapper();
    Runnable callback;

    private class CounterWrapper {
        public volatile int complitedTasks = 0;
        public volatile int failedTasks = 0;
        public volatile int endThreadsNumber = 0;
    }

    private class ContextImpl implements Context {
        private boolean finished = false;

        @Override
        public int getComplitedTaskCount() {
            return counterWrapper.complitedTasks;
        }

        @Override
        public int getFailedTaskCount() {
            return counterWrapper.failedTasks;
        }

        @Override
        public int getInterruptedTaskCount() {
            return numberOfTasks - counterWrapper.complitedTasks - counterWrapper.failedTasks;
        }

        @Override
        public void interrupt() {
            for (int i = 0; i < threads.length; i++) {
                threads[i].interrupt();
            }
        }

        @Override
        public boolean isFinished() {
            return (threads.length - counterWrapper.endThreadsNumber) == 0;
        }
    }

    private class ThreadWorker extends Thread{

        Runnable task;

        @Override
        public void run() {
            while (!isInterrupted() && !tasks.isEmpty()) {
                synchronized (tasks) {
                    if (!tasks.isEmpty()) {
                        task = tasks.poll();
                    }
                    else {
                        task = null;
                    }
                }
                if (task != null) {
                    try {
                        task.run();
                        synchronized (counterWrapper) {
                            counterWrapper.complitedTasks++;
                        }
                    } catch (RuntimeException e) {
                        synchronized (counterWrapper) {
                            if (e.getCause() instanceof InterruptedException) {
                                interrupt();
                            }
                            counterWrapper.failedTasks++;
                        }
                    }
                }
            }
            synchronized (counterWrapper) {
                counterWrapper.endThreadsNumber++;
            }
            synchronized (ExecutionManagerImpl.this) {
                ExecutionManagerImpl.this.notify();
            }
            System.out.println(Thread.currentThread().getName() + " is end.");
        }
    }

    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
        this.tasks.addAll(Arrays.asList(tasks));
        this.callback = callback;

        numberOfTasks = tasks.length;
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new ThreadWorker();
            threads[i].start();
        }

        final Context context = new ContextImpl();
        new Thread(() -> {
            synchronized (ExecutionManagerImpl.this) {
                while (!context.isFinished()) {
                    try {
                        ExecutionManagerImpl.this.wait();
                        System.out.println("Check end of tasks...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            callback.run();
            System.out.println(Thread.currentThread().getName() + " is end.");
        }).start();

        return context;
    }
}
