package homeWork1._2051;

import java.io.File;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Student on 15.07.2016.
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
            String inString = fileScanner.nextLine();
            fileScanner.close();



            System.out.print("Elapsed time is: ");
            System.out.print(System.currentTimeMillis() - start);
            System.out.println(" ms.");
        }
        catch (InputMismatchException e) {
            System.out.println("Cannot read Integer value from file.");
        }
    }
}
