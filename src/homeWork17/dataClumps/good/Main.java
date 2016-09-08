package homeWork17.dataClumps.good;

/**
 * Created by Master on 08.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        makeInsets(new Insets(4, 2, 2, 2));
    }

    public static void makeInsets(Insets insets) {
        System.out.println("Make insets: left: " + insets.getLeft() +
                " right: " + insets.getRight() + " top: " + insets.getTop() + " bottom: " + insets.getBottom());
    }
}

class Insets {
    private int left;
    private int right;
    private int top;
    private int bottom;

    public Insets(int left, int right, int top, int bottom) {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }
}
