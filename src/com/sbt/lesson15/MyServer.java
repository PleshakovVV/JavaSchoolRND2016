package com.sbt.lesson15;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Student on 29.08.2016.
 */
public class MyServer {

    private final static int PORT = 3333;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();

        BufferedReader BR = new BufferedReader(new InputStreamReader(inputStream));
        String string = BR.readLine();
        System.out.println(string);

        BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(outputStream));
        BW.write("Ok\n");
        BW.flush();
    }
}
