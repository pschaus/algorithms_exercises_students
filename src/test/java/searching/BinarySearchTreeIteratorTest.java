package searching;

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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.Iterator;

@ExtendWith(ConditionalOrderingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Grade
public class BinarySearchTreeIteratorTest {

    @Test
    @Grade(value=1, cpuTimeout = 1000)
    @GradeFeedback(message="Sorry, something is wrong with your algorithm. Debug first on this small example")
    public void  testExample() {
        BinarySearchTreeIterator<Integer> tree = new BinarySearchTreeIterator<>();
        int [] values = new int []{12, 8, 18, 3, 11, 14, 20, 9, 15};
        for (int v : values) {
            tree.put(v);
        }
        Integer [] output = new Integer []{3, 8, 9, 11, 12, 14, 15, 18, 20};

        Iterator<Integer> iter = tree.iterator();
        for (int i = 0; i < output.length; i++) {
            assertTrue(iter.hasNext());
            assertEquals(output[i], iter.next());
        }
        assertTrue(!iter.hasNext());
    }

}

