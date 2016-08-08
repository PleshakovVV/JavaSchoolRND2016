package com.sbt.lesson9;

import java.io.*;

/**
 * Created by Student on 08.08.2016.
 */
class A implements Serializable{
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
class B implements Serializable{
    private C c;

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }
}
class C implements Serializable{
    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}


public class RecursiveLinks {
    public static void main(String[] args) {
        String fileName = "C:\\temp\\links.bin";

        A a = new A();
        B b = new B();
        C c = new C();

        a.setB(b);
        b.setC(c);
        c.setA(a);

        try (FileOutputStream FOS = new FileOutputStream(fileName);
             ObjectOutputStream OOS = new ObjectOutputStream(FOS)) {
            OOS.writeObject(a);
            OOS.writeObject(b);
            OOS.writeObject(c);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream FIS = new FileInputStream(fileName);
             ObjectInputStream OIS = new ObjectInputStream(FIS)) {
            A a1 = (A)OIS.readObject();
            B b1 = (B)OIS.readObject();
            C c1 = (C)OIS.readObject();

            System.out.println(a1);
            System.out.println(b1);
            System.out.println(c1);

            System.out.println(a == a1);
            System.out.println(b == b1);
            System.out.println(c == c1);
        }
        catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
