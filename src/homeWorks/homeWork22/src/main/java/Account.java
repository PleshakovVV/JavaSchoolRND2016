import java.math.BigDecimal;

/**
 * Created by Master on 29.09.2016.
 */
public class Account {
    private long id;
    private BigDecimal saldo;
    private Client client;
    private String accountNumber;

    public static Account createNewAccount(Client client, String accountNumber) {
        if (accountNumber.length() != 20) {
            throw new BigApplicationException("The accountNumber length must be 20 characters.", null);
        }
        if (client == null) {
            throw new BigApplicationException("Client cannot be empty", null);
        }
        return new Account(0, BigDecimal.valueOf(0, 2), client, accountNumber);
    }

    public static Account constructAccount(long id, BigDecimal saldo, Client client, String accountNumber) {
        return new Account(id, saldo, client, accountNumber);
    }

    private Account(long id, BigDecimal saldo, Client client, String accountNumber) {
        this.id = id;
        this.saldo = saldo;
        this.client = client;
        this.accountNumber = accountNumber;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public Client getClient() {
        return client;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", saldo=" + saldo +
                ", client=" + client +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
