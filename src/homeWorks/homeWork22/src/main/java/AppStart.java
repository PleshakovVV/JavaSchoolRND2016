import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Master on 28.09.2016.
 */
public class AppStart {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        //Utils.createTables((DataSource)applicationContext.getBean("dataSource"));

        ClientDAO clientDAO = new ClientDAOImpl(applicationContext);

        String clientName = "Jhon Kirbi";
        String bankName = "Morgan Stanley";
        clientDAO.saveNewClient(new Client(clientName));
        clientDAO.saveNewClient(new Client(bankName));
        List<Client> clients = clientDAO.getClientByName(clientName);
        Client client = null;
        if (clients != null || clients.size() != 0) {
            client = clients.get(0);
        }
        if (client != null) {
            AccountDAO accountDAO = new AccountDAOImpl(applicationContext);
            accountDAO.saveAccount(Account.createNewAccount(client, "40817810812343456878"));
        }
    }
}
