package homeWork1._2045;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Master on 13.07.2016.
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
        String[] words = fileScanner.nextLine().split(" ");
        fileScanner.close();

        StringBuilder SB = new StringBuilder();
        String resultWord;
        for (int i = 0; i < words.length; i++) {
            if (words[i].trim().length() == 0) {
                continue;
            }
            resultWord = words[i].trim();
            resultWord = resultWord.replaceAll(",",", ").trim();
            resultWord = resultWord.replaceAll("\\.",". ").trim();
            resultWord = resultWord.replaceAll("!","! ").trim();
            resultWord = resultWord.replaceAll("\\?","? ").trim();
            // delete previous space
            if (resultWord.substring(0,1).matches(",|\\.|!|\\?")) {
                SB.delete(SB.length() - 1, SB.length());
            }

            SB.append(resultWord);
            if (i != words.length - 1) {
                SB.append(" ");
            }
        }

        try (FileWriter FW = new FileWriter(file.getParent() + "/output.txt")){
            FW.write(SB.toString());
        }

        System.out.print("Elapsed time is: ");
        System.out.print(System.currentTimeMillis() - start);
        System.out.println(" ms.");
    }
}
