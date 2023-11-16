package searching;

import org.javagrader.Grade;
import org.javagrader.GradeFeedback;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import static org.junit.jupiter.api.Assertions.*;

@Grade
public class LinearProbingHashSTTest {


    @Test
    @GradeFeedback(message="Sorry, something is wrong with your algorithm. Debug first on this small example")
    public void testExample() {
        LinearProbingHashST<Integer,String> lp = new LinearProbingHashST<>();

        assertEquals(4,lp.capacity());
        assertEquals(0,lp.size());

        lp.put(5, "five");
        assertEquals("five",lp.get(5));
        assertEquals(1,lp.size());

        lp.put(9,"nine");
        assertEquals("nine",lp.get(9));
        assertEquals(2,lp.size());

        lp.put(9,"neuf");
        assertEquals("neuf",lp.get(9));
        assertEquals(2,lp.size());

        lp.put(8,"huit");
        assertEquals("huit",lp.get(8));
        assertEquals(3,lp.size());
        assertEquals(8,lp.capacity());


        lp.put(0,"zero");
        assertEquals("zero",lp.get(0));
        assertEquals(4,lp.size());
        assertEquals(8,lp.capacity());


        lp.put(16,"sixteen");
        assertEquals("sixteen",lp.get(16));
        assertEquals(5,lp.size());
        assertEquals(16,lp.capacity());


        assertTrue(lp.contains(5));
        assertTrue(lp.contains(9));


        assertFalse(lp.contains(4));
        assertFalse(lp.contains(32));
        assertFalse(lp.contains(64));
    }

    
}
