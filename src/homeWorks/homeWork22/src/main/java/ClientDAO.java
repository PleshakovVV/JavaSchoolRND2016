import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Master on 29.09.2016.
 */
public class ClientDAO {

    private static String INSERT_CLIENT_QUERY = "insert into clients(name) values(?)";
    private static String SELECT_CLIENT_BY_NAME = "select c.id, c.name from clients c where c.name = ?";

    public static void saveNewClient(Client client, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_QUERY);
        preparedStatement.setString(1, client.getName());
        preparedStatement.executeUpdate();
    }

    public static List<Client> getClientByName(String name, Connection connection) throws SQLException {
        List<Client> clients = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENT_BY_NAME);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet != null && resultSet.next()) {
            clients.add(new Client(resultSet.getLong("id"), resultSet.getString("name")));
        }
        return clients;
    }
}
