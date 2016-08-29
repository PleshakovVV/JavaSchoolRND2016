package com.sbt.lesson15;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Student on 29.08.2016.
 */
public class MyServer1 {

    private final static int PORT = 3333;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while (true) {
            Socket accept = serverSocket.accept();
            executorService.execute(new Worker(accept));
        }
    }
}
