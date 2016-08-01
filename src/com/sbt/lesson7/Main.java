package com.sbt.lesson7;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

/**
 * Created by Student on 01.08.2016.
 */
public class Main {
    public static void main(String[] args) throws Exception{
//        for (int i = 0; i < 100_000_000; i++) {
//            new URLClassLoader(new URL[]{new URL("file:/J:/lecture7/person.jar")},null);
//        }
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL("file:/J:/lecture7/person.jar")},null);

        Class<?> calcClass = urlClassLoader.loadClass("ru.sbt.bvv.lecture7.CalculatorImpl");
//
//        Method method = persClass.getMethod("info");
//        method.invoke(persClass.newInstance());
        Calculator calculator = new CalculatorImpl();
        System.out.println("Interfaces: ");
        System.out.println(Arrays.toString(calculator.getClass().getInterfaces()));
        calculator.calc();
        Class cl = calcClass;
        System.out.println("Interfaces from URL: ");
        System.out.println(Arrays.toString(cl.getInterfaces()));
//        calculator.calc();
    }
}
