import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;

/**
 * Created by Master on 21.08.2016.
 */
public class ThreadPool {

    private Queue<Runnable> taskQueue = new LinkedList<>();
    private Thread[] threads;

    private class ThreadWorker extends Thread {
        @Override
        public void run() {
            while (!interrupted()) {
                Runnable runnable;
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty()) {
                        try {
                            taskQueue.wait();
                        } catch (InterruptedException e) {
                            interrupt();
                        }
                    }
                    runnable = taskQueue.poll();
                }
                runnable.run();
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void initThread(int threadNumber) {
        if (threadNumber > 0) {
            threads = new Thread[threadNumber];
            for (int i = 0; i < threadNumber; i++) {
                threads[i] = new ThreadWorker();
                threads[i].start();
            }
        }
        else {
            throw new IllegalArgumentException("Number of thread must be more than zero.");
        }
    }

    public ThreadPool(int threadNumber) {
        initThread(threadNumber);
    }

    public ThreadPool(File file) {
        try (FileReader FR = new FileReader(file)) {
            Properties properties = new Properties();
            properties.load(FR);
            initThread(Integer.parseInt(properties.getProperty("NumberOfThreads")));
        }
        catch (IOException |NumberFormatException e) {
            System.out.println("Cannot read properties from a file: " + file.getAbsolutePath());
            System.out.println("Exception is: " + e.getMessage() + " Cause is: " + e.getCause());
            int numberOfProcessor = Runtime.getRuntime().availableProcessors();
            initThread(numberOfProcessor);
            System.out.println("Set Number of thread to: " + numberOfProcessor);
        }
    }

    public void addTask(Runnable task) {
        if (task != null) {
            synchronized (taskQueue) {
                taskQueue.add(task);
                taskQueue.notify();
            }
        }
    }

    public int getThreadNumber() {
        return threads.length;
    }
}
