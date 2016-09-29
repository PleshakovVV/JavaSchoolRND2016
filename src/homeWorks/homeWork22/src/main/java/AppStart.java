import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Master on 28.09.2016.
 */
public class AppStart {
    private static String URL = "jdbc:h2:tcp://localhost/~/test;USER=sa;password=";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(URL)) {

            //Utils.createTables(connection);
            String clientName = "Jhon Kirbi";
            Client client = new Client(clientName);
            ClientDAO.saveNewClient(client, connection);

            List<Client> clients = ClientDAO.getClientByName(clientName,connection);
            Client clientFromDB = null;
            if (clients.size() > 0) {
                clientFromDB = clients.get(0);
            }
            System.out.println(clientFromDB);



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
