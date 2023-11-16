package searching;

import org.javagrader.Allow;
import org.javagrader.ConditionalOrderingExtension;
import org.javagrader.Grade;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;



@ExtendWith(ConditionalOrderingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Grade
public class BinarySearchTreeHigherTest {
    
    
    @Test
    @Grade(value=5)
    @Order(1)
    public void testExample() {
        BinarySearchTreeHigher<Integer, Integer> bst = new BinarySearchTreeHigher<Integer, Integer>();

        bst.put(12,12);
        bst.put(8,8);
        bst.put(3,3);
        bst.put(11,11);
        bst.put(9,9);
        bst.put(18,18);
        bst.put(14,14);
        bst.put(15,15);
        bst.put(20,20);

        assertEquals(3, bst.minKey());
        assertEquals(3, bst.higherKey(0));
        assertEquals(9, bst.higherKey(8));
        assertEquals(12, bst.higherKey(11));
        assertEquals(18, bst.higherKey(16));
        assertEquals(null, bst.higherKey(20));

    }

}
