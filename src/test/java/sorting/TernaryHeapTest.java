package sorting;

import org.javagrader.Grade;
import org.javagrader.GradeFeedback;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Grade
public class TernaryHeapTest {

    @Test
    @Grade(value = 7, cpuTimeout = 1)
    @GradeFeedback(message = "Use your debugger or print to debug your code")
    public void testDebugBase() {
        TernaryHeap heap = new TernaryHeap(10);
        assertEquals(0, heap.size());

        for (int i = 0; i < 10; i++) {
            heap.insert(i);
        }

        // Test if the correct size is given
        assertEquals(10, heap.size());

        // Test if the content is the same
        testTernaryHeapProperty(heap.content, heap.size());

        // Test if the max is returned
        assertEquals(9, heap.getMax());

        // Test remove the maximum
        assertEquals(9, heap.delMax());

        testTernaryHeapProperty(heap.content, heap.size());
    }

    @Test
    @Grade(value = 7, cpuTimeout = 1,threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    @GradeFeedback(message = "Your heap should be able to handle duplicates")
    public void testDuplicate() {
        TernaryHeap heap = new TernaryHeap(10);


        assertEquals(0, heap.size());

        heap.insert(1);   // <1 >
        heap.insert(-1);  // <1, -1 >
        heap.insert(1);   // <1, 1, -1 >

        assertEquals(3, heap.size());
        assertEquals(1, heap.getMax());

        heap.insert(21);  // <21, 1, 1, -1 >
        heap.insert(22);  // <22, 21, 1, 1, -1 >

        assertEquals(5, heap.size());
        assertEquals(22, heap.getMax());

        testTernaryHeapProperty(heap.content, heap.size());

        assertEquals(22, heap.delMax());    // <21, 1, 1, -1 >

        assertEquals(4, heap.size());
        assertEquals(21, heap.getMax());

        assertEquals(21, heap.delMax());    // <1, 1, -1 >

        testTernaryHeapProperty(heap.content, heap.size());

        assertEquals(3, heap.size());
        assertEquals(1, heap.getMax());

        assertEquals(1, heap.delMax()); // <1, -1 >

        assertEquals(2, heap.size());
        assertEquals(1, heap.getMax());

        assertEquals(1, heap.delMax()); // <-1 >

        assertEquals(1, heap.size());
        assertEquals(-1, heap.getMax());

        heap.insert(3);

        assertEquals(2, heap.size());
        assertEquals(3, heap.getMax());
    }


    public static void testTernaryHeapProperty(int [] content, int size) {
        for (int i = 0; i < size/3; i++) {
            if (3*i+1 < size)
                assertTrue(content[i] >= content[3*i+1]);
            if (3*i+2 < size)
                assertTrue(content[i] >= content[3*i+2]);
            if (3*i+3 < size)
                assertTrue(content[i] >= content[3*i+3]);
        }
    }






}
