package com.sbt.lesson9;

import java.io.*;

/**
 * Created by Student on 08.08.2016.
 */
class DateAndTime implements Externalizable {

    final static private long serialVersionUID = 0L;

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;

    public DateAndTime() {
        this.year = 2016;
        this.month = 10;
        this.day = 5;
        this.hour = 14;
        this.minute = 44;
        this.second = 20;
    }

    @Override
    public String toString() {
        return "DateAndTime{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        int packed = 0;
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}

public class ExternalizableTest {
    public static void main(String[] args) {
        String fileName = "C:\\temp\\data.bin";
        try (FileOutputStream FOS = new FileOutputStream(fileName);
             ObjectOutputStream OOS = new ObjectOutputStream(FOS)) {
            OOS.writeObject(new DateAndTime());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream FIS = new FileInputStream(fileName);
             ObjectInputStream OIS = new ObjectInputStream(FIS)) {
            DateAndTime student = (DateAndTime) OIS.readObject();
            System.out.println(student);
        }
        catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
