import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Master on 29.09.2016.
 */
public class ClientDAOImpl implements ClientDAO{

    private static String INSERT_CLIENT_QUERY = "insert into clients(name) values(?)";
    private static String SELECT_CLIENT_BY_NAME = "select c.id, c.name from clients c where c.name = ?";

    private JdbcTemplate jdbcTemplate;

    public ClientDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveNewClient(Client client) {
        jdbcTemplate.update(INSERT_CLIENT_QUERY, client.getName());
    }

    public List<Client> getClientByName(String name) {
        return jdbcTemplate.query(SELECT_CLIENT_BY_NAME, new Object[]{name}, new ClientMapper());
    }
}
