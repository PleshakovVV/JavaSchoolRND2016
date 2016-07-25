package com.sbt.lesson5;

/**
 * Created by Student on 25.07.2016.
 */
public class StackOverflowTest {
    static int counter = 0;
    public static void main(String[] args) {
        System.out.println(counter++);
        main(args);
    }
}
