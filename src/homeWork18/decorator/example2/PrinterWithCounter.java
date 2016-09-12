package homeWork18.decorator.example2;

/**
 * Created by Master on 10.09.2016.
 */
public class PrinterWithCounter extends Printer {
    private int counter;

    public PrinterWithCounter(Printable printable) {
        super(printable);
    }

    @Override
    public void print(String str) {
        super.print(str);
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
