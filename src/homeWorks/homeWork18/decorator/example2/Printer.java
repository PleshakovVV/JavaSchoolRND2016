package homeWorks.homeWork18.decorator.example2;

/**
 * Created by Master on 10.09.2016.
 */
abstract public class Printer implements Printable {
    Printable printable;

    public Printer(Printable printable) {
        this.printable = printable;
    }

    @Override
    public void print(String str) {
        this.printable.print(str);
    }
}
