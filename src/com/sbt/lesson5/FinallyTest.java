package com.sbt.lesson5;

/**
 * Created by Student on 25.07.2016.
 */
public class FinallyTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.currentThread().sleep(1000);
                        System.out.println("I'm awake");
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        int a = 1/0;
    }

}
