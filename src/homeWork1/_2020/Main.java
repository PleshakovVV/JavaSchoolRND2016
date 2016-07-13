package homeWork1._2020;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Master on 12.07.2016.
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
        long start = System.currentTimeMillis();
        Scanner fileScanner = new Scanner(file);
        try {
            int N = fileScanner.nextInt();
            if (N == 0) return;
            int value = fileScanner.nextInt();
            int counter = 1;
            int previousValue = value;
            int currentValue = value;
            int tempCounter = 1;
            for (int i = 1; i < N; i++) {
                currentValue = fileScanner.nextInt();
                if (currentValue == previousValue) {
                    tempCounter++;
                }
                else {
                    if (tempCounter > counter) {
                        value = previousValue;
                        counter = tempCounter;
                        tempCounter = 1;
                    }
                    else {
                        tempCounter = 1;
                    }
                }
                previousValue = currentValue;
            }
            if (tempCounter > counter) {
                value = currentValue;
                counter = tempCounter;
            }

            try (FileWriter FW = new FileWriter(file.getParent() + "/output.txt")) {
                FW.write(value + " " + counter);
            }
            System.out.print("Elapsed time is: ");
            System.out.print(System.currentTimeMillis() - start);
            System.out.println(" ms.");
        }
        catch (InputMismatchException e) {
            System.out.println("Cannot read Integer value from file.");
            
        }
        finally {
            fileScanner.close();
        }
    }
}
