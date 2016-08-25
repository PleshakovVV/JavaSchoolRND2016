package com.sbt.lesson14;

import java.util.concurrent.Callable;

/**
 * Created by Student on 25.08.2016.
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "" + Thread.currentThread().getId();
    }
}
