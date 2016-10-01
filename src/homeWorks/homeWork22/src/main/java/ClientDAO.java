import java.sql.Connection;
import java.util.List;

/**
 * Created by Master on 01.10.2016.
 */
public interface ClientDAO {
    void saveNewClient(Client client);
    List<Client> getClientByName(String name);
}
