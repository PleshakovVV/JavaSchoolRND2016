package com.sbt.lesson9;

import java.io.*;

/**
 * Created by Student on 08.08.2016.
 */
class Data implements Serializable {
    String value = "AAAAAA";
}

public class CacheTest {
    public static void main(String[] args) {
        String fileName = "C:\\temp\\data3.bin";

        Data dataHolder = new Data();

        try (FileOutputStream FOS = new FileOutputStream(fileName);
             ObjectOutputStream OOS = new ObjectOutputStream(FOS)) {
            OOS.writeObject(dataHolder);
            dataHolder.value = "BBBBBB";
            OOS.writeUnshared(dataHolder);
            dataHolder.value = "CCCCCC";
            OOS.writeUnshared(dataHolder);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream FIS = new FileInputStream(fileName);
             ObjectInputStream OIS = new ObjectInputStream(FIS)) {
            Data dataHolder1 = (Data) OIS.readObject();
            Data dataHolder2 = (Data) OIS.readObject();
            Data dataHolder3 = (Data) OIS.readObject();
            System.out.println(dataHolder1);
            System.out.println(dataHolder2);
            System.out.println(dataHolder3);


        }
        catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
