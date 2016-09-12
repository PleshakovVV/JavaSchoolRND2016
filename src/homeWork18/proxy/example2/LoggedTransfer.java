package homeWork18.proxy.example2;

/**
 * Created by Master on 11.09.2016.
 */
public class LoggedTransfer implements Transferable{
    private Transferable transferable;
    @Override
    public void transfer(IAccount accountFrom, IAccount accountTo, Double sum) {
        if (transferable == null) {
            transferable = new TransferableImpl();
        }
        System.out.println("Transfer from " + accountFrom + " to " + accountTo + " sum: " + sum);
        transferable.transfer(accountFrom, accountTo, sum);
    }
}
