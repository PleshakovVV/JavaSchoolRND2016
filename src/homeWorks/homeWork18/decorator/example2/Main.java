package homeWorks.homeWork18.decorator.example2;

/**
 * Created by Master on 10.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        Printable printable = new SimplePrinter();

        PrinterWithCounter printerWithCounter = new PrinterWithCounter(printable);
        Printable printableWithCounter = printerWithCounter;

        printableWithCounter.print("Monday");
        printableWithCounter.print("Sunday");
        printableWithCounter.print("Friday");
        printableWithCounter.print("Tuesday");

        System.out.println("Counter is: " + printerWithCounter.getCounter());
    }
}
