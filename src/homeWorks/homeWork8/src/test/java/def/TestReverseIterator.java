package def;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

/**
 * Created by Master on 08.08.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestReverseIterator {

    ReverseIterator<String> reverseIterator;

    @Mock
    List<String> mockList;

    @Test
    public void testHasNextEmptyList() {

        when(mockList.get(anyInt())).thenThrow(new IndexOutOfBoundsException());
        when(mockList.size()).thenReturn(0);

        reverseIterator = new ReverseIterator<>(mockList);
        assertFalse(reverseIterator.hasNext());
    }

    @Test
    public void testHasNextNotEmptyList() {

        when(mockList.get(anyInt())).thenReturn("1");
        when(mockList.size()).thenReturn(1);

        reverseIterator = new ReverseIterator<>(mockList);
        assertTrue(reverseIterator.hasNext());
    }

    @Test
    public void testNextEmptyList() {

        when(mockList.get(anyInt())).thenThrow(new IndexOutOfBoundsException());
        when(mockList.size()).thenReturn(0);

        reverseIterator = new ReverseIterator<>(mockList);
        assertNull(reverseIterator.next());
    }

    @Test
    public void testNextNotEmptyList() {

        when(mockList.get(anyInt())).thenReturn("1");
        when(mockList.size()).thenReturn(1);

        reverseIterator = new ReverseIterator<>(mockList);
        assertNotNull(reverseIterator.next());
    }

    @Test
    public void testRemoveNotEmptyList() {

        when(mockList.get(anyInt())).thenReturn("1");
        when(mockList.size()).thenReturn(1, 1, 0);

        reverseIterator = new ReverseIterator<>(mockList);
        int size1 = mockList.size();
        int size2 = mockList.size();
        assertEquals(1,size1);
        reverseIterator.remove();
        assertEquals(0, size2);
    }

    @Test(expected =  IndexOutOfBoundsException.class)
    public void testRemoveExceptionEmptyList() {

        when(mockList.get(anyInt())).thenThrow(new IndexOutOfBoundsException());
        when(mockList.size()).thenReturn(0);
        when(mockList.remove(anyInt())).thenThrow(new IndexOutOfBoundsException());

        reverseIterator = new ReverseIterator<>(mockList);
        reverseIterator.remove();
    }
}
