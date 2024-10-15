package sorting;

import org.javagrader.ConditionalOrderingExtension;
import org.javagrader.Grade;
import org.javagrader.GradeFeedback;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.*;

@ExtendWith(ConditionalOrderingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Grade
public class MedianHeapTest {

    @Test
    @Grade(value=1, cpuTimeout=1000)
    @GradeFeedback(message="The median element is not always at the root of the tree !")
    @Order(1)
    public void testExample() {
        MedianHeap heap = new MedianHeap(100);
        heap.insertion(5);
        assertEquals(5, heap.findMedian());
        heap.insertion(1);
        // assertEquals(1, heap.findMedian());
        heap.insertion(2);
        assertEquals(2, heap.findMedian());
        heap.insertion(3);
        // assertEquals(2, heap.findMedian());
        heap.insertion(-2);
        assertEquals(2, heap.deleteMedian());
        assertEquals(3, heap.deleteMedian());
        assertEquals(1, heap.deleteMedian());
        assertEquals(5, heap.deleteMedian());
        assertEquals(-2, heap.deleteMedian());
    }


}
