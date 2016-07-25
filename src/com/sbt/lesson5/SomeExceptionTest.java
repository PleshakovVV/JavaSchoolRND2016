package com.sbt.lesson5;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Student on 25.07.2016.
 */
public class SomeExceptionTest {
    public static void main(String[] args) {
        try {
            if (false) {
                Integer.parseInt("I'm not number");
                new URL("It's not URL");
                new URL("WWW.google.com").getContent();
            }
            int a = 1/0;
        } catch (NumberFormatException e) {
            System.out.println(e);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        catch (IOException | ArithmeticException e) {
            System.out.println(e);
        }

    }
}
