package com.sbt.lesson5;

/**
 * Created by Student on 25.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        a();
    }

    private static void a() {
        b();
    }
    private static void b() {
        c();
    }
    private static void c() {
        int x = 1;
        int y = 0;
        System.out.println(x/y);
    }
}
