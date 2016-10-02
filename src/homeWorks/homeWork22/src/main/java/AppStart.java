import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Master on 28.09.2016.
 */
public class AppStart {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        //Utils.createTables((DataSource)applicationContext.getBean("dataSource"));

        // fill db some data
        //fillDB(applicationContext);

        String clientName = "Jhon Kirbi";

        // Print out test data
        ClientDAO clientDAO = new ClientDAOImpl(applicationContext);
        List<Client> clients = clientDAO.getClientByName(clientName);
        Client targetClient = null;
        if (clients != null && clients.size() > 0) {
            targetClient = clients.get(0);
            System.out.println("Client: " + targetClient.getName());
        }
        Account account = null;
        AccountDAO accountDAO = new AccountDAOImpl(applicationContext);
        if (targetClient != null) {
            List<Account> accounts = accountDAO.getAccountByClient(targetClient);
            if (accounts != null && accounts.size() > 0) {
                account = accounts.get(0);
                System.out.println("Account number: " + account.getAccountNumber());
            }
        }
    }

    private static void fillDB(ApplicationContext applicationContext) {
        String clientName = "Jhon Kirbi";
        String bankName = "Morgan Stanley";
        String accountNumberCl = "40817810983746372722";
        createClientAndBindAccountToClient(clientName, accountNumberCl, applicationContext);
        String accountNumberBank = "20202810600000000001";
        createClientAndBindAccountToClient(bankName, accountNumberBank, applicationContext);
        DocumentDAO documentDAO = new DocumentDAOImpl(applicationContext);
        AccountDAO accountDAO = new AccountDAOImpl(applicationContext);
        documentDAO.saveDocument(
                Document.createNewDocument(accountDAO.getAccountByAccountNumber(accountNumberBank),
                        accountDAO.getAccountByAccountNumber(accountNumberCl),
                        BigDecimal.valueOf(4700000, 2),
                        "Взнос собственных денежных средств на текущий счет. НДС не облагается.",
                        new Date()));
        documentDAO.saveDocument(
                Document.createNewDocument(accountDAO.getAccountByAccountNumber(accountNumberCl),
                        accountDAO.getAccountByAccountNumber(accountNumberBank),
                        BigDecimal.valueOf(700000, 2),
                        "Выдача средств с текущего счета. НДС не облагается.",
                        new Date()));
    }

    public static void createClientAndBindAccountToClient(String clientName, String accountNumber, ApplicationContext applicationContext) {
        ClientDAO clientDAO = new ClientDAOImpl(applicationContext);
        clientDAO.saveNewClient(new Client(clientName));
        List<Client> clients = clientDAO.getClientByName(clientName);
        Client client = null;
        if (clients != null || clients.size() != 0) {
            client = clients.get(0);
        }
        if (client != null) {
            AccountDAO accountDAO = new AccountDAOImpl(applicationContext);
            accountDAO.saveAccount(Account.createNewAccount(client, accountNumber));
        }
    }
}
