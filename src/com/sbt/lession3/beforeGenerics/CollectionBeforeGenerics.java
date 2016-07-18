package com.sbt.lession3.beforeGenerics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 19.07.2016.
 */
public class CollectionBeforeGenerics {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList();

        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(apples.get(i).getId());
        }
    }
}
