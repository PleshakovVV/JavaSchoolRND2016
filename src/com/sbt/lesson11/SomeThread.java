package com.sbt.lesson11;

/**
 * Created by Student on 15.08.2016.
 */
public class SomeThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            throw new RuntimeException("Exception!");
        }
    }
}
