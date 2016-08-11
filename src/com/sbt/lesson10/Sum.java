package com.sbt.lesson10;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Student on 11.08.2016.
 */
public class Sum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,4,3,2,2,9);
        int sum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }
}
