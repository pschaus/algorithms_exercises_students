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
public class BinaryHeapTest {


    @Test
    @Grade(value=1, cpuTimeout=1000)
    @GradeFeedback(message="The minimum element is not always at the root of the tree !")
    @Order(1)
    public void testExample() {
        BinaryHeap heap = new BinaryHeap(100);
        heap.push(5);
        assertEquals(5, heap.getRoot());
        heap.push(1);
        assertEquals(1, heap.getRoot());
        heap.push(2);
        assertEquals(1, heap.getRoot());
        heap.push(3);
        assertEquals(1, heap.getRoot());
        heap.push(0);
        assertEquals(0, heap.getRoot());
    }

    @Test
    @Grade(value=1, cpuTimeout=1000)
    @GradeFeedback(message="Do not forget to resize if needed")
    @Order(1)
    public void testExampleResize() {
        BinaryHeap heap = new BinaryHeap(10);
        for (int i = 0; i < 20; i++) {
            heap.push(i);
        }
    }
    
