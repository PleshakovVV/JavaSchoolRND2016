import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Master on 16.08.2016.
 */
public class AppStart {
    public static void main(String[] args) {
        String pathToSettings = "./src/homeWork11/src/main/java/settings.ini";

        Path pathToText = Paths.get(pathToSettings);
        pathToText = Paths.get(pathToText.getParent() + "/Data");

        ThreadingPool.readConfiguration(pathToSettings);

        // reading text from file
        List<String> list = new ArrayList<>();
        String readString;
        for (File file : pathToText.toFile().listFiles()) {
            try (BufferedReader BR = new BufferedReader(new FileReader(file))) {
                while ((readString = BR.readLine()) != null) {
                    list.add(readString);
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found: " + file.getAbsolutePath());
            }
            catch (IOException|NullPointerException e) {
                e.printStackTrace();
            }
        }

        // reformat List to fill all Threads by task
        while (ThreadingPool.getThreadNumber() > list.size()) {
            int listSize = list.size();
            for (int i = 0; i < listSize; i++) {
                String temp = list.get(i);
                if (temp.substring(0,temp.length()/2).length() > 0) {
                    list.set(i, temp.substring(0, temp.length() / 2));
                }
                else {
                    list.set(i,"");
                }
                list.add(temp.substring(temp.length()/2, temp.length()));
            }
        }

        // Count letters
        SumHolder sumHolder = new SumHolder();
        int part = (int)Math.ceil(1.0D * list.size()/ThreadingPool.getThreadNumber());

        List<Thread> threadHolder = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < ThreadingPool.getThreadNumber(); i++) {
            if (i != ThreadingPool.getThreadNumber() - 1) {
                Thread t = new Thread(new CountTask(sumHolder, list, i * part, (i + 1) * part));
                threadHolder.add(t);
                t.start();
            }
            else {
                Thread t = new Thread(new CountTask(sumHolder, list, i * part, list.size()));
                threadHolder.add(t);
                t.start();
            }
        }

        // Waiting
        try {
            for (Thread thread : threadHolder) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sum of letter is: " + sumHolder.getSum());
        System.out.println("Counted by " + threadHolder.size() + " threads.");
        System.out.println("Elapsed time is: " + (System.currentTimeMillis() - start) + " ms.\n");

        System.out.println("Sum of letter over parallel stream API:");
        start = System.currentTimeMillis();
        System.out.println(list.parallelStream()
                .flatMap(s -> Arrays.stream(s.split("")))
                .filter(s -> s.length() > 0 && Character.isLetter(s.codePointAt(0)))
                .count());
        System.out.println("Elapsed time is: " + (System.currentTimeMillis() - start) + " ms.");
    }
}
