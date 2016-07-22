package com.sbt.lesson4;

/**
 * Created by Student on 21.07.2016.
 */
public class OverrideMethod {

    public static <T> String getType(T t) {
        return t.getClass().getTypeName();
    }
}
