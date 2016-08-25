package com.sbt.lesson14;

import java.util.HashMap;
import java.util.concurrent.*;

/**
 * Created by Student on 25.08.2016.
 */
public class TaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        System.out.println("Thread Id: " + Thread.currentThread().getId());
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Runnable task = new Task();
//        executorService.submit(task);
//        executorService.shutdown();

//        System.out.println("From main: " + Thread.currentThread().getId());
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
//        scheduledExecutorService.scheduleAtFixedRate(new Task(),0, 5, TimeUnit.SECONDS);
//        try {
//            Thread.sleep(11000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        scheduledExecutorService.shutdown();

//        MyFutureRunnable futureTask = new MyFutureRunnable(new MyCallable());
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.execute(futureTask);
//        if (!futureTask.isDone()) {
//            System.out.println(futureTask.get());
//        }
//        executorService.shutdown();

//        ReadWriteMap<Integer, String> map = new ReadWriteMap<>(new HashMap<Integer, String>());

        final CountDownLatch startLatch = new CountDownLatch(1);
        final CountDownLatch endLatch = new CountDownLatch(4);

    }
}
