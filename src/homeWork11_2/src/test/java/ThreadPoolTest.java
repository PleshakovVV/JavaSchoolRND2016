import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Master on 21.08.2016.
 */
public class ThreadPoolTest {

    String goodPath = "./src/test/java/settings.ini";
    String badPath = "./load/src/test/java/settings.ini";
    ThreadPool threadPool;

    @Test(expected = IllegalArgumentException.class)
    public void testInitException() {
        threadPool = new ThreadPool(-1);
    }

    @Test
    public void testInitSizePlainConstructor() {
        threadPool = new ThreadPool(7);
        assertEquals(threadPool.getThreadNumber(), 7);
    }

    @Test
    public void testInitSizeFromFileGoodPath() {
        threadPool = new ThreadPool(new File(goodPath));
        assertEquals(threadPool.getThreadNumber(), 23);
    }

    @Test
    public void testInitSizeFromFileBadPath() {
        threadPool = new ThreadPool(new File(badPath));
        assertEquals(threadPool.getThreadNumber(), Runtime.getRuntime().availableProcessors());
    }

    @Test
    public void testAddTask() {
        threadPool = new ThreadPool(5);
        threadPool.addTask(() -> {

        });
    }
}
