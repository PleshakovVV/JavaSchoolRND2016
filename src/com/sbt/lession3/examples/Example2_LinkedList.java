package com.sbt.lession3.examples;

import com.sbt.lession3.Person;
import com.sbt.lession3.PersonFirstLoad;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Student on 19.07.2016.
 */
public class Example2_LinkedList {

    public static void main(String[] args) {
        List<Person> persons = (List)PersonFirstLoad.init(new LinkedList<>());
//        PersonFirstLoad.print(persons);
        System.out.println("*** peek *******");
        LinkedList<Person> personLL = (LinkedList<Person>)persons;

        System.out.println(personLL.peek());
        System.out.println("*****");
        PersonFirstLoad.print(persons);
        System.out.println("**** poll *****");
        for (int i = 0; i < 20; i++) {
            System.out.println(personLL.poll());
        }
        PersonFirstLoad.print(persons);
    }
}
