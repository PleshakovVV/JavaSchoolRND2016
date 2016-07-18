package com.sbt.lession3.examples;

import com.sbt.lession3.Person;
import com.sbt.lession3.PersonFirstLoad;

import java.util.TreeSet;
import java.util.Set;

/**
 * Created by Student on 18.07.2016.
 */
public class Example3_Set {
    public static void main(String[] args) {
//        Set<Person> persons = new HashSet<>();
        Set<Person> persons = new TreeSet<>();
        persons = (Set)PersonFirstLoad.init(persons);
        System.out.println(persons.size());
        PersonFirstLoad.print(persons);
    }
}
