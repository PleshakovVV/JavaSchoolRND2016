import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by Master on 16.08.2016.
 */
public class ThreadingPullTest {
    String goodPath = "./src/test/java/settings.ini";
    String badPath = "./load/src/test/java/settings.ini";

    void init(String path) {
        ThreadingPool.readConfiguration(path);

    }

    @Test
    public void numberOfProcessorWithoutReadFromFile() {
        assertEquals(ThreadingPool.getThreadNumber(), 1);
    }

    @Test
    public void numberOfProcessorFromFileTest() throws IOException {
        init(goodPath);
        Path path = Paths.get(".");
        assertEquals("The current work directory is: " + path.toRealPath(LinkOption.NOFOLLOW_LINKS),
                ThreadingPool.getThreadNumber(), 23);
    }

    @Test
    public void numberOfProcessorReadFromFileWithException() {
        init(badPath);
        assertEquals(ThreadingPool.getThreadNumber(), 4);
    }
}
