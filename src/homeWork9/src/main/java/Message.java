import java.io.Serializable;

/**
 * Created by Master on 30.08.2016.
 */
public class Message implements Serializable{

    private static final long serialVersionUID = 0;
    private static int globalId = 0;

    private int id;
    private String text;
    private String sender;

    public Message(String sender, String text) {
        this.text = text;
        this.id = globalId++;
        this.sender = sender;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "From " + sender + ": " + text;
    }
}
