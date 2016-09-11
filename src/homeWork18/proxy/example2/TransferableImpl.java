package homeWork18.proxy.example2;

/**
 * Created by Master on 11.09.2016.
 */
public class TransferableImpl implements Transferable{
    @Override
    public void transfer(IAccount accountFrom, IAccount accountTo, Double sum) {
        accountFrom.reduce(sum);
        accountTo.add(sum);
    }
}
