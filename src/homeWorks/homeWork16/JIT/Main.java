package homeWorks.homeWork16.JIT;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Master on 03.09.2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            map.put(i, "value" + i);
            Thread.currentThread().sleep(50);
        }
    }
}
