import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Created by Master on 31.08.2016.
 */
public class ChatServer {

    private static final int CLIENT_NUMBER = 2;
    private static final Map<Socket, Object> sockets = new ConcurrentHashMap<>();
    private static final int TIMEOUT = 5000;
    private static final int PORT = 5151;

    private static final Object emptyObject = new Object();

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(PORT);
        serverSocket.setSoTimeout(TIMEOUT);
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
        
        Scanner scanner = new Scanner(System.in);

        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Socket socket = serverSocket.accept();
                    if (sockets.size() == CLIENT_NUMBER) {
                        BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                        BW.write("The limit of clients is reached. Try to connect later.");
                        BW.flush();
                        BW.close();
                        socket.close();
                    }
                    else {
                        sockets.put(socket, emptyObject);
                        System.out.println("Get new connection. Number of connections is: " + sockets.size());
                        executorService.submit(new SocketHandler(socket, sockets));
                    }
                     
                } catch (SocketTimeoutException e) {
                    //NOPE
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
        });
        thread.start();

        System.out.println("Server is start on " + PORT + " port.");

        do {
            System.out.println("Enter \"stop\" to stop server");
        } while (!"stop".equals(scanner.nextLine().toLowerCase().trim()));

        System.out.println("User enter \"stop\". Stopping server. Please, wait...");
        thread.interrupt();
        executorService.shutdown();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Server is stopped.");
    }
}
