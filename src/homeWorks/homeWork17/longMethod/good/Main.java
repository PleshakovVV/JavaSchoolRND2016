package homeWorks.homeWork17.longMethod.good;

import java.util.Arrays;

/**
 * Created by Master on 07.09.2016.
 */
public class Main {

    private Main() {
        //NOPE
    }

    public static void main(String[] args) {
        Person[] persons = {
                new Person("John Smith", 34),
                new Person("Sarah Connor", 19),
                new Person("Kevin Smith", 45),
                new Person("Christopher Lloyd", 57),
                new Person("Anna Lay", 32)
        };
        System.out.println(Arrays.toString(persons));
        EnhancedBubbleSort.sort(persons);
        System.out.println(Arrays.toString(persons));
    }
}

class EnhancedBubbleSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean wasSwap = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    wasSwap = true;
                    swap(array, j, j + 1);
                }
            }
            if (!wasSwap) break;
        }
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}

class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        if (this.name.compareTo(o.name) == 0) {
            return this.age - o.age;
        }
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        Person other = (Person)obj;
        return this.name.equals(other.name) && (this.age == other.age);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
