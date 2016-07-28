package com.sbt.lesson6;

import java.util.Objects;

/**
 * Created by Student on 28.07.2016.
 */
public class Refl1 {
    public static void main(String[] args) {
        Class c = Object.class;
        Class c1 = c.getSuperclass();
        System.out.println(c1);
    }
}
