package com.sbt.lesson5;

/**
 * Created by Student on 25.07.2016.
 */

class MyException extends RuntimeException{

}

public class MyExceptionTest extends Exception{
    public static void main(String[] args){
        throw new MyException();
    }
}
