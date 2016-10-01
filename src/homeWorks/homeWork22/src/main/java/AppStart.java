import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Master on 28.09.2016.
 */
public class AppStart {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        Utils.createTables((DataSource)applicationContext.getBean("dataSource"));

        ClientDAO clientDAO = new ClientDAOImpl((DataSource) applicationContext.getBean("dataSource"));

        String clientName = "Jhon Kirbi";
        Client client = new Client(clientName);
        clientDAO.saveNewClient(client);

        List<Client> clients = clientDAO.getClientByName(clientName);
        Client clientFromDB = null;
        if (clients.size() > 0) {
            clientFromDB = clients.get(0);
        }
        System.out.println(clientFromDB);
    }
}
