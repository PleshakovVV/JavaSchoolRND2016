package homeWorks.homeWork1._2051;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

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
        scanner.close();
        long start = System.currentTimeMillis();
        Scanner fileScanner = new Scanner(file);
        Deque<Integer> stack = new LinkedList<>();
        Writer writer = new FileWriter(file.getParent() + "/output.txt");
        String inString = fileScanner.nextLine();
        fileScanner.close();

        for (int i = 0; i < inString.length(); i++) {
            if (inString.substring(i, i + 1).equals("(")) {
                stack.push(i + 1);
            }
            if (inString.substring(i, i + 1).equals(")")) {
                writer.write(stack.pop() + " " + (i + 1) + "\n");
            }
        }
        writer.flush();
        writer.close();

        System.out.print("Elapsed time is: ");
        System.out.print(System.currentTimeMillis() - start);
        System.out.println(" ms.");
    }

}
