package com.sbt.lesson4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Student on 21.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        List<? super Number> list = new ArrayList<>();
        list.add(new Integer(2323));
        list.add(new Double(34D));
//        Number n = list.get(0);
        System.out.println(list.get(1));
    }
}
