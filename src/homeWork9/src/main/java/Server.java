import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

/**
 * Created by Master on 18.08.2016.
 */
public class Server {
    private final static int PORT = 5151;
    private final static int TIMEOUT = 5000;

    public static void main(String[] args) {
        System.out.println("Start server on port " + PORT);
        System.out.println("Enter \"stop\" to stop server.");

        Thread getConnectionThread = new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(PORT);
                serverSocket.setSoTimeout(TIMEOUT);
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Socket socket = serverSocket.accept();
                    } catch (SocketTimeoutException e) {
                        //NOPE
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        getConnectionThread.start();
        Scanner scanner = new Scanner(System.in);
        while (!"stop".equals(scanner.nextLine().toLowerCase().trim())) {
            System.out.println("Enter \"stop\" to stop server.");
        }
        System.out.println("User enter \"stop\". Ending program. Wait.");
        getConnectionThread.interrupt();
    }
}
