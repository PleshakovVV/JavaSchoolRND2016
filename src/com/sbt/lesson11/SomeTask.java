package com.sbt.lesson11;

/**
 * Created by Student on 15.08.2016.
 */
public class SomeTask implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                System.err.println("Now i'm sleep...");
                Thread.sleep(5000);
                System.err.println(Thread.currentThread().getName() + "(" + i + ")");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SomeTask someTask = new SomeTask();

        for (int i = 0; i < 5; i++) {
            new Thread(someTask).start();
        }

        System.out.println("End of main program");

    }
}