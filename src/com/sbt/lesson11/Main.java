package com.sbt.lesson11;

/**
 * Created by Student on 15.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Start");
        SomeThread someThread = new SomeThread();
        someThread.setUncaughtExceptionHandler((t1,e) ->
                System.out.println("From thread: " + t1.getName() + " Exception: " + e.getMessage()));
        someThread.start();
        System.out.println("End of program");
    }
}
