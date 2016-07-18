package com.sbt.lession3.beforeGenerics;

/**
 * Created by Student on 19.07.2016.
 */
public class Apple {
    final Long id = counter++;

    static Long counter = new Long(0L);

    public Long getId() {
        return id;
    }
}
