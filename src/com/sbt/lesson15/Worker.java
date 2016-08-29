package com.sbt.lesson15;

import java.io.*;
import java.net.Socket;
import java.util.Random;

/**
 * Created by Student on 29.08.2016.
 */
public class Worker implements Runnable {
    private Socket socket;

    public Worker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        int secretNumber = new Random().nextInt(10);
        System.out.println("SecretNumber is: " + secretNumber);
        try {
            BufferedReader BR = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            BW.write("Try to find: \n");
            BW.flush();

            while (true) {
                if (Integer.parseInt(BR.readLine()) == secretNumber) {
                    BW.write("You win!\n");
                    BW.flush();
                    break;
                }
                else {
                    BW.write("Nope. Try once more.\n");
                    BW.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
