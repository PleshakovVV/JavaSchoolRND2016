import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Master on 02.10.2016.
 */
public class DocumentDAOImpl implements DocumentDAO {
    private static String SAVE_DOCUMENT_QUERY =
            "insert into documents(account_dt, account_ct, document_sum, purpose, doc_date) " +
                    "values(?,?,?,?,?)";
    private static String UPDATE_DOCUMENT_QUERY =
            "update documents d set (d.account_dt, d.account_ct, d.document_sum, d.purpose, d.doc_date) = " +
                    "values(?,?,?,?,?) where d.id = ?";
    private static String SELECT_DOCUMENT_BY_ACCOUNT =
            "select * from documents d where d.account_dt = ? or d.account_ct = ?";


    ApplicationContext applicationContext;
    JdbcTemplate jdbcTemplate;

    public DocumentDAOImpl(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        this.jdbcTemplate = new JdbcTemplate(applicationContext.getBean("dataSource", DataSource.class));
    }

    @Override
    public void saveDocument(Document document) {
        jdbcTemplate.update(SAVE_DOCUMENT_QUERY, document.getAccountDt().getId(), document.getAccountCt().getId(),
                document.getDocumentSum(), document.getPurpose(), document.getDocumentDate());
    }

    @Override
    public List<Document> getDocumentsByAccount(Account account) {
        return jdbcTemplate.query(SELECT_DOCUMENT_BY_ACCOUNT, new Object[]{account.getId(), account.getId()},
                new DocumentMapper(applicationContext));
    }

    @Override
    public void updateDocument(Document document) {
        jdbcTemplate.update(UPDATE_DOCUMENT_QUERY, document.getAccountDt().getId(), document.getAccountCt().getId(),
                document.getDocumentSum(), document.getPurpose(), document.getDocumentDate(), document.getId());
    }
}
