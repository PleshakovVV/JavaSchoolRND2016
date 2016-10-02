import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Master on 01.10.2016.
 */
public class AccountMapper implements RowMapper<Account> {

    ApplicationContext applicationContext;

    public AccountMapper(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        ClientDAO clientDAO = new ClientDAOImpl((applicationContext));
        Client client = clientDAO.getClientById(resultSet.getLong("id_client"));
        Account account = Account.constructAccount(resultSet.getLong("id"),
                resultSet.getBigDecimal("saldo"), client, resultSet.getString("account"));
        return account;
    }
}
