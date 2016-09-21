package homeWorks.homeWork18.proxy.example2;

/**
 * Created by Master on 11.09.2016.
 */
interface IAccount {
    String getAccount();
    Double getSum();
    void add(Double sum);
    boolean reduce(Double sum);
}
