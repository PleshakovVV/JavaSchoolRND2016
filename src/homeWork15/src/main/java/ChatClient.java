import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Master on 01.09.2016.
 */
public class ChatClient {
    public static final String HOST = "localhost";
    public static final int PORT = 5151;

    public static void main(String[] args){
        Socket socket = null;
        try {
            socket = new Socket(HOST, PORT);
        }
        catch (IOException e) {
            System.out.println("Cannot connect to server. " + e.getMessage() + " Cause: " + e.getCause());
            System.exit(0);
        }

        final Socket finalSocket = socket;
        Thread inMessageThread = new Thread(() -> {

            try {
                BufferedReader BR = new BufferedReader(new InputStreamReader(finalSocket.getInputStream()));
                String readString;
                while (!Thread.currentThread().isInterrupted() && ((readString = BR.readLine()) != null)) {
                    System.out.println(readString);
                }
            } catch (IOException e) {
                System.out.println("Server is down...");
            }
        });
        inMessageThread.start();

        Scanner scanner = new Scanner(System.in);
        try {
            BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String readString;
            System.out.println("Enter \"exit\" to exit program.");

            while (!"exit".equals(readString = scanner.nextLine())) {
                BW.write(readString);
                BW.write("\n");
                BW.flush();
            }
            socket.close();
        } catch (IOException e) {
            System.out.println("Stop program.");
        }
        System.out.println("User enter \"exit\" - stopping the client.");
    }
}
