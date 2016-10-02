import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Master on 01.10.2016.
 */
public class AccountDAOImpl implements AccountDAO {

    private final static String SAVE_ACCOUNT_QUERY =
            "insert into Accounts(saldo, id_client, account) values(?, ?, ?)";
    private final static String DELETE_ACCOUNT_QUERY =
            "delete from Accounts where id = ?";
    private final static String SELECT_ACCOUNT_BY_CLIENT =
            "select a.id, a.saldo, a.id_client, a.account from accounts a where a.id_client = ?";
    private final static String SELECT_ACCOUNT_BY_ID =
            "select a.id, a.saldo, a.id_client, a.account from accounts a where a.id = ?";
    private final static String UPDATE_ACCOUNT_QUERY =
            "update accounts set (saldo, id_client, account) = (?, ?, ?)";

    private ApplicationContext applicationContext;
    private JdbcTemplate jdbcTemplate;

    public AccountDAOImpl(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        this.jdbcTemplate = new JdbcTemplate((DataSource)applicationContext.getBean("dataSource"));
    }

    @Override
    public List<Account> getAccountByClient(Client client) {
        return jdbcTemplate.query(SELECT_ACCOUNT_BY_CLIENT, new Object[]{client.getId()},
                new AccountMapper(this.applicationContext));
    }

    @Override
    public Account getAccountById(long id) {
        List<Account> accounts = jdbcTemplate.query(SELECT_ACCOUNT_BY_ID, new Object[]{id},
                new AccountMapper(this.applicationContext));
        if (accounts == null || accounts.size() == 0) {
            return null;
        }
        return accounts.get(0);
    }

    @Override
    public void saveAccount(Account account) {
        jdbcTemplate.update(SAVE_ACCOUNT_QUERY, account.getSaldo(), account.getClient().getId(),
                account.getAccountNumber());
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update(UPDATE_ACCOUNT_QUERY,
                account.getSaldo(), account.getClient().getId(), account.getAccountNumber());
    }

    @Override
    public void deleteAccount(Account account) {
        jdbcTemplate.update(DELETE_ACCOUNT_QUERY, account.getId());
    }
}
