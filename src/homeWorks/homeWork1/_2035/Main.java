package homeWorks.homeWork1._2035;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Master on 14.07.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        File file = null;
        if (args.length > 0) {
            file = new File(args[0]);
        }
        Path path = Paths.get(".");
        Scanner scanner = new Scanner(System.in);
        while (file == null || !file.exists()) {
            System.out.println("The current work directory is: " + path.toRealPath(LinkOption.NOFOLLOW_LINKS));
            System.out.println("Please, enter full path to input file: ");
            file = new File(scanner.nextLine());
        }
        scanner.close();
        long start = System.currentTimeMillis();

        try (Scanner fileScanner = new Scanner(file)){
            int N = fileScanner.nextInt();
            int period;
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = fileScanner.nextInt();
            }
            if (array.length == 1) {
                period = 1;
            }
            else {
                // All numbers in array the same - period = 1
                boolean isDifferent = false;
                int element = array[0];
                for (int i = 1; i < array.length; i++) {
                    if (array[i] != element) {
                        isDifferent = true;
                        break;
                    }
                }
                if (!isDifferent) {
                    period = 1;
                }
                else {
                    // If length of array - primal number => period = length of array
                    boolean isPrimal = true;
                    for (int i = 2; i*i <= N; i++) {
                        if (N % i == 0) {
                            isPrimal = false;
                            break;
                        }
                    }
                    if (isPrimal) {
                        period = N;
                    }
                    else {
                        // initialize period for helpless finding period
                        period = array.length;
                        // find all primal dividers and check them
                        List<Integer> primalDividers = new ArrayList<>();
                        for (int i = 2; i <= N/2; i++) {
                            if (N % i == 0)
                            {
                                primalDividers.add(i);
                            }
                        }
                        for (int i = 0; i < primalDividers.size(); i++) {
                            boolean isPeriod = true;
                            period = primalDividers.get(i);
                            outer:
                            for (int j = 0; j < primalDividers.get(i); j++) {
                                for (int k = 1; k < array.length / primalDividers.get(i); k++) {
                                    if (array[j] != array[j + k * primalDividers.get(i)]) {
                                        isPeriod = false;
                                        break outer;
                                    }
                                }
                            }
                            if (!isPeriod) {
                                period = array.length;
                            }
                            else {
                                break;
                            }
                        }
                    }
                }
            }
            try (FileWriter FW = new FileWriter(file.getParent() + "/output.txt")) {
                FW.write(String.valueOf(period));
            }

            System.out.print("Elapsed time is: ");
            System.out.print(System.currentTimeMillis() - start);
            System.out.println(" ms.");
        }
        catch (InputMismatchException e) {
            System.out.println("Cannot read Integer value from file.");
            throw e;
        }
    }
}
