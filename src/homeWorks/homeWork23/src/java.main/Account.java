import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Master on 06.10.2016.
 */
@Entity
@Table(name = "ACCOUNTS")
public class Account implements Serializable{
    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SALDO")
    private BigDecimal saldo = BigDecimal.valueOf(0,2);
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENT", nullable = false)
    private Client client;
    @Column(name = "ACCOUNT", length = 20)
    private String account;

    public Account() {
    }

    public Account(Client client, String account) {
        this.client = client;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public Client getClient() {
        return client;
    }

    public String getAccount() {
        return account;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return id != null ? id.equals(account.id) : account.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
