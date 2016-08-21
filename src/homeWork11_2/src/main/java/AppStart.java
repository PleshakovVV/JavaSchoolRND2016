import java.io.File;

/**
 * Created by Master on 21.08.2016.
 */
public class AppStart {
    public static void main(String[] args) {
        String pathToSettings = "./src/homeWork11_2/src/main/java/settings.ini";
        File file = new File(pathToSettings);
        ThreadPool threadPool = new ThreadPool(file);
        for (int i = 0; i < 22; i++) {
            final int[] num = new int[] {i};
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.err.println("Message " + num[0] + " from " + Thread.currentThread().getName());
                }
            };
            threadPool.addTask(runnable);
        }
    }
}
