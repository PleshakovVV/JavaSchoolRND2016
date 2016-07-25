package com.sbt.lesson5;

/**
 * Created by Student on 25.07.2016.
 */
class SBTEmployee {
    public SBTEmployee(int grade) {
        if (grade < 0 || grade > 16) {
            throw new IllegalArgumentException("Args is: " + grade);
        }
    }
}

public class IAETest {
    public static void main(String[] args) {
        new SBTEmployee(2);
        new SBTEmployee(22);
    }
}
