import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Master on 06.10.2016.
 */
@Entity
@Table(name = "DOCUMENTS")
public class Document implements Serializable{
    private static final long serialVersionUID = 0L;

    public Document() {
    }

    public Document(Account accountDt, Account accountCt, BigDecimal sum, String purpuse) {
        this.accountDt = accountDt;
        this.accountCt = accountCt;
        this.sum = sum;
        this.purpuse = purpuse;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "ACCOUNT_DT")
    private Account accountDt;

    @OneToOne
    @JoinColumn(name = "ACCOUNT_CT")
    private Account accountCt;

    @Column(name = "DOCUMENT_SUM")
    private BigDecimal sum;

    @Column(name = "PURPOSE", length = 210)
    private String purpuse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccountDt() {
        return accountDt;
    }

    public void setAccountDt(Account accountDt) {
        this.accountDt = accountDt;
    }

    public Account getAccountCt() {
        return accountCt;
    }

    public void setAccountCt(Account accountCt) {
        this.accountCt = accountCt;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public String getPurpuse() {
        return purpuse;
    }

    public void setPurpuse(String purpuse) {
        this.purpuse = purpuse;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", accountDt=" + accountDt +
                ", accountCt=" + accountCt +
                ", sum=" + sum +
                ", purpuse='" + purpuse + '\'' +
                '}';
    }
}
