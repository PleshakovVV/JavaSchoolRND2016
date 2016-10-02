import java.util.List;

/**
 * Created by Master on 02.10.2016.
 */
public interface DocumentDAO {
    void saveDocument(Document document);
    List<Document> getDocumentsByAccount(Account account);
    void updateDocument(Document document);
}
