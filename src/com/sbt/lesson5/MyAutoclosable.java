package com.sbt.lesson5;

/**
 * Created by Student on 25.07.2016.
 */
class Ok implements AutoCloseable {
    private String message;

    public Ok(String message) {
        this.message = message;
        System.out.println("I'm created.");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Resources free: " + message);
    }
}

public class MyAutoclosable {
    public static void main(String[] args) {
        try (Ok ok = new Ok("Hi");
             Ok ok1 = new Ok("bye")) {

        } catch (Exception e) {
            //Nope
        }
    }
}
