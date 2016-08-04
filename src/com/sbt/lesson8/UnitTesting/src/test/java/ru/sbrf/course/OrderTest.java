package ru.sbrf.course;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.inOrder;

/**
 * Created by Student on 04.08.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderTest {
    @Mock
    List<String> mockList1;

    @Mock
    List<String> mockList2;

    @Test
    public void testList() {
        mockList1.add("First");
        mockList2.add("Second");

        InOrder order = inOrder(mockList1, mockList2);

        order.verify(mockList1).add("First");
        order.verify(mockList2).add("Second");
    }

}
