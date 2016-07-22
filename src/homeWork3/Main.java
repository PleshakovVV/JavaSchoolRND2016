package homeWork3;

import java.io.File;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Master on 21.07.2016.
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

        List<String> stringList = new ArrayList<>();
        List<String> wordList = new ArrayList<>();

        String tempString;
        while (fileScanner.hasNextLine()) {
            tempString = fileScanner.nextLine();
            stringList.add(tempString);
            String[] words = tempString.split(" ");
            Collections.addAll(wordList, words);
        }

        Tasks123(wordList);
        System.out.println();
        Tasks456(stringList);

    }

    private static void Tasks123(List<String> inList) {
        Map<String, Integer> words = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() > o2.length() ? 1 : o1.length() < o2.length() ? -1 : o1.compareTo(o2);
            }
        });

        for (String str : inList) {
            if (words.containsKey(str)) {
                words.put(str, words.get(str) + 1);
            }
            else {
                words.put(str, 1);
            }
        }

        System.out.println("The number of unique words is: " + words.size());
        System.out.println("**************************");
        System.out.println("List of words, sorted by length is:");
        for (String key : words.keySet()) {
            System.out.println(key);
        }
        System.out.println("**************************");
        System.out.println("The number of appearance of each word is:");
        for (String key : words.keySet()) {
            System.out.println("Word \"" + key + "\" appear " + words.get(key) + " time(s).");
        }
    }

    private static void Tasks456(List<String> inList) {
        ReverseIterator<String> iterator = new ReverseIterator<>(inList);
        System.out.println("All string in reverse order:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("**************************");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter strings, which you want to print divided by space:");
        String whichStrings = scanner.nextLine();
        scanner.close();
        try {
            for (String str : whichStrings.split(" ")) {
                Integer number = Integer.parseInt(str);
                System.out.print("String number " + number + " is: ");
                System.out.println(inList.get(number - 1));
            }
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

class ReverseIterator<T> implements Iterator<T>{
    private List<T> list;
    private int counter;

    public ReverseIterator(List<T> list) {
        this.list = list;
        counter = list == null ? 0 : list.size();
    }

    @Override
    public boolean hasNext() {
        return counter != 0;
    }

    @Override
    public T next() {
        return counter == 0 ? null : list.get(--counter);
    }
}
