import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 * Created by Master on 29.08.2016.
 */
public class SocketHandler implements Runnable{
    public SocketHandler(List<Socket> sockets, Socket socket) {
        this.sockets = sockets;
        this.socket = socket;
    }

    private final List<Socket> sockets;
    private final Socket socket;

    @Override
    public void run() {
        try (BufferedReader BR = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            while (true) {
                String readString = BR.readLine();
                for (int i = 0; i < sockets.size(); i++) {
                    if (!sockets.get(i).equals(socket)) {
                        BufferedWriter bufferedWriter =new BufferedWriter(
                                new OutputStreamWriter(sockets.get(i).getOutputStream()));
                        bufferedWriter.write(readString);
                        bufferedWriter.write("\n");
                        bufferedWriter.flush();
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
