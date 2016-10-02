import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Master on 02.10.2016.
 */
public class DocumentMapper implements RowMapper<Document> {

    ApplicationContext applicationContext;

    public DocumentMapper(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Document mapRow(ResultSet resultSet, int i) throws SQLException {
        AccountDAO accountDAO = new AccountDAOImpl(applicationContext);

        Document document = Document.createFromDB(resultSet.getLong("id"),
                accountDAO.getAccountById(resultSet.getLong("account_dt")),
                accountDAO.getAccountById(resultSet.getLong("account_ct")),
                resultSet.getBigDecimal("document_sum"),
                resultSet.getString("purpose"),
                resultSet.getDate("doc_date"));
        return document;
    }
}
