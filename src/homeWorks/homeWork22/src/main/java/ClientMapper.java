import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Master on 01.10.2016.
 */
public class ClientMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Client(resultSet.getLong("id"), resultSet.getString("name"));
    }
}
