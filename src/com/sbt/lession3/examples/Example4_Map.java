package com.sbt.lession3.examples;

import com.sbt.lession3.Person;
import com.sbt.lession3.PersonFirstLoad;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Student on 18.07.2016.
 */
public class Example4_Map {
    public static void main(String[] args) {
        Map<String, Person> map = PersonFirstLoad.init(new HashMap<String, Person>());
        PersonFirstLoad.print(map);
        System.out.println(map.size());
    }
}
