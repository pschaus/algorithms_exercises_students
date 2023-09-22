package sorting;

import org.javagrader.ConditionalOrderingExtension;
import org.javagrader.Grade;
import org.javagrader.GradeFeedback;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.stream.Stream;

@ExtendWith(ConditionalOrderingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Grade
public class MinMaxHeapTest {

    @Test
    @Grade(value=1, cpuTimeout=1000)
    @GradeFeedback(message="The minimum element is not always at the root of the tree !")
    @Order(1)
    public void testExample() {
        MinMaxHeap<Integer> heap = new MinMaxHeap<>(100);
        int min;
        int max;
        heap.insert(5);
        min = heap.min();
        max = heap.max();
        assertEquals(5, min);
        assertEquals(5, max);
        heap.insert(1);
        min = heap.min();
        max = heap.max();
        assertEquals(1, min);
        assertEquals(5, max);
        heap.insert(2);
        min = heap.min();
        max = heap.max();
        assertEquals(1, min);
        assertEquals(5, max);
        heap.insert(6);
        min = heap.min();
        max = heap.max();
        assertEquals(1, min);
        assertEquals(6, max);
        heap.insert(0);
        min = heap.min();
        max = heap.max();
        assertEquals(0, min);
        assertEquals(6, max);
    }

}
