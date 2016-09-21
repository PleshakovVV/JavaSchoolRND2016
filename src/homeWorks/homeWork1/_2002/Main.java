package homeWorks.homeWork1._2002;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Master on 12.07.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException{
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
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += fileScanner.nextInt();
            }

            try (FileWriter FW = new FileWriter(file.getParent() + "/output.txt")) {
                FW.write(String.valueOf(sum));
            }
            System.out.print("Elapsed time is: ");
            System.out.print(System.currentTimeMillis() - start);
            System.out.println(" ms.");
        }
        catch (InputMismatchException e) {
            System.out.println("Cannot read Integer value from file.");
            throw e;
        }
        catch (NoSuchElementException e) {
            System.out.println("There is not enough values in a file.");
            throw e;
        }
    }
}
