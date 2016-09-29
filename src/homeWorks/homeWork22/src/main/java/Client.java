/**
 * Created by Master on 29.09.2016.
 */
public class Client {
    private long id;
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public Client(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
