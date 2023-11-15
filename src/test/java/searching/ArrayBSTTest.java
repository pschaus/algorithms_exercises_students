package searching;

import org.javagrader.ConditionalOrderingExtension;
import org.javagrader.Grade;
import org.javagrader.GradeFeedback;
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
public class ArrayBSTTest {

    @Test
    @Grade(value = 1, cpuTimeout = 2000)
    @GradeFeedback(message = "Sorry, something is wrong with your get algorithm, debug first this small example")
    @Order(0)
    public void debugTestGetChar() {
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

        ArrayBST<Integer,Character> bst = new ArrayBST<>();

        bst.values = new ArrayList<>(Arrays.asList('A', 'C', 'B', 'E', 'D'));
        bst.keys   = new ArrayList<>(Arrays.asList(12, 15, 5, 8, 1));
        bst.idxLeftNode  = new ArrayList<>(Arrays.asList(2, bst.NONE, 4, bst.NONE, bst.NONE));
        bst.idxRightNode = new ArrayList<>(Arrays.asList(1, bst.NONE, 3, bst.NONE, bst.NONE));

        assertEquals(bst.get(12), Character.valueOf('A'));
        assertEquals(bst.get(8),  Character.valueOf('E'));
        assertNull(bst.get(20));
        assertEquals(bst.get(15), Character.valueOf('C'));
        assertEquals(bst.get(1),  Character.valueOf('D'));
    }



    @Test
    @Grade(value = 1, cpuTimeout = 2000)
    @Order(0)
    @GradeFeedback(message = "Sorry, something is wrong with your put algorithm, debug first this small example")
    public void debugTestPutInteger() {
        /*
         *  The tree below is the result of putting keyn,value pairs (12,A),(15,B),(5,C),(8,D),(1,E) (in this order)
         *
         *                12(A)
         *                / \
         *               /   \
         *             5(C)  15(B)
         *             / \
         *          1(E)  8(D)
         *
         *   The state of internal array list after those put operations is
         *    values:        A, B, C, D, E
         *    keys:        12, 15, 5, 8, 1
         *    idxLeftNode:  2, -1, 4,-1,-1
         *    idxRightNode: 1, -1, 3,-1,-1
         */
        ArrayBST<Integer,Character> bst = new ArrayBST<>();

        assertTrue(bst.put(12,'A'));
        assertTrue(bst.put(15,'B'));
        assertTrue(bst.put(5,'C'));
        assertTrue(bst.put(8,'D'));
        assertTrue(bst.put(1,'E'));

        assertFalse(bst.put(8,'d')); // replace value D of key 8 by d

        assertTrue(isBST(bst));
        assertArrayEquals(bst.keys.toArray(),new Integer[]{12,15,5,8,1});
        assertArrayEquals(bst.values.toArray(),new Character[]{'A','B','C','d','E'});
        assertArrayEquals(bst.idxLeftNode.toArray(),new Integer[]{2, bst.NONE,4, bst.NONE, bst.NONE});
        assertArrayEquals(bst.idxRightNode.toArray(),new Integer[]{1, bst.NONE,3, bst.NONE, bst.NONE});
        assertArrayEquals(collectIncreasing(bst).toArray(), new Integer[]{1,5,8,12,15});
    }




    // helper methods for the tests

    public static <Key extends Comparable<Key>,Value> boolean  isBST(ArrayBST<Key,Value> bst) {
        return isBST(bst,0, null, null);
    }

    private static <Key extends Comparable<Key>,Value> boolean isBST(ArrayBST<Key,Value> bst, int index, Key min, Key max) {
        if (index == bst.NONE) return true;
        if (min != null && bst.keys.get(index).compareTo(min) <= 0) return false;
        if (max != null && bst.keys.get(index).compareTo(max) >= 0) return false;
        return isBST(bst,bst.idxLeftNode.get(index), min, bst.keys.get(index)) && isBST(bst,bst.idxRightNode.get(index), bst.keys.get(index), max);
    }

    private static <Key extends Comparable<Key>,Value> List<Key>  collectIncreasing(ArrayBST<Key,Value> bst) {
        List<Key> result = new LinkedList<>();
        collectIncreasing(bst,0,result);
        return result;
    }

    private static <Key extends Comparable<Key>,Value> void  collectIncreasing(ArrayBST<Key,Value> bst, int index, List<Key> increasing) {
        if (bst.idxLeftNode.get(index) != bst.NONE) {
            collectIncreasing(bst,bst.idxLeftNode.get(index),increasing);
        }
        increasing.add(bst.keys.get(index));
        if (bst.idxRightNode.get(index) != bst.NONE) {
            collectIncreasing(bst,bst.idxRightNode.get(index),increasing);
        }
    }


}



