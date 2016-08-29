package com.sbt.lesson15;

import java.io.*;
import java.net.Socket;

/**
 * Created by Student on 29.08.2016.
 */
public class MyClient {
    public static final String HOST = "localhost";
    public static final int PORT = 3333;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(HOST, PORT);
        BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader BR = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(BR.readLine());

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            BW.write(consoleReader.readLine());
            BW.write("\n");
            BW.flush();
            if (BR.readLine().equals("You win!")) {
                System.out.println("You win!");
                break;
            }
            else {
                System.out.println("Nope. Try again.");
            }
        }

    }
}
