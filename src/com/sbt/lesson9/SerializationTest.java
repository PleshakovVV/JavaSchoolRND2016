package com.sbt.lesson9;

import java.io.*;

/**
 * Created by Student on 08.08.2016.
 */
class Person implements Serializable{
    private String firstName;
    private int age;


    public Person() {
        this.firstName = "Mike";
        this.age = 20;

        System.out.println("I'm in Person.");
    }
}

class Student /*extends Person*/ implements Serializable{
    private String group;
    private int avgMark;
    transient private String password;

    private static final long serialVersionUID = 0L;

    public Student() {
        group = "default";
        avgMark = 3;
        this.password = "Very good password";
        System.out.println("i'm in constructor Student.");
    }

    @Override
    public String toString() {
        return "Student{" +
                "group='" + group + '\'' +
                ", avgMark=" + avgMark +
                ", password='" + password + '\'' +
                '}';
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        avgMark ^= 0xFFFFFFFF;
        out.defaultWriteObject();
        out.writeLong(System.currentTimeMillis());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        long value = in.readLong();
        System.out.println(value);
        avgMark ^= 0xFFFFFFFF;
    }
}

public class SerializationTest {
    public static void main(String[] args) {
        String fileName = "C:\\temp\\student.bin";
        try (FileOutputStream FOS = new FileOutputStream(fileName);
             ObjectOutputStream OOS = new ObjectOutputStream(FOS)) {
            OOS.writeObject(new Student());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream FIS = new FileInputStream(fileName);
             ObjectInputStream OIS = new ObjectInputStream(FIS)) {
            Student student = (Student)OIS.readObject();
            System.out.println(student);
        }
        catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
