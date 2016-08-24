package homeWork13.task2;

import java.util.concurrent.Callable;

/**
 * Created by Master on 24.08.2016.
 */
public class AppStart {
    public static void main(String[] args) {
        ExecutionManager executionManager = new ExecutionManagerImpl();
        Runnable runnable = new Runnable() {
            @Override
            public void run(){
                System.out.printf("Execution Callback.");
            }
        };

        Runnable[] runnables = new Runnable[17];
        for (int i = 0; i < runnables.length; i++) {
            final int num = i;
            runnables[i] = new Runnable() {
                @Override
                public void run() {
                    if (num % 5 == 0) {
                        throw new RuntimeException("Exception!");
                    }
                    System.out.println("Executing task #" + num);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException("Interrupted exception occur", e);
                    }
                }
            };
        }

        Context context = executionManager.execute(runnable, runnables);

        while (!context.isFinished()) {
            try {
                Thread.sleep(1500);
                context.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Complited tasks: " + context.getComplitedTaskCount());
        System.out.println("Failed tasks: " + context.getFailedTaskCount());
        System.out.println("Interrupted tasks: " + context.getInterruptedTaskCount());
    }
}
