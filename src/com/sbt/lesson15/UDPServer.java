package com.sbt.lesson15;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by Student on 29.08.2016.
 */
public class UDPServer {
    public static final int PORT = 3333;
    public static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        try (DatagramSocket datagramSocket = new DatagramSocket(PORT)){
            byte[] buffer = new byte[BUFFER_SIZE];
            String command = "";
            do {
                System.out.println("Enter do");
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                datagramSocket.receive(dp);
                System.out.println("Recive...");
                command = new String(dp.getData(), 0, dp.getLength());
                System.out.println(command);

            } while (!command.equals("exit!"));
        }
        catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
