import java.io.*;
import java.net.Socket;
import java.util.Map;

/**
 * Created by Master on 31.08.2016.
 */
public class SocketHandler implements Runnable {
    private Socket socket;
    private Map<Socket, Object> sockets;

    public SocketHandler(Socket socket, Map<Socket, Object> sockets) {
        this.socket = socket;
        this.sockets = sockets;
    }

    @Override
    public void run() {
        try {
            BufferedReader BR = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String readString;
            while (!Thread.currentThread().isInterrupted()) {
                readString = BR.readLine();
                System.out.println(readString);
                for (Socket otherSocket : sockets.keySet()) {
                    if (readString == null) {
                        throw new IOException("Exception: read null string.");
                    }
                    if (otherSocket != socket) {
                        try {
                            BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(otherSocket.getOutputStream()));
                            BW.write(readString);
                            BW.write("\n");
                            BW.flush();
                        } catch (IOException e) {
                            // NOPE
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occur: " + e.getMessage() + "Cause: " + e.getCause());
            System.out.println("Removing socket from list of connections.");
            sockets.remove(socket);
            System.out.println("Socket removed.");
        }

    }
}
