package homeWorks.homeWork3.AL_vs_LL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Master on 20.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        int ARRAY_SIZE = 300_000;

        ArrayList<Person> arrayList = new ArrayList<>();
        LinkedList<Person> linkedList = new LinkedList<>();

        System.out.println("Start init");

        Random random = new Random(47);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            Person person = new Person(i, 20_000 + (int)(10_000 * random.nextDouble()));
            arrayList.add(person);
            linkedList.add(person);
        }
        {
            System.out.println("Start testing ArrayList");
            System.out.println("Size of ArrayList before: " + arrayList.size());

            Iterator<Person> iterator = arrayList.iterator();
            long start = System.currentTimeMillis();
            while (iterator.hasNext()) {
                if (iterator.next().getSalary() > 25_000) {
                    iterator.remove();
                }
            }
            System.out.println("Elapsed time is: " + (System.currentTimeMillis() - start) + "ms");
            System.out.println("Size of ArrayList after: " + arrayList.size());
        }
        System.out.println("***************");
        {
            System.out.println("Start testing LinkedList");
            System.out.println("Size of LinkedList before: " + linkedList.size());

            Iterator<Person> iterator = linkedList.iterator();
            long start = System.currentTimeMillis();
            while (iterator.hasNext()) {
                if (iterator.next().getSalary() > 25_000) {
                    iterator.remove();
                }
            }
            System.out.println("Elapsed time is: " + (System.currentTimeMillis() - start) + "ms");
            System.out.println("Size of LinkedList after: " + linkedList.size());
        }
    }
}

class Person {
    private int id;
    private double salary;

    public Person(int id, double salary) {
        this.id = id;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
}