import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Master on 13.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(44);
        list.add(2);
        list.add(-5);
        list.add(12);
        list.add(107);
        list.add(-22);

        TwoParameterValidatable<Number, Number, Number> isProper =
                (value, lowerBound, upperBound) -> {
                    return value.doubleValue() > lowerBound.doubleValue() && value.doubleValue() < upperBound.doubleValue();
                };

        System.out.println("Between -10 and 50:");
        List<Integer> newList = new ArrayList<>();
        for (Integer i : list) {
            if (isProper.isValidate(i, -10, 50)) {
                newList.add(i);
            }
        }

        newList.stream().sorted().forEach(System.out::println);

        // Predicate
        System.out.println("Test predicate. More then zero:");
        newList.stream().filter((i) -> i.intValue() > 0).forEach(System.out::println);

        //Function
        System.out.println("Test function. Square:");
        newList.stream().map(i -> Math.pow(i, 2)).forEach(System.out::println);
    }
}
