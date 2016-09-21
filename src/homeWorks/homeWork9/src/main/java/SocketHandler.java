import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 * Created by Master on 29.08.2016.
 */
public class SocketHandler implements Runnable{

    private final List<Socket> sockets;
    private final Socket socket;

    public SocketHandler(List<Socket> sockets, Socket socket) {
        this.sockets = sockets;
        this.socket = socket;
    }

    @Override
    public void run() {
        try  {
            ObjectInput OI = new ObjectInputStream(socket.getInputStream());
            while (!Thread.currentThread().isInterrupted()) {
                Message message = (Message)OI.readObject();
                System.out.println(message);
                for (int i = 0; i < sockets.size(); i++) {
                    if (!sockets.get(i).equals(socket)) {
                        ObjectOutput OO = new ObjectOutputStream(sockets.get(i).getOutputStream());
                        OO.writeObject(message);
                        OO.flush();
                    }
                }
            }
        }
        catch (IOException|ClassNotFoundException e) {
            // NOPE
        }
    }
}
