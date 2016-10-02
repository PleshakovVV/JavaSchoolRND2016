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
        Client client = new Client(clientName);
        clientDAO.saveNewClient(client);

        List<Client> clients = clientDAO.getClientByName(clientName);
        Client clientFromDB = null;
        if (clients.size() > 0) {
            clientFromDB = clients.get(0);
        }
        System.out.println(clientFromDB);
        Account account = Account.createNewAccount(clientFromDB, "40817810333333333333");
        AccountDAO accountDAO = new AccountDAOImpl(applicationContext);
        accountDAO.saveAccount(account);
        List<Account> accounts = accountDAO.getAccountByClient(clientFromDB);
        for (Account acc : accounts) {
            System.out.println(acc);
        }
    }
}
