package com.sbt.lesson6;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * Created by Student on 28.07.2016.
 */
public class Reflection {
    public static void main(String[] args) {
//        Class cl = new A().getClass();
//        Arrays.asList(cl.getMethods()).forEach(System.out::println);
        try {
            System.out.println("Start");

            A a = A.class.newInstance();

            Field field = A.class.getDeclaredField("finalString");
            field.setAccessible(true);
            field.set(a, "22");
            System.out.println(field.get(a));
            a.someMethod();

            Method m = I.class.getMethod("someMethod", String.class);
            m.invoke(a, "Hi");
        }
        catch (Exception e) {
            System.out.println("No such method!");
            System.out.println(e.getMessage());
        }

    }
}

class A implements I{
    public int i;

    private final String finalString = "11";

    public A(int i) {
        this.i = i;
    }

    public A() {
    }

    public void pA(String str) {
        System.out.println("From A: " + str);
    }

    public void someMethod() {
        System.out.println(finalString);
    }
}
