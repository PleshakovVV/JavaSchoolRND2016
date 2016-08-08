import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Master on 08.08.2016.
 */
public class TestReverseIterator {

    ReverseIterator<String> reverseIterator;

    List<String> list;

    @Before
    public void init() {
        list = new ArrayList<>();
    }

    @Test
    public void testHasNextEmptyList() {
        reverseIterator = new ReverseIterator<>(list);
        assertFalse(reverseIterator.hasNext());
    }

    @Test
    public void testHasNextNotEmptyList() {
        list.add("1");
        reverseIterator = new ReverseIterator<>(list);
        assertTrue(reverseIterator.hasNext());
    }

    @Test
    public void testNextEmptyList() {
        reverseIterator = new ReverseIterator<>(list);
        assertNull(reverseIterator.next());
    }

    @Test
    public void testNextNotEmptyList() {
        list.add("1");
        reverseIterator = new ReverseIterator<>(list);
        assertNotNull(reverseIterator.next());
    }

    @Test
    public void testRemoveNotEmpty() {
        list.add("1");
        reverseIterator = new ReverseIterator<>(list);
        assertEquals(1,list.size());
        reverseIterator.remove();
        assertEquals(0, list.size());
    }

    @Test(expected =  IndexOutOfBoundsException.class)
    public void testRemoveExceptionEmpty() {
        reverseIterator = new ReverseIterator<>(list);
        reverseIterator.remove();
    }
}
