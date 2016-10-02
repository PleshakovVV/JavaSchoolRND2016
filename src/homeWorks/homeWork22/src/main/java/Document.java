import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Master on 02.10.2016.
 */
public class Document {
    private long id;
    private Account accountDt;
    private Account accountCt;
    private BigDecimal documentSum;
    private String purpose;
    private Date documentDate;

    private Document(Account accountDt, Account accountCt, BigDecimal documentSum, String purpose, Date documentDate) {
        this.accountDt = accountDt;
        this.accountCt = accountCt;
        this.documentSum = documentSum;
        this.purpose = purpose;
        this.documentDate = documentDate;
    }

    public static Document createNewDocument(Account accountDt, Account accountCt, BigDecimal documentSum, String purpose,
                                             Date documentDate) {
        if (accountDt == null || accountCt == null) {
            throw new BigApplicationException("Accounts must not be null.", null);
        }
        if (documentSum.compareTo(BigDecimal.valueOf(0.00)) <= 0) {
            throw new BigApplicationException("Document sum must be more than zero.", null);
        }
        if (purpose == null || purpose.length() == 0) {
            throw new BigApplicationException("The purpose of document must exists.", null);
        }
        if (documentDate == null) {
            documentDate = new Date();
        }
        return new Document(accountDt, accountCt, documentSum, purpose, documentDate);
    }

    public static Document createFromDB(long id, Account accountDt, Account accountCt, BigDecimal documentSum, String purpose,
                                        Date documentDate) {
        Document document = Document.createNewDocument(accountDt, accountCt, documentSum, purpose, documentDate);
        document.id = id;
        return document;
    }

    public long getId() {
        return id;
    }

    public Account getAccountDt() {
        return accountDt;
    }

    public Account getAccountCt() {
        return accountCt;
    }

    public BigDecimal getDocumentSum() {
        return documentSum;
    }

    public String getPurpose() {
        return purpose;
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    public void setAccountDt(Account accountDt) {
        this.accountDt = accountDt;
    }

    public void setAccountCt(Account accountCt) {
        this.accountCt = accountCt;
    }

    public void setDocumentSum(BigDecimal documentSum) {
        this.documentSum = documentSum;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }
}
