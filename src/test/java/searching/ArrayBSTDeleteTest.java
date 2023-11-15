package searching;

import org.javagrader.ConditionalOrderingExtension;
import org.javagrader.Grade;
import org.javagrader.GradeFeedback;
import org.javagrader.TestResultStatus;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ConditionalOrderingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Grade
public class ArrayBSTDeleteTest {

    @Test
    @Order(0)
    @Grade(value = 1, cpuTimeout = 2000)
    @GradeFeedback(message = "Congrats!", on= TestResultStatus.SUCCESS)
    @GradeFeedback(message = "Something is wrong, understand the test code and debug locally", on=TestResultStatus.FAIL)
    @GradeFeedback(message = "Too slow, infinite loop ?", on=TestResultStatus.TIMEOUT)
    public void debugDelete() {
        /*
         *  Encoding of the tree below key(value)
         *
         *                12(A)
         *                / \
         *               /   \
         *             5(B) 15(C)
         *             / \
         *           1(D) 8(E)
         *
         *   The state of internal array list after those put operations is
         *
         *    keys:        12, 15, 5, 8, 1
         *    values:       A,  C, B, E, D
         *    idxLeftNode:  2, -1, 4,-1,-1
         *    idxRightNode: 1, -1, 3,-1,-1
         */
        ArrayBSTDelete<Integer,Character> bst = new ArrayBSTDelete<>();

        bst.put(12,'A');
        bst.put(15,'C');
        bst.put(5,'B');
        bst.put(8,'E');
        bst.put(1,'D');

        assertEquals(new ArrayList<>(Arrays.asList('A', 'C', 'B', 'E', 'D')), bst.values);
        assertEquals(new ArrayList<>(Arrays.asList(12, 15, 5, 8, 1)), bst.keys);
        assertEquals(new ArrayList<>(Arrays.asList(2, bst.NONE, 4, bst.NONE, bst.NONE)), bst.idxLeftNode);
        assertEquals(new ArrayList<>(Arrays.asList(1, bst.NONE, 3, bst.NONE, bst.NONE)), bst.idxRightNode);

        assertTrue(bst.delete(5)); // true since the key was present
        assertFalse(bst.delete(5));// false since the key is not present

        assertEquals('A',bst.get(12));
        assertNull(bst.get(5)); // 5 is deleted

        assertTrue(bst.put(5, 'F'));  // key inserted, was not present
        assertFalse(bst.put(5, 'F')); // key already present
        assertFalse(bst.put(5, 'G')); // key already present (but value erased)

        assertEquals('G',bst.get(5));
        assertEquals('E',bst.get(8));
        assertNull(bst.get(16)); // key not present

        assertTrue(bst.values.size() <= 5);

    }


}
