package com.sbt.lession3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Student on 19.07.2016.
 */
public class PersonFirstLoad {
    public static Collection<Person> init(Collection<Person> persons) {

        persons.add(new Person(1L,"����� ���� ���������","79185551234"));
        persons.add(new Person(2L,"������� ����� ���������","79185551233"));
        persons.add(new Person(3L,"����������� ������ ������������","79185551232"));
        persons.add(new Person(5L,"������� ������ ���� ����","79185551231"));
        persons.add(new Person(4L,"����� ����� ���������","79185551230"));
        persons.add(new Person(6L,"��������� ������� ����������","79185551229"));
        persons.add(new Person(7L,"������ ���� �����������","79185551228"));
        persons.add(new Person(8L,"�������� ��������� ���������","79185551227"));
        persons.add(new Person(9L,"������� ����� ����������","79185551226"));
        persons.add(new Person(10L,"���������� ��������� ��������","79185551225"));
        persons.add(new Person(11L,"������� �������� �����������","79185551224"));
        persons.add(new Person(12L,"���������� ������ ���������","79185551223"));
        persons.add(new Person(12L,"���������� ������ ���������","79185551223"));
        persons.add(new Person(13L,"�������� ����� �������������","79185551222"));
        persons.add(new Person(14L,"�������� �������� ������������","79185551221"));
        persons.add(new Person(15L,"������ ��������� �������","79185551220"));
        persons.add(new Person(15L,"������ ��������� �������","79185551220"));
        persons.add(new Person(16L,"����������� ����� ����������","79185551219"));

        return persons;
    }

    public static void print(Collection<Person> persons) {

        Iterator<Person> iterator = persons.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

//    public static void print(Map<String, Person> persons) {
//        Iterator<String> iterator = persons.keySet().iterator();
//        while (iterator.hasNext()) {
//            System.out.println(persons.get(iterator.next()));
//        }
//    }
    public static void print(Map<String, Person> persons) {
        Iterator iterator = persons.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }
    }

    public static Map<String, Person> init(Map<String, Person> persons) {
        persons.put("1", new Person(1L,"����� ���� ���������","79185551234"));
        persons.put("2",new Person(2L,"������� ����� ���������","79185551233"));
        persons.put("3",new Person(3L,"����������� ������ ������������","79185551232"));
        persons.put("4",new Person(5L,"������� ������ ���� ����","79185551231"));
        persons.put("5",new Person(4L,"����� ����� ���������","79185551230"));
        persons.put("6",new Person(6L,"��������� ������� ����������","79185551229"));
        persons.put("7",new Person(7L,"������ ���� �����������","79185551228"));
        persons.put("8",new Person(8L,"�������� ��������� ���������","79185551227"));
        persons.put("9",new Person(9L,"������� ����� ����������","79185551226"));
        persons.put("10",new Person(10L,"���������� ��������� ��������","79185551225"));
        persons.put("11",new Person(11L,"������� �������� �����������","79185551224"));
        persons.put("12",new Person(12L,"���������� ������ ���������","79185551223"));
        persons.put("13",new Person(12L,"���������� ������ ���������","79185551223"));
        persons.put("14",new Person(13L,"�������� ����� �������������","79185551222"));
        persons.put("15",new Person(14L,"�������� �������� ������������","79185551221"));
        persons.put("16",new Person(15L,"������ ��������� �������","79185551220"));
        persons.put("17",new Person(15L,"������ ��������� �������","79185551220"));
        persons.put("18",new Person(16L,"����������� ����� ����������","79185551219"));

        return persons;
    }
}
