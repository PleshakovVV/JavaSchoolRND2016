package homeWorks.homeWork1._2056;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Master on 13.08.2016.
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
        Map<String, Integer> words = new TreeMap<>();
        Integer maxCount = 1;
        try (BufferedReader BR = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = BR.readLine()) != null) {
                for (String temp : str.split(" ")) {
                    String lowerTrimString = temp.toLowerCase().trim();
                    if ("".equals(lowerTrimString)) {
                        continue;
                    }
                    if (words.containsKey(lowerTrimString)) {
                        words.put(lowerTrimString, words.get(lowerTrimString) + 1);
                        if (words.get(lowerTrimString).compareTo(maxCount) > 0) {
                            maxCount = words.get(lowerTrimString);
                        }
                    }
                    else {
                        words.put(temp.toLowerCase(), 1);
                    }
                }
            }

            for (String temp : words.keySet()) {
                if (words.get(temp) == maxCount) {
                    System.out.println("->" + temp);
                }
            }
        }
    }
}
