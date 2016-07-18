package com.sbt.lession3.examples;

import com.sbt.lession3.Person;
import com.sbt.lession3.PersonFirstLoad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 19.07.2016.
 */
public class Example1_ArrayList {

    public static void main(String[] args) {
        List<Person> persons = (List)PersonFirstLoad.init(new ArrayList<>());
        PersonFirstLoad.print(persons);
        System.out.println("****");
        System.out.println(persons.get(10));
        System.out.println("****");

        List<Person> subPerson = persons.subList(10,15);
        PersonFirstLoad.print(subPerson);
        System.out.println(persons.containsAll(subPerson));
        System.out.println("****");
        Person person = new Person(19L,"∆овнир ≈катерина ёрьевна", "79185551210");
        System.out.println(persons.contains(person));
    }
}
