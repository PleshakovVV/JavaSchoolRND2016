import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Master on 29.09.2016.
 */
public class ClientDAOImpl implements ClientDAO {

    private static String INSERT_CLIENT_QUERY = "insert into clients(name) values(?)";
    private static String SELECT_CLIENT_BY_NAME = "select c.id, c.name from clients c where c.name = ?";
    private static String SELECT_CLIENT_BY_ID = "select c.id, c.name from clients c where c.id = ?";
    private static String UPDATE_CLIENT = "update clients c set c.name = ? where c.id = ?";

    private JdbcTemplate jdbcTemplate;

    public ClientDAOImpl(ApplicationContext applicationContext) {
        jdbcTemplate = new JdbcTemplate(applicationContext.getBean("dataSource", DataSource.class));
    }

    public void saveNewClient(Client client) {
        jdbcTemplate.update(INSERT_CLIENT_QUERY, client.getName());
    }

    public List<Client> getClientByName(String name) {
        return jdbcTemplate.query(SELECT_CLIENT_BY_NAME, new Object[]{name}, new ClientMapper());
    }

    @Override
    public Client getClientById(long id) {
        List<Client> clients = jdbcTemplate.query(SELECT_CLIENT_BY_ID, new Object[]{id}, new ClientMapper());
        if (clients == null || clients.size() == 0) {
            return null;
        }
        return clients.get(0);
    }

    @Override
    public void updateClient(Client client) {
        if (!client.isSaved()) {
            throw new BigApplicationException("Client " + client + " is't saved yet. Save him before update.", null);
        }
        jdbcTemplate.update(UPDATE_CLIENT, client.getName(), client.getId());
    }
}
