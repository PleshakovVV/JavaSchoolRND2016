import java.util.List;

/**
 * Created by Master on 01.10.2016.
 */
public interface AccountDAO {
    List<Account> getAccountByClient(Client client);
    Account getAccountById(long id);
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Account account);
}
