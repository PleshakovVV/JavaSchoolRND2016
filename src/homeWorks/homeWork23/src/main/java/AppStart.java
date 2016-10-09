
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Master on 05.10.2016.
 */
public class AppStart {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        String clientName = "John Smith";
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Client client = new Client(clientName);
            Account account = new Account(client, "40817978912308495837");
            Account accountDep = new Account(client, "42305978391824839323");

            Client bank = new Client("Morgan Stanley");
            Account accountBank = new Account(bank, "20202810938493859685");

            Document document = new Document(accountBank, account, BigDecimal.valueOf(4700000, 2),
                    "Внесение собственных средств на текущий счет. НДС не облагается.");
            Document documentDep = new Document(account, accountDep, BigDecimal.valueOf(4700000, 2),
                    "Внесение денежных средств на вклад. НДС не облагается.");

            session.beginTransaction();
            session.save(client);
            session.save(bank);
            session.save(account);
            session.save(accountDep);
            session.save(accountBank);
            session.save(document);
            session.save(documentDep);

            session.getTransaction().commit();

            session.beginTransaction();
            Query clientQuery = session.createQuery("from Client c where c.name = :clientName");
            List<Client> clientList = clientQuery.setParameter("clientName", clientName).list();
            if (clientList != null && clientList.size() > 0) {
                System.out.println("Client: " + clientList.get(0).getName());
                Query accountQuery = session.createQuery("from Account a where a.client = :client");
                List<Account> accounts = accountQuery.setParameter("client", clientList.get(0)).list();
                if (accounts != null && accounts.size() > 0) {
                    for (Account acc : accounts) {
                        BigDecimal sum = BigDecimal.valueOf(0);
                        System.out.println("Account: " + acc.getAccount() + " in saldo: 0.00");
                        System.out.println("Client name\t\t\tAccount number\t\t\tType op\t\tSum op");
                        System.out.println("---------------------------------------------------------------");
                        Query queryDocuments = session.createQuery("from Document d where d.accountDt = :account or d.accountCt = :account");
                        List<Document> documents = queryDocuments.setParameter("account", acc).list();
                        for (Document doc : documents) {
                            Account correspondAccount = null;
                            String typeOp = "Debet";
                            if (doc.getAccountDt().equals(acc)) {
                                correspondAccount = doc.getAccountCt();
                                sum = sum.subtract(doc.getSum());
                            } else {
                                correspondAccount = doc.getAccountDt();
                                typeOp = "Credit";
                                sum = sum.add(doc.getSum());
                            }
                            System.out.print(correspondAccount.getClient().getName());
                            System.out.print("\t\t");
                            System.out.print(correspondAccount.getAccount());
                            System.out.print("\t\t");
                            System.out.print(typeOp);
                            System.out.print("\t\t");
                            System.out.println(doc.getSum());
                        }
                        System.out.println("Out saldo: " + sum + "\n");
                    }
                }
            }
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}
