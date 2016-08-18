package com.sbt.lesson11_2;

import java.util.Date;

/**
 * Created by Student on 18.08.2016.
 */
public class Main {
    public static void main(String[] args) {

//        Square square = new Square(10,5,5);
//        Thread thread1 = new Thread(square);
//        Thread thread2 = new Thread(square);
//
//        thread1.start();
//        thread2.start();

//        Test test = new Test();
//        Thread thread1 = new Thread(test);
//
//
//        thread1.start();
//
//        thread1.interrupt();
//        try {
//            Thread.sleep(5);
//        } catch (InterruptedException e) {
//            //
//        }
//        System.out.println("Awake");
//        test.end();
//        System.out.println("End of main");


//        Date date1 = new Date();
//        Man man = new Man("Mike", date1);
//        date1.setTime(1);

        MonitorExample monitorExample = new MonitorExample();

        Thread thread = new Thread(monitorExample);
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitorExample.sendMessage("Hi!");
    }
}
