package com.sbt.lesson15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by Student on 29.08.2016.
 */
public class UDPClient {
    public static final String HOST = "localhost";
    public static final int PORT = 3333;

    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName(HOST);

        try (DatagramSocket socket = new DatagramSocket();
             BufferedReader BR = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            do {
                System.out.print("Enter message: ");
                line = BR.readLine();
                byte[] bytes = line.getBytes();
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length, inetAddress, PORT);

            } while (!line.equals("exit"));

        }

    }
}