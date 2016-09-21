package homeWorks.homeWork18.proxy.example2;

/**
 * Created by Master on 11.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        IAccount account1 = Accounts.getAccount("20202810712537895670");
        IAccount account2 = Accounts.getAccount("40817810940285960941");
        account1.add(100D);
        account2.add(100D);

        Transferable transferable = new LoggedTransfer();

        transferable.transfer(account1, account2, 14D);
        transferable.transfer(account2, account1, 29D);
        System.out.println(account1.getSum());
        System.out.println(account2.getSum());
    }
}
