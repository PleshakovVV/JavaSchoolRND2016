package homeWorks.homeWork21;

/**
 * Created by Master on 21.09.2016.
 */
public class FibonachiableImpl implements Fibonachiable {
    @Override
    @PersistentCached
    public int count(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("NUmber must be more than zero. Number = " + number);
        }
        if (number == 1 || number == 2) {
            return number;
        }
        return count(number - 1) + count(number - 2);
    }
}
