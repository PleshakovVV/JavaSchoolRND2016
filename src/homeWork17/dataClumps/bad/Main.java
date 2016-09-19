package homeWork17.dataClumps.bad;

/**
 * Created by Master on 08.09.2016.
 * Start Application
 */
public class Main {

    private Main() {
        //NOPE
    }

    public static void main(String[] args) {
        makeInsets(2, 1, 1, 1);
    }

    /**
     * Print out fake insets form something
     * @param leftInset
     * @param rightInset
     * @param topInset
     * @param bottomInset
     */
    public static void makeInsets(int leftInset, int rightInset, int topInset, int bottomInset) {
        System.out.println("Make insets: left: " + leftInset +
        " right: " + rightInset + " top: " + topInset + " bottom: " + bottomInset);
    }
}
