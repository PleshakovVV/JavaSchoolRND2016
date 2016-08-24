package homeWork13.task1;

import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

/**
 * Created by Master on 24.08.2016.
 */
public class AppStart {
    public static void main(String[] args) {
        Task<String> task1 = new Task<>(() -> {
            System.out.println("Start compute very difficult task... (wait 2 sec)");
            sleep(2000);
            System.out.println("End compute very difficult task!");
            return "It,s a result of very difficult task";
        });

        try {
            System.out.println(task1.get());
            System.out.println(task1.get());
            System.out.println(task1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n****************\n");

        Task<String> task2 = new Task<>(() -> {
            System.out.println("Start compute very difficult task... (wait 2 sec)");
            sleep(2000);
            if (System.currentTimeMillis() % 2 != 7) {
                throw new Exception("The exception occur.");
            }
            return "It,s a result of very difficult task";
        });

        try {
            System.out.println(task2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(task2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(task2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}