package homeWork2;

import java.io.File;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Master on 15.07.2016.
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

        Scanner fileScanner = new Scanner(file);
        List<String> words = new ArrayList<>();
        try {
            while (true) {
                words.add(fileScanner.next().replace(" ", ""));
            }
        }
        catch (NoSuchElementException e) {
            /*NOPE*/
        }
        finally {
            fileScanner.close();
        }
        Collections.sort(words);
        System.out.println(words.toString());
    }
}
