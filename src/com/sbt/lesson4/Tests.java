package com.sbt.lesson4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Master on 23.07.2016.
 */
public class Tests {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
//        list = list1;
        list.add("123");
        System.out.println(list.get(0).getClass());
    }
}
